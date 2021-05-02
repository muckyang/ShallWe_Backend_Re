package ShallWe.Refactoring.entity.partyMember.dto;

import ShallWe.Refactoring.entity.partyMember.PartyMember;
import ShallWe.Refactoring.entity.partyMember.PartyStatus;
import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
public class PartyMemberResponseDto {
    private int price;
    private String joinDescription;
    private String status;

    @QueryProjection
    public PartyMemberResponseDto(PartyMember partyMember){
        price = partyMember.getPrice();
        joinDescription = partyMember.getJoinDescription();
        status = partyMember.getStatus().toString();
    }


}
