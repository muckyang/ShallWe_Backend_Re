package ShallWe.Refactoring.domain.partyMember.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PartyMemberRequest {
    private Long id;
    private Long orderId;
    private Long memberId;
    private int price;
    private String joinDescription;
}
