package com.example.parsec.model;

public class Cargo {
    private int cargo[];
    private final int maxCargo;
    private int cargoFilled;


    public Cargo() {
        this(10);
    }
    public Cargo(int maxCargo) {
        this.cargo = new int[Resource.values().length];
        this.maxCargo = maxCargo;
    }

    public int getCargoStock(Resource resource) {
        return cargo[resource.getCode()];
    }
    public int getCargoFilled() {
        return this.cargoFilled;
    }
    public int getMaxCargo() {
        return this.maxCargo;
    }
    public int getRemainingCargo() {
        return maxCargo - cargoFilled;
    }

    public void buy(Resource resource, int num) {
        cargo[resource.getCode()] += num;
        cargoFilled += num;
    }
    public void sell(Resource resource, int num) {
        cargo[resource.getCode()] -= num;
        cargoFilled -= num;
    }

}
