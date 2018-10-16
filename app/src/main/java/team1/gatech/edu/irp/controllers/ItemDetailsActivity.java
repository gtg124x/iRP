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
import team1.gatech.edu.irp.model.Model;

public class ItemDetailsActivity extends AppCompatActivity {

    private TextView timeStampField;
    private TextView dateStampField;
    private TextView locationField;
    private TextView categoryField;
    private TextView valueField;
    private TextView shortDescriptionField;
    private TextView fullDescriptionField;


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
        String shortDescription = model.getCurrentItemDetails().getShortDescripiton();
        String fullDescription = model.getCurrentItemDetails().getFullDescripiton();


        timeStampField = (TextView) findViewById(R.id.TimeStampText);
        timeStampField.setText(timeStamp);

        dateStampField = (TextView) findViewById(R.id.DateStampText);
        dateStampField.setText(dateStamp);

        locationField = (TextView) findViewById(R.id.LocationText);
        locationField.setText(location);

        categoryField = (TextView) findViewById(R.id.CategoryText);
        categoryField.setText(category);

        valueField = (TextView) findViewById(R.id.ValueText);
        valueField.setText("$" + value);

        shortDescriptionField = (TextView) findViewById(R.id.ShortDecriptionText);
        shortDescriptionField.setText(shortDescription);

        fullDescriptionField = (TextView) findViewById(R.id.FullDecriptionText);
        fullDescriptionField.setText(fullDescription);


    }

    public void onBackItemDetailsOnPress(View v) {
        finish();
    }


}
