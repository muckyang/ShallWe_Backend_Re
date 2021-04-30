package ShallWe.Refactoring.entity.user;

import ShallWe.Refactoring.entity.BaseEntity;
import ShallWe.Refactoring.entity.address.Address;
import ShallWe.Refactoring.entity.order.Order;
import ShallWe.Refactoring.entity.user.dto.UserSaveRequestDto;
import ShallWe.Refactoring.entity.user.dto.UserUpdateRequestDto;
import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString(of = {"name", "email", "nickname", "address", "info",})
@Table(name = "user")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String name;
    private String email;
    private String password;
    private String nickname;
    @Embedded
    private Address address;
    @Embedded
    @Column(name = "user_info")
    private Info info;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private final List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }
    
    public void update(UserUpdateRequestDto request){
        this.nickname =request.getNickname();
        this.name =request.getName();
        // TODO 주소랑 상세정보 변경 로직
    }

}
