package com.example.parsec.model;

/**
 * The type Market.
 */
public class Market {
    private final double[] market;
    private final TechLevel techLevel;
    private final Characteristic characteristic;
    private RandomEvent event;

    /**
     * Instantiates a new Market.
     *
     * @param techLevel      the tech level
     * @param characteristic the characteristic
     */
    public Market(TechLevel techLevel, Characteristic characteristic) {
        this.market = new double[Resource.values().length];
        this.techLevel = techLevel;
        this.characteristic = characteristic;
        this.event = RandomEvent.Normal;
    }

    /**
     * Gets market price.
     *
     * @param resource the resource
     * @return the market price
     */
    public double getMarketPrice(Resource resource) {
        return market[resource.getCode()];
    }

    /**
     * Sets scare resource.
     *
     * @param resource the resource
     */
    private void setScareResource(Resource resource) {
        if(event != RandomEvent.Normal) {
            market[resource.getCode()] *= 5;
        }
    }

    /**
     * Can buy boolean.
     *
     * @param resource the resource
     * @return the boolean
     */
    public boolean canBuy(Resource resource) {
        return resource.getMTLP() <= techLevel.getLevelCode();
    }

    /**
     * Can sell boolean.
     *
     * @param resource the resource
     * @return the boolean
     */
    public boolean canSell(Resource resource) {
        return resource.getMTLU() <= techLevel.getLevelCode();
    }

    /**
     * Generate market.
     */
    public void generateMarket() {
        // generate market prices
        Resource resources[] = Resource.values();
        for(int i = 0; i < market.length; i++) {
            double cost = resources[i].getBasePrice();
            if(Math.random() - 0.5 > 0) {
                cost += cost*(Math.random()*resources[i].getVar()/100);
            } else {
                cost -= cost*(Math.random()*resources[i].getVar()/100);
            }
            if(characteristic.equals(resources[i].getCR())) {
                cost /= 2;
            }
            cost += techLevel.getLevelCode()*resources[i].getIPL();
            market[i] = cost;
        }
        setScareResource(event.getAffectedResource());
    }


    /**
     * Sets event.
     *
     * @param event the event
     */
    public void setEvent(RandomEvent event) {
        this.event = event;
    }

}
