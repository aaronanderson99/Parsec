package com.example.parsec.viewmodels;

import android.util.Log;

import com.example.parsec.model.Difficulty;
import com.example.parsec.model.Player;
import com.example.parsec.model.Game;
import com.example.parsec.model.Ship;
import com.example.parsec.model.ShipType;
import com.example.parsec.model.Universe;

/**
 * The type Configuration view model.
 */
public class ConfigurationViewModel {
    private Game game = Game.getInstance();

    /**
     * Create player.
     *
     * @param player the player
     */
    public void createPlayer(Player player) {
        game.setPlayer(player);
        game.setUniverse(Universe.generateDefaultUniverse());
        player.getShip().setCurrentSystem(game.getUniverse().getSystem(5));
        player.getShip().getCurrentSystem().getMarket().generateMarket();
        player.getShip().findSystemsInRange();
        Log.i("Player created successfully", "\n" + player.getName() +
                String.format(" %d", player.getPilotSkill()) +
                String.format(" %d", player.getFighterSkill()) +
                String.format(" %d", player.getTraderSkill()) +
                String.format(" %d", player.getEngineerSkill()) +
                String.format(" %f", player.getCredits().getCredits()) +
                " " + player.getShip().getName());

        Log.i("\nUniverse created successfully", "\n" + game.getUniverse().toString());
    }

    /**
     * Update game difficulty.
     *
     * @param difficulty the difficulty
     */
    public void updateGameDifficulty(Difficulty difficulty) {
        game.setDifficulty(difficulty);
    }

}
