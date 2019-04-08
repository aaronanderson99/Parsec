package com.example.parsec.model;

/**
 * The enum Characteristic.
 */
public enum Characteristic {
    /**
     * Nospecialresources characteristic.
     */
    NOSPECIALRESOURCES(0),
    /**
     * Mineralrich characteristic.
     */
    MINERALRICH(1),
    /**
     * Desert characteristic.
     */
    DESERT(2),
    /**
     * Lotsofwater characteristic.
     */
    LOTSOFWATER(3),
    /**
     * Richsoil characteristic.
     */
    RICHSOIL(4),
    /**
     * Poorsoil characteristic.
     */
    POORSOIL(5),
    /**
     * Richfauna characteristic.
     */
    RICHFAUNA(6),
    /**
     * Lifeless characteristic.
     */
    LIFELESS(7),
    /**
     * Weirdmushrooms characteristic.
     */
    WEIRDMUSHROOMS(8),
    /**
     * Lotsofherbs characteristic.
     */
    LOTSOFHERBS(9),
    /**
     * Artistic characteristic.
     */
    ARTISTIC(10),
    /**
     * Warlike characteristic.
     */
    WARLIKE(11);


    /*
    [water]         Drought
    [furs]          Cold
    [food]          Famine
    [ore]
    [games]         Boredom
    [firearms]      War
    [medicine]      Plague
    [machines]
    [narcotics]
    [robots]
     */

    /*
    [water]         LOTSOFWATER
    [furs]          RICHFUANA
    [food]          RICHSOIL
    [ore]
    [games]         ARTISTIC
    [firearms]      WARLIKE
    [medicine]
    [machines]      LIFELESS
    [narcotics]     WEIRDMUSHROOMS
    [robots]
     */

    private final int characteristicCode;

    Characteristic(int characteristicCode) {
        this.characteristicCode = characteristicCode;
    }

    /**
     * Gets characteristic code.
     *
     * @return the characteristic code
     */
    public int getCharacteristicCode() {
        return this.characteristicCode;
    }
}