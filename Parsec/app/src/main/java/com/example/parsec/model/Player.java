package com.example.parsec.model;

public class Player {
    private String name;
    private Ship ship;

    private int pilotSkill;
    private int fighterSkill;
    private int traderSkill;
    private int engineerSkill;

    private Credits credits;


    /**
     * Default constructor, creates new Player named Bob,
     * with 16 skill points divided evenly across attributes
     */
    public Player() {
        this("Bob", new Ship(ShipType.Gnat), 4, 4, 4, 4, 1000);
    }

    public Player(String name, Ship ship, int pilotSkill, int fighterSkill, int traderSkill, int engineerSkill, double credits) {
        this.name = name;
        this.ship = ship;
        this.pilotSkill = pilotSkill;
        this.fighterSkill = fighterSkill;
        this.traderSkill = traderSkill;
        this.engineerSkill = engineerSkill;
        this.credits = new Credits(credits);
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

    public Credits getCredits() {
        return this.credits;
    }


    // returns true if successful, false if unsuccessful
    public boolean buy(Resource resource, double cost, int num, Market market) {
        if(cost*num > credits.getCredits()) {
            // TOO EXPENSIVE !!!
            return false;
        } else if (num > ship.getCargo().getRemainingCargo()) {
            // NOT ENOUGH SPACE !!!
            return false;
        } else if(!market.canBuy(resource)) {
            // TECH LEVEL TOO LOW !!!
            return false;
        }
        else {
            credits.buy(cost*num);
            ship.buy(resource, num);
            return true;
        }
    }

    // returns 0 if successful, 1 if unsuccessful
    public int sell(Resource resource, double cost, int num) {
        return 0;
    }

}
