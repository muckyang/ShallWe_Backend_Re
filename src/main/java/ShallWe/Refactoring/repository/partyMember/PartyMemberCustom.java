package ShallWe.Refactoring.repository.partyMember;

import ShallWe.Refactoring.domain.order.domain.Order;
import ShallWe.Refactoring.domain.partyMember.domain.PartyStatus;
import ShallWe.Refactoring.domain.partyMember.dto.PartyMemberResponse;

import java.util.List;

public interface PartyMemberCustom {
    List<PartyMemberResponse> findByOrderAndStatus(Order order, PartyStatus status);
    List<PartyMemberResponse> findByOrder(Order order) ;
}
