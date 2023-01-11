package controller.command.commandImpl;

import controller.command.Command;
import controller.util.constants.Pages;
import services.factory.ServiceFactory;
import services.impl.MasterService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RedirectToRecordCommand implements Command {
    private MasterService masterService;

    public RedirectToRecordCommand() {
        masterService = ServiceFactory.getMasterService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("masterEmail");
        //TimeUnit.DAYS.toMillis(1)
        request.setAttribute("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        request.setAttribute("master", masterService.findByEmail(email));
        return Pages.RECORD_PAGE;
    }
}
