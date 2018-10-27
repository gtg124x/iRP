package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Model;
import android.view.View;
import android.widget.Toast;

/**
 * Screen that appears after login when the account is for a location employee
 */
public class LocalEmployeeActivity extends AppCompatActivity {

    private Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_employee);
    }

    /**
     * When the Logout Button is pressed it sends the local employee back to the welcome screen
     *
     * @param v the view
     */
    public void onLogoutClicked(View v) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    /**
     * When the View Locations Button is pressed it sends the local employee to the a screen that displays the locations in a spinner
     *
     * @param v the view
     */
    public void onViewLocationLocalEmployeeOnPress(View v) {
        Model model = Model.getInstance();
        if (model.noLocations()) {
            Toast.makeText(this, "No Locations have been loaded by Admin.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, LocationListActivity.class);
            startActivity(intent);
        }
    }

    /**
     * When the Add Donation Button is pressed is sends you to the add donation screen
     *
     * @param v the view
     */
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
