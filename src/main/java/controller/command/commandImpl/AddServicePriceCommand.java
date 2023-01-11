package controller.command.commandImpl;

import controller.command.Command;
import dto.ServicePrice;
import services.factory.ServiceFactory;
import services.impl.PriceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static controller.util.constants.Pages.PRICE_LIST;

/**
 * New service adding handler.
 * Allows admin to add new service with price
 */
public class AddServicePriceCommand implements Command {
    private PriceService priceService;

    public AddServicePriceCommand() {
        priceService = ServiceFactory.getPriceService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ServicePrice servicePrice = new ServicePrice();
        servicePrice.setServiceName(request.getParameter("serviceName"));
        servicePrice.setServicePrice(Long.valueOf(request.getParameter("servicePrice")));
        priceService.add(servicePrice);
        request.setAttribute("prices", priceService.findAll());
        return PRICE_LIST;
    }
}
