package controller.command.commandImpl;

import controller.command.Command;
import controller.util.constants.Pages;
import dto.Master;
import services.factory.ServiceFactory;
import services.impl.MasterService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateMasterCommand implements Command {
    private MasterService masterService;

    public UpdateMasterCommand() {
        masterService = ServiceFactory.getMasterService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String description = request.getParameter("description");
        Master master = (Master) request.getSession().getAttribute("currentUser");
        master.setDescription(description);
        masterService.update(master);
        return Pages.MAIN_PAGE;
    }
}
