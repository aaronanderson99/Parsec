package com.example.parsec.model;

/**
 * The type System.
 */
public class System {
    private final int id;
    private final String name;
    private final Coordinate location;
    private final Market market;
    private final TechLevel techLevel;
    private final Characteristic characteristic;
    // Distance from current system. Used in jumping, only matters if the system is within range, else can be anything.
    private double distance;
    private RandomEvent event;

    /**
     * Instantiates a new System.
     *
     * @param id             the id
     * @param name           the name
     * @param techLevel      the tech level
     * @param characteristic the characteristic
     * @param location       the location
     */
    public System(int id, String name, TechLevel techLevel, Characteristic characteristic, Coordinate location) {
        this.id = id;
        this.name = name;
        this.techLevel = techLevel;
        this.characteristic = characteristic;
        this.location = location;
        this.market = new Market(techLevel, characteristic);
        this.event = RandomEvent.Normal;
    }


    /**
     * Sets distance.
     *
     * @param distance the distance
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * Sets event.
     *
     * @param event the event
     */
    public void setEvent(RandomEvent event) {
        this.event = event;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public Coordinate getLocation() {
        return location;
    }

    /**
     * Gets tech level.
     *
     * @return the tech level
     */
    public TechLevel getTechLevel() {
        return this.techLevel;
    }

    /**
     * Gets characteristic.
     *
     * @return the characteristic
     */
    public Characteristic getCharacteristic() {
        return this.characteristic;
    }

    /**
     * Gets market.
     *
     * @return the market
     */
    public Market getMarket() {
        return this.market;
    }

    /**
     * Gets distance.
     *
     * @return the distance
     */
    public double getDistance() {
        return this.distance;
    }

    /**
     * Gets event.
     *
     * @return the event
     */
    public RandomEvent getEvent() {
        return event;
    }

    /**
     * Generate market.
     */
    public void generateMarket() {
        market.setEvent(event);
        market.generateMarket();
    }
}
