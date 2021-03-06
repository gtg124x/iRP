package team1.gatech.edu.irp.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.CategoryENUM;
import team1.gatech.edu.irp.model.Location;
import team1.gatech.edu.irp.model.LocationServiceFacade;
import team1.gatech.edu.irp.model.ItemServiceFacade;
import team1.gatech.edu.irp.model.AddDonationResultENUM;

/**
 * Screen that lets a location employee input items details to add to the inventory
 *
 * @author Mitchell_Alvarado
 */
public class AddDonationActivity extends AppCompatActivity {

    private TextView timeStampTextView;
    private TextView dateStampTextView;
    private Spinner locationSpinner;
    private Spinner categorySpinner;
    private TextView dollarValueTextView;
    private TextView shortDescriptionTextView;
    private TextView fullDescriptionTextView;

    private String timeStamp;
    private String dateStamp;
    private Location location;
    private CategoryENUM category;
    private String dollarValue;
    private String shortDescription;
    private String fullDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donation);
        LocationServiceFacade locationServiceFacade = LocationServiceFacade.getInstance();
//      Grab the dialog widgets so we can get info for later use
        timeStampTextView = findViewById(R.id.TimeStampEditText);
        dateStampTextView = findViewById(R.id.DateOfDonationEditText);
        locationSpinner = findViewById(R.id.AddDonationLocationSpinner);
        categorySpinner = findViewById(R.id.CategorySpinner);
        dollarValueTextView = findViewById(R.id.ValueEditText);
        shortDescriptionTextView = findViewById(R.id.DescriptionEditText);
        fullDescriptionTextView = findViewById(R.id.FullDescriptionEditText);

//      Set up the adapter to display the allowable location in the spinner
        ArrayAdapter<Location> locationAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, getMeLocations(locationServiceFacade));
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locationAdapter);
        locationSpinner.setSelection(0);

//      Set up the adapter to display the allowable category in the spinner
        ArrayAdapter<CategoryENUM> categoryAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, CategoryENUM.values());
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryAdapter);
        categorySpinner.setSelection(0);
    }

    /**
     * Button handler for the add new donation button
     * Takes the user input and send to model for verification
     * @param view the button
     */
    public void onSubmitOnPress(View view) {
        ItemServiceFacade itemServiceFacade = ItemServiceFacade.getInstance();

        timeStamp = timeStampTextView.getText() + "";
        dateStamp = dateStampTextView.getText() + "";
        location = ((Location) locationSpinner.getSelectedItem());
        category= (CategoryENUM) categorySpinner.getSelectedItem();
        dollarValue = dollarValueTextView.getText() + "";
        shortDescription = shortDescriptionTextView.getText() + "";
        fullDescription = fullDescriptionTextView.getText() + "";


//        if (timeStamp.isEmpty() || dateStamp.isEmpty() || dollarValue.isEmpty()
//                || shortDescription.isEmpty() || fullDescription.isEmpty() ) {
        if (isEmpty()) {
            Toast.makeText(this, "Invalid Data.", Toast.LENGTH_SHORT).show();
        }

        AddDonationResultENUM addDonationResult = validate(itemServiceFacade);

        if (addDonationResult == AddDonationResultENUM.TIME_INVALID) {
            Toast.makeText(this,
                    "Time Stamp must be in 24 Hour:Min:Sec form ex. 05:02:02",
                    Toast.LENGTH_SHORT).show();
        } else if (addDonationResult == AddDonationResultENUM.DATE_INVALID) {
            Toast.makeText(this,
                    "Date Stamp must be in Month/Day/Year form ex. 02-04-2018",
                    Toast.LENGTH_SHORT).show();
        } else if (addDonationResult == AddDonationResultENUM.VALUE_INVALID) {
            Toast.makeText(this,
                    "Dollar Value must be $xx.xx form ex. 0.19",
                    Toast.LENGTH_SHORT).show();
        } else if (addDonationResult == AddDonationResultENUM.SHORT_DESCRIPTION_INVALID_TO_SHORT) {
            Toast.makeText(this,
                    "Short Description to short.", Toast.LENGTH_SHORT).show();
        } else if (addDonationResult == AddDonationResultENUM.SHORT_DESCRIPTION_INVALID_TO_LONG) {
            Toast.makeText(this,
                    "Short Description less than or equal to 15 characters..",
                    Toast.LENGTH_SHORT).show();
        } else if (addDonationResult == AddDonationResultENUM.LONG_DESCRIPTION_INVALID_TO_SHORT) {
            Toast.makeText(this,
                    "Full Description must be longer than 2 characters.",
                    Toast.LENGTH_SHORT).show();
        } else if (addDonationResult == AddDonationResultENUM.SUCCESS) {
            Toast.makeText(this, "Item added to Inventory.",
                    Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    /**
     * is empty check
     *
     * @return if the strings are empty
     */
    private boolean isEmpty() {
        return (timeStamp.isEmpty() || dateStamp.isEmpty() || dollarValue.isEmpty()
                || shortDescription.isEmpty() || fullDescription.isEmpty());
    }

    /**
     * When the user presses the Back button is sends them back to the Local Employee home screen
     *
     * @param v the view
     */
    public void onAddDonationBackOnPress(View v) {
        finish();
    }

    /**
     * gets the locations
     *
     * @param locationServiceFacade the locationServiceFacade
     * @return list of locations
     */
    private List<Location> getMeLocations(LocationServiceFacade locationServiceFacade) {
        return locationServiceFacade.getLocations();
    }

    /**
     * gets the result code from the itemServiceFacade and adds and account if valid
     *
     * @param itemServiceFacade the itemServiceFacade
     * @return validation result
     */
    private AddDonationResultENUM validate(ItemServiceFacade itemServiceFacade) {
        return itemServiceFacade.validateAndAddItemToInventory(timeStamp, dateStamp, location,
                category, dollarValue, shortDescription, fullDescription);
    }

}

