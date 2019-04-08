package com.example.parsec.model;

import android.util.Log;
import android.widget.Toast;

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

    private static Game game = new Game();

    /**
     * Default constructor
     */

    public Game() {
        this(new Player(), Universe.generateDefaultUniverse(), Difficulty.Easy);
    }

    public Game(Player player, Universe universe, Difficulty difficulty) {
        this.player = player;
        this.universe = universe;
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





    // These JSON methods are adapted from Bob Water's AndroidPersistenceDemo
    public boolean saveJson(File file) {
        try {
            PrintWriter writer = new PrintWriter(file);
            Gson gson = new Gson();
            String outString = gson.toJson(game);
            Log.d("DEBUG", "JSON Saved: " + outString);
            writer.println(outString);
            writer.close();
        } catch (FileNotFoundException e) {
            Log.e("UserManagementFacade", "Failed to open json file for output");
            return false;
        }

        return true;
    }

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

}
