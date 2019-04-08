package com.example.parsec.model;

public enum RandomEvent {

    Normal(-1, null, "Reports suggest that activity in this system is normal."),
    Drought(0, Resource.Water, "Reports suggest a severe drought in this system. The price of water has increased greatly!"),
    Famine(1, Resource.Food, "Reports suggest a severe famine in this system. The price of food has increased greatly!");


    private final int eventCode;
    private final Resource affectedResource;
    private final String description;


    RandomEvent(int eventCode, Resource affectedResource, String description) {
        this.eventCode = eventCode;
        this.affectedResource = affectedResource;
        this.description = description;
    }



    public int getEventCode() {
        return this.eventCode;
    }
    public Resource getAffectedResource() {
        return this.affectedResource;
    }
    public String getDescription() {
        return this.description;
    }


    public static void generateRandomEvent(System system) {
        RandomEvent[] events = RandomEvent.values();
        // There is a 33% chance that code is greater than the highest event code,
        // therefore, there is a 33% chance of the "Normal" event, and each of the others are equally likely.
        int code = (int) (Math.random() * events.length * 1.5);
        RandomEvent event = Normal;
        for(int i = 0; i < events.length; i++) {
            if (events[i].getEventCode() == code)
                event =  events[i];
        }
        system.setEvent(event);
    }

}
