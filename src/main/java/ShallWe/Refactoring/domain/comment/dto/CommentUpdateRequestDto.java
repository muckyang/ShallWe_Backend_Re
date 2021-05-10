package ShallWe.Refactoring.domain.comment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class CommentUpdateRequestDto {
    @NotBlank
    private String content;

    @Builder
    protected CommentUpdateRequestDto(String content) {
        this.content = content;
    }

//    public Comment toEntity(Order order, User user) {
//        return Comment.builder()
//                .order(order)
//                .user(user)
//                .content(content)
//                .status(CommentStatus.UPDATED)
//                .build();
//    }

}
