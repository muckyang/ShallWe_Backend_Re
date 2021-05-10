package ShallWe.Refactoring.domain.order.dto;

import ShallWe.Refactoring.domain.order.domain.Category;
import ShallWe.Refactoring.domain.order.domain.Order;
import ShallWe.Refactoring.domain.order.domain.Tag;
import ShallWe.Refactoring.domain.order.domain.OrderStatus;
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
public class OrderListResponseDto {
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
    private LocalDateTime createTime;
    private List<String> tags= new ArrayList<>();

    @QueryProjection
    public OrderListResponseDto(Order order){
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
