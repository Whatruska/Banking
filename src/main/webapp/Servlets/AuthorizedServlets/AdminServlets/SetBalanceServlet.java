package main.webapp.Servlets.AuthorizedServlets.AdminServlets;

import main.webapp.Backend.Banking.Card.Card;
import main.webapp.Backend.Banking.Card.CardManager;
import main.webapp.Backend.Banking.Client.Client;
import main.webapp.Backend.Banking.Client.ClientManager;
import main.webapp.Servlets.AuthorizedServlets.AuthorizedServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/setBalance")
public class SetBalanceServlet extends AuthorizedServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        check(req, resp, "/Pages/AuthPages/AdminPages/SetBalance.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cardNum = req.getParameter("cardNum");
        Integer value = Integer.parseInt(req.getParameter("value"));
        if (CardManager.getAllCardNum().contains(cardNum)){
            Client client = ClientManager.getClientFormDBbyCardNum(cardNum);
            Card card = client.getCard();
            card.setValue(value);
            CardManager.updateCard(card);
            resp.sendRedirect(req.getContextPath() + "/main");
        } else {
            req.getRequestDispatcher("/Pages/AuthPages/AdminPages/SetBalance.jsp").forward(req, resp);
        }
    }
}
