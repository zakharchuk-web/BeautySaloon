package services.impl;

import dto.Comment;
import model.dao.daoInterfaces.CommentDao;
import model.dao.factory.DaoFactory;
import model.dao.factory.JdbcDaoFactory;
import services.factory.ServiceFactory;

import java.util.List;

public class CommentService {
    private CommentDao dao;

    public CommentService() {
        dao = JdbcDaoFactory.getInstance().getCommentDao();
    }

    public List<Comment> getAllComments() {
        return dao.findAll();
    }

    public void addComment(Comment comment) {
        dao.add(comment);
    }

    public Comment findCommentByRecord(Long id) {
        return dao.findCommentByRecord(id);
    }
}
