package in.co.bel.acempp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.parser.PdfTextExtractor;
import in.co.bel.acempp.dto.form.FormPdfRequest;
import in.co.bel.acempp.dto.rocketmotorcasing.RmcDetailsRequest;
import in.co.bel.acempp.dto.rocketmotorcasing.RmcDetailsResponse;
import in.co.bel.acempp.dto.rocketmotorcasing.RmcSectionsResponse;
import in.co.bel.acempp.dto.rocketmotorcasing.embeddeddocuments.MotorReceipt;
import in.co.bel.acempp.dto.rocketmotorcasing.embeddeddocuments.NdtUtReport;
import in.co.bel.acempp.enums.Status;
import in.co.bel.acempp.service.sourcing.RocketMotorCasingService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FormPdfServiceRocketMotorCasingTest {

    @Test
    void rendersNdtReportDatesAsDayMonthYear() throws Exception {
        RocketMotorCasingService casingService = mock(RocketMotorCasingService.class);
        FormPdfService service = new FormPdfService(
                null, casingService, null, null, null, null, null, null, null,
                null, null, null, null, new ObjectMapper(), null, null, null);
        RmcDetailsResponse details = RmcDetailsResponse.builder()
                .motorCasingId("RMC-2026-27-001")
                .motorStage(1)
                .motorId("MOTOR-001")
                .status(Status.APPROVED)
                .createdAt(LocalDateTime.of(2026, 11, 3, 11, 18))
                .sections(RmcSectionsResponse.builder()
                        .motorReceipt(MotorReceipt.builder()
                                .ndtUtReport(NdtUtReport.builder()
                                        .postPptUtDate(LocalDate.of(2026, 11, 29))
                                        .ndtDate(LocalDate.of(2026, 11, 27))
                                        .build())
                                .build())
                        .build())
                .build();
        when(casingService.getFormDetails(any(RmcDetailsRequest.class))).thenReturn(details);
        FormPdfRequest request = new FormPdfRequest();
        request.setFormId("RMC-2026-27-001");
        request.setSubDepartmentId(2L);

        String base64 = service.generatePdf(request, "approver").getBase64();
        String text = new PdfTextExtractor(new PdfReader(
                Base64.getDecoder().decode(base64))).getTextFromPage(1);

        assertTrue(text.contains("Post-PPT UT date"));
        assertTrue(text.contains("29-11-2026"), text);
        assertTrue(text.contains("NDT date"));
        assertTrue(text.contains("27-11-2026"), text);
        assertTrue(text.contains("03-11-2026 11:18"), text);
        assertFalse(text.contains("2026-11-29"), text);
        assertFalse(text.contains("2026-11-27"), text);
    }
}
