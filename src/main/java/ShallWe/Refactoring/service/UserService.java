package ShallWe.Refactoring.service;

import ShallWe.Refactoring.entity.user.User;
import ShallWe.Refactoring.entity.user.UserStatus;
import ShallWe.Refactoring.entity.user.dto.UserRequest;
import ShallWe.Refactoring.entity.user.dto.UserResponse;
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
//    @Autowired
//    ModelMapper modelMapper;

    public Long save(UserRequest request) throws Exception {
        if (canUseNickname(request.getNickname())) {
            return userRepository.save(request.toEntity()).getId();
        } else {
            throw new IllegalArgumentException("이미 존재하는 닉네임 입니다.");
        }
    }

    public User findUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new NullPointerException("Order is null");
    }

    public List<UserResponse> findAll() {
        return userRepository.findUserAll();
    }

    public void banUser(Long userId) {
        User user = userRepository.getOne(userId);
        user.getInfo().setUserStatus(UserStatus.BAN);

    }

    public void activeUser(Long userId) {
        User user = userRepository.getOne(userId);
        user.getInfo().setUserStatus(UserStatus.ACTIVE);
    }

    public Page<UserResponse> getUserPage(Pageable pageable) {
        return userRepository.getUserPaging(pageable);
    }

    public Slice<UserResponse> getUserScroll(Pageable pageable) {
        return userRepository.getUserScroll(pageable);
    }

    public boolean canUseNickname(String nickname) throws Exception {
        Optional<User> userOpt = userRepository.findUserByNickname(nickname);
        return userOpt.isEmpty();
    }

}
