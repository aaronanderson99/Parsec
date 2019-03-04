package com.example.parsec.model;

public class System {
    private int id;
    private String name;
    private Coordinate location;
    TechLevel techLevel;
    Characteristics characteristic;

    public System(int id, String name, TechLevel techLevel, Characteristics characteristic, Coordinate location) {
        this.id = id;
        this.name = name;
        this.techLevel = techLevel;
        this.characteristic = characteristic;
        this.location = location;
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

    public String getName() {
        return this.name;
    }
    public int getId() {
        return this.id;
    }
    public Coordinate getLocation() {
        return location;
    }


    public double getDistance(System s2) {
        return location.getDistance(s2.getLocation());
    }
}
