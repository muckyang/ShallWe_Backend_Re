package ShallWe.Refactoring.domain.comment.dto;

import ShallWe.Refactoring.domain.comment.domain.Comment;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class CommentListResponseDto {
    private final Long orderId;
    private final Long userId;
    private final String content;
    private final String status;

    @QueryProjection
    public CommentListResponseDto(Comment comment){
        orderId = comment.getOrder().getId();
        userId = comment.getUser().getId();
        content = comment.getContent();
        status = comment.getStatus().toString();
    }
}
