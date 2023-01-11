package model.dao.daoInterfaces;

import dto.Role;
import dto.User;

public interface UserDao extends Dao<User, Long> {
    Long findRoleId(Role role);
    User findByEmail(String email);
}
