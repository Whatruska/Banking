package main.webapp.Servlets.AuthorizedServlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends AuthorizedServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        pagePath = "/Pages/AuthPages/Admin.jsp";
        String method = req.getMethod();
        if (method.equalsIgnoreCase("GET")){
            doGet(req, resp);
        } else {
            doPost(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        check(req, resp, "/Pages/MainPanel.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        check(req, resp, pagePath, redir);
    }
}
