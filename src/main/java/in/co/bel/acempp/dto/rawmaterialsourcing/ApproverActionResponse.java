package in.co.bel.acempp.dto.rawmaterialsourcing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApproverActionResponse {
    private String sourcingId;
    private String lotId;
    private String actionType;
    private String status;           // "Approved" or "Rejected"
    private String actionBy;         // approver's userId
    private LocalDateTime actionAt;
    private String remarks;
    private String rejectionReason;
}