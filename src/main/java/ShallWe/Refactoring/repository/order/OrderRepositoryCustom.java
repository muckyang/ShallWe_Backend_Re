package ShallWe.Refactoring.repository.order;

import ShallWe.Refactoring.domain.order.dto.OrderListResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface OrderRepositoryCustom {
    Page<OrderListResponseDto> getOrderPaging(Pageable pageable);
    Slice<OrderListResponseDto> getOrderScroll(Pageable pageable);

}
