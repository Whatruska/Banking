package main.webapp.Servlets;

import main.webapp.Backend.Banking.Managers.ServletManagerRequest.SMR;
import main.webapp.Backend.Banking.Managers.ServletManagerRequest.SMRBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

abstract public class WServlet extends HttpServlet {
    protected static String pagePath;
    protected static String redir = "/main";

    protected static SMR makeDefaultSMR(HttpServletRequest req, HttpServletResponse resp){
        return SMRBuilder
                .req(req)
                .resp(resp)
                .failPath(pagePath)
                .successRedir(redir)
                .build();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        if (method.equalsIgnoreCase("GET")){
            doGet(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(pagePath).forward(req,resp);
    }
}
