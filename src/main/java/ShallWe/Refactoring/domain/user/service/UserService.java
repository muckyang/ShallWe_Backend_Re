package ShallWe.Refactoring.domain.user.service;

import ShallWe.Refactoring.domain.user.domain.User;
import ShallWe.Refactoring.domain.user.dto.UserListResponseDto;
import ShallWe.Refactoring.domain.user.dto.UserResponseDto;
import ShallWe.Refactoring.domain.user.dto.UserSaveRequestDto;
import ShallWe.Refactoring.domain.user.dto.UserUpdateRequestDto;
import ShallWe.Refactoring.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long save(UserSaveRequestDto request) throws Exception {
        if (canUseNickname(request.getNickname())) {
            return userRepository.save(request.toEntity()).getId();
        } else {
            throw new IllegalArgumentException("이미 존재하는 닉네임 입니다.");
        }
    }

    @Transactional(readOnly = true)
    public UserResponseDto findById(Long id) throws IllegalArgumentException {
        User user = findUser(id);
        return new UserResponseDto(user);
    }

    @Transactional(readOnly = true)
    public List<UserListResponseDto> findAll() {
        return userRepository.findUserAll();
    }

    public Long update(Long id, UserUpdateRequestDto request) {
        User user = findUser(id);
        user.update(request);
        return id;
    }

    public void banUser(Long id) {
        User user = findUser(id);
        user.getInfo().ban();
    }

    public void activeUser(Long id) {
        User user = findUser(id);
        user.getInfo().active();
    }

    @Transactional(readOnly = true)
    public Page<UserListResponseDto> getUserPage(Pageable pageable) {
        return userRepository.getUserPaging(pageable);
    }

    @Transactional(readOnly = true)
    public Slice<UserListResponseDto> getUserScroll(Pageable pageable) {
        return userRepository.getUserScroll(pageable);
    }

    public boolean canUseNickname(String nickname) throws Exception {
        return userRepository.findUserByNickname(nickname).isEmpty();
    }

    private User findUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
    }

}
