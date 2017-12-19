package calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/calculate")
public class calculate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        add(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        add(req, resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int num1 = Integer.parseInt(req.getParameter("firstnumber"));
        int num2 = Integer.parseInt(req.getParameter("secondnumber"));
        String opp = req.getParameter("operation");
        int result;
        if (opp.equals("+")) {
            result = num1 + num2;
            resp.setContentType("text/html");
            resp.getWriter().println("Result is   " + result);
        } else if (opp.equals("-")) {
            result = num1 - num2;
            resp.setContentType("text/html");
            resp.getWriter().println("Result is   " + result);
        }
        else
        {
            resp.setContentType("text/html");
            resp.getWriter().println("Error");
        }


    }
}