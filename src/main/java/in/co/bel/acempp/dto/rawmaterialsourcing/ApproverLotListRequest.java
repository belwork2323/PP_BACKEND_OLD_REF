package in.co.bel.acempp.dto.rawmaterialsourcing;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ApproverLotListRequest {

    @NotNull(message = "subDepartmentId is required")
    private Long subDepartmentId;

    @Min(value = 1, message = "page must be >= 1")
    private int page;

    @Min(value = 1, message = "limit must be >= 1")
    private int limit;

    private List<String> status;         // optional: In Progress, Waiting for Approval, etc.
    private List<String> materialCode;   // optional: HTPB, AP, etc.
    private String search;               // optional: searches in lotId or supplyOrderNo
    private LocalDate fromDate;          // optional
    private LocalDate toDate;            // optional
}