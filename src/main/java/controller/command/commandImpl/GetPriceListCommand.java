package controller.command.commandImpl;

import controller.command.Command;
import controller.util.constants.Pages;
import dto.ServicePrice;
import services.factory.ServiceFactory;
import services.impl.PriceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Return list with prices and services for price list
 */
public class GetPriceListCommand implements Command {
    private PriceService priceService;

    public GetPriceListCommand() {
        priceService = ServiceFactory.getPriceService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("prices", priceService.findAll());
        System.out.println(priceService.findAll());
        return Pages.PRICE_LIST;
    }
}
