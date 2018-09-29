package team1.gatech.edu.irp.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team1.gatech.edu.irp.R;

import android.view.View;
import team1.gatech.edu.irp.model.Model;
import android.util.Log;
import android.content.Intent;


/**
 * THIS IS OUR TOP_LEVEL WINDOW THAT THE USER FIRST SEES IN THE APPLICATION!
 *
 * An activity representing login and register options.
 *
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

    }


    public void onLoginClicked(View v) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void onRegistrationClicked(View v) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

}




