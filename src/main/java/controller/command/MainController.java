package controller.command;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Main controller that send requests to appropriate commands
 */
public class MainController extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(MainController.class);

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter("command");
        Command command = CommandList.valueOf(commandName).getCommand();
        String goTo = command.execute(req, resp);
        req.getRequestDispatcher(goTo).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter("command");
        Command command = CommandList.valueOf(commandName).getCommand();
        String goTo = command.execute(req, resp);
        //req.getRequestDispatcher(goTo).forward(req, resp);
        resp.sendRedirect(goTo);
    }
}
