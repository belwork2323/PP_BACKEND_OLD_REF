package in.co.bel.acempp.dto.rawmaterialsourcing;

import in.co.bel.acempp.dto.general.PersonInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApproverLotSummaryDto {
    private String lotId;
    private String sourcingId;
    private String materialCode;
    private String materialName;
    private String supplyOrderNo;
    private LocalDate receiptDate;
    private String manufacturerName;
    private String priority;           // may be null if not stored
    private String status;
    private PersonInfo assignedTo;      // maps to lot.updatedBy or future field
    private PersonInfo createdBy;       // maps to lot.createdBy
    private LocalDateTime createdOn;
    private String rejectionReason;
}