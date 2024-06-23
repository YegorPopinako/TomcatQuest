package ua.quest.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.quest.question.Question;
import ua.quest.question.QuestionList;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuestServletTest {

    @InjectMocks
    private QuestServlet questServlet;

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

    @BeforeEach
    @SneakyThrows
    public void setUp(){
        when(req.getSession(true)).thenReturn(session);

        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Question 1", "Option 1", "Option 2", 1, "Explanation 1"));
        questions.add(new Question("Question 2", "Option 1", "Option 2", 1, "Explanation 2"));
        QuestionList.setQuestions(questions);

        questServlet.init(servletConfig);
    }

    @Test
    @SneakyThrows
    void testDoGet_WithCorrectAnswer() {
        when(session.getAttribute("questionNumber")).thenReturn(0);
        when(session.getAttribute("question")).thenReturn(QuestionList.getQuestions().get(0));
        when(req.getParameter("answer")).thenReturn("1");
        when(servletContext.getRequestDispatcher("/quest.jsp")).thenReturn(dispatcher);
        when(questServlet.getServletContext()).thenReturn(servletContext);

        questServlet.doGet(req, resp);

        verify(session).setAttribute("questionNumber", 1);
        verify(servletContext).getRequestDispatcher("/quest.jsp");
        verify(dispatcher).forward(req, resp);
    }

    @Test
    @SneakyThrows
    void testDoGet_WithIncorrectAnswer() {
        when(session.getAttribute("question")).thenReturn(QuestionList.getQuestions().get(0));
        when(req.getParameter("answer")).thenReturn("2");

        questServlet.doGet(req, resp);

        verify(resp).sendRedirect("/restart");
    }
}
