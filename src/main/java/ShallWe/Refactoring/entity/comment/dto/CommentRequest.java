package ShallWe.Refactoring.entity.comment.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data

public class CommentRequest {
    @NotBlank
    private Long orderId;
    @NotBlank
    private Long userId;
    @NotBlank
    private String content;
    @Builder
    protected CommentRequest(@NotBlank Long orderId, @NotBlank Long userId, @NotBlank String content) {
        this.orderId = orderId;
        this.userId = userId;
        this.content = content;
    }
}
