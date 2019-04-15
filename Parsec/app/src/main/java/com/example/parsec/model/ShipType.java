package com.example.parsec.model;

/**
 * The enum Ship type.
 */
public enum ShipType {
    /**
     * Gnat ship type.
     */
    Gnat(10, 10),
    Wasp(25, 25),
    Hornet(50, 50),
    Dragonfly(100, 100);

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
