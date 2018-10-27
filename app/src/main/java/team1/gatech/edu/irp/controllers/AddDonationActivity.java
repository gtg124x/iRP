package team1.gatech.edu.irp.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Category;
import team1.gatech.edu.irp.model.Location;
import team1.gatech.edu.irp.model.Model;
import team1.gatech.edu.irp.model.AddDonationResultENUM;

/**
 * Screen that lets a location employee input items details to add to the inventory
 */
public class AddDonationActivity extends AppCompatActivity {

    private TextView timeStampTextView;
    private TextView dateStampTextView;
    private Spinner locationSpinner;
    private Spinner categorySpinner;
    private TextView dollarValueTextView;
    private TextView shortDescriptionTextView;
    private TextView fullDescriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donation);
        Model model = Model.getInstance();

        /**
         * Grab the dialog widgets so we can get info for later
         */
        timeStampTextView = (TextView) findViewById(R.id.TimeStampEditText);
        dateStampTextView = (TextView) findViewById(R.id.DateOfDonationEditText);
        locationSpinner = (Spinner) findViewById(R.id.AddDonationLocationSpinner);
        categorySpinner = (Spinner) findViewById(R.id.CategorySpinner);
        dollarValueTextView = (TextView) findViewById(R.id.ValueEditText);
        shortDescriptionTextView = (TextView) findViewById(R.id.DescriptionEditText);
        fullDescriptionTextView = (TextView) findViewById(R.id.FullDescriptionEditText);

    /**
      Set up the adapter to display the allowable location in the spinner
     */
        ArrayAdapter<String> locationAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, model.getLocationsAsString());
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locationAdapter);
        locationSpinner.setSelection(0);

    /**
      Set up the adapter to display the allowable location in the spinner
     */
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Category.values());
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryAdapter);
        categorySpinner.setSelection(0);
    }

    /**
     * Button handler for the add new donation button
     * @param view the button
     */
    public void onSubmitOnPress(View view) {
        Model model = Model.getInstance();

        String timeStamp = timeStampTextView.getText().toString();
        String dateStamp = dateStampTextView.getText().toString();
        String locationString = ((String) locationSpinner.getSelectedItem());
        Category category = (Category) categorySpinner.getSelectedItem();
        String dollarValue = dollarValueTextView.getText().toString();
        String shortDescription = shortDescriptionTextView.getText().toString();
        String fullDescription = fullDescriptionTextView.getText().toString();

        model.setCurrentLocationAddDonation(locationString);               //convert location string to a location object
        Location location = model.getCurrentLocationAddDonation();

        AddDonationResultENUM addDonationResult = model.validateAndAddItemToInventory(timeStamp, dateStamp,
                location, category, dollarValue, shortDescription, fullDescription);

        if (addDonationResult == AddDonationResultENUM.TIME_INVALID) {
            Toast.makeText(this, "Time Stamp must be in 24 Hour:Min:Sec form ex. 05:02:02", Toast.LENGTH_SHORT).show();
        } else if (addDonationResult == AddDonationResultENUM.DATE_INVALID) {
            Toast.makeText(this, "Date Stamp must be in Month/Day/Year form ex. 02-04-2018", Toast.LENGTH_SHORT).show();
        } else if (addDonationResult == AddDonationResultENUM.VALUE_INVALID) {
            Toast.makeText(this, "Dollar Value must be $xx.xx form ex. 0.19", Toast.LENGTH_SHORT).show();
        } else if (addDonationResult == AddDonationResultENUM.SHORTDESCRIPTION_INVALID_TO_SHORT) {
            Toast.makeText(this, "Short Description must be longer than 2 characters.", Toast.LENGTH_SHORT).show();
        } else if (addDonationResult == AddDonationResultENUM.SHORTDESCRIPTION_INVALID_TO_LONG) {
            Toast.makeText(this, "Short Description less than or equal to 15 characters..", Toast.LENGTH_SHORT).show();
        } else if (addDonationResult == AddDonationResultENUM.LONGDESCRIPTION_INVALID_TO_SHORT) {
            Toast.makeText(this, "Full Description must be longer than 2 characters.", Toast.LENGTH_SHORT).show();
        } else if (addDonationResult == AddDonationResultENUM.SUCCESS) {
            Toast.makeText(this, "Item added to Inventory.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    /**
     * When the user presses the Back button is sends them back to the Local Employee home screen
     */
    public void onAddDonationBackOnPress(View v) {
        finish();
    }


}

