package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;

import java.util.*;

public class MockUserService implements UserService {

    private Map<Integer, User> users;

    public MockUserService() {
        users = new HashMap<>();
    }

    public MockUserService(Map<Integer, User> users) {
        this.users = users;
    }

    @Override
    public void add(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User findByName(String username) {

        LinkedList<User> usersList = new LinkedList<>(users.values());

        for (User user : usersList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public int count() {
        return users.size();
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public String toString() {
        return "MockUserService{" +
                "users=" + users.values() +
                '}';
    }
}


