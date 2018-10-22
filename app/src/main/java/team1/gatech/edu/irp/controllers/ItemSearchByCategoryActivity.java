package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Category;
import team1.gatech.edu.irp.model.Item;
import team1.gatech.edu.irp.model.Model;

public class ItemSearchByCategoryActivity extends AppCompatActivity {

    private Spinner LocationSpinner;
    private Spinner CategorySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_search_by_category);
        LocationSpinner = (Spinner) findViewById(R.id.SpinnerLocationSearchByCategory);
        CategorySpinner = (Spinner) findViewById(R.id.spinnerCategorySearch);
        Model model = Model.getInstance();
    /*
      Set up the adapter to display the allowable locations in the spinner
     */




        ArrayList<String> locationsList = new ArrayList<>();
        locationsList.add("All Locations");
        locationsList.addAll(model.getLocationsAsString());


        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, locationsList);

//        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, model.getLocationsAsString());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        LocationSpinner.setAdapter(adapter);
        LocationSpinner.setSelection(0);

        ArrayAdapter<String> adapterCat = new ArrayAdapter(this, android.R.layout.simple_spinner_item,  Category.values());
        adapterCat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        CategorySpinner.setAdapter(adapterCat);
        CategorySpinner.setSelection(0);
    }

    public void onViewItemDetailsFromNameCategoryOnPress(View v) {
        Model model = Model.getInstance();

        String currLoc = ((String) LocationSpinner.getSelectedItem());
        Category category = (Category) CategorySpinner.getSelectedItem();

        ArrayList<String> itemListByCategoryAndLocation = model.getInventoryByCategoryAndLocation(category, currLoc);
        model.setCurrentItemList(itemListByCategoryAndLocation);

        Intent intent = new Intent(this, ItemListActivity.class);
        startActivity(intent);
    }

    public void onItemSearchByCategoryBackOnPress(View v) {
        finish();
    }

}