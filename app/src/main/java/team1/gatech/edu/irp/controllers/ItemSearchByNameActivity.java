package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.ItemServiceFacade;
import team1.gatech.edu.irp.model.LocationServiceFacade;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;


/**
 * After a user selects the Search Item by Name, this is the screen that appears
 *
 * @author Mitchell_Alvarado
 */
public class ItemSearchByNameActivity extends AppCompatActivity {

    private Spinner LocationSpinner;
    private TextView itemNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_search_by_name);

        LocationSpinner = findViewById(R.id.SpinnerLocationItemSearchByName);
        LocationServiceFacade locationServiceFacade = LocationServiceFacade.getInstance();

//      Set up the adapter to display the allowable location in the spinner
        List<String> locationsList = getLocationsAll(locationServiceFacade);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, locationsList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        LocationSpinner.setAdapter(adapter);
        LocationSpinner.setSelection(0);

        itemNameTextView = findViewById(R.id.SearchByNameEditText);

    }

    /**
     * gets the location list with all locations option
     *
     * @param locationServiceFacade the locationServiceFacade
     * @return location list with all locations option
     */
    private List<String> getLocationsAll(LocationServiceFacade locationServiceFacade) {
        return locationServiceFacade.getLocationsAsStringWithAllLocationOption();
    }


    /**
     * When the user presses the View Item Details button is sends them to the Item Details Screen
     *
     * @param v the view
     */
    public void onViewItemDetailsFromNameSearchOnPress(View v) {
        ItemServiceFacade itemServiceFacade = ItemServiceFacade.getInstance();
        CharSequence itemNameChar = itemNameTextView.getText();
        String itemName = itemNameChar.toString();
        String currLoc = ((String) LocationSpinner.getSelectedItem());

        getInventory(itemServiceFacade, itemName, currLoc);
        Intent intent = new Intent(this, ItemListActivity.class);
        startActivity(intent);
    }

    /**
     * gets the inventory by category and location
     *
     * @param itemServiceFacade the itemServiceFacade
     */
    private void getInventory(ItemServiceFacade itemServiceFacade, String itemName,
                              String currLoc) {
        itemServiceFacade.setInventoryByNameAndLocation(itemName, currLoc);
    }

    /**
     * When the user presses the Back button is sends them back to user home screen
     *
     * @param v the view
     */
    public void onItemSearchByCategoryBackOnPress(View v) {
        finish();
    }

}