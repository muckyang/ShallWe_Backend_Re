package ShallWe.Refactoring.repository.order;


import ShallWe.Refactoring.entity.order.Order;
import ShallWe.Refactoring.entity.order.dto.OrderListResponseDto;
import ShallWe.Refactoring.entity.order.dto.OrderResponse;
import ShallWe.Refactoring.entity.order.dto.QOrderListResponseDto;
import ShallWe.Refactoring.entity.order.dto.QOrderResponse;
import ShallWe.Refactoring.entity.user.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.EntityManager;
import java.util.List;

import static ShallWe.Refactoring.entity.order.QOrder.order;
import static ShallWe.Refactoring.entity.tag.QTag.tag;
import static ShallWe.Refactoring.entity.user.QUser.*;

public class OrderSearchCustomImpl implements OrderSearchCustom {

    private final JPAQueryFactory queryFactory;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public OrderSearchCustomImpl(EntityManager em) {
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<OrderListResponseDto> searchByTagName(String tagName) {
        List<OrderListResponseDto> results = queryFactory.select(new QOrderListResponseDto(tag.order))
                .from(tag)
                .join(tag.order, order)
                .where(tag.name.eq(tagName))
                .fetch();
        logger.info(results.size()+"");

        return results;
    }

    @Override
    public List<OrderListResponseDto> searchByUser(User findUser) {
        List<OrderListResponseDto> results = queryFactory.select(new QOrderListResponseDto(order))
                .from(order)
                .join(order.user, user).fetchJoin()
                .where(order.user.eq(findUser))
                .fetch();
        logger.info(results.size()+"");
        return results;
    }
}
