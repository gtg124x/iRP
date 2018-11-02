package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Model;
import team1.gatech.edu.irp.model.CategoryENUM;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.List;

/**
 * After a user selects the Search Item by Category, this is the screen that appears
 */
public class ItemSearchByCategoryActivity extends AppCompatActivity {

    private Spinner LocationSpinner;
    private Spinner CategorySpinner;

    private String currLoc;
    private CategoryENUM category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_search_by_category);
        LocationSpinner = findViewById(R.id.SpinnerLocationSearchByCategory);
        CategorySpinner = findViewById(R.id.spinnerCategorySearch);
        Model model = Model.getInstance();


//      Set up the adapter to display the allowable locations in the spinner
//        List<String> locationsList = model.getLocationsAsStringWithAllLocationOption();
        List<String> locationsList = getLocationsAll(model);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, locationsList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        LocationSpinner.setAdapter(adapter);
        LocationSpinner.setSelection(0);

//      Set up the adapter to display the categories in the spinner
        ArrayAdapter<CategoryENUM> adapterCat = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, CategoryENUM.values());
        adapterCat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        CategorySpinner.setAdapter(adapterCat);
        CategorySpinner.setSelection(0);
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
    public void onViewItemDetailsFromNameCategoryOnPress(View v) {
        Model model = Model.getInstance();

        currLoc = ((String) LocationSpinner.getSelectedItem());

        category = (CategoryENUM) CategorySpinner.getSelectedItem();

//        model.setInventoryByCategoryAndLocation(category, currLoc);
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
        model.setInventoryByCategoryAndLocation(category, currLoc);
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