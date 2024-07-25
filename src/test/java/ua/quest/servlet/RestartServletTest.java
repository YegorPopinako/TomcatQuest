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
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestartServletTest {

    @InjectMocks
    private RestartServlet restartServlet;

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
    void testDoGet_WithWin() throws ServletException, IOException {
        when(req.getSession(true)).thenReturn(session);
        when(session.getAttribute("counter")).thenReturn(0);
        when(session.getAttribute("win")).thenReturn(true);
        when(servletConfig.getServletContext()).thenReturn(servletContext);
        when(servletContext.getRequestDispatcher("/win.jsp")).thenReturn(dispatcher);

        restartServlet.doGet(req, resp);

        verify(session).setAttribute("counter", 1);
        verify(session).setAttribute("questionNumber", 0);
        verify(servletContext).getRequestDispatcher("/win.jsp");
        verify(dispatcher).forward(req, resp);
    }

    @Test
    void testDoGet_WithLose() throws ServletException, IOException {
        when(req.getSession(true)).thenReturn(session);
        when(session.getAttribute("counter")).thenReturn(0);
        when(session.getAttribute("win")).thenReturn(false);
        when(servletConfig.getServletContext()).thenReturn(servletContext);
        when(servletContext.getRequestDispatcher("/failure.jsp")).thenReturn(dispatcher);

        restartServlet.doGet(req, resp);

        verify(session).setAttribute("counter", 1);
        verify(session).setAttribute("questionNumber", 0);
        verify(servletContext).getRequestDispatcher("/failure.jsp");
        verify(dispatcher).forward(req, resp);
    }
}