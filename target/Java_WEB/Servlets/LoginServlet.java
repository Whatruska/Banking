package main.webapp.Servlets;

import main.webapp.Backend.Banking.Managers.ServletManager;
import main.webapp.Backend.Banking.Managers.ServletManagerRequest.SMR;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends WServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        pagePath = "/Pages/Login.jsp";
        String method = req.getMethod();
        if (method.equalsIgnoreCase("GET")){
            doGet(req, resp);
        } else {
            doPost(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST");
        SMR smr = makeDefaultSMR(req, resp);
        ServletManager.login(smr);
    }
}
