package model.dao.mappers;

import dto.Role;
import dto.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Class for simplify a process of entity creation
 */
public class UserMapper {
    private static final Logger LOGGER = LogManager.getLogger(UserMapper.class);

    public static User map(ResultSet resultSet) {
        User user = new User();
        try {
            user.setUserId(resultSet.getLong("iduser"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setEmail(resultSet.getString("e_mail"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(Role.getRole(resultSet.getLong("role")));
        } catch (SQLException e) {
            LOGGER.error("can't map object", e);
        }
        return user;
    }
}
