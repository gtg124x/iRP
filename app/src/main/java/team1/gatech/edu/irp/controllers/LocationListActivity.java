package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Model;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Displays a list of locations.
 * Upon selecting a location, the details will be displayed on the LocationDetailsActivity
 */
public class LocationListActivity extends AppCompatActivity {

    private Spinner LocationSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);

        LocationSpinner = findViewById(R.id.SpinnerLocation);
        Model model = Model.getInstance();

//       Set up the adapter to display the allowable locations in the spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, model.getLocationsAsString());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        LocationSpinner.setAdapter(adapter);
        LocationSpinner.setSelection(0);

    }

    /**
     * Upon pressing the "View Location Details" Button, it displays the details of a location
     *
     * @param v the view
     */
    public void onViewLocationDetailsOnPress(View v) {
        Model model = Model.getInstance();

        String currLoc = ((String) LocationSpinner.getSelectedItem());
        model.setCurrentLocation(currLoc);

        Intent intent = new Intent(this, LocationDetailsActivity.class);
        startActivity(intent);
    }

    /**
     * Upon pressing the "Back" Button it returns back to the respective account type home screen
     *
     * @param v the view
     */
    public void onLocationListBackOnPress(View v) {
        finish();
    }

}
