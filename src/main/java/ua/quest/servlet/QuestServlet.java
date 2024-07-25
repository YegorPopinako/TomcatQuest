package ua.quest.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.quest.question.Question;
import ua.quest.question.QuestionList;

import java.io.IOException;

@WebServlet(name = "QuestServlet", value = "/quest")
public class QuestServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(QuestServlet.class);

    private final int winNumber = QuestionList.getQuestions().size();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        if (req.getParameter("answer") != null) {
            if (!checkAnswer(req, resp, session)) {
                logger.info("Player won the game");
                return;
            }
        }

        int questionNumber = (Integer) session.getAttribute("questionNumber");
        Question question = QuestionList.getQuestions().get(questionNumber);
        session.setAttribute("question", question);

        logger.info("Serving question number {}", questionNumber);

        getServletContext().getRequestDispatcher("/quest.jsp").forward(req, resp);
    }

    private boolean checkAnswer(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException, ServletException {
        int answerValue = Integer.parseInt(req.getParameter("answer"));
        Question question = (Question) session.getAttribute("question");

        if (answerValue == question.getAnswer()) {
            int questionNumber = (Integer) session.getAttribute("questionNumber");
            session.setAttribute("questionNumber", questionNumber + 1);

            logger.info("Correct answer for question number {}", questionNumber);

            if (questionNumber + 1 >= winNumber) {
                session.setAttribute("win", true);
                logger.info("Player won the game");
                resp.sendRedirect("/restart");
                return false;
            }

            return true;
        } else {
            session.setAttribute("win", false);
            logger.info("Incorrect answer for question number {}", session.getAttribute("questionNumber"));
            resp.sendRedirect("/restart");
            return false;
        }
    }
}
