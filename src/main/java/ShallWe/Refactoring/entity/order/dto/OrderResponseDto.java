package ShallWe.Refactoring.entity.order.dto;

import ShallWe.Refactoring.entity.order.Category;
import ShallWe.Refactoring.entity.order.Order;
import ShallWe.Refactoring.entity.order.OrderStatus;
import ShallWe.Refactoring.entity.tag.Tag;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@ToString(of={"id","userId","title","description"})
public class OrderResponseDto {
    private Long id;
    private Long userId;
    private String title;
    private String description;
    private int goalPrice;
    private int sumPrice;
    private int likeCount;
    private int commentCount;
    private OrderStatus status;
    private Category category;
    private List<String> tags= new ArrayList<>();
    private LocalDateTime createTime;

    @QueryProjection
    public OrderResponseDto(Order order){
        this.id  = order.getId();
        this.userId  = order.getUser().getId();
        this.title  = order.getTitle();
        this.description  = order.getDescription();
        this.goalPrice  = order.getGoalPrice();
        this.sumPrice  = order.getSumPrice();
        this.likeCount  = order.getLikeCount();
        this.commentCount  = order.getCommentCount();
        this.status  = order.getStatus();
        this.tags = order.getTags().stream().map(Tag::getName).collect(Collectors.toList());
        this.category  = order.getCategory();
        this.createTime = order.getCreateTime();
    }

}
