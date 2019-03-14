package com.example.parsec.model;

public enum Resource {

    Water("Water", 0, 30, 0, 0, 3, 4, Characteristic.LOTSOFWATER),
    Furs("Furs", 1, 250, 0, 0, 10, 10, Characteristic.RICHFAUNA),
    Food("Food", 2, 100, 1, 0, 5, 5, Characteristic.RICHSOIL),
    Ore("Ore", 3, 350, 2, 2, 20, 10, Characteristic.MINERALRICH),
    Games("Games", 4, 250, 3, 1, -10, 5, Characteristic.ARTISTIC),
    Firearms("Firearms", 5, 1250, 3, 1, -75, 100, Characteristic.WARLIKE),
    Medicine("Medicine", 6, 650, 4, 1, -20, 10, Characteristic.LOTSOFHERBS),
    Machines("Machines", 7, 900, 4, 3, -30, 5, null),
    Narcotics("Narcotics", 8, 3500, 5, 0, -125, 150, Characteristic.LOTSOFWATER),
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

    public String getName() {
        return this.name;
    }
    public double getBasePrice() {
        return this.basePrice;
    }
    public int getCode() {
        return this.code;
    }
    public int getMTLP() {
        return this.MTLP;
    }
    public int getMTLU() {
        return this.MTLU;
    }
    public int getIPL() {
        return this.IPL;
    }
    public double getVar() {
        return this.var;
    }
    public Characteristic getCR() {
        return this.CR;
    }
}
