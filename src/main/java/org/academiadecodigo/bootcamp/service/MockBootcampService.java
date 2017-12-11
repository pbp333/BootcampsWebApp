package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.Bootcamp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MockBootcampService implements BootcampService {

    Map<Integer, Bootcamp> bootcamps = new HashMap<>();

    public void setBootcamps(Map<Integer, Bootcamp> bootcamps) {
        this.bootcamps = bootcamps;
    }

    @Override
    public void add(Bootcamp bootcamp) {
        bootcamps.put(bootcamp.getId(), bootcamp);
    }

    @Override
    public Bootcamp findById(int id) {
        return bootcamps.get(id);
    }

    @Override
    public List<Bootcamp> findAll() {
        return new LinkedList<>(bootcamps.values());
    }

    @Override
    public int count() {
        return bootcamps.size();
    }
}
