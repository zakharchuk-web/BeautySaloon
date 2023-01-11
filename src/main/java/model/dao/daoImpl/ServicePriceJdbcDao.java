package model.dao.daoImpl;

import dto.ServicePrice;
import model.dao.daoImpl.template.GenericJdbcDao;
import model.dao.daoInterfaces.ServicePriceDao;
import model.dao.jdbc.ConnectionManager;
import model.dao.mappers.ServicePriceMapper;

import java.util.List;

public class ServicePriceJdbcDao implements ServicePriceDao {
    ConnectionManager cm;
    GenericJdbcDao genericJdbcDao;

    public ServicePriceJdbcDao() {
        this.cm = ConnectionManager.getInstance();
        genericJdbcDao = new GenericJdbcDao(cm);
    }

    @Override
    public Long add(ServicePrice servicePrice) {
        return genericJdbcDao.insert("INSERT INTO service_price " +
                        "(service_name," +
                        "service_price)" +
                        "VALUES(?,?)",
                servicePrice.getServiceName(),
                servicePrice.getServicePrice());
    }

    @Override
    public ServicePrice find(Long id) {
        return genericJdbcDao.findObject("SELECT * FROM service_price WHERE idservice_price=?", ServicePriceMapper::map, id);
    }

    @Override
    public void update(ServicePrice servicePrice) {
        genericJdbcDao.update("UPDATE service_price SET " +
                        "service_name=?, " +
                        "service_price=? " +
                        "WHERE idservice_price=?",
                servicePrice.getServiceName(),
                servicePrice.getServicePrice(),
                servicePrice.getPriceId());
    }

    @Override
    public void delete(Long id) {
        genericJdbcDao.remove("DELETE FROM service_price WHERE idservice_price=?", id);
    }

    @Override
    public List<ServicePrice> findAll() {
        return genericJdbcDao.findAll("SELECT * FROM service_price", ServicePriceMapper::map);
    }
}
