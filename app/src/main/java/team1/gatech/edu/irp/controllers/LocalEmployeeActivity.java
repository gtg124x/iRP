package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Location;
import team1.gatech.edu.irp.model.LocationServiceFacade;
import android.view.View;
import android.widget.Toast;

import java.util.List;

/**
 * Location employee home screen that appears after login
 */
public class LocalEmployeeActivity extends AppCompatActivity {

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
     * When the View Locations Button is pressed it sends the local employee to the a
     * screen that displays the locations in a spinner
     *
     * @param v the view
     */
    public void onViewLocationLocalEmployeeOnPress(View v) {
        LocationServiceFacade locationServiceFacade = LocationServiceFacade.getInstance();
        if (locationsEmpty(locationServiceFacade)) {
            Toast.makeText(this, "No Locations have been loaded by Admin.",
                    Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, LocationListActivity.class);
            startActivity(intent);
        }
    }

    /**
     * tests whether or not the location list is empty
     *
     * @param locationServiceFacade locationServiceFacade
     * @return if there are no locations entered in the app
     */
    private boolean locationsEmpty(LocationServiceFacade locationServiceFacade) {
        return locationServiceFacade.noLocations();
    }

    /**
     * When the Add Donation Button is pressed is sends you to the add donation screen
     *
     * @param v the view
     */
    public void onAddDonationOnPress(View v) {
        LocationServiceFacade locationServiceFacade = LocationServiceFacade.getInstance();
        List<Location> locations = getCurrentLocations(locationServiceFacade);
        if (locations.isEmpty()) {
            Toast.makeText(this, "No Locations have been loaded by Admin.",
                    Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, AddDonationActivity.class);
            startActivity(intent);
        }
    }

    /**
     * gets the locations
     *
     * @param locationServiceFacade the model
     * @return list of locations
     */
    private List<Location> getCurrentLocations(LocationServiceFacade locationServiceFacade) {
        return locationServiceFacade.getLocations();
    }
}
