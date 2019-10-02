package main.webapp.Servlets.AuthorizedServlets;

import main.webapp.Backend.Banking.Client.Client;
import main.webapp.Servlets.WServlet;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AuthorizedServlet extends WServlet {
    protected void check(HttpServletRequest req, HttpServletResponse resp, String path, String redirectPath){
        Client client = (Client) req.getSession().getAttribute("client");
        if (client == null){
            try {
                resp.sendRedirect(req.getContextPath() + redirectPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                req.getRequestDispatcher(path).forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void check(HttpServletRequest req, HttpServletResponse resp, String path){
        check(req, resp, path, "/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        check(req, resp, pagePath);
    }
}
