package main.webapp.Servlets.AuthorizedServlets;

import main.webapp.Backend.Banking.Client.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Client client = (Client) req.getSession().getAttribute("client");
        if (client.isAdmin()){
            req.getRequestDispatcher("/Pages/AuthPages/Admin.jsp").forward(req,resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/main");
        }
    }
}