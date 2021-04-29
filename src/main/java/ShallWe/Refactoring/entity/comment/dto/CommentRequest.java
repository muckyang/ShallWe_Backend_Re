package ShallWe.Refactoring.entity.comment.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CommentRequest {
    @NotBlank
    private final Long userId;
    @NotBlank
    private final String content;
    @NotBlank
    private final Long orderId;
    @Builder
    protected CommentRequest(Long orderId,Long userId,String content) {
        this.orderId = orderId;
        this.userId = userId;
        this.content = content;
    }
}
