package team1.gatech.edu.irp.controllers;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.support.design.widget.TextInputEditText;
import android.widget.TextView;


import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Location;
import team1.gatech.edu.irp.model.LocationDataBase;
import team1.gatech.edu.irp.model.Model;




public class LocationDetailsActivity extends AppCompatActivity {

    private TextView nameField;
    private Location location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_details);

        Model model = Model.getInstance();
        String name = model.getCurrentLocation().getName();

        //Log.d("Edit", " " + name);
        //nameField.setText(name);






        nameField = (TextView) findViewById(R.id.LocationNameText);


        //nameField.setText("Hi");
        nameField.setText(name);
    }


}

