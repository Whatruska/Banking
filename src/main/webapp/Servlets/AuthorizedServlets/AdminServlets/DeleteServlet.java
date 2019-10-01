package main.webapp.Servlets.AuthorizedServlets.AdminServlets;

import main.webapp.Backend.Banking.Managers.ClientManager;

import main.webapp.Backend.Banking.Managers.ServletManager;
import main.webapp.Backend.Banking.Managers.ServletManagerRequest.SMR;
import main.webapp.Backend.Banking.Managers.ServletManagerRequest.SMRBuilder;
import main.webapp.Servlets.AuthorizedServlets.AuthorizedServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends AuthorizedServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        check(req, resp, "/Pages/AuthPages/AdminPages/DeleteUser.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SMR smr = SMRBuilder
                .req(req)
                .resp(resp)
                .failPath("/Pages/AuthPages/AdminPages/DeleteUser.jsp")
                .successRedir("/admin")
                .build();
        ServletManager.deleteClient(smr);
    }
}
