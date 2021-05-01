package ShallWe.Refactoring.entity.order.dto;

import ShallWe.Refactoring.entity.order.Order;
import ShallWe.Refactoring.entity.tag.Tag;
import lombok.Builder;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Builder
public class OrderSaveRequestDto {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private int goalPrice;
    @NotBlank
    private String category;
    private List<String> tags ;
    @NotBlank
    private LocalDateTime endTime;
    private int pay;

    public Order toEntity(){
        return Order.builder()
                .title(title)
                .description(description)
                .goalPrice(goalPrice)
                .tags(tags.stream().map(Tag::new).collect(Collectors.toList()))
                .sumPrice(pay)
//                .category(cate)
                .build();
    }
}
