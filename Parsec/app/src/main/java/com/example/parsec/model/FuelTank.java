package com.example.parsec.model;

/**
 * The type Fuel tank.
 */
class FuelTank {
    private final double maxFuel;
    private double fuelLevel;

    /**
     * Instantiates a new Fuel tank.
     *
     * @param maxFuel the max fuel
     */
    public FuelTank(double maxFuel) {
        this.maxFuel = maxFuel;
        this.fuelLevel = maxFuel;
    }

    /**
     * Gets fuel.
     *
     * @return the fuel
     */
    public double getFuel() {
        return this.fuelLevel;
    }

    /**
     * Gets max fuel.
     *
     * @return the max fuel
     */
    public double getMaxFuel() {
        return this.maxFuel;
    }

    /**
     * Gets fuel space.
     *
     * @return the fuel space
     */
    public double getFuelSpace() {
        return this.maxFuel - this.fuelLevel;
    }

    /**
     * Refuel.
     */
    public void refuel() {
        this.fuelLevel = maxFuel;
    }

    /**
     * Jump.
     *
     * @param distance the distance
     */
    public void jump(double distance) {
        this.fuelLevel -= distance;
    }
}
