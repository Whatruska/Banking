package main.webapp.Servlets;

import main.webapp.Backend.Banking.Managers.ServletManager;
import main.webapp.Backend.Banking.Managers.ServletManagerRequest.SMR;
import main.webapp.Backend.Banking.Managers.ServletManagerRequest.SMRBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Pages/Login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SMR smr = SMRBuilder
                .req(req)
                .resp(resp)
                .failPath("/Pages/Login.jsp")
                .successRedir("/main")
                .build();
        ServletManager.login(smr);
    }
}
