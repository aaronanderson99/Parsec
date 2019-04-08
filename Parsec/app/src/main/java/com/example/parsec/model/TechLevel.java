package com.example.parsec.model;

/**
 * The enum Tech level.
 */
public enum TechLevel {
    /**
     * Pre agriculture tech level.
     */
    PRE_AGRICULTURE (0),
    /**
     * Agriculture tech level.
     */
    AGRICULTURE(1),
    /**
     * Medieval tech level.
     */
    MEDIEVAL(2),
    /**
     * Renaissance tech level.
     */
    RENAISSANCE(3),
    /**
     * Early industrial tech level.
     */
    EARLY_INDUSTRIAL(4),
    /**
     * Industrial tech level.
     */
    INDUSTRIAL(5),
    /**
     * Post industrial tech level.
     */
    POST_INDUSTRIAL(6),
    /**
     * Hi tech tech level.
     */
    HI_TECH(7);

    private final int levelCode;

    TechLevel(int levelCode) {
        this.levelCode = levelCode;
    }

    /**
     * Gets level code.
     *
     * @return the level code
     */
    public int getLevelCode() {
        return this.levelCode;
    }
}
