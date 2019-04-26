package com.example.parsec.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parsec.R;
import com.example.parsec.model.Game;
import com.example.parsec.model.Player;
import com.example.parsec.model.Resource;
import com.example.parsec.model.System;

import java.io.File;
import java.util.Arrays;

/**
 * The type Temp marketplace activity.
 */
public class TEMP_MarketplaceActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {

    private Spinner resourceSpinner;
    private TextView cost;
    private TextView credits;
    private TextView inCargo;
    private TextView cargo;
    private EditText quantity;
    private Game game;
    private Player player;
    private System system;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_activity_marketplace);

        game = Game.getInstance();
        player = game.getPlayer();
        system = player.getShip().getCurrentSystem();

        resourceSpinner = findViewById(R.id.resource_spinner);
        cost = findViewById(R.id.cost);
        credits = findViewById(R.id.credits);
        inCargo = findViewById(R.id.in_cargo);
        cargo = findViewById(R.id.cargo);
        quantity = findViewById(R.id.quantity);
        quantity.setText("1");


        ArrayAdapter<Resource> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                Arrays.asList(Resource.values()));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        resourceSpinner.setAdapter(adapter);
        resourceSpinner.setSelection(0);
        resourceSpinner.setOnItemSelectedListener(this);

    }


    /**
     * On buy pressed.
     *
     * @param view the view
     */
    public void onBuyPressed(View view) {
        Resource resource = (Resource) resourceSpinner.getSelectedItem();
        int num = Integer.parseInt(quantity.getText().toString());
        if(game.getPlayer().buy(resource, num)) {
            Toast.makeText(this.getApplicationContext(), "Transaction Successful!",
                    Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this.getApplicationContext(), "Transaction Failed!",
                    Toast.LENGTH_LONG).show();
        }
        update();
        game.saveJson(this.getApplicationContext());
    }

    /**
     * On sell pressed.
     *
     * @param view the view
     */
    public void onSellPressed(View view) {
        Resource resource = (Resource) resourceSpinner.getSelectedItem();
        int num = Integer.parseInt(quantity.getText().toString());
        if(game.getPlayer().sell(resource, num)) {
            Toast.makeText(this.getApplicationContext(), "Transaction Successful!",
                    Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this.getApplicationContext(), "Transaction Failed!",
                    Toast.LENGTH_LONG).show();
        }
        update();
        game.saveJson(this.getApplicationContext());
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        update();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    /**
     * Update.
     */
    private void update() {
        double price = system.getMarket().getMarketPrice((Resource)
                resourceSpinner.getSelectedItem());
        double playerCredits = player.getCredits().getCredits();
        String playerCargo = player.getShip().getCargo().getCargoFilled() + " / " +
                player.getShip().getCargo().getMaxCargo();
        int inPlayerCargo = player.getShip().getCargo().getCargoStock((Resource)
                resourceSpinner.getSelectedItem());

        String costText = "" + (Math.floor(price * 100) / 100);
        String creditsText = "" + (Math.floor(playerCredits * 100) / 100);
        String cargoText = "" + playerCargo;
        String inCargoText = "" + inPlayerCargo;

        cost.setText(costText);
        credits.setText(creditsText);
        cargo.setText(cargoText);
        inCargo.setText(inCargoText);
    }


}
