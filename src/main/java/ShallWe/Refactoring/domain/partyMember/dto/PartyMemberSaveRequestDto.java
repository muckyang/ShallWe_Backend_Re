package ShallWe.Refactoring.domain.partyMember.dto;

import ShallWe.Refactoring.domain.partyMember.domain.PartyMember;
import ShallWe.Refactoring.domain.partyMember.domain.PartyStatus;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartyMemberSaveRequestDto {
    private int price;
    private String status;
    private String joinDescription;

    public PartyMember toEntity(){
        return PartyMember.builder()
                .price(price)
                .status(PartyStatus.getPartyStatus(status))
                .joinDescription(joinDescription)
                .build();
    }
}
