package com.example.parsec.model;

import java.util.LinkedList;
import java.util.List;

public class Ship {
<<<<<<< HEAD
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
=======
    private Coordinate location;
    private List<System> systemsInRange = new LinkedList<System>();

>>>>>>> Aaron
}
