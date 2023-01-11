package model.dao.mappers;

import dto.ServicePrice;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicePriceMapper {
    private static final Logger LOGGER = LogManager.getLogger(ServicePriceMapper.class);

    public static ServicePrice map(ResultSet resultSet) {
        ServicePrice servicePrice = new ServicePrice();
        try {
            servicePrice.setPriceId(resultSet.getLong("idservice_price"));
            servicePrice.setServiceName(resultSet.getString("service_name"));
            servicePrice.setServicePrice(resultSet.getLong("service_price"));
        } catch (SQLException e) {
            LOGGER.error("can't map object", e);
        }
        return servicePrice;
    }
}
