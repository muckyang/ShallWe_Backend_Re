package ShallWe.Refactoring.repository.user;

import ShallWe.Refactoring.entity.user.dto.UserListResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface UserRepositoryCustom {
    List<UserListResponseDto> findUserAll();

    Page<UserListResponseDto> getUserPaging(Pageable pageable);
    Slice<UserListResponseDto> getUserScroll(Pageable pageable);
//    public Page<UserResponse> findByInfoPoint(int point, Pageable pageable);

}

