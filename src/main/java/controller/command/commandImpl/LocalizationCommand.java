package controller.command.commandImpl;

import controller.command.Command;
import controller.util.constants.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Language change handler.
 * Allows change language on site
 */
public class LocalizationCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String language = request.getParameter("language");
        if (language.equals("English")) {
            session.setAttribute("locale", "en_US");
        } else {
            session.setAttribute("locale", "uk_UA");
        }
        return Pages.MAIN_PAGE;
    }
}
