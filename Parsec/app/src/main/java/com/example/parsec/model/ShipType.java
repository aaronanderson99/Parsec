package com.example.parsec.model;

/**
 * The enum Ship type.
 */
public enum ShipType {
    /**
     * Gnat ship type.
     */
    Gnat(10, 10),
    Wasp(15, 15),
    Hornet(20, 20),
    Dragonfly(25, 25);

    private final int maxCargo;
    private final double maxFuel;


    ShipType(int maxCargo, double maxFuel) {
        this.maxCargo = maxCargo;
        this.maxFuel = maxFuel;
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
