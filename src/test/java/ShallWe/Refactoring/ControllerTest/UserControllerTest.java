package ShallWe.Refactoring.ControllerTest;


import ShallWe.Refactoring.controller.UserController;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.hamcrest.core.Is.is;

//DB 접근을 하지않기 떄문에 DB 설정파일 지정도 필요없다.
@WebMvcTest(UserController.class)
public class UserControllerTest {

//    @Autowired
//    MockMvc mvc;
//
//    @MockBean
//    UserService userService;
//
//    @BeforeEach
//    public void before() {
//        UserRequest request = UserRequest.builder()
//                .id(1L)
//                .name("Joe")
//                .password("12341234")
//                .email("12341234")
//                .nickname("nickname")
//                .city("12341234").street("12341234").detail("12341234")
//                .year(2012).month(5).day(12)
//                .build();
////        ObjectMapper mapper = new ObjectMapper();
////        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//
//
//        ArrayList<UserResponse> userList = new ArrayList<>();
//        userList.add(new UserResponse(new User(request)));
//        given(this.userService.findAll()).willReturn(userList);
//        given(this.userService.findUser(1L)).willReturn(new User(request));
//    }
//
//
//    @Test
//    @DisplayName("유저 목록 출력")
//    public void getUsers() throws Exception {
//        System.out.println("=========================GET USERS=======================");
//        mvc.perform(get("/api/user-all").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andDo(print());
//    }
//
//    @Test
//    @DisplayName("유저 GET")
//    public void getUser() throws Exception {
//        System.out.println("=========================GET USER 1=======================");
//        mvc.perform(get("/api/users/" + 1).accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name", is("Joe")))
////                .andDo(MockMvcResultHandlers.print())
//                .andDo(print());
//
//        ResultActions actions =
//                mvc.perform(get("/api/users/" + 1).contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//        actions.andDo(print()) ;
//    }

}
