package ShallWe.Refactoring.service;

import ShallWe.Refactoring.entity.comment.Comment;
import ShallWe.Refactoring.entity.comment.dto.*;
import ShallWe.Refactoring.entity.order.Order;
import ShallWe.Refactoring.entity.user.User;
import ShallWe.Refactoring.repository.comment.CommentRepository;
import ShallWe.Refactoring.repository.history.CommentHistoryRepository;
import ShallWe.Refactoring.repository.order.OrderRepository;
import ShallWe.Refactoring.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final CommentRepository commentRepository;
    private final CommentHistoryRepository historyRepository;
    ModelMapper modelMapper = new ModelMapper();

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
