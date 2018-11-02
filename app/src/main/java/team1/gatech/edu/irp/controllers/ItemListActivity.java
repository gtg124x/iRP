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
import android.widget.Toast;

import java.util.List;

/**
 * Displays the list of items from the search by category/name activity
 */
public class ItemListActivity extends AppCompatActivity {
    private Spinner itemSpinner;
    private Model model;
    private int size;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        model = Model.getInstance();
        List<Item> itemListItem = model.getCurrentItemList();
        size = itemListItem.size();
        itemSpinner = findViewById(R.id.spinnerItemListing);


//      Set up the adapter to display the allowable items in the spinner
        //List<String> itemList = model.getInventoryAsString(itemListItem);

//        ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_spinner_item, itemList);
        ArrayAdapter<Item> itemAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, itemListItem);
        itemAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itemSpinner.setAdapter(itemAdapter);
        itemSpinner.setSelection(0);
    }

    /**
     * After selecting an item it displays the ItemDetailsActivity
     * @param view the button
     */
    public void onViewItemDetailsOnPress(View view) {
        model = Model.getInstance();
        //List<Item> currentItemList = model.getCurrentItemList();




        if (size == 0) {
//        if (model.isCurrentItemListEmpty()) {
            Toast.makeText(this, "No Items Found In Search",
                    Toast.LENGTH_SHORT).show();
        } else {
            //String currItem = ((String) itemSpinner.getSelectedItem());
            int selectionNumber = itemSpinner.getSelectedItemPosition();
            //List<Item> itemListItem = model.getCurrentItemList();

            //model.setSelectedItemFromItemListAndSendToItemDetails(itemListItem.get(
            // selectionNumber));

            model.setSelectedItemFromItemListAndSendToItemDetails(selectionNumber);

            Intent intent = new Intent(this, ItemDetailsActivity.class);
            startActivity(intent);
        }
    }

    /**
     * When the user presses the Back button is sends them back to search by category/name Activity
     *
     * @param view the view
     */
    public void onItemListBackOnPress(View view) {
        finish();
    }

}
