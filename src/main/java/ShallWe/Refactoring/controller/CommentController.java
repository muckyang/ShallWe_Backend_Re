package ShallWe.Refactoring.controller;

import ShallWe.Refactoring.domain.comment.dto.CommentListResponseDto;
import ShallWe.Refactoring.domain.comment.dto.CommentResponseDto;
import ShallWe.Refactoring.domain.comment.dto.CommentSaveRequestDto;
import ShallWe.Refactoring.domain.comment.dto.CommentUpdateRequestDto;
import ShallWe.Refactoring.domain.comment.service.CommentService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment/{userId}/{orderId}")
    @ApiOperation("댓글 작성")
    public Long addComment(@PathVariable("userId") Long userId,
                           @PathVariable("orderId") Long orderId,
                           @RequestBody CommentSaveRequestDto request) {
        return commentService.createComment(userId, orderId, request);
    }

    @GetMapping("/comment/{orderId}")
    @ApiOperation("게시물의 댓글리스트")
    public List<CommentListResponseDto> orderComments(@PathVariable("orderId") Long orderId) {
        return commentService.getOrderComments(orderId);
    }

    @GetMapping("/comment/{commentId}")
    @ApiOperation("댓글 조회")
    public CommentResponseDto getComment(@PathVariable("commentId") Long commentId) {
        return commentService.findById(commentId);
    }

    @PutMapping("/comment/{commentId}")
    @ApiOperation("댓글 수정")
    public Long updateComment(@PathVariable("commentId") Long commentId,
                              @RequestBody CommentUpdateRequestDto request) {
        return commentService.updateComment(commentId, request);
    }

}
