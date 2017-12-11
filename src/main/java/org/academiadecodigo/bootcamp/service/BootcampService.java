package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.Bootcamp;

import java.util.List;

public interface BootcampService {

    void add(Bootcamp bootcamp);

    Bootcamp findById(int id);

    List<Bootcamp> findAll();

    int count();
}
