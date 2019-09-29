package main.webapp.Servlets;

import main.webapp.Backend.Banking.Card.Card;
import main.webapp.Backend.Banking.Client.Client;
import main.webapp.Backend.Banking.Client.ClientBuilder;
import main.webapp.Backend.Banking.Client.ClientManager;
import main.webapp.Backend.Banking.CryptWithMD5;
import main.webapp.Backend.Banking.SoftManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Pages/Register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String birthdateString = req.getParameter("birthdate");
        Date birthdate = SoftManager.stringToDate(birthdateString);

        if (SoftManager.isUnique(phone, ClientManager.getAllPhones())){
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
            resp.sendRedirect(req.getContextPath() + "/main");
        }
    }
}
