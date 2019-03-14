package com.example.parsec.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parsec.R;
import com.example.parsec.model.Difficulty;
import com.example.parsec.model.Game;
import com.example.parsec.model.Market;
import com.example.parsec.model.Player;
import com.example.parsec.model.Resource;
import com.example.parsec.model.System;

import java.util.Arrays;

public class TEMP_MarketplaceActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner resourceSpinner;
    private TextView cost;
    private TextView credits;
    private TextView inCargo;
    private TextView cargo;
    private Button buy;
    private Button sell;
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
        buy = findViewById(R.id.buy_button);
        sell = findViewById(R.id.sell_button);
        quantity = findViewById(R.id.quantity);


        ArrayAdapter<Resource> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,
                Arrays.asList(Resource.values()));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        resourceSpinner.setAdapter(adapter);
        resourceSpinner.setSelection(0);
        resourceSpinner.setOnItemSelectedListener(this);

    }



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
    }
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
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        update();
    }
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void update() {
        double price = system.getMarket().getMarketPrice((Resource) resourceSpinner.getSelectedItem());
        double playerCredits = player.getCredits().getCredits();
        String playerCargo = player.getShip().getCargo().getCargoFilled() + " / " + player.getShip().getCargo().getMaxCargo();
        int inPlayerCargo = player.getShip().getCargo().getCargoStock((Resource) resourceSpinner.getSelectedItem());

        cost.setText("" + price);
        credits.setText("" + playerCredits);
        cargo.setText("" + playerCargo);
        inCargo.setText("" + inPlayerCargo);
    }


}