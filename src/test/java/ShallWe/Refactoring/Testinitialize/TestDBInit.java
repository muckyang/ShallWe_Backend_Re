package ShallWe.Refactoring.Testinitialize;


import ShallWe.Refactoring.entity.address.Address;
import ShallWe.Refactoring.entity.comment.Comment;
import ShallWe.Refactoring.entity.comment.CommentStatus;
import ShallWe.Refactoring.entity.comment.dto.CommentRequest;
import ShallWe.Refactoring.entity.order.Category;
import ShallWe.Refactoring.entity.order.Order;
import ShallWe.Refactoring.entity.order.OrderStatus;
import ShallWe.Refactoring.entity.order.dto.OrderRequest;
import ShallWe.Refactoring.entity.partyMember.PartyMember;
import ShallWe.Refactoring.entity.partyMember.PartyStatus;
import ShallWe.Refactoring.entity.partyMember.dto.PartyMemberRequest;
import ShallWe.Refactoring.entity.tag.Tag;
import ShallWe.Refactoring.entity.user.Info;
import ShallWe.Refactoring.entity.user.User;
import ShallWe.Refactoring.entity.user.dto.UserRequest;

import ShallWe.Refactoring.repository.comment.CommentRepository;
import ShallWe.Refactoring.repository.partyMember.PartyMemberRepository;
import ShallWe.Refactoring.service.*;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
        properties = {"spring.config.location=classpath:application-test.yml"}
)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
@Rollback(false)
public class TestDBInit {

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
    @org.junit.jupiter.api.Order(1)
    @DisplayName("유저 데이터 생성")
    public void init() {
        for(int num = 1 ;num<100;num++) {
            createUser(num);
        }
        logger.info("User Initialize COMPLETED");
    }

    private void createUser(int num) {
        String randomNum = (int) (Math.random() * 1000) + (num * 1000) + "";
        String name = "Clone" + randomNum;
        String email = "user" + randomNum + "@naver.com";
        String password = "12341234";
        String nickname = "nick" + randomNum;
        String city = "seoul";
        String street = randomNum + "street";
        String detail = "room 1" + randomNum;
        int year = (int) (Math.random() * 30) + 1990;
        int month = (int) (Math.random() * 12) + 1;
        int day = (int) (Math.random() * 28) + 1;

        UserRequest userReq = UserRequest.builder()
                .name(name)
                .password(password)
                .email(email)
                .nickname(nickname)
                .city(city)
                .street(street)
                .detail(detail)
                .year(year)
                .month(month)
                .day(day)
                .build();
        userService.save(userReq);
    }

    @Test
    @org.junit.jupiter.api.Order(2)
    @DisplayName("주문 데이터 생성")
    public void saveOrder() {
        List<String> tags = new ArrayList<>();
        tags.add("치킨");
        tags.add("음식");

        OrderRequest request = OrderRequest.builder()
                .userId(1L)
                .title("치킨먹을사람~")
                .description("치킨 같이 시켜 먹어요!")
                .tags(tags)
                .category(Category.DELIVERY.toString())
                .goalPrice(32000)
                .endTime(LocalDateTime.now().plusHours(4L))
                .build();

        User user = userService.findUser(request.getUserId());

        OrderRequest orderReq = OrderRequest.builder()
                .userId(user.getId())
                .title(request.getTitle())
                .description(request.getDescription())
                .endTime(request.getEndTime())
                .tags(new ArrayList<>())
                .goalPrice(request.getGoalPrice())
                .category("DELIVERY")
                .build();

        logger.info(orderReq.toString());
        Order order =orderService.createOrder(orderReq,user);
        logger.info("before tag Save");

        List<String> tagReqList = request.getTags();
        for (String tagName : tagReqList) {
            Tag tag = new Tag(tagName);
            tag.setOrder(order);
        }
        tagService.createTags(order,tagReqList);

        logger.info("before Party New");
        PartyMember partyMember= PartyMember.builder()
                .user(user)
                .order(order)
                .price(6000)
                .status(PartyStatus.JOIN)
                .joinDescription("글 게시자 본인 입니다.")
                .build();

        logger.info("before Party Save");
        partyMemberRepository.save(partyMember);

        logger.info("complete");
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    @DisplayName("댓글 등록")
    public void create() throws Exception {
        Order order = orderService.findOrder(1L);
        User user = userService.findUser(2L);
//        CommentRequest commentReq = CommentRequest.builder()
//                .orderId(1L)
//                .userId(1L)
//                .content("댓글 작성 합니다")
//                .build();

        Comment comment = commentService.createComment(order,user,"댓글작성합니다");

        commentRepository.save(comment);
        order.addComment(comment);
        assertThat(comment).isEqualTo(commentRepository.getOne(comment.getId()));

    }

}
