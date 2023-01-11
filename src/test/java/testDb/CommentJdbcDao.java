package testDb;

import creator.EntityCreator;
import dto.Comment;
import dto.Record;
import model.dao.factory.JdbcDaoFactory;
import model.dao.jdbc.ConnectionManager;

public class CommentJdbcDao extends AbstractDaoTest<Comment, Long> {
    public CommentJdbcDao() {
        ConnectionManager.initFromProperties();
        dao = JdbcDaoFactory.getInstance().getCommentDao();
    }

    @Override
    protected Long getId(Comment obj) {
        return obj.getCommentId();
    }

    @Override
    protected void setId(Comment obj, Long id) {
        obj.setCommentId(id);
    }

    @Override
    protected Comment getTestObj() {
        return EntityCreator.createComment();
    }

    @Override
    protected void updateObj(Comment obj) {
        obj.setComment("Some another text");
    }
}
