package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import team1.gatech.edu.irp.R;
import android.view.View;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }


    public void onLogoutClicked(View v) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    public void onViewLocationAdminOnPress(View v) {
        Intent intent = new Intent(this, LocationListActivity.class);
        startActivity(intent);
    }

    public void onLoadLocationOnPress(View v) {
        //TODO create parse file program


    }

}
