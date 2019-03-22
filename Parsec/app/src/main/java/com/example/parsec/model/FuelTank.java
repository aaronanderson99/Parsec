package com.example.parsec.model;

public class FuelTank {
    private double maxFuel;
    private double fuelLevel;

    public FuelTank(double maxFuel) {
        this.maxFuel = maxFuel;
        this.fuelLevel = maxFuel;
    }

    public double getFuel() {
        return this.fuelLevel;
    }
    public double getMaxFuel() {
        return this.maxFuel;
    }
    public double getFuelSpace() {
        return this.maxFuel - this.fuelLevel;
    }
    public void refuel() {
        this.fuelLevel = maxFuel;
    }
    public void jump(double distance) {
        this.fuelLevel -= distance;
    }
}
