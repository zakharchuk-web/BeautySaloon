package model.dao.mappers;

import dto.*;
import dto.Record;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class for simplify a process of entity creation
 */
public class CommentMapper {
    private static final Logger LOGGER = LogManager.getLogger(CommentMapper.class);

    public static Comment map(ResultSet resultSet) {
        Comment comment = new Comment();
        try {
            comment.setCommentId(resultSet.getLong("idcomment"));
            Master master = new Master();
            master.setMasterId(resultSet.getLong("master_id"));
            comment.setMaster(master);
            User user = new User();
            user.setUserId(resultSet.getLong("user_id"));
            comment.setUser(user);
            Record record = new Record();
            record.setRecordId(resultSet.getLong("record_id"));
            comment.setRecord(record);
            comment.setComment(resultSet.getString("comment_text"));

        } catch (SQLException e) {
            LOGGER.error("can't map object", e);
        }
        return comment;
    }
}
