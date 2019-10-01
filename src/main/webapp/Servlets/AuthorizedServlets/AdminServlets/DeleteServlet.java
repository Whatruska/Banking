package main.webapp.Servlets.AuthorizedServlets.AdminServlets;

import main.webapp.Backend.Banking.Client.ClientManager;

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
        String phone = req.getParameter("phone");
        if (ClientManager.getAllPhones().contains(phone)){
            ClientManager.deleteClient(ClientManager.getClientFormDBbyPhone(phone));
            resp.sendRedirect(req.getContextPath() + "/admin");
        } else {
            req.getRequestDispatcher("/Pages/AuthPages/AdminPages/DeleteUser.jsp");
        }
    }
}
