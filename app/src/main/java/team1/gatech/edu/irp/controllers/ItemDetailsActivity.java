package team1.gatech.edu.irp.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.ItemServiceFacade;
import android.view.View;
import android.widget.TextView;

import java.util.List;

/**
 * Screen that displays the details of an item
 *
 * @author Mitchell_Alvarado
 */
public class ItemDetailsActivity extends AppCompatActivity {

    /**
     * displays the details of an item
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        ItemServiceFacade itemServiceFacade = ItemServiceFacade.getInstance();
        List<String> itemString = getSelectedItem(itemServiceFacade);

        String timeStamp = itemString.get(0);
        String dateStamp = itemString.get(1);
        String location = itemString.get(2);
        String category = itemString.get(3);
        String value = itemString.get(4);
        String shortDescription = itemString.get(5);
        String fullDescription = itemString.get(6);

        TextView timeStampField = findViewById(R.id.TimeStampText);
        timeStampField.setText(timeStamp);

        TextView dateStampField = findViewById(R.id.DateStampText);
        dateStampField.setText(dateStamp);

        TextView locationField = findViewById(R.id.LocationText);
        locationField.setText(location);

        TextView categoryField = findViewById(R.id.CategoryText);
        categoryField.setText(category);

        TextView valueField = findViewById(R.id.ValueText);
        String moneySignAndValue = "$ " + value;
        valueField.setText(moneySignAndValue);

        TextView shortDescriptionField = findViewById(R.id.ShortDescriptionText);
        shortDescriptionField.setText(shortDescription);

        TextView fullDescriptionField = findViewById(R.id.FullDescriptionText);
        fullDescriptionField.setText(fullDescription);


    }

    /**
     * When the user presses the Back button is sends them back the LocationDetailsActivity
     *
     * @param v the view
     */
    public void onBackItemDetailsOnPress(View v) {
        finish();
    }

    /**
     * gets the selected item from the model and returns the details
     *
     * @param itemServiceFacade the itemServiceFacade
     * @return item details
     */
    private List<String> getSelectedItem(ItemServiceFacade itemServiceFacade) {
        return itemServiceFacade.getSelectedItemFromItemListAndSendToItemDetails();
    }


}

