package filters;

import controller.util.SecurityConstraints;
import controller.util.constants.Pages;
import dto.Role;
import dto.User;
import model.dao.factory.JdbcDaoFactory;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

@WebFilter(urlPatterns = "/*")
public class SecurityFilter implements Filter {
    private final static Logger LOGGER = Logger.getLogger(SecurityFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.debug("Initialising security filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        User user = (User) httpServletRequest.getSession().getAttribute("currentUser");
        User daoUser = null;
        if (user != null) daoUser = JdbcDaoFactory.getInstance().getUserDao().findByEmail(user.getEmail());

        if (daoUser != null) user = daoUser;
        if (user != null) httpServletRequest.getSession().setAttribute("currentUser", user);
        String commandName = httpServletRequest.getParameter("command");
        Role role = user != null ? user.getRole() : null;
        if (commandName != null) {
            if (!SecurityConstraints.getInstance().isAllowed(commandName, role)) {
                if (user == null) {
                    httpServletRequest.getRequestDispatcher(Pages.ACCESS_DENIED)
                            .forward(servletRequest, servletResponse);
                    return;
                } else {
                    httpServletRequest.getRequestDispatcher(Pages.ACCESS_DENIED)
                            .forward(servletRequest, servletResponse);
                    return;
                }

            }
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {
        LOGGER.debug("Destroying security filter");
    }

}
