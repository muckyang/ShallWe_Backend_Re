package ShallWe.Refactoring.domain.comment.service;

import ShallWe.Refactoring.domain.comment.domain.Comment;
import ShallWe.Refactoring.domain.comment.dto.CommentListResponseDto;
import ShallWe.Refactoring.domain.comment.dto.CommentResponseDto;
import ShallWe.Refactoring.domain.comment.dto.CommentSaveRequestDto;
import ShallWe.Refactoring.domain.comment.dto.CommentUpdateRequestDto;
import ShallWe.Refactoring.domain.order.domain.Order;
import ShallWe.Refactoring.domain.user.domain.User;
import ShallWe.Refactoring.repository.comment.CommentRepository;
import ShallWe.Refactoring.repository.commentHistory.CommentHistoryRepository;
import ShallWe.Refactoring.repository.order.OrderRepository;
import ShallWe.Refactoring.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final CommentRepository commentRepository;
    private final CommentHistoryRepository historyRepository;

    public Long createComment(Long userId, Long orderId, CommentSaveRequestDto request) {
        Order order = orderRepository.getOne(orderId);
        User user = userRepository.getOne(userId);
        return commentRepository.save(request.toEntity(order, user)).getId();
    }

    public CommentResponseDto findById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. Comment ID=" + id));
        return new CommentResponseDto(comment);
    }

    public List<CommentListResponseDto> getOrderComments(Long orderId) {
        return commentRepository.findByOrderId(orderId).stream()
                .map(CommentListResponseDto::new)
                .collect(Collectors.toList());
    }

    public Long updateComment(Long id, CommentUpdateRequestDto request) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. Comment ID=" + id));
        comment.update(request.getContent());
        return id;
    }
}
