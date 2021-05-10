package ShallWe.Refactoring.repository.commentHistory;

import ShallWe.Refactoring.domain.comment.domain.CommentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentHistoryRepository extends CommentHistoryCustom, JpaRepository<CommentHistory,Long> {

}
