package ua.quest.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
class StartServletTest extends Mockito {

    @InjectMocks
    private StartServlet startServlet;

    @Mock
    private HttpServletRequest req;

    @Mock
    private HttpServletResponse resp;

    @Mock
    private HttpSession session;

    @Mock
    private RequestDispatcher dispatcher;

    @Mock
    private ServletConfig servletConfig;

    @Mock
    private ServletContext servletContext;

    @Test
    void testDoGet() throws ServletException, IOException {

        when(req.getSession(true)).thenReturn(session);
        when(req.getRequestedSessionId()).thenReturn("1234567890123456");
        when(servletConfig.getServletContext()).thenReturn(servletContext);
        when(servletContext.getRequestDispatcher("/index.jsp")).thenReturn(dispatcher);

        startServlet.init(servletConfig);

        startServlet.doGet(req, resp);

        verify(session).setAttribute("counter", 0);
        verify(session).setAttribute("ID", "1234567890123456");
        verify(session).setAttribute("questionNumber", 0);
        verify(servletContext).getRequestDispatcher("/index.jsp");
        verify(dispatcher).forward(req, resp);
    }
}
