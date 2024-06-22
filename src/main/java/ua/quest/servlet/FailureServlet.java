package ua.quest.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "FailureServlet", value = "/failure")
public class FailureServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        int counter = (int) session.getAttribute("counter");
        counter++;
        session.setAttribute("counter", counter);

        getServletContext().getRequestDispatcher("/failure.jsp").forward(req, resp);
    }
}
