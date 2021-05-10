package ShallWe.Refactoring.entity.partyMember.dto;

import ShallWe.Refactoring.entity.order.Category;
import ShallWe.Refactoring.entity.partyMember.PartyMember;
import ShallWe.Refactoring.entity.partyMember.PartyStatus;
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
