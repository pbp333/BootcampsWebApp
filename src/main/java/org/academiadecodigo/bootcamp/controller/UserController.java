package org.academiadecodigo.bootcamp.controller;

import org.academiadecodigo.bootcamp.app.Attribute;
import org.academiadecodigo.bootcamp.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserController extends HttpServlet {

    private static final Logger log = Logger.getLogger(UserController.class.getSimpleName());

    private UserService userService;
    private RequestDispatcher mainDispatcher;

    @Override
    public void init() throws ServletException {

        log.log(Level.INFO, "Initializing Servlet");

        userService = (UserService) getServletContext().getAttribute(Attribute.USER_SERVICE);
        mainDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/user-list.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.log(Level.INFO, "GET request received");

        String username = (String) req.getSession().getAttribute(Attribute.USER_NAME);

        if (username == null || username.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        req.getSession().setAttribute(Attribute.USER_LIST, userService.findAll());
        req.getSession().setAttribute(Attribute.USER_COUNT, userService.count());

        mainDispatcher.forward(req, resp);

    }
}
