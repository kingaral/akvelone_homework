package com.main.akvelon.homework2.service;

import com.main.akvelon.homework2.model.entity.Passenger;

import java.util.List;

public interface PassengerService {
    void save(Passenger passenger);
    List<Passenger> findAll();

    Passenger findAnyPassenger();
}
