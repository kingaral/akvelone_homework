package com.main.akvelon.homework2.model.entity;

import com.main.akvelon.homework2.model.enums.DriverStatus;

import java.util.UUID;

public class Driver extends Entity{
    private String username;
    private DriverStatus status;

    public Driver(UUID id, String username) {
        super(id);
        this.username = username;
        this.status = DriverStatus.FREE;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "username='" + username + '\'' +
                ", status=" + status +
                ", id=" + id +
                ", createdDate=" + createdDate +
                '}';
    }
}
