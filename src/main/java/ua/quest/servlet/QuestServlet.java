package ua.quest.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "QuestServlet", value = "/quest")
public class QuestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String question = "What is the capital of France?";
        String option1 = "Paris";
        String option2 = "London";

        req.setAttribute("question", question);
        req.setAttribute("option1", option1);
        req.setAttribute("option2", option2);

        getServletContext().getRequestDispatcher("/quest.jsp").forward(req, resp);
    }
}
