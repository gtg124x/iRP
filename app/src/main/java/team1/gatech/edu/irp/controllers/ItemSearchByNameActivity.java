package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Model;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;


/**
 * After a user selects the Search Item by Name, this is the screen that appears
 */
public class ItemSearchByNameActivity extends AppCompatActivity {

    private Spinner LocationSpinner;
    private TextView itemNameTextView;

    private String itemName;
    private String currLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_search_by_name);

        LocationSpinner = findViewById(R.id.SpinnerLocationItemSearchByName);
        Model model = Model.getInstance();

//      Set up the adapter to display the allowable location in the spinner
//        List<String> locationsList = model.getLocationsAsStringWithAllLocationOption();
        List<String> locationsList = getLocationsAll(model);
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
     * @param model the model
     * @return location list with all locations option
     */
    private List<String> getLocationsAll(Model model) {
        return model.getLocationsAsStringWithAllLocationOption();
    }

    /**
     * When the user presses the View Item Details button is sends them to the Item Details Screen
     *
     * @param v the view
     */
    public void onViewItemDetailsFromNameSearchOnPress(View v) {
        Model model = Model.getInstance();

        CharSequence itemNameChar = itemNameTextView.getText();
        itemName = itemNameChar.toString();
        currLoc = ((String) LocationSpinner.getSelectedItem());

//        model.setInventoryByNameAndLocation(itemName, currLoc);
        getInventory(model);

        Intent intent = new Intent(this, ItemListActivity.class);
        startActivity(intent);
    }

    /**
     * gets the inventory by category and location
     *
     * @param model the model
     */
    private void getInventory(Model model) {
        model.setInventoryByNameAndLocation(itemName, currLoc);
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