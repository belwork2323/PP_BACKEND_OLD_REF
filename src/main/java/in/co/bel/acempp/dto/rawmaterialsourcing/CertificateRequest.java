package in.co.bel.acempp.dto.rawmaterialsourcing;

import in.co.bel.acempp.dto.rocketmotorcasing.DocumentDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class CertificateRequest extends DocumentDto {
    private String certificateType;

}
