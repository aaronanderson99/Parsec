package com.example.parsec.model;

public class Player {
    private String name;
    private Ship ship;

    private int pilotSkill;
    private int fighterSkill;
    private int traderSkill;
    private int engineerSkill;

    private double credits;

    /**
     * Default constructor, creates new Player named Bob,
     * with 16 skill points divided evenly across attributes
     */
    public Player() {
        this("Bob", 4, 4, 4, 4, 1000);
    }

    public Player(String name, int pilotSkill, int fighterSkill, int traderSkill, int engineerSkill, double credits) {
        this.name = name;
        this.pilotSkill = pilotSkill;
        this.fighterSkill = fighterSkill;
        this.traderSkill = traderSkill;
        this.engineerSkill = engineerSkill;
        this.credits = credits;
        this.ship = new Ship(ShipType.Gnat);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public int getPilotSkill() {
        return pilotSkill;
    }

    public void setPilotSkill(int pilotSkill) {
        this.pilotSkill = pilotSkill;
    }

    public int getFighterSkill() {
        return fighterSkill;
    }

    public void setFighterSkill(int fighterSkill) {
        this.fighterSkill = fighterSkill;
    }

    public int getTraderSkill() {
        return traderSkill;
    }

    public void setTraderSkill(int traderSkill) {
        this.traderSkill = traderSkill;
    }

    public int getEngineerSkill() {
        return engineerSkill;
    }

    public void setEngineerSkill(int engineerSkill) {
        this.engineerSkill = engineerSkill;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }
}
