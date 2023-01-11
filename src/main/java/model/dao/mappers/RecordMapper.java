package model.dao.mappers;

import dto.Master;
import dto.Record;
import dto.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Class for simplify a process of entity creation
 */
public class RecordMapper {
    private static final Logger LOGGER = LogManager.getLogger(RecordMapper.class);

    public static Record map(ResultSet resultSet) {
        Record record = new Record();
        try {
            record.setRecordId(resultSet.getLong("idrecord"));
            User user = new User();
            user.setUserId(resultSet.getLong("user_id"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            record.setUser(user);
            Master master = new Master();
            master.setMasterId(resultSet.getLong("master_id"));

            record.setMaster(master);
            record.setDate(resultSet.getString("date"));
            record.setTimeFrom(resultSet.getString("time_from"));

        } catch (SQLException e) {
            LOGGER.error("can't map object", e);
        }
        return record;
    }
}
