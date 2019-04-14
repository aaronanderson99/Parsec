package com.example.parsec.model;

/**
 * The enum Random event.
 */
public enum RandomEvent {

    /**
     * The Normal.
     */
    Normal(-1, null, "Reports suggest that activity in this system is normal."),
    /**
     * The Drought.
     */
    Drought(0, Resource.Water, "Reports suggest a severe drought in this system." +
            "The price of water has increased greatly!"),
    /**
     * The Famine.
     */
    Famine(1, Resource.Food, "Reports suggest a severe famine in this system. The price of food" +
            "has increased greatly!");


    private final int eventCode;
    private final Resource affectedResource;
    private final String description;


    RandomEvent(int eventCode, Resource affectedResource, String description) {
        this.eventCode = eventCode;
        this.affectedResource = affectedResource;
        this.description = description;
    }


    /**
     * Gets event code.
     *
     * @return the event code
     */
    private int getEventCode() {
        return this.eventCode;
    }

    /**
     * Gets affected resource.
     *
     * @return the affected resource
     */
    public Resource getAffectedResource() {
        return this.affectedResource;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }


    /**
     * Generate random event.
     *
     * @param system the system
     */
    public static void generateRandomEvent(System system) {
        RandomEvent[] events = RandomEvent.values();
        // There is a 33% chance that code is greater than the highest event code,
        // therefore, there is a 33% chance of the "Normal" event,
        // and each of the others are equally likely.
        int code = (int) (Math.random() * events.length * 1.5);
        RandomEvent event = Normal;
        for (RandomEvent event1 : events) {
            if (event1.getEventCode() == code)
                event = event1;
        }
        system.setEvent(event);
    }

}
