package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.LocationServiceFacade;
import android.view.View;
import android.widget.Toast;

/**
 * Manager home screen that appears after login
 */
public class ManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
    }

    /**
     * When the Logout Button is pressed it sends the manager back to the welcome screen
     *
     * @param v the view
     */
    public void onLogoutClicked(View v) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    /**
     * When the View Locations Button is pressed it sends the manager to the a screen that
     * displays the locations in a spinner
     *
     * @param v the view
     */
    public void onViewLocationManagerOnPress(View v) {
//        Model model = Model.getInstance();
////        if (model.noLocations()) {
//        if (locationsEmpty(model)) {
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

//    /**
//     * checks if there are no locations
//     *
//     * @param model the model
//     * @return success
//     */
//    private boolean locationsEmpty(Model model) {
//        return model.noLocations();
//    }

}
