package com.main.akvelon.homework2.service.impl;

import com.main.akvelon.homework2.model.entity.Passenger;
import com.main.akvelon.homework2.repository.CrudRepository;
import com.main.akvelon.homework2.repository.impl.CrudRepositoryImpl;
import com.main.akvelon.homework2.service.PassengerService;

import java.util.List;
import java.util.UUID;

public class PassengerServiceImpl implements PassengerService {

    private final CrudRepository<Passenger, UUID> passengerRepository;

    public PassengerServiceImpl() {
        passengerRepository = new CrudRepositoryImpl<>();
    }

    @Override
    public void save(Passenger passenger) {
        passengerRepository.save(passenger);
    }

    @Override
    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }

    @Override
    public Passenger findAnyPassenger() {
        return passengerRepository.findAll()
                .stream()
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(("Passenger not found")));
    }
}
