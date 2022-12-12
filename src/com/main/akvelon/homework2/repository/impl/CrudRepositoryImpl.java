package com.main.akvelon.homework2.repository.impl;

import com.main.akvelon.homework2.model.entity.Entity;
import com.main.akvelon.homework2.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public class CrudRepositoryImpl<T extends Entity, V> implements CrudRepository<T, V> {

    private final List<T> tList;

    public CrudRepositoryImpl() {
        this.tList = new ArrayList<>();
    }

    @Override
    public void save(T t) {
        tList.stream()
                .filter(in -> in.getId().equals(t.getId()))
                .findFirst().ifPresent(tList::remove);

        tList.add(t);
    }

    @Override
    public void deleteById(V id) {
        tList.remove(findById(id));
    }

    @Override
    public T findById(V id) {
        return tList
                .stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Entity with id %s not found", id)));
    }

    @Override
    public List<T> findAll() {
        return tList;
    }
}
