package ShallWe.Refactoring.repository.order;

import ShallWe.Refactoring.domain.order.domain.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends OrderRepositoryCustom,OrderSearchCustom, JpaRepository<Order, Long> {
//    Page<Order> findByUser(User user, Pageable pageable);

    @EntityGraph(attributePaths = {"user"})
    @Query("select o from Order o")
    List<Order> findEntityGraphOrder();

    @Query("select o from Order o join fetch o.user")
    List<Order> findFetchJoin();

}
