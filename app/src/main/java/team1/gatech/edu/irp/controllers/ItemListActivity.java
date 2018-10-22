package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Item;
import team1.gatech.edu.irp.model.Location;
import team1.gatech.edu.irp.model.Model;

public class ItemListActivity extends AppCompatActivity {
    private Spinner itemSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        Model model = Model.getInstance();

        ArrayList<String> itemList = model.getCurrentItemList();

        itemSpinner = (Spinner) findViewById(R.id.spinnerItemListing);

            /*
      Set up the adapter to display the allowable location in the spinner
     */
        ArrayAdapter<String> itemAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, itemList);
        itemAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itemSpinner.setAdapter(itemAdapter);
        itemSpinner.setSelection(0);



    }

    /**
     * Button handler for the add new donation button
     * @param view the button
     */
    public void onViewItemDetailsOnPress(View view) {
        Model model = Model.getInstance();
        ArrayList<String> itemList = model.getCurrentItemList();
        if (itemList.size() == 0) {
            Toast.makeText(this, "No Items Found In Search", Toast.LENGTH_SHORT).show();
        } else {
            String currItem = ((String) itemSpinner.getSelectedItem());
            model.setCurrentItemDetails(currItem);
            Intent intent = new Intent(this, ItemDetailsActivity.class);
            startActivity(intent);
        }
    }

    public void onItemListBackOnPress(View view) {
        finish();
    }

}
