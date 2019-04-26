package com.example.parsec.model;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.parsec.views.GameStartActivity;
import com.example.parsec.views.MainActivity;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

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

    /**
     * Instantiates a player object
     */
    public void createPlayer() {
        player.setCurrentSystem(game.getStarterSystem());
        player.generateMarket();
        player.findSystemsInRange();
        game.setPlayer(player);
        game.setUniverse(Universe.generateDefaultUniverse());
    }

    /**
     * Returns a String representation of a Player object
     *
     * @return a string representation of Player
     */
    public String playerToString() {
        return player.toString();
    }

    /**
     * Returns a String representation of a Universe object
     *
     * @return a string representation of Universe
     */
    public String universeToString() {
        return universe.toString();
    }

    // These JSON methods are adapted from Bob Water's AndroidPersistenceDemo
    /**
     * Save json.
     *
     */
    public void saveJson(final Context context) {
        //create request body
        JSONObject requestBody = new JSONObject();
        try {
            Gson gson = new Gson();
            String outString = gson.toJson(game);
            Log.d("DEBUG", "JSON Saved: " + outString);
            requestBody.put("username", MainActivity.username);
            requestBody.put("password", MainActivity.password);
            requestBody.put("game", outString);
        } catch (JSONException e) {
            Log.e("UserManagementFacade", "Error parsing Json data");
        }

        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                MainActivity.HEROKU_URL + "/api/gameState", requestBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if (response.getInt("code") == 500) {
                        Toast.makeText(context, "Server error saving game, try again",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(context, "Game saved successfully",
                                Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    Toast.makeText(context, "Game saved",
                            Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Game saved",
                        Toast.LENGTH_LONG).show();
                java.lang.System.out.println(error);
            }
        });

        queue.add(jsonObjectRequest);
    }

    /**
     * Load json boolean.
     *
     * @return the boolean
     */
    public static void loadJson(final StateChangeCallable cb, Context context) {
        JSONObject jsonLogin = new JSONObject();
        try {
            jsonLogin.put("username", MainActivity.username);
            jsonLogin.put("password", MainActivity.password);
//            Log.d("DEBUG", "Username: " + jsonLogin.getString("username"));
//            Log.d("DEBUG", "Password " + jsonLogin.getString("password"));
        } catch (JSONException e) {
            //more high quality error logging (:
            java.lang.System.out.println(e);
            cb.callback(false);
        }

        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                MainActivity.HEROKU_URL + "/api/getGameState", jsonLogin, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Gson gson = new Gson();
                    game = gson.fromJson(response.getString("game"), Game.class);
                    cb.callback(true);
                } catch (JSONException e) {
                    Log.e("UserManagementFacade", "Failed to open/read the json");
                    cb.callback(false);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                java.lang.System.out.println(error);
                cb.callback(false);
            }
        });

        queue.add(jsonObjectRequest);
    }

    private System getStarterSystem() {
        return universe.getStarterSystem();
    }

    /**
     * Generates a default Game Object when no parameters are provided in the constructor
     *
     * @param player the default player object provided
     * @param difficulty the default difficulty for the game
     */

    public static void generateDefaultGame(Player player, Difficulty difficulty) {
        game = new Game(player, Universe.generateDefaultUniverse(), difficulty);
    }


    public interface StateChangeCallable {
        void callback(boolean success);
    }
}
