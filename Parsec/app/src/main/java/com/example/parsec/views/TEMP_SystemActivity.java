package com.example.parsec.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parsec.R;
import com.example.parsec.model.Game;
import com.example.parsec.model.System;

/**
 * The type Temp system activity.
 */
public class TEMP_SystemActivity extends AppCompatActivity {

    private TextView systemName;
    private TextView techLevel;
    private TextView characteristic;

    private Button spaceStation;
    private Button marketPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_activity_system);

        Game game = Game.getInstance();
        System system = game.getPlayer().getShip().getCurrentSystem();


        systemName = findViewById(R.id.system_name);
        techLevel = findViewById(R.id.tech_level);
        characteristic = findViewById(R.id.characteristic);

        systemName.setText(system.getName());
        techLevel.setText(system.getTechLevel().toString());
        characteristic.setText(system.getCharacteristic().toString());

        spaceStation = findViewById(R.id.space_station_button);
        marketPlace = findViewById(R.id.marketplace_button);

    }

    /**
     * On space station pressed.
     *
     * @param view the view
     */
    public void onSpaceStationPressed(View view) {
        Intent spaceStation = new Intent(this, TEMP_SpaceportActivity.class);
        startActivity(spaceStation);
    }

    /**
     * On market place pressed.
     *
     * @param view the view
     */
    public void onMarketPlacePressed(View view) {
        Intent marketPlace = new Intent(this, TEMP_MarketplaceActivity.class);
        startActivity(marketPlace);
    }

}
