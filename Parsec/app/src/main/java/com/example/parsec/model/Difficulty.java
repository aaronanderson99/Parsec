package com.example.parsec.model;

public enum Difficulty {
    Beginner(0),
    Easy(1),
    Normal(2),
    Hard(3),
    Impossible(4);

    private final int difficulty;

    public int getDifficulty() { return this.difficulty; }

    Difficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
