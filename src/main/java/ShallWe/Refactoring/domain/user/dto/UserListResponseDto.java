package ShallWe.Refactoring.domain.user.dto;


import ShallWe.Refactoring.domain.user.domain.Address;
import ShallWe.Refactoring.domain.user.domain.User;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@ToString(of = {"name","email"})
public class UserListResponseDto {
    private Long id;
    private String email;
    private String name;
    private String nickname;
    private String city;
    private String street;
    private String detail;
    private int year;
    private int month;
    private int day;

    @QueryProjection
    public UserListResponseDto(User entity) {
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.name = entity.getName();
        this.nickname = entity.getNickname();
        setAddress(entity.getAddress());
        setBirthDay(entity.getInfo().getBirthday());
    }

    private void setAddress(Address address) {
        this.city = address.getCity();
        this.street = address.getStreet();
        this.detail = address.getDetail();
    }

    private void setBirthDay(LocalDate time) {
        this.year = time.getYear();
        this.month = time.getMonthValue();
        this.day = time.getDayOfMonth();
    }
}