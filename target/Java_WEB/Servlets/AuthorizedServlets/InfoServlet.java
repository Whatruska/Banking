package main.webapp.Servlets.AuthorizedServlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/info")
public class InfoServlet extends AuthorizedServlet {
    @Override
    public void init() throws ServletException {
        pagePath = "/Pages/AuthPages/Info.jsp";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        check(req, resp, pagePath);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
