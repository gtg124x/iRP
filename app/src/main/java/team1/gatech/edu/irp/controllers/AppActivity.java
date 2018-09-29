package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import team1.gatech.edu.irp.R;

import android.util.Log;
import android.widget.Button;
import android.content.Intent;
import android.view.View;


public class AppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

    }


    public void onLogoutClicked(View v) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }


}
