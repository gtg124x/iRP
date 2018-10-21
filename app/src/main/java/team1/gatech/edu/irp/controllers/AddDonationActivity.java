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
import team1.gatech.edu.irp.model.Item;

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

    /*
      Set up the adapter to display the allowable location in the spinner
     */
        ArrayAdapter<String> locationAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, model.getLocationsAsString());
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locationAdapter);
        locationSpinner.setSelection(0);

    /*
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

//        //convert location string to a location object
        model.setCurrentLocationAddDonation(locationString);
        Location location = model.getCurrentLocationAddDonation();

        if (!validiateTimeStamp(timeStamp)) {
            Toast.makeText(this, "Time Stamp must be in 24 Hour:Min:Sec form ex. 05:02:02", Toast.LENGTH_SHORT).show();
        } else if (!validiateDateStamp(dateStamp)) {
            Toast.makeText(this, "Date Stamp must be in Month/Day/Year form ex. 02-04-2018", Toast.LENGTH_SHORT).show();
        } else if (!validiateDollarValue(dollarValue)) {
            Toast.makeText(this, "Dollar Value must be $xx.xx form ex. 0.19", Toast.LENGTH_SHORT).show();
        } else if (shortDescription.length() < 3) {
            Toast.makeText(this, "Short Description must be longer than 2 characters.", Toast.LENGTH_SHORT).show();
        } else if (shortDescription.length() > 15 ) {
            Toast.makeText(this, "Short Description less than or equal to 15 characters..", Toast.LENGTH_SHORT).show();
        } else if (fullDescription.length() < 3) {
            Toast.makeText(this, "Full Description must be longer than 2 characters.", Toast.LENGTH_SHORT).show();
        } else {
            Item item = new Item(timeStamp, dateStamp, location, category, dollarValue, shortDescription,
                    fullDescription);
            model.addToInventory(item);
            Toast.makeText(this, "Item added to Inventory.", Toast.LENGTH_SHORT).show();
//
//            Intent intent = new Intent(this, LocalEmployeeActivity.class);
//            startActivity(intent);
            finish();
        }
    }

    private boolean validiateTimeStamp(String time) {
        if (time.length() != 8) { return false; }
        String firstColen = "" + time.charAt(2);
        String secondColen = "" + time.charAt(5);
        if (!(firstColen.equals(":")) || !(secondColen.equals(":"))) { return false; }

        String hourAsString = "" + time.charAt(0) + time.charAt(1);
        String minAsString = "" + time.charAt(3) + time.charAt(4);
        String secAsString = "" + time.charAt(6) + time.charAt(7);

        try {
            int hourAsInt = Integer.parseInt(hourAsString);
            int minAsInt = Integer.parseInt(minAsString);
            int secAsInt = Integer.parseInt(secAsString);

            if (hourAsInt < 0 || hourAsInt >= 24) { return false; }
            else if (minAsInt < 0 || minAsInt >= 60) { return false; }
            else if (secAsInt < 0 || secAsInt >= 60) { return false; }
            else { return true; }

        } catch (NumberFormatException e) {
            return false;
        }

    }

    private boolean validiateDateStamp(String date) {
        if (date.length() != 10) { return false; }
        String firstDast = "" + date.charAt(2);
        String secondDash = "" + date.charAt(5);
        if (!(firstDast.equals("-")) || !(secondDash.equals("-"))) { return false; }

        String monthAsString = "" + date.charAt(0) + date.charAt(1);
        String dateString = "" + date.charAt(3) + date.charAt(4);
        String yearAsString = "" + date.charAt(6) + date.charAt(7) + date.charAt(8) + date.charAt(9);

        try {
            int monthAsInt = Integer.parseInt(monthAsString);
            int dateAsInt = Integer.parseInt(dateString);
            int yearAsInt = Integer.parseInt(yearAsString);

            if (monthAsInt < 1 || monthAsInt > 12) { return false; }
            else if (dateAsInt < 0 || dateAsInt >= 31) { return false; }
            else if (yearAsInt < 2000 || yearAsInt >= 2020) { return false; }
            else if ((monthAsInt == 4 || monthAsInt == 6 || monthAsInt == 9 || monthAsInt == 11)
                    && (dateAsInt > 30)) { return false; }
            else if (monthAsInt == 2 && dateAsInt > 28) { return false; }
            else { return true; }

        } catch (NumberFormatException e) {
            return false;
        }

    }

    private boolean validiateDollarValue(String dollarValue) {
        if (dollarValue.length() < 4) { return false; }

        String change = "" + dollarValue.charAt(dollarValue.length() - 2) + dollarValue.charAt(dollarValue.length() - 1);
        String dollars = "" + dollarValue.substring(0, dollarValue.length() - 3);
        String decimalPoint = "" + dollarValue.charAt(dollarValue.length() - 3);
        if (!(decimalPoint.equals("."))) { return false; }

        try {
            int changeAsInt = Integer.parseInt(change);
            int dollarsAsInt = Integer.parseInt(dollars);

            if (changeAsInt < 0 || changeAsInt > 99) { return false; }
            else if (dollarsAsInt < 0) { return false; }
            else if (dollarsAsInt == 0 && changeAsInt == 0) { return false; }
            else { return true; }

        } catch (NumberFormatException e) {
            return false;
        }

    }

    public void onAddDonationBackOnPress(View v) {
        finish();
    }


}

