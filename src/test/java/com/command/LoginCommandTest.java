package com.command;

import controller.command.commandImpl.AuthorizationCommand;
import controller.util.constants.Pages;
import dto.Role;
import dto.User;
import model.dao.jdbc.ConnectionManager;
import org.junit.Before;
import org.junit.Test;
import services.impl.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginCommandTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private AuthorizationCommand authorizationCommand;
    private UserService userService;
    private User user;
    private String email;
    private String password;
    private Long userId;
    private Role role;

    @Before
    public void setUp() throws Exception {
        ConnectionManager.initFromProperties();
        userService = mock(UserService.class);
        authorizationCommand = new AuthorizationCommand();
        user = mock(User.class);
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        email = "vlad@gmail.com";
        password = "vladpassword";
        userId = 12L;
        role = Role.USER;
    }

    @Test
    public void execute() throws Exception {
        when(user.getUserId()).thenReturn(userId);
        when(user.getEmail()).thenReturn(email);
        when(user.getPassword()).thenReturn(password);
        when(user.getRole()).thenReturn(role);
        when(session.getAttribute("currentUser")).thenReturn(role);
        when(request.getParameter("e_mail")).thenReturn(email);
        when(request.getParameter("password")).thenReturn(password);
        when(request.getSession()).thenReturn(session);

        when(userService.findByEmail(anyString())).thenReturn(user);

        String page = authorizationCommand.execute(request, response);
        assertNotNull(page);
        assertEquals(page, Pages.MAIN_PAGE);
    }
}
