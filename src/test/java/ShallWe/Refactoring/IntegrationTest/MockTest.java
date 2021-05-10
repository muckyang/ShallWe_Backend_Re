package ShallWe.Refactoring.IntegrationTest;

import ShallWe.Refactoring.domain.user.dto.UserListResponseDto;
import ShallWe.Refactoring.domain.user.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.WebApplicationContext;


import static org.assertj.core.api.BDDAssertions.then;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MockTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MockMvc mvc;

    @Autowired
    private UserService userService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private WebApplicationContext ctx;


    @BeforeEach
    public void before() {
        log.info("##### USER GET 테스트 #####");
        log.info("******** START : MOC MVC test **********");
    }

    @AfterEach
    public void after() {
        log.info("******** END : MOC MVC test **********");
    }

    @Test
    public void getUser() throws Exception {
        int userId = 1;
        mvc.perform(get("/api/users/" + userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    public void getAllUsers() throws Exception {
        mvc.perform(get("/api/user-all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }



    public void getMemberRes(Long userId) throws Exception {
        ResponseEntity<UserListResponseDto> response =
                restTemplate.getForEntity("/api/users/" + userId, UserListResponseDto.class);

        then(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(response.getBody()).isNotNull();

    }

}
