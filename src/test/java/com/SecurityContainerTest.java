package com;

import controller.util.SecurityConstraints;
import dto.Role;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SecurityContainerTest {
    private SecurityConstraints securityConstraints;

    @Before
    public void setUp() throws Exception {
        securityConstraints.getInstance().clear();
        securityConstraints = securityConstraints.getInstance();
    }

    @Test
    public void testAddedConstraintCheckExact() {
        securityConstraints.addConstraint("/user/.*", Role.USER);
        assertTrue(securityConstraints
                .isAllowed("/user/index.html", Role.USER));
    }

}
