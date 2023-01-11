package model.dao.factory;

import model.dao.daoImpl.*;
import model.dao.daoInterfaces.*;

/**
 * Class for getting instances of DAO. Realised as a Factory
 */
public class JdbcDaoFactory implements DaoFactory {
    private static JdbcDaoFactory jdbcDaoFactory = new JdbcDaoFactory();
    private UserJdbcDao userJdbcDao = new UserJdbcDao();
    private MasterJdbcDao masterJdbcDao = new MasterJdbcDao();
    private RecordJdbcDao recordJdbcDao = new RecordJdbcDao();
    private CommentJdbcDao commentJdbcDao = new CommentJdbcDao();
    private ServicePriceJdbcDao servicePriceJdbcDao = new ServicePriceJdbcDao();

    @Override
    public ServicePriceDao getServicePriceDao() {
        return servicePriceJdbcDao;
    }

    @Override
    public CommentDao getCommentDao() {
        return commentJdbcDao;
    }

    @Override
    public UserDao getUserDao() {
        return userJdbcDao;
    }

    @Override
    public MasterDao getMasterDao() {
        return masterJdbcDao;
    }

    @Override
    public RecordDao getRecordDao() {
        return recordJdbcDao;
    }


    public static JdbcDaoFactory getInstance() {
        return jdbcDaoFactory;
    }
}
