package com.example.parsec.model;

public enum Characteristics {
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

    private final int characteristicCode;

    Characteristics(int levelCode) {
        this.characteristicCode = levelCode;
    }

    public int getCharacteristicCode() {
        return this.characteristicCode;
    }
}
