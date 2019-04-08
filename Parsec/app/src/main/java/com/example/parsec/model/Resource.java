package com.example.parsec.model;

/**
 * The enum Resource.
 */
public enum Resource {

    /**
     * Water resource.
     */
    Water("Water", 0, 30, 0, 0, 3, 4, Characteristic.LOTSOFWATER),
    /**
     * Furs resource.
     */
    Furs("Furs", 1, 250, 0, 0, 10, 10, Characteristic.RICHFAUNA),
    /**
     * Food resource.
     */
    Food("Food", 2, 100, 1, 0, 5, 5, Characteristic.RICHSOIL),
    /**
     * Ore resource.
     */
    Ore("Ore", 3, 350, 2, 2, 20, 10, Characteristic.MINERALRICH),
    /**
     * Games resource.
     */
    Games("Games", 4, 250, 3, 1, -10, 5, Characteristic.ARTISTIC),
    /**
     * Firearms resource.
     */
    Firearms("Firearms", 5, 1250, 3, 1, -75, 100, Characteristic.WARLIKE),
    /**
     * Medicine resource.
     */
    Medicine("Medicine", 6, 650, 4, 1, -20, 10, Characteristic.LOTSOFHERBS),
    /**
     * Machines resource.
     */
    Machines("Machines", 7, 900, 4, 3, -30, 5, null),
    /**
     * Narcotics resource.
     */
    Narcotics("Narcotics", 8, 3500, 5, 0, -125, 150, Characteristic.LOTSOFWATER),
    /**
     * Robots resource.
     */
    Robots("Robots", 9, 5000, 6, 4, -150, 100, null);

    private final String name;
    private final int code;
    private final double basePrice;
    private final int MTLP;
    private final int MTLU;
    private final int IPL;
    private final double var;
    private final Characteristic CR;



    Resource(String name, int code, double basePrice, int MTLP, int MTLU, int IPL, double var, Characteristic CR) {
        this.name = name;
        this.code = code;
        this.basePrice = basePrice;
        this.MTLP = MTLP;
        this.MTLU = MTLU;
        this.IPL = IPL;
        this.var = var;
        this.CR = CR;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets base price.
     *
     * @return the base price
     */
    public double getBasePrice() {
        return this.basePrice;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * Gets mtlp.
     *
     * @return the mtlp
     */
    public int getMTLP() {
        return this.MTLP;
    }

    /**
     * Gets mtlu.
     *
     * @return the mtlu
     */
    public int getMTLU() {
        return this.MTLU;
    }

    /**
     * Gets ipl.
     *
     * @return the ipl
     */
    public int getIPL() {
        return this.IPL;
    }

    /**
     * Gets var.
     *
     * @return the var
     */
    public double getVar() {
        return this.var;
    }

    /**
     * Gets cr.
     *
     * @return the cr
     */
    public Characteristic getCR() {
        return this.CR;
    }
}
