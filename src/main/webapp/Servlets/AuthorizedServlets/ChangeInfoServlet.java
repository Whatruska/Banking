package main.webapp.Servlets.AuthorizedServlets;

import main.webapp.Backend.Banking.Managers.ServletManager;
import main.webapp.Backend.Banking.Managers.ServletManagerRequest.SMR;
import main.webapp.Backend.Banking.Managers.ServletManagerRequest.SMRBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changeInfo")
public class ChangeInfoServlet extends AuthorizedServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        check(req, resp, "/Pages/AuthPages/ChangeInfo.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SMR smr = SMRBuilder
                .req(req)
                .resp(resp)
                .failPath("/Pages/AuthPages/ChangeInfo.jsp")
                .successRedir("/info")
                .build();
        ServletManager.changeInfo(smr);
    }
}
