package org.academiadecodigo.bootcamp.controller;

import org.academiadecodigo.bootcamp.app.Attribute;
import org.academiadecodigo.bootcamp.service.BootcampService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BootcampController extends HttpServlet {

    private static final Logger log = Logger.getLogger(BootcampController.class.getSimpleName());

    private BootcampService bootcampService;
    private RequestDispatcher dispatcher;

    @Override
    public void init() throws ServletException {

        log.log(Level.INFO, "Initializing Servlet");

        bootcampService = (BootcampService) getServletContext().getAttribute(Attribute.BOOTCAMP_SERVICE);
        dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/bootcamp-list.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.log(Level.INFO, "GET request received");

        String username = (String) req.getSession().getAttribute(Attribute.USER_NAME);

        if (username == null || username.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        req.getSession().setAttribute(Attribute.BOOTCAMP_LIST, bootcampService.findAll());
        req.getSession().setAttribute(Attribute.BOOTCAMP_COUNT, bootcampService.count());


        dispatcher.forward(req, resp);

    }

}
