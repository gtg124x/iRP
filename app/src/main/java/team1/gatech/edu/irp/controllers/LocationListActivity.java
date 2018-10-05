package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Model;

public class LocationListActivity extends AppCompatActivity {

    private Spinner LocationSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);

        LocationSpinner = (Spinner) findViewById(R.id.SpinnerLocation);

    /*
      Set up the adapter to display the allowable class standing in the spinner
     */

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Model.locationsArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        LocationSpinner.setAdapter(adapter);
        LocationSpinner.setSelection(0);

    }

    public void onViewLocationDetailsOnPress(View v) {
        Model model = Model.getInstance();

        String currLoc = ((String) LocationSpinner.getSelectedItem());
        model.setCurrentLocation(currLoc);

        Intent intent = new Intent(this, LocationDetailsActivity.class);
        startActivity(intent);
    }


}