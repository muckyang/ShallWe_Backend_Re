package ShallWe.Refactoring.entity.user.dto;


import ShallWe.Refactoring.entity.address.Address;
import ShallWe.Refactoring.entity.user.Info;
import ShallWe.Refactoring.entity.user.User;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    @Email(message = "Email 형식이 아닙니다.")
    @NotNull(message = "email을 입력하세요.")
    private String email;
    @NotNull(message = "password를 입력하세요.")
    private String password;
    @NotNull(message = "name를 입력하세요.")
    private String name;
    @NotNull(message = "nickname값이 필요합니다.")
    private String nickname;

    //address
    private String city;
    private String street;
    private String detail;

    //info_birthday
    private int year;
    private int month;
    private int day;

    @Builder
    public UserSaveRequestDto(String email, String password, String name, String nickname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
    }

    public User toEntity() {
        return User.builder()
                .email(email)
                .name(name)
                .password(password)
                .nickname(nickname)
                .address(Address.builder().city(city).street(street).detail(detail).build())
                .info(Info.builder().year(year).month(month).day(day).build())
                .build();
    }
}
