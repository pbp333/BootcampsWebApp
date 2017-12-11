package org.academiadecodigo.bootcamp.auth;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.UserService;

public class Authenticator {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public boolean authenticate(String username, String password) {

        User user = userService.findByName(username);
        return user != null && user.getPassword().equals(password);

    }
}
