package ShallWe.Refactoring.ServiceTest;

import ShallWe.Refactoring.entity.address.Address;
import ShallWe.Refactoring.entity.user.Info;
import ShallWe.Refactoring.entity.user.User;
import ShallWe.Refactoring.entity.user.dto.UserRequest;
import ShallWe.Refactoring.entity.user.dto.UserResponse;
import ShallWe.Refactoring.repository.user.UserRepository;
import ShallWe.Refactoring.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
//    final Long USER_ID = 20L;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @InjectMocks
//    private UserService userService;
//
//    @Test
//    void createUser() {
//        UserRequest request = UserRequest.builder()
//                .id(USER_ID)
//                .name("Joe")
//                .password("12341234")
//                .email("12341234")
//                .nickname("nickname")
//                .city("seoul")
//                .street("New Street")
//                .detail("10-13")
//                .year(2012).month(5).day(12)
//                .build();
//        User user = request.toEntity();
////        given(userRepository.save(user)).willReturn(user);
//        assertThat(userService.save(request).getName()).isEqualTo(user.getName());
//        System.out.println(user.toString());
////        UserResponse response = userService.save(request);
////       assertThat(request.getName()).isEqualTo(response.getName());
//    }
}
