package com.example.parsec.model;

public enum ShipType {
    Gnat("Gnat", 10, 10);

    private final String typeName;
    private final int maxCargo;
    private final double maxFuel;


    ShipType(String typeName, int maxCargo, double maxFuel) {
        this.typeName = typeName;
        this.maxCargo = maxCargo;
        this.maxFuel = maxFuel;
    }


    public String getType() {
        return this.typeName;
    }
    public int getMaxCargo() {
        return this.maxCargo;
    }
    public double getMaxFuel() {
        return this.maxFuel;
    }


}
