package com.example.parsec.model;

/**
 * The enum Ship type.
 */
public enum ShipType {
    /**
     * Gnat ship type.
     */
    Gnat("Gnat", 10, 10);

    private final String typeName;
    private final int maxCargo;
    private final double maxFuel;


    ShipType(String typeName, int maxCargo, double maxFuel) {
        this.typeName = typeName;
        this.maxCargo = maxCargo;
        this.maxFuel = maxFuel;
    }


    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return this.typeName;
    }

    /**
     * Gets max cargo.
     *
     * @return the max cargo
     */
    public int getMaxCargo() {
        return this.maxCargo;
    }

    /**
     * Gets max fuel.
     *
     * @return the max fuel
     */
    public double getMaxFuel() {
        return this.maxFuel;
    }


}
