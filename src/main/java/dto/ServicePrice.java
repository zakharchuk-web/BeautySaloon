package dto;

import java.util.Objects;

public class ServicePrice {
    private Long priceId;
    private String serviceName;
    private Long servicePrice;

    public Long getPriceId() {
        return priceId;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Long getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Long servicePrice) {
        this.servicePrice = servicePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicePrice that = (ServicePrice) o;
        return Objects.equals(priceId, that.priceId) &&
                Objects.equals(serviceName, that.serviceName) &&
                Objects.equals(servicePrice, that.servicePrice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(priceId, serviceName, servicePrice);
    }

    @Override
    public String toString() {
        return "ServicePrice{" +
                "priceId=" + priceId +
                ", serviceName='" + serviceName + '\'' +
                ", servicePrice=" + servicePrice +
                '}';
    }
}
