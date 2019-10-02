package main.webapp.Servlets.AuthorizedServlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/info")
public class InfoServlet extends AuthorizedServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        pagePath = "/Pages/AuthPages/Info.jsp";
        String method = req.getMethod();
        if (method.equalsIgnoreCase("GET")){
            doGet(req, resp);
        }
    }
}
