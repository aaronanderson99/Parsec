package com.example.parsec.model;

import java.util.LinkedList;
import java.util.List;

/**
 * The type Ship.
 */
public class Ship {
    private final ShipType type;
    private System currentSystem;
    private List<System> systemsInRange = new LinkedList<>();
    private final Cargo cargo;
    private final FuelTank fuelTank;


    /**
     * Instantiates a new Ship.
     *
     * @param type the type
     */
    public Ship(ShipType type) {
        this.type = type;
        this.cargo = new Cargo(type.getMaxCargo());
        this.fuelTank = new FuelTank(type.getMaxFuel());
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public ShipType getName() {
        return type;
    }

    /**
     * Gets current system.
     *
     * @return the current system
     */
    public System getCurrentSystem() {
        return this.currentSystem;
    }

    /**
     * Sets current system.
     *
     * @param system the system
     */
    public void setCurrentSystem(System system) {
        this.currentSystem = system;
    }

    /**
     * Find systems in range.
     */
    public void findSystemsInRange() {
        // generate list of systems
        Universe universe = Game.getInstance().getUniverse();
        systemsInRange = universe.getSystemsInRange();
    }

    /**
     * Gets systems in range.
     *
     * @return the systems in range
     */
    public List<System> getSystemsInRange() {
        return systemsInRange;
    }

    /**
     * Jump.
     *
     * @param system the system
     */
    public void jump(System system) {
        if(systemsInRange.contains(system)) {
            currentSystem = system;
            fuelTank.jump(system.getDistance());
            RandomEvent.generateRandomEvent(system);
            system.generateMarket();
            findSystemsInRange();
        }
    }

    /**
     * Gets cargo.
     *
     * @return the cargo
     */
    public Cargo getCargo() {
        return cargo;
    }

    /**
     * Buy.
     *
     * @param resource the resource
     * @param num      the num
     */
    public void buy(Resource resource, int num) {
        cargo.buy(resource, num);
    }

    /**
     * Sell.
     *
     * @param resource the resource
     * @param num      the num
     */
    public void sell(Resource resource, int num) {
        cargo.sell(resource, num);
    }

    /**
     * Refuel.
     */
    public void refuel() {
        fuelTank.refuel();
        findSystemsInRange();
    }

    /**
     * Gets fuel.
     *
     * @return the fuel
     */
    public double getFuel() {
        return fuelTank.getFuel();
    }

    /**
     * Gets fuelTank.
     *
     * @return the fuelTank
     */
    public FuelTank getFuelTank() {
        return this.fuelTank;
    }

    /**
     * Gets fuel space.
     *
     * @return the fuel space
     */
    public double getFuelSpace() {
        return fuelTank.getFuelSpace();
    }

    /**
     * Gets max fuel.
     *
     * @return the max fuel
     */
    public double getMaxFuel() {
        return fuelTank.getMaxFuel();
    }

    /**
     * invokes the generateMarket() method from the System object
     */
    public void generateMarket() {
        currentSystem.generateMarket();
    }


}