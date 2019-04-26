package com.example.parsec.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.parsec.R;
import com.example.parsec.model.Game;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {

    public static final String HEROKU_URL = "https://parsec-backend.herokuapp.com";
    public static String username = "";
    public static String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Perform login request, and launch game
     * @param view the view
     */
    public void onLogin(View view) {
        //perform login here
        //post request to URL/api/login
        //initialize session with node stuff
        //after launching main menu, option to load will allow user
        //to load the game corresponding to their username
        final TextView usernameInput = (TextView) findViewById(R.id.usernameEdit);
        final TextView passwordInput = (TextView) findViewById(R.id.passwordEdit);

        final Context context = this.getApplicationContext();

        //imagine writing code like this
        final MainActivity thisHolder = this;

        //build login json object
        final JSONObject jsonLogin = new JSONObject();
        try {
            jsonLogin.put("username", usernameInput.getText());
            jsonLogin.put("password", passwordInput.getText());

            //i dont think i need this but im scared to leave it out
            jsonLogin.put("game", "null");
        } catch (JSONException e) {
            //more high quality error logging (:
            System.out.println(e);
        }

        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                HEROKU_URL + "/api/login", jsonLogin, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(context, "User logged in successfully",
                        Toast.LENGTH_LONG).show();

                try {
                    MainActivity.username =jsonLogin.getString("username");
                    MainActivity.password = jsonLogin.getString("password");
                } catch (JSONException e) {
                    //this will literally never happen
                }

                Intent mainMenu = new Intent(thisHolder, GameStartActivity.class);
                startActivity(mainMenu);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Incorrect username or password",
                        Toast.LENGTH_LONG).show();
            }
        });

        queue.add(jsonObjectRequest);
    }

    /**
     * Create new user
     * @param view the view
     */
    public void onCreateUser(View view) {
        //make post request to URL/api/createUser
        final TextView usernameInput = (TextView) findViewById(R.id.usernameEdit);
        final TextView passwordInput = (TextView) findViewById(R.id.passwordEdit);

        //this should work out ok (:
        final Context context = this.getApplicationContext();

        //build login json object
        JSONObject jsonLogin = new JSONObject();
        try {
            jsonLogin.put("username", usernameInput.getText());
            jsonLogin.put("password", passwordInput.getText());
            jsonLogin.put("game", "null");
        } catch (JSONException e) {
            //more high quality error logging (:
            System.out.println(e);
        }

        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                HEROKU_URL + "/api/createUser", jsonLogin, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response);
                try {
                    if (response.getInt("code") == 200) {
                        Toast.makeText(context, "User successfully created",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(context, "Error creating User, likely duplicate username",
                                Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    Toast.makeText(context, "JSON parsing error, check backend",
                            Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error creating User",
                        Toast.LENGTH_LONG).show();
            }
        });

        queue.add(jsonObjectRequest);
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
