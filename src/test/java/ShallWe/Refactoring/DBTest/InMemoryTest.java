package ShallWe.Refactoring.DBTest;


import ShallWe.Refactoring.entity.user.dto.UserListResponseDto;
import ShallWe.Refactoring.repository.comment.CommentRepository;
import ShallWe.Refactoring.repository.partyMember.PartyMemberRepository;
import ShallWe.Refactoring.service.*;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InMemoryTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private TagService tagService;
    @Autowired
    private CommentService commentService;

    @Autowired
    private PartyMemberRepository partyMemberRepository;
    @Autowired
    private CommentRepository commentRepository;


    @BeforeEach
    public void before() {
        logger.trace("*************** Start Test DB Init *******************");
    }

    @Test
    @org.junit.jupiter.api.Order(100)
    @DisplayName("유저 데이터 조회")
    public void init() {
        List<UserListResponseDto>userList = userService.findAll();
        userList.forEach(System.out::println);
    }


}
