package com.example.parsec.views;

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
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        if(Game.loadJson(new File(this.getFilesDir(), "game.json"))) {
            Toast.makeText(this.getApplicationContext(), "Game loaded successfully!",
                    Toast.LENGTH_LONG).show();


            Intent saveGame = new Intent(this, TEMP_SystemActivity.class);
            startActivity(saveGame);
        } else {
            Toast.makeText(this.getApplicationContext(), "No game save found!",
                    Toast.LENGTH_LONG).show();
        }
    }

}
