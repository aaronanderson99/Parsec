package com.example.parsec.model;

public enum ShipType {
    Gnat("Gnat");

    private final String typeName;

    public String getType() {
        return this.typeName;
    }

    ShipType(String typeName) {
        this.typeName = typeName;
    }
}
