package com.main.akvelon.homework2.service;

import com.main.akvelon.homework2.model.entity.Driver;
import com.main.akvelon.homework2.model.entity.Order;
import com.main.akvelon.homework2.model.entity.Passenger;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    void createOrder(String address, Passenger passenger);
    void setDriverToOrder(Order order, Driver driver);
    List<Order> findAll();

    Order getById(UUID id);

    void cancelOrder(Order order);

    void endOrder(Order order);
}
