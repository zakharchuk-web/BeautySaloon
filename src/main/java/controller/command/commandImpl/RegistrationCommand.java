package controller.command.commandImpl;

import controller.command.Command;
import controller.util.constants.Pages;
import controller.util.converters.Sha256Encoder;
import dto.User;
import model.dao.mappers.UserMapper;
import services.factory.ServiceFactory;
import services.impl.UserService;
import util.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Registration handler
 */
public class RegistrationCommand implements Command {
    private UserService userService;

    public RegistrationCommand() {
        userService = ServiceFactory.getUserService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String eMail = request.getParameter("e_mail");
        String password = request.getParameter("password");
//        if (!Validator.isValidName(firstName)) {
//            request.setAttribute("isError", true);
//            request.setAttribute("errorMessage", "Invalid first name, please try again.");
//            return Pages.SIGN_UP_PAGE;
//        }
//        if (!Validator.isValidName(lastName)) {
//            request.setAttribute("isError", true);
//            request.setAttribute("errorMessage", "Invalid last name, please try again.");
//            return Pages.SIGN_UP_PAGE;
//        }
        if (!userService.isUniqueEmail(eMail)) {
            request.setAttribute("isError", true);
            request.setAttribute("errorMessage", "Duplicate email, please try again.");
            return Pages.SIGN_UP_PAGE;
        }
//        if (!Validator.isValidPassword(password)) {
//            request.setAttribute("isError", true);
//            request.setAttribute("errorMessage", "Wrong pass, please try again.");
//            return Pages.SIGN_UP_PAGE;
//        }
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(eMail);
        user.setPassword(password);
        userService.add(user);

        return Pages.SIGN_IN_PAGE;
    }
}
