package ShallWe.Refactoring.controller;

import ShallWe.Refactoring.entity.user.dto.*;
import ShallWe.Refactoring.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final UserService userService;

    @PostMapping("/users")
    @ApiOperation(value = "회원가입")
    public Long joinUser(@Valid @RequestBody UserSaveRequestDto request) throws Exception {
        return userService.save(request);
    }

    @GetMapping("/users/{id}")
    @ApiOperation("회원 조회")
    public UserResponseDto getUser(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping("/user-all")
    @ApiOperation("전체 회원 조회")
    public List<UserListResponseDto> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/checkNickname/{nickname}")
    @ApiOperation(value = "닉네임 중복 체크")
    public ResponseEntity<String> nicknameCheck(@PathVariable String nickname) throws Exception {
        if (userService.canUseNickname(nickname)) {
            return new ResponseEntity<>("Available nickname.", HttpStatus.OK);
        } else
            return new ResponseEntity<>("Duplication nickname", HttpStatus.OK);
    }

    @GetMapping("/users/paging")
    @ApiOperation("유저 조회 페이징")
    public Page<UserListResponseDto> getUserPaging(Pageable pageable) {
        return userService.getUserPage(pageable);
    }

    @GetMapping("/users/scroll")
    @ApiOperation("유저 조회 스크롤링")
    public Slice<UserListResponseDto> getUserScroll(Pageable pageable) {
        return userService.getUserScroll(pageable);
    }

    @PutMapping("/users/{id}")
    @ApiOperation("회원 수정")
    public Long updateUser(@PathVariable Long id,@RequestBody UserUpdateRequestDto request) {
        return userService.update(id,request);
    }


    //관리자 기능
    @PutMapping("/user/ban/{id}")
    @ApiOperation("회원 밴")
    public String banUser(@PathVariable Long id) {
        userService.banUser(id);
        return "ban success!";
    }

    @PatchMapping("/user/active/{id}")
    @ApiOperation("회원 활성화")
    public String activeUser(@PathVariable Long id) {
        userService.activeUser(id);
        return "ban success!";
    }

}


