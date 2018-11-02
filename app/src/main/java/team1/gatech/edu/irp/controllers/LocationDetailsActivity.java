package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Item;
import team1.gatech.edu.irp.model.Model;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

/**
 * Location Details Screen
 *
 */
public class LocationDetailsActivity extends AppCompatActivity {

    private Spinner itemSpinner;

    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String locationType;
    private String phoneNumber;
    private String website;
    private String latitude;
    private String longitude;

    private List<Item> currentLocationItemListItem;

    /**
     * sets the fill data
     *
     */
    private void helper() {
        Model model = Model.getInstance();
        List<String> locationString =
                model.getSelectedLocationFromLocationListAndSendToLocationDetails();
        name = locationString.get(0);
        address = locationString.get(1);
        city = locationString.get(2);
        state = locationString.get(3);
        zip = locationString.get(4);
        locationType = locationString.get(5);
        phoneNumber = locationString.get(6);
        website = locationString.get(7);
        latitude = locationString.get(8);
        longitude = locationString.get(9);
    }

    /**
     * Displays the details of a location
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_details);

        Model model = Model.getInstance();

        helper();

        TextView nameField = findViewById(R.id.LocationNameText);
        nameField.setText(name);

        TextView addressField = findViewById(R.id.addressText);
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

        currentLocationItemListItem = model.getInventoryByLocation();

        ArrayAdapter<Item> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, currentLocationItemListItem);
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
        //List<Item> currentItemList = model.getCurrentItemList();
        if (currentLocationItemListItem.isEmpty()) {
            Toast.makeText(this, "No Items Have Been Added To Inventory",
                    Toast.LENGTH_SHORT).show();
        } else {
            int selectionNumber = itemSpinner.getSelectedItemPosition();
            model.setSelectedItemFromItemListAndSendToItemDetails(selectionNumber);
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

