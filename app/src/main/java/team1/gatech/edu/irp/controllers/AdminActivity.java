package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.LocationServiceFacade;
import android.view.View;
import android.widget.Toast;

/**
 * Administrator home page that appears after login screen
 */
public class AdminActivity extends AppCompatActivity {

    //private Model model;

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
        LocationServiceFacade locationServiceFacade = LocationServiceFacade.getInstance();
        //model = Model.getInstance();
//        if (locationServiceFacade.noLocations()) {
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
     * When the Load Locations Button is pressed it loads the locations into app from a CSV file
     *
     * @param v the view
     */
    public void onLoadLocationOnPress(View v) {
        LocationServiceFacade locationServiceFacade = LocationServiceFacade.getInstance();
        //model = Model.getInstance();
//        boolean success = locationServiceFacade.loadLocations(v);
        boolean success = grabLocations(v, locationServiceFacade);
        if (success) {
            Toast.makeText(this, "Locations have been loaded.",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Duplicate Locations will not be added.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * loads the locations from CSV file to app
     *
     * @param v the view
     * @param locationServiceFacade locationServiceFacade
     * @return list of Location objects
     */
    private boolean grabLocations(View v, LocationServiceFacade locationServiceFacade) {
        return locationServiceFacade.loadLocations(v);
    }


}
