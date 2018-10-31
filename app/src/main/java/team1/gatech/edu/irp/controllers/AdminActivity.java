package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Model;
import android.view.View;
import android.widget.Toast;

/**
 * Administrator home page that appears after login screen
 */
public class AdminActivity extends AppCompatActivity {

    private Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }

    /**
     * When the Logout Button is pressed it sends the admin back to the welcome screen
     *
     * @param v the view
     */
    public void onLogoutClicked(View v) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    /**
     * When the View Locations Button is pressed it sends the admin to the a screen that displays
     * the locations in a spinner
     *
     * @param v the view
     */
    public void onViewLocationAdminOnPress(View v) {
        model = Model.getInstance();
        if (model.noLocations()) {
            Toast.makeText(this, "No Locations have been loaded by Admin.",
                    Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, LocationListActivity.class);
            startActivity(intent);
        }
    }

    /**
     * When the Load Locations Button is pressed it loads the locations into app from a CSV file
     *
     * @param v the view
     */
    public void onLoadLocationOnPress(View v) {
        model = Model.getInstance();
        boolean success = model.loadLocations(v);
        if (success) {
            Toast.makeText(this, "Locations have been loaded.",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Duplicate Locations will not be added.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
