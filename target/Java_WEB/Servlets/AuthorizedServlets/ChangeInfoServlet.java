package main.webapp.Servlets.AuthorizedServlets;

import main.webapp.Backend.Banking.Managers.ServletManager;
import main.webapp.Backend.Banking.Managers.ServletManagerRequest.SMR;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changeInfo")
public class ChangeInfoServlet extends AuthorizedServlet {
    @Override
    public void init() throws ServletException {
        pagePath = "/Pages/AuthPages/ChangeInfo.jsp";
        redir = "/info";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        check(req, resp, pagePath);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SMR smr = makeDefaultSMR(req, resp);
        ServletManager.changeInfo(smr);
    }
}
