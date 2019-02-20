package com.example.parsec.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.parsec.R;
import com.example.parsec.model.Difficulty;

import java.util.Arrays;

public class ConfigurationActivity extends AppCompatActivity {

    private EditText playerNameInput;
    private Spinner difficultySpinner;

    private EditText pilotSkillPointsInput;
    private EditText fighterSkillPointsInput;
    private EditText traderSkillPointsInput;
    private EditText EngineerSkillPointsInput;

    private Button continueButton;
    private Button cancelButton;

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
        EngineerSkillPointsInput = findViewById(R.id.engineer_skill_points_input);

        ArrayAdapter<Difficulty> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,
                Arrays.asList(Difficulty.values()));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(adapter);

    }


    public void onContinuePressed() {

    }
    public void onCancelPressed() {

    }
}
