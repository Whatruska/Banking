package main.webapp.Servlets.AuthorizedServlets;

import main.webapp.Backend.Banking.Card.Card;
import main.webapp.Backend.Banking.Card.CardManager;
import main.webapp.Backend.Banking.Client.Client;
import main.webapp.Backend.Banking.Client.ClientManager;
import main.webapp.Backend.Banking.Transaction.Transaction;
import main.webapp.Backend.Banking.Transaction.TransactionManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/transactions")
public class TransactionServlet extends AuthorizedServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        check(req, resp, "/Pages/AuthPages/Transactions.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Client client = (Client) req.getSession().getAttribute("client");
        Card fromCard = CardManager.getCardFormDB(client.getCardNum());
        Card toCard = CardManager.getCardFormDB(req.getParameter("cardNum"));
        if (toCard == null){
            req.getRequestDispatcher("/Pages/AuthPages/Transactions.jsp").forward(req, resp);
        } else {
            Integer value = Integer.parseInt(req.getParameter("value"));
            Transaction transaction = new Transaction(fromCard, toCard, value);
            if (transaction.performTransaction() == Transaction.SUCCESS){
                req.getSession().setAttribute("client", ClientManager.getClientFormDBbyCardNum(fromCard.getCardNum()));
                resp.sendRedirect(req.getContextPath() + "/info");
            } else {
                req.getRequestDispatcher("/Pages/AuthPages/Transactions.jsp").forward(req, resp);
            }
        }
    }
}
