package com.example.parsec.model;

public class Ship {
    private ShipType type;

    public Ship(ShipType type) {
        this.type = type;
    }

    public ShipType getName() {
        return type;
    }

    public void setName(ShipType type) {
        this.type = type;
    }
}
