package in.co.bel.acempp.dto.rawmaterialsourcing;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApproverActionRequest {

    @NotBlank(message = "sourcingId is required")
    private String sourcingId;

    @NotBlank(message = "lotId is required")
    private String lotId;

    @NotNull(message = "subDepartmentId is required")
    private Long subDepartmentId;

    @NotBlank(message = "actionType is required")
    private String actionType;               // APPROVED / REJECTED

    private String remarks;                  // optional for approval

    private String rejectionReason;          // mandatory when actionType = REJECTED
}