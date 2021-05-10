package ShallWe.Refactoring.repository.comment;

import ShallWe.Refactoring.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends CommentCustom, JpaRepository<Comment,Long> {
    public List<Comment> findByOrderId(Long orderId);
}
