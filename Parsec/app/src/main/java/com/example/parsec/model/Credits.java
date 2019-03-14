package com.example.parsec.model;

public class Credits {
    private double credits;

    public Credits() {
        this(1000);
    }
    public Credits(double credits) {
        this.credits = credits;
    }

    public double getCredits() {
        return this.credits;
    }

    public boolean buy(double cost) {
        if(cost < credits) {
            credits -= cost;
            return true;
        }
        else {
            return false;
        }

    }
    public void sell(double cost) {
        credits += cost;
    }
}
