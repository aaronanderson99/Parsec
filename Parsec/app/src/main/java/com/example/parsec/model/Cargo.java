package com.example.parsec.model;

/**
 * The type Cargo.
 */
public class Cargo {
    private int cargo[];
    private final int maxCargo;
    private int cargoFilled;


    /**
     * Instantiates a new Cargo.
     */
    public Cargo() {
        this(10);
    }

    /**
     * Instantiates a new Cargo.
     *
     * @param maxCargo the max cargo
     */
    public Cargo(int maxCargo) {
        this.cargo = new int[Resource.values().length];
        this.maxCargo = maxCargo;
    }

    /**
     * Gets cargo stock.
     *
     * @param resource the resource
     * @return the cargo stock
     */
    public int getCargoStock(Resource resource) {
        return cargo[resource.getCode()];
    }

    /**
     * Gets cargo filled.
     *
     * @return the cargo filled
     */
    public int getCargoFilled() {
        return this.cargoFilled;
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
     * Gets remaining cargo.
     *
     * @return the remaining cargo
     */
    public int getRemainingCargo() {
        return maxCargo - cargoFilled;
    }

    /**
     * Buy.
     *
     * @param resource the resource
     * @param num      the num
     */
    public void buy(Resource resource, int num) {
        cargo[resource.getCode()] += num;
        cargoFilled += num;
    }

    /**
     * Sell.
     *
     * @param resource the resource
     * @param num      the num
     */
    public void sell(Resource resource, int num) {
        cargo[resource.getCode()] -= num;
        cargoFilled -= num;
    }

}
