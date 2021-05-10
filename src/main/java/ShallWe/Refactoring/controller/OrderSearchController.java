package ShallWe.Refactoring.controller;

import ShallWe.Refactoring.domain.order.dto.OrderListResponseDto;
import ShallWe.Refactoring.domain.order.service.OrderService;
import ShallWe.Refactoring.domain.order.service.TagService;
import ShallWe.Refactoring.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderSearchController {

    private final OrderService orderService;
    private final UserService userService;
    private final TagService tagService;

    @GetMapping("/orders/searchByTag/{tagName}")
    public List<OrderListResponseDto> searchByTagName(@PathVariable("tagName") String tagName) {
        return orderService.searchByTag(tagName);
    }

    @GetMapping("/orders/searchByUserId/{userId}")
    public List<OrderListResponseDto> searchByUser(@PathVariable("userId") Long userId) {
        return orderService.searchByUserId(userId);
    }
}
