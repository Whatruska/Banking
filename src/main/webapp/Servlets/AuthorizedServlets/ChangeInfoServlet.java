package main.webapp.Servlets.AuthorizedServlets;

import main.webapp.Backend.Banking.Card.Card;
import main.webapp.Backend.Banking.Client.Client;
import main.webapp.Backend.Banking.Client.ClientBuilder;
import main.webapp.Backend.Banking.Client.ClientManager;
import main.webapp.Backend.Banking.CryptWithMD5;
import main.webapp.Backend.Banking.SoftManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/changeInfo")
public class ChangeInfoServlet extends AuthorizedServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        check(req, resp, "/Pages/AuthPages/ChangeInfo.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Client curr = (Client)req.getSession().getAttribute("client");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String birthdateString = req.getParameter("birthdate");
        Date birthdate = SoftManager.stringToDate(birthdateString);
            Client client = ClientBuilder
                    .name(name)
                    .surname(surname)
                    .phone(curr.getPhone())
                    .password(
                            CryptWithMD5.cryptWithMD5(password)
                    )
                    .gender(gender)
                    .birthdate(birthdate)
                    .card(
                            curr.getCard()
                    )
                    .isAdmin(curr.isAdmin())
                    .build();

            ClientManager.updateClient(client);
            req.getSession().setAttribute("client", client);
            resp.sendRedirect(req.getContextPath() + "/main");
    }
}
