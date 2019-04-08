package com.example.parsec.model;

/**
 * The type System.
 */
public class System {
    private int id;
    private String name;
    private Coordinate location;
    private Market market;
    private TechLevel techLevel;
    private Characteristic characteristic;
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
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(Coordinate location) {
        this.location = location;
    }

    /**
     * Sets tech level.
     *
     * @param techLevel the tech level
     */
    public void setTechLevel(TechLevel techLevel) {
        this.techLevel = techLevel;
    }

    /**
     * Sets characteristic.
     *
     * @param characteristic the characteristic
     */
    public void setCharacteristic(Characteristic characteristic) {
        this.characteristic = characteristic;
    }

    /**
     * Sets market.
     *
     * @param market the market
     */
    public void setMarket(Market market) {
        this.market = market;
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
     * Gets distance.
     *
     * @param s2 the s 2
     * @return the distance
     */
    public double getDistance(System s2) {
        return location.getDistance(s2.getLocation());
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
