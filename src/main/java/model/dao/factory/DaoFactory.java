package model.dao.factory;

import model.dao.daoInterfaces.*;

public interface DaoFactory {
    UserDao getUserDao();

    MasterDao getMasterDao();

    RecordDao getRecordDao();

    CommentDao getCommentDao();

    ServicePriceDao getServicePriceDao();
}
