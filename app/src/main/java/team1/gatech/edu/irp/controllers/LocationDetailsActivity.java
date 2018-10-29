package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Location;
import team1.gatech.edu.irp.model.Model;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;


public class LocationDetailsActivity extends AppCompatActivity {

    private Spinner itemSpinner;

    /**
     * Displays the details of a location
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_details);

        Model model = Model.getInstance();
        Location currSelectedLocation = model.getCurrentLocation();
        String name = currSelectedLocation.getName();
        String address = currSelectedLocation.getStreetAddress();
        String city = currSelectedLocation.getCity();
        String state = currSelectedLocation.getState();
        String zip = "" + currSelectedLocation.getZipCode();
        String locationType = currSelectedLocation.getLocationType().toString();
        String phoneNumber = currSelectedLocation.getPhoneNumber();
        String website =  currSelectedLocation.getWebsiteLink();
        String latitude = "" + currSelectedLocation.getLatitude();
        String longitude = "" + currSelectedLocation.getLongitude();

        TextView nameField = findViewById(R.id.LocationNameText);
        nameField.setText(name);

        TextView addressField = findViewById(R.id.adressText);
        addressField.setText(address);

        TextView cityField = findViewById(R.id.CityText);
        cityField.setText(city);

        TextView stateField = findViewById(R.id.StateText);
        stateField.setText(state);

        TextView zipField = findViewById(R.id.ZipText);
        zipField.setText(zip);

        TextView locationTypeField = findViewById(R.id.LocationTypeText);
        locationTypeField.setText(locationType);

        TextView phoneNumberField = findViewById(R.id.PhoneNumberText);
        phoneNumberField.setText(phoneNumber);

        TextView websiteLinkField = findViewById(R.id.WebSiteText);
        websiteLinkField.setText(website);

        TextView latitudeField = findViewById(R.id.LatitudeText);
        latitudeField.setText(latitude);

        TextView longitudeField = findViewById(R.id.LongitudeText);
        longitudeField.setText(longitude);

        itemSpinner = findViewById(R.id.ItemSpinner);


//          Set up the adapter to display the allowable locations in the spinner

        List<String> currentLocationItemList = model.getInventoryByLocation(currSelectedLocation);

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, currentLocationItemList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itemSpinner.setAdapter(adapter);
        itemSpinner.setSelection(0);
    }

    /**
     * Upon selecting the "View Items" Button, display the detail of the item.
     * This takes the user to the ItemDetailsActivity if there are items to view.
     *
     * @param v the view
     */
    public void onViewItemOnPress(View v) {
        Model model = Model.getInstance();
        Location currSelectedLocation = model.getCurrentLocation();
        if (model.isInventoryByLocationEmpty(currSelectedLocation)) {
            Toast.makeText(this, "No Items Have Been Added To Inventory", Toast.LENGTH_SHORT).show();
        } else {
            String currItem = ((String) itemSpinner.getSelectedItem());
            model.setCurrentItemDetails(currItem);
            Intent intent = new Intent(this, ItemDetailsActivity.class);
            startActivity(intent);
        }
    }

    /**
     * Sends them back to the LocationListActivity
     * 
     * @param v the view
     */
    public void onLocationDetailsBackButtonOnPress(View v) {
        finish();
    }


}

