package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Model;

public class LocalEmployeeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_employee);
    }

    public void onLogoutClicked(View v) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    public void onViewLocationLocalEmployeeOnPress(View v) {
        Model model = Model.getInstance();
        if (model.getLocations().size() == 0) {
            Toast.makeText(this, "No Locations have been loaded by Admin.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, LocationListActivity.class);
            startActivity(intent);

        }

    }

    public void onAddDonationOnPress(View v) {
        Model model = Model.getInstance();
        if (model.getLocations().size() == 0) {
            Toast.makeText(this, "No Locations have been loaded by Admin.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, AddDonationActivity.class);
            startActivity(intent);

        }

    }
}
