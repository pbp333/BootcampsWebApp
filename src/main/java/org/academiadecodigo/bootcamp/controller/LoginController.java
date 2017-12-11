package org.academiadecodigo.bootcamp.controller;

import org.academiadecodigo.bootcamp.app.Attribute;
import org.academiadecodigo.bootcamp.auth.Authenticator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController extends HttpServlet {

    private static final Logger log = Logger.getLogger(LoginController.class.getSimpleName());

    private Authenticator authenticator;
    private RequestDispatcher formDispatcher;

    @Override
    public void init() throws ServletException {

        log.log(Level.INFO, "Initializing Servlet");

        authenticator = (Authenticator) getServletContext().getAttribute(Attribute.AUTH_SERVICE);
        formDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.log(Level.INFO, "GET request received");

        String username = (String) req.getSession().getAttribute(Attribute.USER_NAME);

        if (username != null && !username.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/bootcamps");
            return;
        }

        formDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.log(Level.INFO, "POST request received");

        String username = req.getParameter(Attribute.USER_NAME);
        String password = req.getParameter(Attribute.USER_PASSWORD);

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        if (authenticator.authenticate(username, password)) {

            log.log(Level.INFO, "Authentication succeeded for " + username);

            req.getSession().setAttribute(Attribute.USER_NAME, username);
            req.getSession().setAttribute(Attribute.AUTH_FAILURE, false);

            resp.sendRedirect(req.getContextPath() + "/bootcamps");

        } else {

            log.log(Level.INFO, "Authentication failed");

            req.getSession().setAttribute(Attribute.AUTH_FAILURE, true);
            formDispatcher.forward(req, resp);
        }

    }
}
