package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.CSVFile;
import team1.gatech.edu.irp.model.Location;
import team1.gatech.edu.irp.model.LocationType;
import team1.gatech.edu.irp.model.Model;


import android.util.Log;
import android.view.View;

import android.app.Activity;
import android.os.Parcelable;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class AdminActivity extends AppCompatActivity {

    //private ListView listView;
   // private ItemArrayAdapter itemArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }


    public void onLogoutClicked(View v) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    public void onViewLocationAdminOnPress(View v) {
        Intent intent = new Intent(this, LocationListActivity.class);
        startActivity(intent);
    }

    public void onLoadLocationOnPress(View v) {

        Model model = Model.getInstance();
        InputStream inputStream = getResources().openRawResource(R.raw.locationdata);
        CSVFile csvFile = new CSVFile(inputStream);
        ArrayList<String[]> scoreList;
        scoreList = csvFile.read();

        for (int i = 1; i < scoreList.size(); i++) {
                boolean duplicate = false;
                Location tempLoc = new Location(Integer.parseInt(scoreList.get(i)[0]), scoreList.get(i)[1],
                        Double.parseDouble(scoreList.get(i)[2]), Double.parseDouble(scoreList.get(i)[3]),
                        scoreList.get(i)[4], scoreList.get(i)[5], scoreList.get(i)[6],
                        Integer.parseInt(scoreList.get(i)[7]), LocationType.convertType(scoreList.get(i)[8]),
                        scoreList.get(i)[9], scoreList.get(i)[10]);
                for (Location x : model.getLocation()){
                    if ((x.equals(tempLoc))) {
                        duplicate = true;
                    }
                }
                if (duplicate) {
                    Toast.makeText(this, "Duplicate Locations will not be added.", Toast.LENGTH_SHORT).show();
                } else {
                    model.getLocationsArray().add(tempLoc.toString());
                    model.getLocation().add(tempLoc);
                    Toast.makeText(this, "Locations have been loaded.", Toast.LENGTH_SHORT).show();
                }


            }


    }

}
