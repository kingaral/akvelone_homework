package com.main.akvelon.homework2.model.entity;

import java.time.Instant;
import java.util.UUID;

public abstract class Entity {

    UUID id;
    Instant createdDate;

    public Entity(UUID id) {
        this.id = id;
        this.createdDate = Instant.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }
}
