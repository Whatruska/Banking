package main.webapp.Servlets.AuthorizedServlets;

import main.webapp.Backend.Banking.Managers.ServletManager;
import main.webapp.Backend.Banking.Managers.ServletManagerRequest.SMR;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/transactions")
public class TransactionServlet extends AuthorizedServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        pagePath = "/Pages/AuthPages/Transactions.jsp";
        redir = "/info";
        String method = req.getMethod();
        if (method.equalsIgnoreCase("GET")){
            doGet(req, resp);
        } else {
            doPost(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SMR smr = makeDefaultSMR(req, resp);
        ServletManager.makeTransaction(smr);
    }
}
