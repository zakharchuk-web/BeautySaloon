package services.impl;

import dto.Master;
import model.dao.daoInterfaces.MasterDao;
import model.dao.factory.JdbcDaoFactory;

import java.util.List;

public class MasterService {
    private MasterDao dao;

    public MasterService() {
        dao = JdbcDaoFactory.getInstance().getMasterDao();
    }

    public void add(Master master) {
        dao.add(master);
    }

    public void update(Master master) {
        dao.update(master);
    }

    public List<Master> findAll() {
        return dao.findAll();
    }

    public Master findByEmail(String email) {
        return dao.findByEmail(email);
    }

    public Master findById(Long id) {
        return dao.find(id);
    }

    public boolean isUniqueEmail(String email) {
        if (dao.findByEmail(email) == null) return true;
        return false;
    }
}
