package com.main.akvelon.homework2.model.entity;

import java.util.UUID;

public class Passenger extends Entity{

    private String username;

    public Passenger(UUID id , String username) {
        super(id);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", createdDate=" + createdDate +
                '}';
    }
}
