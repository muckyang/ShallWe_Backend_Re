package ShallWe.Refactoring.repository.order;

import ShallWe.Refactoring.domain.order.dto.OrderListResponseDto;
import ShallWe.Refactoring.domain.user.domain.User;

import java.util.List;

public interface OrderSearchCustom {
    List<OrderListResponseDto> searchByTagName(String tagName);
    List<OrderListResponseDto> searchByUser(User user);
}
