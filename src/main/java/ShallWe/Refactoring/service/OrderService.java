package ShallWe.Refactoring.service;

import ShallWe.Refactoring.entity.order.Category;
import ShallWe.Refactoring.entity.order.Order;
import ShallWe.Refactoring.entity.order.dto.*;
import ShallWe.Refactoring.entity.partyMember.dto.PartyMemberRequest;
import ShallWe.Refactoring.entity.user.User;
import ShallWe.Refactoring.repository.order.OrderRepository;
import ShallWe.Refactoring.repository.partyMember.PartyMemberRepository;
import ShallWe.Refactoring.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final PartyMemberService partyMemberService;

    @Transactional(readOnly = true)
    public OrderResponseDto findById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 주문입니다. id = " + id));
        return new OrderResponseDto(order);
    }

    public Long createOrder(Long userId, OrderSaveRequestDto request) throws IllegalArgumentException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다. User ID=" + userId));
        Order order = orderRepository.save(request.toEntity(user));
        partyMemberService.create(user.getId(),order.getId(),request.getPay());
        return order.getId();
    }

    public List<OrderListResponseDto> getAll() {
        List<OrderListResponseDto> result = new ArrayList<>();
        for (Order order : orderRepository.findAll())
            result.add(new OrderListResponseDto(order));
        return result;
    }

    public List<OrderListResponseDto> searchByTag(String tagName) {
        return orderRepository.searchByTagName(tagName);
    }

    public List<OrderListResponseDto> searchByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + userId));
        return orderRepository.searchByUser(user);
    }

    public Page<OrderListResponseDto> findByPaging(Pageable pageable) {
        return orderRepository.getOrderPaging(pageable);
    }

}
