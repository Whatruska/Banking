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
import java.util.ArrayList;

@WebServlet("/setCardNum")
public class SetCardNumServlet extends AuthorizedServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        check(req, resp, "/Pages/AuthPages/AdminPages/SetCardNum.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldCardNum = req.getParameter("oldCardNum");
        String newCardNum = req.getParameter("newCardNum");

        boolean isOK = false;

        ArrayList<String> cards = CardManager.getAllCardNum();
        if (cards.contains(oldCardNum)){
            Client client = ClientManager.getClientFormDBbyCardNum(oldCardNum);
            if (!cards.contains(oldCardNum)){
                Card card = client.getCard();
                card.setCardNum(newCardNum);
                client.setCard(card);
                ClientManager.deleteClient(client);
                resp.sendRedirect(req.getContextPath() + "/admin");
                isOK = true;
            }
        }

        if (!isOK){
            req.getRequestDispatcher("/Pages/AuthPages/AdminPages/SetCardNum.jsp");
        }
    }
}
