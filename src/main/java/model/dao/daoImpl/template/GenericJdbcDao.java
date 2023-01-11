package model.dao.daoImpl.template;

import model.dao.jdbc.ConnectionManager;
import model.dao.mappers.EntityMapper;
import model.exception.RuntimeSqlException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that realise basic operation with database
 */
public class GenericJdbcDao {
    private static final Logger LOGGER = LogManager.getLogger(GenericJdbcDao.class);

    private ConnectionManager connectionManager;

    public GenericJdbcDao(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public Long insert(String query, Object... params) {
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return null;
        }
        try (PreparedStatement statement
                     = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
            }
        } catch (SQLException e) {
            LOGGER.error("Can't insert into DB");
        } finally {
            closeConn(connection);
        }
        return null;
    }

    public <T> T findObject(String query, EntityMapper<T> mapper, Object... param) {
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return null;
        }
        try (PreparedStatement statement
                     = connection.prepareStatement(query)) {
            statement.setObject(1, param[0]);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) return mapper.map(rs);
        } catch (SQLException e) {
            LOGGER.error("Can't find obj in DB");
        } finally {
            closeConn(connection);
        }
        return null;
    }

    public <T> List<T> findAll(String query, EntityMapper<T> mapper) {
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return null;
        }
        try (PreparedStatement statement
                     = connection.prepareStatement(query)) {
            List<T> list = new ArrayList<>();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                list.add(mapper.map(rs));
            }
            return list;
        } catch (SQLException e) {
            LOGGER.error("Can't find obj in DB");

        } finally {
            closeConn(connection);
        }
        return null;
    }

    public int update(String query, Object... params) {
        Connection conn = connectionManager.getConnection();

        if (conn == null)
            return 0;

        try (PreparedStatement stmt = conn.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            return stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Cannot execute update query", e);
            throw new RuntimeSqlException(e);
        } finally {
            closeConn(conn);
        }
    }

    public int remove(String query, Object... params) {
        return update(query, params);
    }

    private void closeConn(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            LOGGER.error("Cannot close jdbc connection", e);
        }
    }
}
