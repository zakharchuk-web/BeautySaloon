package model.dao.mappers;

import dto.Level;
import dto.Master;
import dto.Role;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Class for simplify a process of entity creation
 */
public class MasterMapper {
    private static final Logger LOGGER = LogManager.getLogger(MasterMapper.class);

    public static Master map(ResultSet resultSet) {
        Master master = new Master();
        try {
            master.setMasterId(resultSet.getLong("idmaster"));
            master.setFirstName(resultSet.getString("first_name"));
            master.setLastName(resultSet.getString("last_name"));
            master.setEmail(resultSet.getString("e_mail"));
            master.setPassword(resultSet.getString("password"));
            master.setPhoneNumber(resultSet.getString("phone_number"));
            master.setDescription(resultSet.getString("description"));
            master.setUserId(resultSet.getLong("iduser"));
            master.setLevel(Level.getLevel(resultSet.getString("level")));
            master.setRole(Role.getRole(resultSet.getLong("role")));

        } catch (SQLException e) {
            LOGGER.error("can't map object", e);
        }
        return master;
    }
}
