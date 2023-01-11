package controller.command.commandImpl;

import controller.command.Command;
import controller.util.constants.Pages;
import controller.util.converters.Sha256Encoder;
import dto.Level;
import dto.Master;
import services.factory.ServiceFactory;
import services.impl.MasterService;
import util.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Master creation handler.
 */
public class MasterCreationCommand implements Command {
    private MasterService masterService;

    public MasterCreationCommand() {
        masterService = ServiceFactory.getMasterService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String eMail = request.getParameter("e_mail");
        String password = request.getParameter("password");
        String masterLevel = request.getParameter("level");
        String phoneNumber = request.getParameter("phoneNumber");
        if (!Validator.isValidName(firstName)) {
            request.setAttribute("isError", true);
            request.setAttribute("errorMessage", "Invalid first name, please try again.");
            return Pages.SIGN_UP_PAGE;
        }
        if (!Validator.isValidName(lastName)) {
            request.setAttribute("isError", true);
            request.setAttribute("errorMessage", "Invalid last name, please try again.");
            return Pages.SIGN_UP_PAGE;
        }
        if (!masterService.isUniqueEmail(eMail)) {
            request.setAttribute("isError", true);
            request.setAttribute("errorMessage", "Duplicate email, please try again.");
            return Pages.SIGN_UP_PAGE;
        }
        if (!Validator.isValidPassword(password)) {
            request.setAttribute("isError", true);
            request.setAttribute("errorMessage", "Wrong pass, please try again.");
            return Pages.SIGN_UP_PAGE;
        }
        Master master = new Master();
        master.setFirstName(firstName);
        master.setLastName(lastName);
        master.setPassword(Sha256Encoder.encode(password));
        master.setEmail(eMail);
        master.setLevel(Level.getLevel(masterLevel));
        master.setPhoneNumber(phoneNumber);
        masterService.add(master);

        return Pages.MAIN_PAGE;
    }
}
