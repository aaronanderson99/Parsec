package com.example.parsec.model;


/**
 * The type Player.
 */
public class Player {
    private final String name;
    private final Ship ship;

    private final int pilotSkill;
    private final int fighterSkill;
    private final int traderSkill;
    private final int engineerSkill;

    private final Credits credits;


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
    public Player(String name, Ship ship, int pilotSkill, int fighterSkill, int traderSkill,
                  int engineerSkill, double credits) {
        this.name = name;
        this.ship = ship;
        this.pilotSkill = pilotSkill;
        this.fighterSkill = fighterSkill;
        this.traderSkill = traderSkill;
        this.engineerSkill = engineerSkill;
        this.credits = new Credits(credits);
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
     * Refuel.
     */
// returns true if successful, false if unsuccessful
    public void refuel() {
        if(credits.getCredits() < ship.getFuelSpace() * 10) {
            return;
        }
        credits.buy(ship.getFuelSpace() * 10);
        ship.refuel();
    }

    public String toString() {
        return  name  +
                "\nPilot Skill:      " + pilotSkill +
                "\nFighter Skill:    " + fighterSkill +
                "\nTrader Skill:     " + traderSkill +
                "\nEngineer Skill:   " + engineerSkill +
                "\nShip:             " + ship.getName();
    }

    /**
     * sets the current system with a provided System object
     * @param system Inputted System object to be set
     */
    public void setCurrentSystem(System system) {
        ship.setCurrentSystem(system);
    }

    /**
     * invokes the generateMarket() method from the Ship object
     */
    public void generateMarket() {
        ship.generateMarket();
    }

    /**
     * invokes the findSystemsInRange() method from the Ship object
     */
    public void findSystemsInRange() {
        ship.findSystemsInRange();
    }

}
