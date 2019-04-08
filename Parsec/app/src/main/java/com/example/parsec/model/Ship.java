package com.example.parsec.model;

import android.content.Intent;

import com.example.parsec.views.TEMP_SystemActivity;

import java.util.LinkedList;
import java.util.List;

public class Ship {
    private ShipType type;
    private System currentSystem;
    private List<System> systemsInRange = new LinkedList<System>();
    private Cargo cargo;
    private FuelTank fuelTank;



    public Ship(ShipType type) {
        this.type = type;
        this.cargo = new Cargo(type.getMaxCargo());
        this.fuelTank = new FuelTank(type.getMaxFuel());
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
        Universe universe = Game.getInstance().getUniverse();
        systemsInRange = universe.getSystemsInRange();
    }

    public List<System> getSystemsInRange() {
        return systemsInRange;
    }

    public void jump(System system) {
        if(systemsInRange.contains(system)) {
            currentSystem = system;
            fuelTank.jump(system.getDistance());
            RandomEvent.generateRandomEvent(system);
            system.generateMarket();
            findSystemsInRange();
        }
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

    public void refuel() {
        fuelTank.refuel();
        findSystemsInRange();
    }
    public double getFuel() {
        return fuelTank.getFuel();
    }
    public double getFuelSpace() {
        return fuelTank.getFuelSpace();
    }
    public double getMaxFuel() {
        return fuelTank.getMaxFuel();
    }

}