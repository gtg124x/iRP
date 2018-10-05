package team1.gatech.edu.irp.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Account;
import team1.gatech.edu.irp.model.AccountDataBase;
import team1.gatech.edu.irp.model.UserType;

import android.view.View;
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

        Account account = new Account("mitch", "1234", "@.", UserType.ADMIN);
        AccountDataBase.addToAccountDatabase(account);


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




