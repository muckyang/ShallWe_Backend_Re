package ShallWe.Refactoring.entity.order;

import ShallWe.Refactoring.entity.BaseEntity;
import ShallWe.Refactoring.entity.tag.Tag;
import lombok.*;
import ShallWe.Refactoring.entity.comment.Comment;
import ShallWe.Refactoring.entity.like.OrderLike;
import ShallWe.Refactoring.entity.partyMember.PartyMember;
import ShallWe.Refactoring.entity.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
//@Setter
// 없앨수는 없음 변경이 필요한 경우도 있기 때문 아니면 SET메소드 다 작성해야함
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(of = {"id","title", "description", "category", "status", "goalPrice", "sumPrice", "endTime"})
@Table(name = "orders")
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String title;
    private String description;
    private int goalPrice;
    private int sumPrice;

    private int likeCount;
    private int commentCount;

    @OneToMany(mappedBy = "order")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "order",cascade = CascadeType.REMOVE)
    private List<OrderLike> orderLikeList = new ArrayList<>();

    @OneToMany(mappedBy = "order",cascade = CascadeType.REMOVE)
    private List<Tag> tags = new ArrayList<>();

    // TODO image, url, Kakao Talk link 추가

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<PartyMember> members = new ArrayList<>();

    @Column(name = "order_end_time")
    private LocalDateTime endTime;



    // 연관 관계 편의 메소드
    public void setUser(User user) {
        this.user = user;
        user.addOrder(this);
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public void addPrice(int price) {
        sumPrice += price;
        if (overGoalPrice()) {
            status = OrderStatus.COMP_READY;
        }
    }

    public void addPartyMember(PartyMember partyMember) {
        members.add(partyMember);
        addPrice(partyMember.getPrice());
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        commentCount++;
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
        commentCount--;
    }

    public boolean overGoalPrice() {
        return goalPrice <= sumPrice;
    }

    public boolean isWriter(User user) {
        return user.getId().equals(this.user.getId());
    }
}


