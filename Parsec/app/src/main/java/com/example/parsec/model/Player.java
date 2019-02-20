package com.example.parsec.model;

public class Player {
    private String name;

    private int pilotSkill;
    private int fighterSkill;
    private int traderSkill;
    private int engineerSkill;

    public Player() {
        this("Bob", 4, 4, 4, 4);
    }
    public Player(String name, int pilotSkill, int fighterSkill, int traderSkill, int engineerSkill) {
        this.name = name;
        this.pilotSkill = pilotSkill;
        this.fighterSkill = fighterSkill;
        this.traderSkill = traderSkill;
        this.engineerSkill = engineerSkill;
    }

    public String getName() { return this.name; }
    public int getPilotSkill() { return this.pilotSkill; }
    public int getFighterSkill() { return this.fighterSkill; }
    public int getTraderSkill() { return this.traderSkill; }
    public int getEngineerSkill() { return this.engineerSkill; }
}
