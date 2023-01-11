package app;

import controller.command.CommandList;
import controller.util.SecurityConstraints;
import dto.Role;
import model.dao.jdbc.ConnectionManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * The web application tuner.
 * It configures the application(connection manager, security constraints)
 */
@WebListener
public class AppListener implements ServletContextListener {
    private static final Logger LOGGER = LogManager.getLogger(AppListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.debug("App initializing");
        init();
        LOGGER.debug("App initialized");

    }

    public void init() {
        ConnectionManager.initFromJNDI("jdbc/beauty_saloon");
        initSecurityConstraints();
    }

    private void initSecurityConstraints() {
        SecurityConstraints constraints = SecurityConstraints.getInstance();
        constraints.addConstraint(CommandList.CREATE_MASTER.name(), Role.ADMIN);
        constraints.addConstraint(CommandList.CREATE_RECORD.name(), Role.USER);
        constraints.addConstraint(CommandList.LOG_OUT.name(), Role.ADMIN, Role.USER, Role.MASTER);
        constraints.addConstraint(CommandList.UPDATE_MASTER.name(), Role.MASTER);
        constraints.addConstraint(CommandList.GET_ALL_COMMENTS.name(), Role.ADMIN);
        constraints.addConstraint(CommandList.USER_PAGE_INFO.name(), Role.USER);
        constraints.addConstraint(CommandList.REDIRECT_TO_RECORD_COMMAND.name(), Role.USER, Role.MASTER, Role.ADMIN);
        constraints.addConstraint(CommandList.GET_RECORDS_FOR_DATE.name(), Role.USER, Role.MASTER, Role.ADMIN);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
