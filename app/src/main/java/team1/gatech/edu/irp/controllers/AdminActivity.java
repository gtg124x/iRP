package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Model;
import android.view.View;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {

    private final static int NOLOCATIONS = 0;
    private Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }

    /**
     * Button handler for logout
     *
     * @param v the view
     */
    public void onLogoutClicked(View v) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    /**
     * Button handler for viewing a list of locations
     *
     * @param v the view
     */
    public void onViewLocationAdminOnPress(View v) {
        model = Model.getInstance();
        if (model.getLocations().size() == NOLOCATIONS) {
            Toast.makeText(this, "No Locations have been loaded by Admin.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, LocationListActivity.class);
            startActivity(intent);
        }
    }

    /**
     * Button handler for loading locations into app from CSV
     *
     * @param v the view
     */
    public void onLoadLocationOnPress(View v) {
        model = Model.getInstance();
        boolean success = model.loadLocations(v);
        if (success) {
            Toast.makeText(this, "Locations have been loaded.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Duplicate Locations will not be added.", Toast.LENGTH_SHORT).show();
        }
    }
}
