package com.main.akvelon.homework2.repository;

import com.main.akvelon.homework2.model.entity.Entity;

import java.util.List;

public interface CrudRepository<T extends Entity, V> {
    void save(T t);
    void deleteById(V id);
    T findById(V id);
    List<T> findAll();
}
