package model.dao.daoInterfaces;

import dto.Comment;

public interface CommentDao extends Dao<Comment, Long> {
    Comment findCommentByRecord(Long recordId);
}
