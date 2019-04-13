package com.example.parsec.model;

import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.Gson;

/**
 * Singleton class that holds game state
 */
public class Game {

    private Player player;
    private Universe universe;
    private Difficulty difficulty;

    private static Game game;

    /**
     * Instantiates a new Game.
     *
     * @param player     the player
     * @param universe   the universe
     * @param difficulty the difficulty
     */
    private Game(Player player, Universe universe, Difficulty difficulty) {
        this.player = player;
        this.universe = universe;
        this.difficulty = difficulty;
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Game getInstance() {
        return game;
    }

    /**
     * Gets player.
     *
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Sets player.
     *
     * @param player the player
     */
    private void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Gets universe.
     *
     * @return the universe
     */
    public Universe getUniverse() {
        return universe;
    }

    /**
     * Sets universe.
     *
     * @param universe the universe
     */
    private void setUniverse(Universe universe) {
        this.universe = universe;
    }

    /**
     * Sets difficulty.
     *
     * @param difficulty the difficulty
     */
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void createPlayer() {
        player.setCurrentSystem(game.getStarterSystem());
        player.generateMarket();
        player.findSystemsInRange();
        game.setPlayer(player);
        game.setUniverse(Universe.generateDefaultUniverse());
    }

    public String playerToString() {
        return player.toString();
    }

    public String universeToString() {
        return universe.toString();
    }

    // These JSON methods are adapted from Bob Water's AndroidPersistenceDemo
    /**
     * Save json.
     *
     * @param file the file
     */
    public void saveJson(File file) {
        try {
            PrintWriter writer = new PrintWriter(file);
            Gson gson = new Gson();
            String outString = gson.toJson(game);
            Log.d("DEBUG", "JSON Saved: " + outString);
            writer.println(outString);
            writer.close();
        } catch (FileNotFoundException e) {
            Log.e("UserManagementFacade", "Failed to open json file for output");
        }

    }

    /**
     * Load json boolean.
     *
     * @param file the file
     * @return the boolean
     */
    public static boolean loadJson(File file) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String inString = input.readLine();
            Log.d("DEBUG", "JSON: " + inString);
            Gson gson = new Gson();
            game = gson.fromJson(inString, Game.class);
            input.close();
        } catch (IOException e) {
            Log.e("UserManagementFacade", "Failed to open/read the buffered reader for json");
            return false;
        }
        return true;
    }

    private System getStarterSystem() {
        return universe.getStarterSystem();
    }

    public static void generateDefaultGame(Player player, Difficulty difficulty) {
        game = new Game(player, Universe.generateDefaultUniverse(), difficulty);
    }

}
