package controller.command.commandImpl;

import controller.command.Command;
import controller.util.constants.Pages;
import controller.util.converters.Sha256Encoder;
import dto.Master;
import dto.Role;
import dto.User;
import services.factory.ServiceFactory;
import services.impl.MasterService;
import services.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Authorization handler.
 * Allows guest to log in
 */
public class AuthorizationCommand implements Command {
    private UserService userService;
    private MasterService masterService;

    public AuthorizationCommand() {
        userService = ServiceFactory.getUserService();
        masterService = ServiceFactory.getMasterService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String eMail = request.getParameter("e_mail");
        String password = request.getParameter("password");
        {
            User user = userService.findByEmail(eMail);

            if (user == null) {
                request.setAttribute("isError", true);
                request.setAttribute("errorMessage", "There is not acc with this email, please try again.");
                return Pages.SIGN_IN_PAGE;
            }
            if (!user.getPassword().equals(Sha256Encoder.encode(password))) {
                request.setAttribute("isError", true);
                request.setAttribute("errorMessage", "Wrong pass, please try again.");
                System.out.println(user.getPassword());
                return Pages.SIGN_IN_PAGE;
            } else {
                HttpSession session = request.getSession();
                if (user.getRole().equals(Role.MASTER)){
                    Master master = masterService.findByEmail(eMail);
                    session.setAttribute("currentUser", master);
                }else session.setAttribute("currentUser", user);

            }
            return Pages.MAIN_PAGE;
        }
    }
}
