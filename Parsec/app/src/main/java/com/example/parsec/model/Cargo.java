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

    public int getRemainingCargo() {
        return maxCargo - cargoFilled;
    }

    public void buy(Resource resource, int num) {
        cargo[resource.getCode()] += num;
    }
    public void sell(Resource resource, int num) {
        cargo[resource.getCode()] -= num;
    }

}
