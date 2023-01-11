package com.command;

import controller.command.commandImpl.LogOutCommand;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.*;

public class LogOutCommandTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private LogOutCommand logOutCommand;

    @Before
    public void setUp() throws Exception {

        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        logOutCommand = new LogOutCommand();
    }

    @Test
    public void logOutTest() {
        when(request.getSession()).thenReturn(session);
        logOutCommand.execute(request, response);
        verify(session, times(1)).invalidate();
    }
}
