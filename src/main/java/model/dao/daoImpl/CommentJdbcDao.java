package model.dao.daoImpl;

import dto.Comment;
import model.dao.daoImpl.template.GenericJdbcDao;
import model.dao.daoInterfaces.CommentDao;
import model.dao.jdbc.ConnectionManager;
import model.dao.mappers.CommentMapper;

import java.util.List;

public class CommentJdbcDao implements CommentDao {
    ConnectionManager cm;
    GenericJdbcDao genericJdbcDao;

    public CommentJdbcDao() {
        this.cm = ConnectionManager.getInstance();
        genericJdbcDao = new GenericJdbcDao(cm);
    }

    @Override
    public Long add(Comment comment) {
        return genericJdbcDao.insert("INSERT INTO comment " +
                        "(comment_text," +
                        "user_id," +
                        "master_id," +
                        "record_id)" +
                        "VALUES(?,?,?,?)",
                comment.getComment(),
                comment.getUser().getUserId(),
                comment.getMaster().getMasterId(),
                comment.getRecord().getRecordId());
    }

    @Override
    public Comment findCommentByRecord(Long recordId) {
        return genericJdbcDao.findObject("SELECT * FROM comment WHERE record_id=?", CommentMapper::map, recordId);
    }

    @Override
    public Comment find(Long id) {
        Comment comment = genericJdbcDao.findObject("SELECT * FROM comment " +
                "WHERE idcomment=?", CommentMapper::map, id);
        return comment;
    }

    @Override
    public void update(Comment comment) {
        genericJdbcDao.update("UPDATE comment " +
                        "SET " +
                        "comment_text=?, " +
                        "user_id=?, " +
                        "master_id=?, " +
                        "record_id=? " +
                        "WHERE idcomment=?",
                comment.getComment(),
                comment.getUser().getUserId(),
                comment.getMaster().getMasterId(),
                comment.getRecord().getRecordId(),
                comment.getCommentId());
    }

    @Override
    public void delete(Long id) {
        genericJdbcDao.remove("DELETE FROM comment " +
                "WHERE idcomment=?", id);
    }

    @Override
    public List<Comment> findAll() {
        List<Comment> comments = genericJdbcDao.findAll("SELECT * FROM comment", CommentMapper::map);
        return comments;
    }
}
