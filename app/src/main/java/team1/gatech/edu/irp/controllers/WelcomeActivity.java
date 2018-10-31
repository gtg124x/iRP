package team1.gatech.edu.irp.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.PersistenceManager;

import android.view.View;
import android.content.Intent;
import android.widget.Toast;
import java.io.File;


/**
 * THIS IS OUR TOP_LEVEL WINDOW THAT THE USER FIRST SEES IN THE APPLICATION!
 *
 * An activity representing login and register options.
 *
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    /**
     * When the user clicks the login button it sends them to the loginActivity
     *
     */
    public void onLoginClicked(View v) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * When the user clicks the register button it sends them to the RegistrationActivity
     *
     */
    public void onRegistrationClicked(View v) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }


    /**
     * When the user clicks the load data button it loads the saved data
     *
     */
    public void onLoadDataOnPressed(View v) {
        File file;
        file = new File(this.getFilesDir(), "data.bin");
        boolean success = PersistenceManager.loadBinary(file);
        if (success) {
            Toast.makeText(this, "Data has been loaded.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "ERROR: No saved data to load.",
                    Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * When the user clicks the save data button it saves the data
     *
     */
    public void onSaveDataOnPressed(View v) {
        File file;
        file = new File(this.getFilesDir(), "data.bin");
        boolean success =  PersistenceManager.saveBinary(file);
        if (success) {
            Toast.makeText(this, "Data has been saved.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "ERROR: Data has NOT been saved.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * When the user clicks the clear data button it erases the data
     *
     */
    public void onClearDataOnPressed(View v) {
        File file = new File(this.getFilesDir(), "data.bin");
        boolean success =  PersistenceManager.deleteBinary(file);
        if (success) {
            Toast.makeText(this, "Data has been deleted.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "ERROR: Data has NOT been deleted.",
                    Toast.LENGTH_SHORT).show();
        }
    }

}




