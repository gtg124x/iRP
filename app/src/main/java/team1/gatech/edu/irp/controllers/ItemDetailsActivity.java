package team1.gatech.edu.irp.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Model;
import android.view.View;
import android.widget.TextView;

/**
 * Screen that displays the details of an item
 */
public class ItemDetailsActivity extends AppCompatActivity {



    /**
     * displays the details of an item
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        Model model = Model.getInstance();

        String timeStamp = model.getCurrentItemDetails().getTimeStamp();
        String dateStamp = model.getCurrentItemDetails().getDateStamp();
        String location = model.getCurrentItemDetails().getLocation().toString();
        String category = model.getCurrentItemDetails().getCategory().toString();
        String value = model.getCurrentItemDetails().getDollarValue();
        String shortDescription = model.getCurrentItemDetails().getShortDescription();
        String fullDescription = model.getCurrentItemDetails().getFullDescription();



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
     */
    public void onBackItemDetailsOnPress(View v) {
        finish();
    }


}

