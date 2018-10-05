package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.CSVFile;


import android.util.Log;
import android.view.View;

import android.app.Activity;
import android.os.Parcelable;
import android.os.Bundle;
import android.widget.ListView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class AdminActivity extends AppCompatActivity {

    private ListView listView;
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

        InputStream inputStream = getResources().openRawResource(R.raw.locationdata);
        CSVFile csvFile = new CSVFile(inputStream);
        ArrayList<String[]> scoreList;
        scoreList = csvFile.read();

        for(String[] scoreData: scoreList ) {
            for (int i = 0; i < scoreData.length; i++) {
                Log.d("Edit", "" + scoreData[i] );
            }

        }


    }

}
