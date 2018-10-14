package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Account;
import team1.gatech.edu.irp.model.Category;
import team1.gatech.edu.irp.model.LocationType;
import team1.gatech.edu.irp.model.Model;
import team1.gatech.edu.irp.model.UserType;

public class AddDonationActivity extends AppCompatActivity {

    private TextView timeStamp;
    private TextView dateStamp;
    private Spinner locationSpinner;
    private Spinner categorySpinner;
    private TextView value;
    private TextView shortDescription;
    private TextView fullDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donation);

        Model model = Model.getInstance();

        /**
         * Grab the dialog widgets so we can get info for later
         */
        timeStamp = (TextView) findViewById(R.id.TimeStampEditText);
        dateStamp = (TextView) findViewById(R.id.DateOfDonationEditText);
        locationSpinner = (Spinner) findViewById(R.id.AddDonationLocationSpinner);
        categorySpinner = (Spinner) findViewById(R.id.CategorySpinner);
        value = (TextView) findViewById(R.id.ValueEditText);
        shortDescription = (TextView) findViewById(R.id.DescriptionEditText);
        fullDescription = (TextView) findViewById(R.id.FullDescriptionEditText);

    /*
      Set up the adapter to display the allowable location in the spinner
     */
        ArrayAdapter<String> locationAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, model.getLocationsArray());
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locationAdapter);
        locationSpinner.setSelection(0);

    /*
      Set up the adapter to display the allowable location in the spinner
     */
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Category.values());
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryAdapter);
        locationSpinner.setSelection(0);

    }


    public void onAddDonationBackOnPress(View v) {
        finish();
    }
}

