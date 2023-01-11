package controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Command interface
 */
public interface Command {
    String execute(HttpServletRequest request, HttpServletResponse response);
}
