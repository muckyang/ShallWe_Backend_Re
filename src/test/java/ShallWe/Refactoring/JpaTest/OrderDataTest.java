package ShallWe.Refactoring.JpaTest;

import ShallWe.Refactoring.entity.order.Category;
import ShallWe.Refactoring.entity.order.Order;
import ShallWe.Refactoring.entity.order.OrderStatus;
import ShallWe.Refactoring.entity.user.User;
import ShallWe.Refactoring.repository.order.OrderRepository;
import ShallWe.Refactoring.repository.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest(properties = {"spring.config.location=classpath:application-init.yml"})
public class OrderDataTest {

    @Autowired
    UserRepository userRepository;

//    @Autowired
//    OrderRepository orderRepository;
//
//    @Test
//    @DisplayName("카테고리 오류")
//    public void orderCreateFail() throws Exception {
//        User user = userRepository.getOne(1L);
//        String category = "NOPE";
//        if (Category.contains(category)) {
//            Order order = Order.builder()
//                    .user(user)
//                    .title("존재하지 않는 카테고리")
//                    .description("FAIL!")
//                    .endTime(LocalDateTime.now().plusHours(4))
//                    .goalPrice(40000)
//                    .category(Category.valueOf("NOPE"))
//                    .status(OrderStatus.WAITING)
//                    .build();
//            orderRepository.save(order);
//        }else {
//            System.out.println("fail");
//        }
//    }

//    @Test
//    @DisplayName("주문 생성")
//    public void orderCreate() throws Exception {
//        User user = userRepository.getOne(1L);
//
//        Order order = Order.builder()
//                .user(user)
//                .title("주문생성")
//                .description("주문을 생성합니다.")
//                .endTime(LocalDateTime.now().plusHours(4))
//                .goalPrice(40000)
//                .category(Category.valueOf("SHARE"))
//                .status(OrderStatus.WAITING)
//                .build();
//        orderRepository.save(order);
//
//        assertThat(order).isEqualTo(orderRepository.getOne(order.getId()));
//        System.out.println(order.getId());
//    }
//
//    @Test
//    @DisplayName("주문 삭제")
//    public void orderDelete() throws Exception {
//        Order order = orderRepository.getOne(1L);
//        orderRepository.deleteAll();
//        System.out.println(orderRepository.getOne(1L).getId());
//        try {
//            assertThat(order).isEqualTo(orderRepository.getOne(1L));
//            System.out.println("아직 남아 있는 경우");
//        } catch (NullPointerException e) {
//            System.out.println("삭제되어 없음");
//            e.printStackTrace();
//        }
//    }
}
