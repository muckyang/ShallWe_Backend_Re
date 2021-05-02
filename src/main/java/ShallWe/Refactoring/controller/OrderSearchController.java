package ShallWe.Refactoring.controller;

import ShallWe.Refactoring.entity.order.dto.OrderListResponseDto;
import ShallWe.Refactoring.entity.order.dto.OrderResponse;
import ShallWe.Refactoring.entity.user.User;
import ShallWe.Refactoring.service.OrderService;
import ShallWe.Refactoring.service.TagService;
import ShallWe.Refactoring.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
