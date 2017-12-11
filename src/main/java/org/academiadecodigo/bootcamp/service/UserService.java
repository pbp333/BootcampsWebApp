package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;

import java.util.List;

/**
 * user service
 */
public interface UserService {

    void add(User user);

    User findById(int id);

    User findByName(String username);

    List<User> findAll();

    int count();
}


