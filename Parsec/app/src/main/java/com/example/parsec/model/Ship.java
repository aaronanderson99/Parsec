package com.example.parsec.model;

import java.util.LinkedList;
import java.util.List;

public class Ship {
    private ShipType type;
    private System currentSystem;
    private List<System> systemsInRange = new LinkedList<System>();
    private Cargo cargo;



    public Ship(ShipType type) {
        this.type = type;
        this.cargo = new Cargo(type.getMaxCargo());
    }

    public ShipType getName() {
        return type;
    }
    public void setName(ShipType type) {
        this.type = type;
    }
    public System getCurrentSystem() {
        return this.currentSystem;
    }
    public void setCurrentSystem(System system) {
        this.currentSystem = system;
    }

    public void findSystemsInRange() {
        // generate list of systems
    }

    public List<System> getSystemsInRange() {
        return systemsInRange;
    }

    public void jump(System system) {
        // generate random event
        // generate system conditions
        // update location
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void buy(Resource resource, int num) {
        cargo.buy(resource, num);
    }
    public void sell(Resource resource, int num) {
        cargo.sell(resource, num);
    }

}