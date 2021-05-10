package ShallWe.Refactoring.repository.partyMember;

import ShallWe.Refactoring.domain.order.domain.Order;
import ShallWe.Refactoring.domain.partyMember.domain.PartyMember;
import ShallWe.Refactoring.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartyMemberRepository extends PartyMemberCustom, JpaRepository<PartyMember,Long> {
    Optional<PartyMember> findByOrderAndUser(Order order, User user);

}
