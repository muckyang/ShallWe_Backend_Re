package ShallWe.Refactoring.domain.order.dto;

import ShallWe.Refactoring.domain.order.domain.Category;
import ShallWe.Refactoring.domain.order.domain.Order;
import ShallWe.Refactoring.domain.order.domain.Tag;
import ShallWe.Refactoring.domain.user.domain.User;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class OrderSaveRequestDto {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private int goalPrice;
    @NotBlank
    private String category;
    private List<String> tags;
    @NotBlank
    private LocalDateTime endTime;
    private int pay;

    public Order toEntity(User user){
        return Order.builder()
                .user(user)
                .title(title)
                .description(description)
                .goalPrice(goalPrice)
                .category(Category.getCategory(category))
                .tags(tags.stream().map(Tag::new).collect(Collectors.toList()))
                .sumPrice(pay)
                .endTime(endTime)
                .build();
    }
}
