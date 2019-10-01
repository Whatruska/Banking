package main.webapp.Servlets.AuthorizedServlets.AdminServlets;

import main.webapp.Backend.Banking.Client.Client;
import main.webapp.Backend.Banking.Client.ClientManager;
import main.webapp.Servlets.AuthorizedServlets.AuthorizedServlet;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/giveAdmin")
public class GiveAdminServlet extends AuthorizedServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        check(req, resp, "/Pages/AuthPages/AdminPages/GiveAdmin.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        Client client = ClientManager.getClientFormDBbyPhone(phone);
        if (client != null){
            client.setAdmin(true);
            ClientManager.updateAdmin(client);
            resp.sendRedirect(req.getContextPath() + "/admin");
        } else {
            req.getRequestDispatcher("/Pages/AuthPages/AdminPages/GiveAdmin.jsp").forward(req, resp);
        }
    }
}
