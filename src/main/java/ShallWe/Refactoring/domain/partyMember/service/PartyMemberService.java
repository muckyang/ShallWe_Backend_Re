package ShallWe.Refactoring.domain.partyMember.service;

import ShallWe.Refactoring.domain.order.domain.Order;
import ShallWe.Refactoring.domain.partyMember.domain.PartyMember;
import ShallWe.Refactoring.domain.partyMember.domain.PartyStatus;
import ShallWe.Refactoring.domain.partyMember.dto.PartyMemberRequest;
import ShallWe.Refactoring.domain.partyMember.dto.PartyMemberResponse;
import ShallWe.Refactoring.domain.user.domain.User;
import ShallWe.Refactoring.repository.partyMember.PartyMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartyMemberService {

    private final PartyMemberRepository partyMemberRepository;

    public void create(Long userId , Long orderId ,int price) {
//        PartyMember partyMember = PartyMember.builder()
//                .price(price)
//                .status(PartyStatus.JOIN)
//                .joinDescription("글 작성자 본인 입니다")
//                .build();
//        order.addPartyMember(partyMember);
////        order.getMembers().add(partyMember);
////        order.addPrice(price);
//        partyMemberRepository.save(partyMember);
    }

    public List<PartyMemberResponse> findByOrderAndStatus(Order order,PartyStatus status) {
        return partyMemberRepository.findByOrderAndStatus(order,status);
    }
    public List<PartyMemberResponse> findByOrder(Order order) {
        return partyMemberRepository.findByOrder(order);
    }
    public PartyMember joinRequestParty(User user, Order order, PartyMemberRequest request) {
        PartyMember partyMember = PartyMember.builder()
                .user(user)
                .order(order)
                .price(request.getPrice())
                .status(PartyStatus.WAITING)
                .joinDescription(request.getJoinDescription())
                .build();
        return partyMemberRepository.save(partyMember);
    }

    public void joinParty(Order order, User user) {
        PartyMember partyMember = findPartyMember(order, user);
        partyMember.joinApprove();
    }


    public void cancelParty(Order order, User user) {
        PartyMember partyMember = findPartyMember(order, user);
        partyMember.joinCancel();
    }

    public PartyMember findPartyMember(Order order, User user) {
        Optional<PartyMember> partyMember = partyMemberRepository.findByOrderAndUser(order, user);
        if (partyMember.isPresent()) {
            return partyMember.get();
        } else
            throw new NullPointerException("no have user");
    }
}
