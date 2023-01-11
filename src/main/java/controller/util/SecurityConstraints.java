package controller.util;

import dto.Role;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecurityConstraints {
    private final static Logger LOGGER = Logger.getLogger(SecurityConstraints.class);
    private static SecurityConstraints instance = new SecurityConstraints();
    private Map<String, List<Role>> constraints;

    public static SecurityConstraints getInstance() {
        return instance;
    }

    private SecurityConstraints() {
        constraints = new HashMap<>();
    }

    public void addConstraint(String commandName, Role... roles) {
        if (roles == null) {
            LOGGER.error("Adding constraint without roles");
            return;
        }
        constraints.put(commandName, Arrays.asList(roles));
    }

    public void clear() {
        constraints.clear();
    }

    public boolean isAllowed(String commandName, Role role) {
        if (!constraints.containsKey(commandName)) {
            return true;
        } else {
            if (role == null) return false;
        }
        if (constraints.get(commandName).contains(role)) {
            return true;
        } else {
            return false;
        }
    }
}
