package testDb;

import creator.EntityCreator;
import dto.ServicePrice;
import model.dao.factory.JdbcDaoFactory;
import model.dao.jdbc.ConnectionManager;

public class ServicePriceDaoTest extends AbstractDaoTest<ServicePrice, Long> {
    public ServicePriceDaoTest() {
        ConnectionManager.initFromProperties();
        dao = JdbcDaoFactory.getInstance().getServicePriceDao();
    }

    @Override
    protected Long getId(ServicePrice obj) {
        return obj.getPriceId();
    }

    @Override
    protected void setId(ServicePrice obj, Long id) {
        obj.setPriceId(id);
    }

    @Override
    protected ServicePrice getTestObj() {
        return EntityCreator.createSetvicePrice();
    }

    @Override
    protected void updateObj(ServicePrice obj) {
        obj.setServiceName("Some another name");
    }
}
