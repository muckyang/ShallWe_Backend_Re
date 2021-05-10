package ShallWe.Refactoring.repository.order;

import ShallWe.Refactoring.entity.order.dto.OrderListResponseDto;
import ShallWe.Refactoring.entity.order.dto.OrderResponse;
import ShallWe.Refactoring.entity.user.User;

import java.util.List;

public interface OrderSearchCustom {
    List<OrderListResponseDto> searchByTagName(String tagName);
    List<OrderListResponseDto> searchByUser(User user);
}
