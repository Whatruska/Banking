package main.webapp.Servlets;

import main.webapp.Backend.Banking.Client.Client;
import main.webapp.Backend.Banking.SoftManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Pages/Login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");

        Client client = SoftManager.login(phone, password);
        if (client != null){
            //Сделать cookie
            req.getSession().setAttribute("client", client);
            resp.sendRedirect(req.getContextPath() + "/main");
        } else {
            req.getRequestDispatcher("/Pages/Login.jsp").forward(req, resp);
            resp.getWriter().write("Invalid");
        }
    }
}
