package testDb;

import creator.EntityCreator;
import dto.User;
import model.dao.factory.JdbcDaoFactory;
import model.dao.jdbc.ConnectionManager;

public class UserDaoTest extends AbstractDaoTest<User, Long> {
    public UserDaoTest() {
        ConnectionManager.initFromProperties();
        dao = JdbcDaoFactory.getInstance().getUserDao();
    }

    @Override
    protected Long getId(User obj) {
        return obj.getUserId();
    }

    @Override
    protected void setId(User obj, Long id) {
        obj.setUserId(id);
    }

    @Override
    protected User getTestObj() {
        return EntityCreator.createUser();
    }

    @Override
    protected void updateObj(User obj) {
        obj.setFirstName("testName");
    }
}
