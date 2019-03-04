package com.example.parsec.model;

public class Game {

    private Player player;
    private Ship ship;
    private Universe universe;
    private Difficulty difficulty;

    public Game() {
        this(new Player(), new Ship(), new Universe(), Difficulty.Easy);
    }

    public Game(Player player, Ship ship, Universe universe, Difficulty difficulty) {
        this.player = player;
        this.ship = ship;
        this.universe = universe;
        this.difficulty = difficulty;
    }

}
