package main.webapp.Servlets.AuthorizedServlets.AdminServlets;

import main.webapp.Servlets.AuthorizedServlets.AuthorizedServlet;

import javax.servlet.ServletException;

abstract public class AdminServlet extends AuthorizedServlet {
    @Override
    public void init() throws ServletException {
        redir = "/admin";
    }
}
