package ShallWe.Refactoring.controller;

import ShallWe.Refactoring.entity.order.Order;
import ShallWe.Refactoring.entity.order.dto.OrderListResponseDto;
import ShallWe.Refactoring.entity.order.dto.OrderResponse;
import ShallWe.Refactoring.entity.order.dto.OrderResponseDto;
import ShallWe.Refactoring.entity.order.dto.OrderSaveRequestDto;
import ShallWe.Refactoring.service.*;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;
    private final TagService tagService;
    private final PartyMemberService partyMemberService;
    private final ValidationService validationService;

    @PostMapping("/orders/create/{userId}")
    @ApiOperation("Order Create")
    public Long createOrder(@PathVariable("userId") Long userId,
                            @Valid @RequestBody OrderSaveRequestDto request) {
        return orderService.createOrder(userId, request);
    }

    @GetMapping("/orders/{id}")
    @ApiOperation("Order Get")
    public OrderResponseDto getOrder(@PathVariable("id") Long orderId) {
        return orderService.findById(orderId);
    }

    @GetMapping("/order-all")
    @ApiOperation("Order Get All")
    public List<OrderListResponseDto> getOrderAll() {
        return orderService.getAll();
    }

    @GetMapping("/orders/list/paging")
    @ApiOperation("Order List Paging")
    public Page<OrderListResponseDto> getOrderList(Pageable pageable) {
        return orderService.findByPaging(pageable);
    }

}
