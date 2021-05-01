package ShallWe.Refactoring.entity.user.dto;


import ShallWe.Refactoring.entity.address.Address;
import ShallWe.Refactoring.entity.user.Info;
import ShallWe.Refactoring.entity.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {
    @NotNull(message = "name를 입력하세요.")
    private String name;
    @NotNull(message = "nickname을 입력하세요.")
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
    public UserUpdateRequestDto(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .nickname(nickname)
                .address(Address.builder().city(city).street(street).detail(detail).build())
                .info(Info.builder().year(year).month(month).day(day).build())
                .build();
    }
}
