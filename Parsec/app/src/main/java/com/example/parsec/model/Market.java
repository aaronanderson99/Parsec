package com.example.parsec.model;

public class Market {
    private double market[];
    private TechLevel techLevel;
    private Characteristic characteristic;
    private RandomEvent event;

    public Market(TechLevel techLevel, Characteristic characteristic) {
        this.market = new double[Resource.values().length];
        this.techLevel = techLevel;
        this.characteristic = characteristic;
        this.event = RandomEvent.Normal;
    }

    public double getMarketPrice(Resource resource) {
        return market[resource.getCode()];
    }
    public void setScareResource(Resource resource) {
        if(event != RandomEvent.Normal) {
            market[resource.getCode()] *= 5;
        }
    }

    public boolean canBuy(Resource resource) {
        if(resource.getMTLP() > techLevel.getLevelCode()) {
            return false;   // Tech Level too low!
        }
        else {
            return true;   // All good!
        }
    }
    public boolean canSell(Resource resource) {
        if(resource.getMTLU() > techLevel.getLevelCode()) {
            return false;   // Tech Level too low!
        }
        else {
            return true;   // All good!
        }
    }

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




    public void setTechLevel(TechLevel techLevel) {
        this.techLevel = techLevel;
    }
    public void setCharacteristic(Characteristic characteristic) {
        this.characteristic = characteristic;
    }
    public void setEvent(RandomEvent event) {
        this.event = event;
    }

}
