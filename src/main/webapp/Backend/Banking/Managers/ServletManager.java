package main.webapp.Backend.Banking.Managers;

import main.webapp.Backend.Banking.Card.Card;
import main.webapp.Backend.Banking.Client.Client;
import main.webapp.Backend.Banking.Client.ClientBuilder;
import main.webapp.Backend.Banking.CryptWithMD5;
import main.webapp.Backend.Banking.Managers.ServletManagerRequest.SMR;
import main.webapp.Backend.Banking.Transaction.Transaction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class ServletManager {
    private static SMR smr = new SMR();
    private static HttpServletRequest req = smr.getReq();
    private static HttpServletResponse resp = smr.getResp();
    private static String failPath = smr.getFailPath();
    private static String successRedir = smr.getSuccessRedir();

    private static void setSmr(SMR smr) {
        ServletManager.smr = smr;
        ServletManager.req = smr.getReq();
        ServletManager.failPath = smr.getFailPath();
        ServletManager.resp = smr.getResp();
        ServletManager.successRedir = smr.getSuccessRedir();
    }

    public static void makeTransaction(SMR smr) throws ServletException, IOException {
        setSmr(smr);
        Client client = (Client) req.getSession().getAttribute("client");
        Card fromCard = CardManager.getCardFormDB(client.getCardNum());
        Card toCard = CardManager.getCardFormDB(req.getParameter("cardNum"));
        if (toCard == null){
            req.getRequestDispatcher(failPath).forward(req, resp);
        } else {
            Integer value = Integer.parseInt(req.getParameter("value"));
            Transaction transaction = new Transaction(fromCard, toCard, value);
            if (transaction.performTransaction() == Transaction.SUCCESS){
                req.getSession().setAttribute("client", ClientManager.getClientFormDBbyCardNum(fromCard.getCardNum()));
                resp.sendRedirect(successRedir);
            } else {
                req.getRequestDispatcher(failPath).forward(req, resp);
            }
        }
    }

    public static void login(SMR smr) throws IOException, ServletException {
        setSmr(smr);
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");

        Client client = SoftManager.login(phone, password);
        if (client != null){
            req.getSession().setAttribute("client", client);
            resp.sendRedirect(successRedir);
        } else {
            req.getRequestDispatcher(failPath).forward(req, resp);
        }
    }

    public static void register(SMR smr) throws IOException {
        setSmr(smr);
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String birthdateString = req.getParameter("birthdate");
        Date birthdate = SoftManager.stringToDate(birthdateString);

        if (!ClientManager.getAllPhones().contains(phone)){
            Client client = ClientBuilder
                    .name(name)
                    .surname(surname)
                    .phone(phone)
                    .password(
                            CryptWithMD5.cryptWithMD5(password)
                    )
                    .gender(gender)
                    .birthdate(birthdate)
                    .card(
                            new Card()
                    )
                    .isAdmin(false)
                    .build();

            ClientManager.insertClient(client);
            req.getSession().setAttribute("client", client);
            resp.sendRedirect(successRedir);
        }
    }

    public static void changeInfo(SMR smr) throws IOException {
        setSmr(smr);
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
        resp.sendRedirect(successRedir);
    }

    public static void deleteClient(SMR smr) throws IOException, ServletException {
        setSmr(smr);
        String phone = req.getParameter("phone");
        if (ClientManager.getAllPhones().contains(phone)){
            ClientManager.deleteClient(ClientManager.getClientFormDBbyPhone(phone));
            resp.sendRedirect(successRedir);
        } else {
            req.getRequestDispatcher(failPath).forward(req, resp);
        }
    }

    public static void giveAdmin(SMR smr) throws IOException, ServletException {
        setSmr(smr);
        String phone = req.getParameter("phone");
        Client client = ClientManager.getClientFormDBbyPhone(phone);
        if (client != null){
            if (!client.isAdmin()){
                client.setAdmin(true);
                ClientManager.updateAdmin(client);
            }
            resp.sendRedirect(successRedir);
        } else {
            req.getRequestDispatcher(failPath).forward(req, resp);
        }
    }

    public static void removeAdmin(SMR smr) throws IOException, ServletException {
        setSmr(smr);
        String phone = req.getParameter("phone");
        Client client = ClientManager.getClientFormDBbyPhone(phone);
        if (client != null){
            if (client.isAdmin()){
                client.setAdmin(false);
                ClientManager.updateAdmin(client);
            }
            resp.sendRedirect(successRedir);
        } else {
            req.getRequestDispatcher(failPath).forward(req, resp);
        }
    }

    public static void setBalance(SMR smr) throws IOException, ServletException {
        setSmr(smr);
        String cardNum = req.getParameter("cardNum");
        Integer value = Integer.parseInt(req.getParameter("value"));
        if (CardManager.getAllCardNum().contains(cardNum)){
            Client client = ClientManager.getClientFormDBbyCardNum(cardNum);
            Card card = client.getCard();
            card.setValue(value);
            CardManager.updateCard(card);
            resp.sendRedirect(successRedir);
        } else {
            req.getRequestDispatcher(failPath).forward(req, resp);
        }
    }

    public static void setCardNum(SMR smr) throws IOException, ServletException {
        setSmr(smr);
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
                resp.sendRedirect(successRedir);
                isOK = true;
            }
        }

        if (!isOK){
            req.getRequestDispatcher(failPath).forward(req,resp);
        }
    }
}
