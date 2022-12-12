package com.main.akvelon.homework2.service.impl;

import com.main.akvelon.homework2.model.entity.Driver;
import com.main.akvelon.homework2.model.enums.DriverStatus;
import com.main.akvelon.homework2.repository.CrudRepository;
import com.main.akvelon.homework2.repository.impl.CrudRepositoryImpl;
import com.main.akvelon.homework2.service.DriverService;

import java.util.List;
import java.util.UUID;

public class DriverServiceImpl implements DriverService {

    private final CrudRepository<Driver, UUID> driverRepository;

    public DriverServiceImpl() {
        driverRepository = new CrudRepositoryImpl<>();
    }

    @Override
    public void save(Driver driver) {
        driverRepository.save(driver);
    }

    @Override
    public Driver findFreeDriver() {
        return driverRepository.findAll()
                .stream().filter(driver -> driver.getStatus().equals(DriverStatus.FREE))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(("Free drivers not found")));
    }

    @Override
    public List<Driver> findAll() {
        return driverRepository.findAll();
    }
}
