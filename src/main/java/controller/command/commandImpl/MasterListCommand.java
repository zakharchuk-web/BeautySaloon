package controller.command.commandImpl;

import controller.command.Command;
import controller.util.constants.Pages;
import dto.Master;
import services.factory.ServiceFactory;
import services.impl.MasterService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Get list with masters for page with list of masters
 */
public class MasterListCommand implements Command {
    private MasterService masterService;

    public MasterListCommand() {
        masterService = ServiceFactory.getMasterService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Master> masterList = masterService.findAll();
        request.setAttribute("masters", masterList);
        return Pages.MASTER_LIST;
    }
}
