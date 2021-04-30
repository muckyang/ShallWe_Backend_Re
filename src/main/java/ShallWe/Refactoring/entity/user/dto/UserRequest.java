package ShallWe.Refactoring.entity.user.dto;


import ShallWe.Refactoring.entity.address.Address;
import ShallWe.Refactoring.entity.user.Info;
import ShallWe.Refactoring.entity.user.User;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRequest {
    private Long id;
    @Email(message = "Email 형식이 아닙니다.")
    @NotNull
    private String email;
    @NotNull(message = "값이 필요합니다.")
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String nickname;

    //address
    private String city;
    private String street;
    private String detail;

    //info_birthday
    private int year;
    private int month;
    private int day;

    public User toEntity(){
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
