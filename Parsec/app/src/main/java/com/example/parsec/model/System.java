package com.example.parsec.model;

public class System {
    private int id;
    private String name;
    private Coordinate location;
    private Market market;
    private TechLevel techLevel;
    private Characteristic characteristic;
    // Distance from current system. Used in jumping, only matters if the system is within range, else can be anything.
    private double distance;

    public System(int id, String name, TechLevel techLevel, Characteristic characteristic, Coordinate location) {
        this.id = id;
        this.name = name;
        this.techLevel = techLevel;
        this.characteristic = characteristic;
        this.location = location;
        this.market = new Market(techLevel, characteristic);
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setLocation(Coordinate location) {
        this.location = location;
    }
    public void setTechLevel(TechLevel techLevel) {
        this.techLevel = techLevel;
    }
    public void setCharacteristic(Characteristic characteristic) {
        this.characteristic = characteristic;
    }
    public void setMarket(Market market) {
        this.market = market;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getName() {
        return this.name;
    }
    public int getId() {
        return this.id;
    }
    public Coordinate getLocation() {
        return location;
    }
    public TechLevel getTechLevel() {
        return this.techLevel;
    }
    public Characteristic getCharacteristic() {
        return this.characteristic;
    }
    public Market getMarket() {
        return this.market;
    }
    public double getDistance() {
        return this.distance;
    }
    public double getDistance(System s2) {
        return location.getDistance(s2.getLocation());
    }
}
