package com.studies.pet;

import java.util.UUID;

public class Pet {
    private UUID id;
    private String name;
    private double weigth;


    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public double getWeigth() {
        return weigth;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
