package com.example.parsec.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.parsec.R;
import com.example.parsec.model.Game;

import java.io.File;

/**
 * The type Main activity.
 */
public class GameStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);
    }

    /**
     * On new game pressed.
     *
     * @param view the view
     */
    public void onNewGamePressed(View view) {
        Intent newGame = new Intent(this, ConfigurationActivity.class);
        startActivity(newGame);
    }

    /**
     * On load game pressed.
     *
     * @param view the view
     */
    public void onLoadGamePressed(View view) {
        final Context context = this.getApplicationContext();
        final GameStartActivity thisHolder = this;

        Game.loadJson(new Game.StateChangeCallable() {
            @Override
            public void callback(boolean success) {
                if (success) {
                    Toast.makeText(context, "Game loaded successfully!",
                            Toast.LENGTH_LONG).show();

                    Intent saveGame = new Intent(thisHolder, TEMP_SystemActivity.class);
                    startActivity(saveGame);
                } else {
                    Toast.makeText(context, "Failed to load game save",
                            Toast.LENGTH_LONG).show();
                }
            }
        }, context);
    }

    /**
     * On quit game pressed.
     *
     * @param view the view
     */
    public void onQuitPressed(View view) {
        finish();
    }
}
