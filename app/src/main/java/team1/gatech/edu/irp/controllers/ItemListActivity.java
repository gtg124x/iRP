package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Item;
import team1.gatech.edu.irp.model.ItemServiceFacade;

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
    private int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        ItemServiceFacade itemServiceFacade = ItemServiceFacade.getInstance();
        List<Item> itemListItem = getCurrentListOfItems(itemServiceFacade);
        size = itemListItem.size();
        itemSpinner = findViewById(R.id.spinnerItemListing);


//      Set up the adapter to display the allowable items in the spinner
        ArrayAdapter<Item> itemAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, itemListItem);
        itemAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itemSpinner.setAdapter(itemAdapter);
        itemSpinner.setSelection(0);
    }


    /**
     * gets the current list of items
     *
     * @param itemServiceFacade the itemServiceFacade
     * @return current list of items
     */
    private List<Item> getCurrentListOfItems(ItemServiceFacade itemServiceFacade) {
        return itemServiceFacade.getCurrentItemList();
    }

    /**
     * After selecting an item it displays the ItemDetailsActivity
     * @param view the button
     */
    public void onViewItemDetailsOnPress(View view) {
        ItemServiceFacade itemServiceFacade = ItemServiceFacade.getInstance();
        if (size == 0) {
            Toast.makeText(this, "No Items Found In Search",
                    Toast.LENGTH_SHORT).show();
        } else {
            int selectionNumber = itemSpinner.getSelectedItemPosition();

            getCurrentListOfItems(itemServiceFacade, selectionNumber);
            Intent intent = new Intent(this, ItemDetailsActivity.class);
            startActivity(intent);
        }
    }

    /**
     * sets the Selected Item From Item List And Sends it To ItemDetails
     *
     * @param itemServiceFacade the itemServiceFacade
     * @param selectionNumber the index of the selected Item
     */
    private void getCurrentListOfItems(ItemServiceFacade itemServiceFacade, int selectionNumber) {
        itemServiceFacade.setSelectedItemFromItemListAndSendToItemDetails(selectionNumber);
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
