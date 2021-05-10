package ShallWe.Refactoring.repository.comment;

import ShallWe.Refactoring.domain.comment.domain.Comment;

public interface CommentCustom {
    Comment findIdFetch(Comment target);
}
