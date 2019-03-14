package com.example.parsec.views;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.parsec.R;
import com.example.parsec.model.Difficulty;
import com.example.parsec.model.Ship;
import com.example.parsec.model.ShipType;
import com.example.parsec.viewmodels.ConfigurationViewModel;
import com.example.parsec.model.Player;

import java.util.Arrays;

public class ConfigurationActivity extends AppCompatActivity {

    private ConfigurationViewModel configViewModel;

    private EditText playerNameInput;
    private Spinner difficultySpinner;

    private EditText pilotSkillPointsInput;
    private EditText fighterSkillPointsInput;
    private EditText traderSkillPointsInput;
    private EditText engineerSkillPointsInput;

    private Button continueButton;
    private Button cancelButton;
    private Button quitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        setTitle("New Game");


        playerNameInput = findViewById(R.id.player_name_input);
        difficultySpinner = findViewById(R.id.difficulty_spinner);

        pilotSkillPointsInput = findViewById(R.id.pilot_skill_points_input);
        fighterSkillPointsInput = findViewById(R.id.fighter_skill_points_input);
        traderSkillPointsInput = findViewById(R.id.trader_skill_points_input);
        engineerSkillPointsInput = findViewById(R.id.engineer_skill_points_input);

        ArrayAdapter<Difficulty> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,
                Arrays.asList(Difficulty.values()));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(adapter);
        difficultySpinner.setSelection(0);

        configViewModel = new ConfigurationViewModel();
    }


    public void onContinuePressed(View view) {
        int pilotPoints = Integer.parseInt(pilotSkillPointsInput.getText().toString());
        int fighterPoints = Integer.parseInt(fighterSkillPointsInput.getText().toString());
        int traderPoints = Integer.parseInt(traderSkillPointsInput.getText().toString());
        int engineerPoints = Integer.parseInt(engineerSkillPointsInput.getText().toString());
        if (pilotPoints + fighterPoints + traderPoints + engineerPoints != 16) {
            Toast.makeText(this.getApplicationContext(), "Skill points must sum to 16",
                    Toast.LENGTH_LONG).show();
        } else {
            String playerName = playerNameInput.getText().toString();

            configViewModel.createPlayer(new Player(playerName, new Ship(ShipType.Gnat), pilotPoints, fighterPoints,
                    traderPoints, engineerPoints, 1000));
            configViewModel.updateGameDifficulty((Difficulty) difficultySpinner.getSelectedItem());
            Toast.makeText(this.getApplicationContext(), "New game created",
                    Toast.LENGTH_LONG).show();

            Intent cont = new Intent(this, SystemActivity.class);
            startActivity(cont);
        }
    }

    public void onCancelPressed(View view) {
        Toast.makeText(this.getApplicationContext(), "Game creation canceled",
                Toast.LENGTH_LONG).show();
        finish();
    }
    public void onQuitPressed(View view) {
        finish();
    }
}
