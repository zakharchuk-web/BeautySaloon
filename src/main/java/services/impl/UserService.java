package services.impl;

import dto.User;
import model.dao.daoImpl.UserJdbcDao;
import model.dao.daoInterfaces.UserDao;
import model.dao.factory.JdbcDaoFactory;

public class UserService {
    private UserDao dao;

    public UserService() {
        dao = JdbcDaoFactory.getInstance().getUserDao();
    }

    public boolean isUniqueEmail(String email) {
        if (dao.findByEmail(email) == null) return true;
        return false;
    }

    public User findById(Long id) {
        return dao.find(id);
    }

    public void add(User user) {
        dao.add(user);
    }

    public User findByEmail(String email) {
        return dao.findByEmail(email);
    }

}
