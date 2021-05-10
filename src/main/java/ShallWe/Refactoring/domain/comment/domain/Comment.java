package ShallWe.Refactoring.domain.comment.domain;

import ShallWe.Refactoring.domain.base.BaseEntity;
import lombok.*;
import ShallWe.Refactoring.domain.order.domain.Order;
import ShallWe.Refactoring.domain.user.domain.User;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Table(name = "comment")
public class Comment extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    private String content;

    //TODO update -> Logger / status change Updated
    @Enumerated(EnumType.STRING)
    private CommentStatus status;

    public void setOrder(Order order){
        this.order = order;
        order.addComment(this);
    }

    public void update(String content){
        this.content = content;
        status = CommentStatus.UPDATED;
    }


}
