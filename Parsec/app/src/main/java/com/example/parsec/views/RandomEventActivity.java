package com.example.parsec.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.parsec.R;
import com.example.parsec.model.Game;

/**
 * The type Random event activity.
 */
public class RandomEventActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_event);
        setTitle("Random Event");
        TextView eventDescription = findViewById(R.id.random_event_description);
        eventDescription.setText(Game.getInstance().getPlayer().getShip()
                .getCurrentSystem().getEvent().getDescription());
    }

    /**
     * On continue pressed.
     *
     * @param view the view
     */
    public void onContinuePressed(View view) {
        Intent cont = new Intent(this, TEMP_SystemActivity.class);
        startActivity(cont);
    }
}
