package in.co.bel.acempp.dto.rawmaterialsourcing;

import in.co.bel.acempp.dto.general.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApproverLotListResponse {
    private StatusCountsDto statusCounts;
    private List<ApproverLotSummaryDto> lots;
    private PaginationDto pagination;
}