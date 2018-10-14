package team1.gatech.edu.irp.controllers;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Location;
import team1.gatech.edu.irp.model.LocationType;
import team1.gatech.edu.irp.model.Model;




public class LocationDetailsActivity extends AppCompatActivity {

    private TextView nameField;
    private TextView addressField;
    private TextView cityField;
    private TextView stateField;
    private TextView zipField;
    private TextView locationTypeField;
    private TextView phoneNumberField;
    private TextView websiteLinkField;
    private TextView latitudeField;
    private TextView longitudeField;

    private Spinner itemSpinner;



    private Location location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_details);

        Model model = Model.getInstance();
        String name = model.getCurrentLocation().getName();
        String address = model.getCurrentLocation().getStreetAddress();
        String city = model.getCurrentLocation().getCity();
        String state = model.getCurrentLocation().getState();
        String zip = "" + model.getCurrentLocation().getZipCode();
        String locationType = model.getCurrentLocation().getLocationType().toString();
        String phoneNumber = model.getCurrentLocation().getPhoneNumber();
        String website =  model.getCurrentLocation().getWebsiteLink();
        String latitude = "" + model.getCurrentLocation().getLatitude();
        String longitude = "" + model.getCurrentLocation().getLongitude();

        nameField = (TextView) findViewById(R.id.LocationNameText);
        nameField.setText(name);

        addressField = (TextView) findViewById(R.id.adressText);
        addressField.setText(address);

        cityField = (TextView) findViewById(R.id.CityText);
        cityField.setText(city);

        stateField = (TextView) findViewById(R.id.StateText);
        stateField.setText(state);

        zipField = (TextView) findViewById(R.id.ZipText);
        zipField.setText(zip);

        locationTypeField = (TextView) findViewById(R.id.LocationTypeText);
        locationTypeField.setText(locationType);

        phoneNumberField = (TextView) findViewById(R.id.PhoneNumberText);
        phoneNumberField.setText(phoneNumber);

        websiteLinkField = (TextView) findViewById(R.id.WebSiteText);
        websiteLinkField.setText(website);

        latitudeField = (TextView) findViewById(R.id.LatitudeText);
        latitudeField.setText(latitude);

        longitudeField = (TextView) findViewById(R.id.LongitudeText);
        longitudeField.setText(longitude);




        itemSpinner = (Spinner) findViewById(R.id.ItemSpinner);
    /*
      Set up the adapter to display the allowable locations in the spinner
     */
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, model.getInventoryStringArray());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itemSpinner.setAdapter(adapter);
        itemSpinner.setSelection(0);




    }

    public void onViewItemOnPress(View v) {
        Model model = Model.getInstance();
        String currItem = ((String) itemSpinner.getSelectedItem());
        model.setCurrentItemDetails(currItem);
        Intent intent = new Intent(this, ItemDetailsActivity.class);
        startActivity(intent);
    }


}

