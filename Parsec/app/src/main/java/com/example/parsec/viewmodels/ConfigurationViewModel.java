package com.example.parsec.viewmodels;

import android.util.Log;

import com.example.parsec.model.Difficulty;
import com.example.parsec.model.Player;
import com.example.parsec.model.Game;

public class ConfigurationViewModel {
    private Game game = Game.getInstance();

    public void createPlayer(Player player) {
        game.setPlayer(player);
        Log.i("Player created successfully", player.getName() +
                String.format(" %d", player.getPilotSkill()) +
                String.format(" %d", player.getFighterSkill()) +
                String.format(" %d", player.getTraderSkill()) +
                String.format(" %d", player.getEngineerSkill()) +
                String.format(" %f", player.getCredits()) +
                " " + player.getShip().getName());
    }

    public void updateGameDifficulty(Difficulty difficulty) { game.setDifficulty(difficulty);}
}
