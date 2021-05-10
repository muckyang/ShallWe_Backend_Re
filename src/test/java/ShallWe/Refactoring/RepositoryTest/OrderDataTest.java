package ShallWe.Refactoring.RepositoryTest;

import ShallWe.Refactoring.domain.order.domain.Category;
import ShallWe.Refactoring.domain.order.domain.Order;
import ShallWe.Refactoring.domain.order.domain.OrderStatus;
import ShallWe.Refactoring.domain.order.domain.Tag;
import ShallWe.Refactoring.domain.user.domain.User;
import ShallWe.Refactoring.repository.order.OrderRepository;
import ShallWe.Refactoring.repository.user.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderDataTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Test
    @DisplayName("카테고리 오류")
    public void orderCreateFail() throws Exception {
        User user = userRepository.getOne(1L);
        String category = "NOPE";
        if (Category.contains(category)) {
            Order order = Order.builder()
                    .user(user)
                    .title("존재하지 않는 카테고리")
                    .description("FAIL!")
                    .endTime(LocalDateTime.now().plusHours(4))
                    .goalPrice(40000)
                    .category(Category.valueOf("NOPE"))
                    .status(OrderStatus.WAITING)
                    .build();
            orderRepository.save(order);
        }else {
            System.out.println("fail");
        }
    }

    @Test
    @DisplayName("주문 생성")
    @Rollback(false)
    public void orderCreate() throws Exception {
        User user = userRepository.getOne(1L);
        System.out.println(user.toString());
        Tag tag =new Tag("order");
        Order order = Order.builder()
                .user(user)
                .title("주문생성")
                .description("주문을 생성합니다.")
                .endTime(LocalDateTime.now().plusHours(4))
                .goalPrice(40000)
                .tags(new ArrayList<>())
                .category(Category.valueOf("SHARE"))
                .status(OrderStatus.WAITING)
                .build();
        order.getTags().add(tag);
        orderRepository.save(order);

        assertThat(order).isEqualTo(orderRepository.getOne(order.getId()));
        System.out.println(order.getId());

//        System.out.println (Arrays.toString(ad));
    }

}
