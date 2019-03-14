package com.example.parsec.model;

public enum Characteristic {
    NOSPECIALRESOURCES(0),
    MINERALRICH(1),
    DESERT(2),
    LOTSOFWATER(3),
    RICHSOIL(4),
    POORSOIL(5),
    RICHFAUNA(6),
    LIFELESS(7),
    WEIRDMUSHROOMS(8),
    LOTSOFHERBS(9),
    ARTISTIC(10),
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

    public int getCharacteristicCode() {
        return this.characteristicCode;
    }
}