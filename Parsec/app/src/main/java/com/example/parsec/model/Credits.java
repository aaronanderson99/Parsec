package com.example.parsec.model;

/**
 * The type Credits.
 */
public class Credits {
    private double credits;

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
     * Buy.
     *
     * @param cost the cost
     */
    public void buy(double cost) {
        if(cost < credits) {
            credits -= cost;
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
