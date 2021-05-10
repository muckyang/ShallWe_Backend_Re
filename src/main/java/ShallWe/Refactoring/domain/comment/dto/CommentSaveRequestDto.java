package ShallWe.Refactoring.domain.comment.dto;

import ShallWe.Refactoring.domain.comment.domain.CommentStatus;
import ShallWe.Refactoring.domain.comment.domain.Comment;
import ShallWe.Refactoring.domain.order.domain.Order;
import ShallWe.Refactoring.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class CommentSaveRequestDto {
    @NotBlank
    private String content;

    @Builder
    protected CommentSaveRequestDto(String content) {
        this.content = content;
    }

    public Comment toEntity(Order order, User user) {
        return Comment.builder()
                .order(order)
                .user(user)
                .content(content)
                .status(CommentStatus.NORMAL)
                .build();
    }

}
