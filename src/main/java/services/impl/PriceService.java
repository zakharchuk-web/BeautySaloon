package services.impl;

import dto.ServicePrice;
import model.dao.daoInterfaces.ServicePriceDao;
import model.dao.factory.JdbcDaoFactory;

import java.util.List;

public class PriceService {
    private ServicePriceDao dao;

    public PriceService() {
        dao = JdbcDaoFactory.getInstance().getServicePriceDao();
    }

    public void add(ServicePrice servicePrice) {
        dao.add(servicePrice);
    }

    public List<ServicePrice> findAll() {
        return dao.findAll();
    }
}
