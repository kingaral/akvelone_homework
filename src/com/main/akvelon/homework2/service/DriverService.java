package com.main.akvelon.homework2.service;

import com.main.akvelon.homework2.model.entity.Driver;

import java.util.List;

public interface DriverService {

    void save(Driver driver);

    Driver findFreeDriver();

    List<Driver> findAll();

}

