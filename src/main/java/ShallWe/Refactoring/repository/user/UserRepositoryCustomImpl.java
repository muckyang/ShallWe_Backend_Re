package ShallWe.Refactoring.repository.user;

import ShallWe.Refactoring.entity.user.dto.*;
import ShallWe.Refactoring.entity.user.User;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static ShallWe.Refactoring.entity.user.QUser.user;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public UserRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<UserListResponseDto> findUserAll() {
        return queryFactory
                .select(new QUserListResponseDto(user))
                .from(user)
                .fetch();
    }

    @Override
    public Page<UserListResponseDto> getUserPaging(Pageable pageable) {

        QueryResults<User> result = queryFactory
                .selectFrom(user)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<UserListResponseDto> content = new ArrayList<>();
        for (User eachUser : result.getResults()) {
            content.add(new UserListResponseDto(eachUser));
        }
        long total = result.getTotal();
        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public Slice<UserListResponseDto> getUserScroll(Pageable pageable) {
        QueryResults<User> result = queryFactory
                .selectFrom(user)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize() + 1)
                .fetchResults();

        List<UserListResponseDto> content = new ArrayList<>();
        for (User eachUser : result.getResults()) {
            content.add(new UserListResponseDto(eachUser));
        }

        boolean hasNext = false;
        if (content.size() > pageable.getPageSize()) {
            content.remove(pageable.getPageSize());
            hasNext = true;
        }
        return new SliceImpl<>(content, pageable, hasNext);
    }

}
