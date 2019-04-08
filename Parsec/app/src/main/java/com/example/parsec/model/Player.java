package com.example.parsec.model;

/**
 * The type Player.
 */
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

    /**
     * Instantiates a new Player.
     *
     * @param name          the name
     * @param ship          the ship
     * @param pilotSkill    the pilot skill
     * @param fighterSkill  the fighter skill
     * @param traderSkill   the trader skill
     * @param engineerSkill the engineer skill
     * @param credits       the credits
     */
    public Player(String name, Ship ship, int pilotSkill, int fighterSkill, int traderSkill, int engineerSkill, double credits) {
        this.name = name;
        this.ship = ship;
        this.pilotSkill = pilotSkill;
        this.fighterSkill = fighterSkill;
        this.traderSkill = traderSkill;
        this.engineerSkill = engineerSkill;
        this.credits = new Credits(credits);
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
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
     * Gets ship.
     *
     * @return the ship
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * Sets ship.
     *
     * @param ship the ship
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }

    /**
     * Gets pilot skill.
     *
     * @return the pilot skill
     */
    public int getPilotSkill() {
        return pilotSkill;
    }

    /**
     * Sets pilot skill.
     *
     * @param pilotSkill the pilot skill
     */
    public void setPilotSkill(int pilotSkill) {
        this.pilotSkill = pilotSkill;
    }

    /**
     * Gets fighter skill.
     *
     * @return the fighter skill
     */
    public int getFighterSkill() {
        return fighterSkill;
    }

    /**
     * Sets fighter skill.
     *
     * @param fighterSkill the fighter skill
     */
    public void setFighterSkill(int fighterSkill) {
        this.fighterSkill = fighterSkill;
    }

    /**
     * Gets trader skill.
     *
     * @return the trader skill
     */
    public int getTraderSkill() {
        return traderSkill;
    }

    /**
     * Sets trader skill.
     *
     * @param traderSkill the trader skill
     */
    public void setTraderSkill(int traderSkill) {
        this.traderSkill = traderSkill;
    }

    /**
     * Gets engineer skill.
     *
     * @return the engineer skill
     */
    public int getEngineerSkill() {
        return engineerSkill;
    }

    /**
     * Sets engineer skill.
     *
     * @param engineerSkill the engineer skill
     */
    public void setEngineerSkill(int engineerSkill) {
        this.engineerSkill = engineerSkill;
    }

    /**
     * Gets credits.
     *
     * @return the credits
     */
    public Credits getCredits() {
        return this.credits;
    }

    /**
     * Jump.
     *
     * @param system the system
     */
    public void jump(System system) {
        ship.jump(system);
    }

    /**
     * Buy boolean.
     *
     * @param resource the resource
     * @param num      the num
     * @return the boolean
     */
// returns true if successful, false if unsuccessful
    public boolean buy(Resource resource, int num) {
        Market market = ship.getCurrentSystem().getMarket();
        if(!market.canBuy(resource)) {
            return false;       // TECH LEVEL TOO LOW !!!
        } else if(market.getMarketPrice(resource)*num > credits.getCredits()) {
            return false;       // TOO EXPENSIVE !!!
        } else if (num > ship.getCargo().getRemainingCargo()) {
            return false;       // NOT ENOUGH SPACE !!!
        } else {
            credits.buy(market.getMarketPrice(resource)*num);
            ship.buy(resource, num);
            return true;
        }
    }

    /**
     * Sell boolean.
     *
     * @param resource the resource
     * @param num      the num
     * @return the boolean
     */
// returns true if successful, false if unsuccessful
    public boolean sell(Resource resource, int num) {
        Market market = ship.getCurrentSystem().getMarket();
        if(!market.canSell(resource)) {
            return false;       // TECH LEVEL TOO LOW !!!
        } else if (num > ship.getCargo().getCargoStock(resource)) {
            return false;       // DON'T HAVE RESOURCES !!!
        } else {
            credits.sell(market.getMarketPrice(resource)*num);
            ship.sell(resource, num);
            return true;
        }
    }

    /**
     * Refuel boolean.
     *
     * @return the boolean
     */
// returns true if successful, false if unsuccessful
    public boolean refuel() {
        if(credits.getCredits() < ship.getFuelSpace() * 10) {
            return false;
        }
        credits.buy(ship.getFuelSpace() * 10);
        ship.refuel();
        return true;
    }

}
