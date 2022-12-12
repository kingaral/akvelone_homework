package com.main.akvelon.homework2.service.impl;


import com.main.akvelon.homework2.model.entity.Driver;
import com.main.akvelon.homework2.model.entity.Order;
import com.main.akvelon.homework2.model.entity.Passenger;
import com.main.akvelon.homework2.model.enums.DriverStatus;
import com.main.akvelon.homework2.model.enums.OrderStatus;
import com.main.akvelon.homework2.repository.CrudRepository;
import com.main.akvelon.homework2.repository.impl.CrudRepositoryImpl;
import com.main.akvelon.homework2.service.DriverService;
import com.main.akvelon.homework2.service.OrderService;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {

    private final CrudRepository<Order, UUID> orderRepository;
    private final DriverService driverService;
    private final Random random;

    public OrderServiceImpl(DriverService driverService) {
         this.driverService = driverService;
        orderRepository = new CrudRepositoryImpl<>();
        random = new Random();
    }

    @Override
    public void createOrder(String address, Passenger passenger) {
        Order order = new Order(UUID.randomUUID(), address, passenger, random.nextDouble());
        orderRepository.save(order);
    }


    @Override
    public void setDriverToOrder(Order order, Driver driver) {
        order.setDriver(driver);
        driver.setStatus(DriverStatus.BUSY);

        driverService.save(driver);
        orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(UUID id) {
        return orderRepository.findById(id);
    }

    @Override
    public void cancelOrder(Order order) {
        if(Objects.nonNull(order.getDriver())){
            Driver driver = order.getDriver();
            driver.setStatus(DriverStatus.FREE);
            driverService.save(driver);
        }

        order.setStatus(OrderStatus.CANCELED);
        orderRepository.save(order);
    }

    @Override
    public void endOrder(Order order) {
        if(Objects.nonNull(order.getDriver())){
            Driver driver = order.getDriver();
            driver.setStatus(DriverStatus.FREE);
            driverService.save(driver);
        }

        order.setEndData(Instant.now());
        orderRepository.save(order);
    }


}
