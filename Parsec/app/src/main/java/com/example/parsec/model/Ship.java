package com.example.parsec.model;

import java.util.LinkedList;
import java.util.List;

public class Ship {
    private ShipType type;
    private Coordinate location;
    private List<System> systemsInRange = new LinkedList<System>();

    public Ship() {
        this(ShipType.Gnat);
    }
    public Ship(ShipType type) {
        this.type = type;
    }

    public ShipType getName() {
        return type;
    }
    public void setName(ShipType type) {
        this.type = type;
    }

    // generate list of systems
    public void findSystemsInRange() {

    }
    public List<System> getSystemsInRange() {
        return systemsInRange;
    }

}
