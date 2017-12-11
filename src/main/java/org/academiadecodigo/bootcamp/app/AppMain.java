package org.academiadecodigo.bootcamp.app;

import org.academiadecodigo.bootcamp.auth.Authenticator;
import org.academiadecodigo.bootcamp.model.Bootcamp;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.BootcampService;
import org.academiadecodigo.bootcamp.service.MockBootcampService;
import org.academiadecodigo.bootcamp.service.MockUserService;
import org.academiadecodigo.bootcamp.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Date;

public class AppMain implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        // Get the servlet context from context event
        ServletContext ctx = sce.getServletContext();

        // instantiate and wire authenticator and services
        Authenticator authenticator = new Authenticator();
        UserService userService = new MockUserService();
        authenticator.setUserService(userService);
        BootcampService bootcampService = new MockBootcampService();

        // make services available to the whole app
        ctx.setAttribute(Attribute.AUTH_SERVICE, authenticator);
        ctx.setAttribute(Attribute.USER_SERVICE, userService);
        ctx.setAttribute(Attribute.BOOTCAMP_SERVICE, bootcampService);

        // Setup some test users
        userService.add(new User(1,"ferrao", "master", "rui.ferrao@academiadecodigo.org"));
        userService.add(new User(2,"nuno", "nuno", "nuno.campelo@academiadecodigo.org"));
        userService.add(new User(3, "antoninho", "antoninho", "pedro.antoninho@academiadecodigo.org"));
        userService.add(new User(4, "sergio", "sergio", "sergio.gouveia@academiadecodigo.org"));
        userService.add(new User(5, "joana", "joana", "joana.falcao@academiadecodigo.org"));

        // Setup some test bootcamps
        bootcampService.add(new Bootcamp(1, "Lisboa", new Date(), new Date()));
        bootcampService.add(new Bootcamp(2, "Lisboa", new Date(), new Date()));
        bootcampService.add(new Bootcamp(3, "Lisboa", new Date(), new Date()));
        bootcampService.add(new Bootcamp(4, "Fundão", new Date(), new Date()));

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
