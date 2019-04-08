package com.example.parsec.model;

/**
 * The enum Difficulty.
 */
public enum Difficulty {
    /**
     * Beginner difficulty.
     */
    Beginner(0),
    /**
     * Easy difficulty.
     */
    Easy(1),
    /**
     * Normal difficulty.
     */
    Normal(2),
    /**
     * Hard difficulty.
     */
    Hard(3),
    /**
     * Impossible difficulty.
     */
    Impossible(4);

    private final int difficulty;

    /**
     * Gets difficulty.
     *
     * @return the difficulty
     */
    public int getDifficulty() { return this.difficulty; }

    Difficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
