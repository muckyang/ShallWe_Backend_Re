package ShallWe.Refactoring.service;

import ShallWe.Refactoring.entity.user.User;
import ShallWe.Refactoring.entity.user.UserStatus;
import ShallWe.Refactoring.entity.user.dto.*;
import ShallWe.Refactoring.exception.DuplicationNicknameException;
import ShallWe.Refactoring.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    public UserResponseDto findById(Long id) throws IllegalArgumentException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        return new UserResponseDto(user);
    }

    public List<UserListResponseDto> findAll() {
        return userRepository.findUserAll();
    }

    public Long update(Long id, UserUpdateRequestDto request) throws IllegalArgumentException{
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        user.update(request);
        return id;
    }

    public void banUser(Long userId) {
        User user = userRepository.getOne(userId);
        user.getInfo().setUserStatus(UserStatus.BAN);

    }

    public void activeUser(Long userId) {
        User user = userRepository.getOne(userId);
        user.getInfo().setUserStatus(UserStatus.ACTIVE);
    }

    public Page<UserListResponseDto> getUserPage(Pageable pageable) {
        return userRepository.getUserPaging(pageable);
    }

    public Slice<UserListResponseDto> getUserScroll(Pageable pageable) {
        return userRepository.getUserScroll(pageable);
    }

    public boolean canUseNickname(String nickname) throws Exception {
        Optional<User> userOpt = userRepository.findUserByNickname(nickname);
        return userOpt.isEmpty();
    }

}
