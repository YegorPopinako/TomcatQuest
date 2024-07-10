package ua.quest.servlet;

import com.oracle.wls.shaded.org.apache.xpath.operations.Bool;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebServlet(name = "RestartServlet", value = "/restart")
public class RestartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        int counter = (int) session.getAttribute("counter");
        counter++;
        session.setAttribute("counter", counter);
        session.setAttribute("questionNumber", 0);

        if((Boolean) session.getAttribute("win")) {
            getServletContext().getRequestDispatcher("/win.jsp").forward(req, resp);
            return;
        }
        getServletContext().getRequestDispatcher("/failure.jsp").forward(req, resp);
    }
}
