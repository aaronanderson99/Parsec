package com.example.parsec.model;

/**
 * Singleton class that holds game state
 */
public class Game {

    private Player player;
    private Ship ship;
    private Universe universe;
    private Difficulty difficulty;

    private static Game game = new Game();

    /**
     * Default constructor
     */
    private Game() {
        this(new Player(), new Ship(), new Universe(), Difficulty.Easy);
    }

    public Game(Player player, Ship ship, Universe universe, Difficulty difficulty) {
        this.player = player;
        this.ship = ship;
        this.universe = universe.generateDefaultUniverse();
        this.difficulty = difficulty;
    }

    public static Game getInstance() {
        return game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Universe getUniverse() {
        return universe;
    }

    public void setUniverse(Universe universe) {
        this.universe = universe;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
