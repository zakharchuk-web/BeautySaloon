package model.dao.daoImpl;

import dto.Role;
import dto.User;
import model.dao.daoImpl.template.GenericJdbcDao;
import model.dao.daoInterfaces.UserDao;
import model.dao.jdbc.ConnectionManager;
import model.dao.mappers.UserMapper;

import java.sql.SQLException;
import java.util.List;

/**
 *
 */
public class UserJdbcDao implements UserDao {
    ConnectionManager cm;
    GenericJdbcDao genericJdbcDao;

    public UserJdbcDao() {
        this.cm = ConnectionManager.getInstance();
        genericJdbcDao = new GenericJdbcDao(cm);
    }


    @Override
    public Long add(User user) {
        return genericJdbcDao.insert("INSERT INTO user " +
                        "(first_name," +
                        "last_name," +
                        "e_mail," +
                        "password)" +
                        "VALUES(?,?,?,?)",
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword());
    }

    @Override
    public User find(Long id) {
        User user = genericJdbcDao.findObject("SELECT * FROM user " +
                "WHERE iduser=?", UserMapper::map, id);
        return user;
    }

    @Override
    public void update(User user) {
        genericJdbcDao.update("UPDATE user " +
                        "SET " +
                        "first_name=?, " +
                        "last_name=?, " +
                        "e_mail=?, " +
                        "password=?, " +
                        "role=? " +
                        "WHERE iduser=?",
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                findRoleId(user.getRole()),
                user.getUserId());
    }

    @Override
    public void delete(Long id) {
        genericJdbcDao.remove("DELETE FROM user " +
                "WHERE iduser=?", id);
    }

    @Override
    public User findByEmail(String email) {
        User user = genericJdbcDao.findObject("SELECT * FROM user " +
                "WHERE e_mail=?", UserMapper::map, email);
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = genericJdbcDao.findAll("SELECT * FROM user", UserMapper::map);
        return users;
    }

    @Override
    public Long findRoleId(Role role) {
        return genericJdbcDao.findObject("SELECT idrole FROM role " +
                "WHERE role=?", rs -> {
            try {
                return rs.getLong("idrole");
            } catch (SQLException e) {
                e.printStackTrace();
                throw new IllegalStateException(e);
            }
        }, role.toString());
    }


}
