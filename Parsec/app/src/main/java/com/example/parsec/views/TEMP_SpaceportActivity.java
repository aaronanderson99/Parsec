package com.example.parsec.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.parsec.R;
import com.example.parsec.model.Game;
import com.example.parsec.model.Player;
import com.example.parsec.model.System;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * The type Temp spaceport activity.
 */
public class TEMP_SpaceportActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner systemSpinner;
    private TextView distance;
    private TextView credits2;
    private TextView fuel;
    private TextView fuelCost;
    private Button refuel;
    private Button jump;
    private Game game;
    private Player player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_activity_spaceport);

        game = Game.getInstance();
        player = game.getPlayer();

        systemSpinner = findViewById(R.id.system_spinner);
        distance = findViewById(R.id.distance);
        credits2 = findViewById(R.id.credits2);
        fuel = findViewById(R.id.fuel);
        fuelCost = findViewById(R.id.fuel_cost);
        refuel = findViewById(R.id.refuel_button);
        jump = findViewById(R.id.jump_button);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, convertList());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        systemSpinner.setAdapter(adapter);
        systemSpinner.setSelection(0);
        systemSpinner.setOnItemSelectedListener(this);

        update();

    }


    /**
     * On refuel pressed.
     *
     * @param view the view
     */
    public void onRefuelPressed(View view) {
        player.refuel();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, convertList());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        systemSpinner.setAdapter(adapter);
        systemSpinner.setOnItemSelectedListener(this);

        update();
        game.saveJson(new File(this.getFilesDir(), "game.json"));
    }

    /**
     * On jump pressed.
     *
     * @param view the view
     */
    public void onJumpPressed(View view) {
        System newSystem = getSystem((String) systemSpinner.getSelectedItem());
        player.jump(newSystem);
        Intent randomEvent = new Intent(this, RandomEventActivity.class);
        startActivity(randomEvent);
        game.saveJson(new File(this.getFilesDir(), "game.json"));
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        update();
    }
    public void onNothingSelected(AdapterView<?> parent) {
    }

    /**
     * Update.
     */
    public void update() {
        System newSystem = getSystem((String) systemSpinner.getSelectedItem());

        double systemDistance = newSystem.getDistance();
        double playerCredits = player.getCredits().getCredits();
        String playerFuel = Math.floor(player.getShip().getFuel() * 100) / 100 + " / " + Math.floor(player.getShip().getMaxFuel() * 100) / 100;
        double playerFuelCost = 10 * player.getShip().getFuelSpace();


        distance.setText("" + Math.floor(systemDistance * 100) / 100);
        credits2.setText("" + Math.floor(playerCredits * 100) / 100);
        fuelCost.setText("" + Math.floor(playerFuelCost * 100) / 100);
        fuel.setText("" + playerFuel);
    }


    private List<String> convertList() {
        List<System> systems = player.getShip().getSystemsInRange();
        List<String> systemNames = new LinkedList<>();
        for(int i = 0; i < systems.size(); i++) {
            systemNames.add(systems.get(i).getName());
        }
        return systemNames;
    }


    private System getSystem(String name) {
        List<System> systems = player.getShip().getSystemsInRange();
        for(int i = 0; i < systems.size(); i++) {
            if(systems.get(i).getName().equals(name)) {
                return systems.get(i);
            }
        }
        return null;
    }


}
