package ShallWe.Refactoring.entity.comment.dto;

import ShallWe.Refactoring.entity.comment.Comment;
import ShallWe.Refactoring.entity.comment.CommentStatus;
import ShallWe.Refactoring.entity.order.Order;
import ShallWe.Refactoring.entity.user.User;
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
