package ShallWe.Refactoring.RepositoryTest;

import ShallWe.Refactoring.domain.user.domain.Address;
import ShallWe.Refactoring.domain.user.domain.Info;
import ShallWe.Refactoring.domain.user.domain.User;
import ShallWe.Refactoring.repository.user.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserDataTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("회원 생성 및 조회")
    @Transactional
    public void userSave() throws Exception {
        User user = User.builder()
                .name("Joe")
                .password("12341234")
                .email("12341234")
                .nickname("nickname")
                .address(Address.builder()
                        .city("12341234")
                        .street("12341234")
                        .detail("12341234")
                        .build())
                .info(Info.builder().year(2012).month(5).day(12).build())
                .build();

        System.out.println(user.toString());

        userRepository.save(user);
        userRepository.findAll().forEach(System.out::println);

        assertThat(user).isEqualTo(userRepository.getOne(user.getId()));
    }

    @Test
    @DisplayName("닉네임 중복 체크 테스트")
    public void DuplicateNicknameTest(){
        String duplicateNick = "nick1673";
        String newNick = "nick1673234";
        Optional<User> present = userRepository.findUserByNickname(duplicateNick);
        assertThat(present.isPresent()).isEqualTo(true);
        Optional<User> empty = userRepository.findUserByNickname(newNick);
        assertThat(empty.isEmpty()).isEqualTo(true);
    }

}
