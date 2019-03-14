package com.example.parsec.model;

public enum ShipType {
    Gnat("Gnat", 10);

    private final String typeName;
    private final int maxCargo;


    ShipType(String typeName, int maxCargo) {
        this.typeName = typeName;
        this.maxCargo = maxCargo;
    }


    public String getType() {
        return this.typeName;
    }
    public int getMaxCargo() {
        return this.maxCargo;
    }

}
