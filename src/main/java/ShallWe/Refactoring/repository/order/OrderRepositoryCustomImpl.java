package ShallWe.Refactoring.repository.order;

import ShallWe.Refactoring.domain.order.domain.Order;
import ShallWe.Refactoring.domain.order.dto.OrderListResponseDto;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static ShallWe.Refactoring.entity.order.QOrder.*;

public class OrderRepositoryCustomImpl implements OrderRepositoryCustom{


    JPAQueryFactory queryFactory;

    public OrderRepositoryCustomImpl(EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<OrderListResponseDto> getOrderPaging(Pageable pageable) {

        QueryResults<Order> result = queryFactory
                .select(order).from(order)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<OrderListResponseDto> content = new ArrayList<>();
        for (Order eachOrder : result.getResults()) {
            content.add(new OrderListResponseDto(eachOrder));
        }

        long total = result.getTotal();
        return new PageImpl<>(content,pageable,total);
    }

    @Override
    public Slice<OrderListResponseDto> getOrderScroll(Pageable pageable) {

        QueryResults<Order> result = queryFactory
                .selectFrom(order)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize() + 1)
                .fetchResults();

        List<OrderListResponseDto> content = new ArrayList<>();
        for (Order eachOrder : result.getResults()) {
            content.add(new OrderListResponseDto(eachOrder));
        }

        boolean hasNext = false;
        if (content.size() > pageable.getPageSize()) {
            content.remove(pageable.getPageSize());
            hasNext = true;
        }

        return new SliceImpl<>(content,pageable,hasNext);
    }
}
