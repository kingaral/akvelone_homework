package com.main.akvelon.homework2.model.entity;

import com.main.akvelon.homework2.model.enums.OrderStatus;

import java.time.Instant;
import java.util.UUID;

public class Order extends Entity {

    private String address;
    private Driver driver;
    private Passenger passenger;
    private Double price;
    private OrderStatus status;
    private Instant endData;

    public Order(UUID id, String address, Passenger passenger, Double price) {
        super(id);
        this.address = address;
        this.driver = null;
        this.passenger = passenger;
        this.price = price;
        this.status = OrderStatus.ACTIVE;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Instant getEndData() {
        return endData;
    }

    public void setEndData(Instant endData) {
        this.endData = endData;
    }

    @Override
    public String toString() {
        return "Order{" +
                "address='" + address + '\'' +
                ", driver=" + driver +
                ", passenger=" + passenger +
                ", price=" + price +
                ", status=" + status +
                ", endData=" + endData +
                ", id=" + id +
                ", createdDate=" + createdDate +
                '}';
    }
}

