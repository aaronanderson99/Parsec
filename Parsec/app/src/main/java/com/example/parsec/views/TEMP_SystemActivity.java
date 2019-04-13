package com.example.parsec.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.parsec.R;
import com.example.parsec.model.Game;
import com.example.parsec.model.System;

/**
 * The type Temp system activity.
 */
public class TEMP_SystemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_activity_system);

        Game game = Game.getInstance();
        System system = game.getPlayer().getShip().getCurrentSystem();


        TextView systemName = findViewById(R.id.system_name);
        TextView techLevel = findViewById(R.id.tech_level);
        TextView characteristic = findViewById(R.id.characteristic);

        systemName.setText(system.getName());
        techLevel.setText(system.getTechLevel().toString());
        characteristic.setText(system.getCharacteristic().toString());
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
