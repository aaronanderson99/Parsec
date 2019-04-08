package com.example.parsec.model;

/**
 * The type Credits.
 */
public class Credits {
    private double credits;

    /**
     * Instantiates a new Credits.
     */
    public Credits() {
        this(1000);
    }

    /**
     * Instantiates a new Credits.
     *
     * @param credits the credits
     */
    public Credits(double credits) {
        this.credits = credits;
    }

    /**
     * Gets credits.
     *
     * @return the credits
     */
    public double getCredits() {
        return this.credits;
    }

    /**
     * Buy boolean.
     *
     * @param cost the cost
     * @return the boolean
     */
    public boolean buy(double cost) {
        if(cost < credits) {
            credits -= cost;
            return true;
        }
        else {
            return false;
        }

    }

    /**
     * Sell.
     *
     * @param cost the cost
     */
    public void sell(double cost) {
        credits += cost;
    }
}
