package team1.gatech.edu.irp.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Account;
import team1.gatech.edu.irp.model.Model;
import team1.gatech.edu.irp.model.UserType;

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
    private Model model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        model = Model.getInstance();

        // hack to get into app before persistence data
        Account admin = new Account("mitch", "1234", "@.", UserType.ADMIN);
        model.addAccount(admin);

    }

    public void onLoginClicked(View v) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void onRegistrationClicked(View v) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    public void onLoadDataOnPressed(View v) {
        model = model.getInstance();
        File file;
        file = new File(this.getFilesDir(), model.DEFAULT_BINARY_FILE_NAME);
        boolean success = model.loadBinary(file);
        if (success) {
            Toast.makeText(this, "Data has been loaded.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "ERROR: No saved data to load.", Toast.LENGTH_SHORT).show();
        }

    }

    public void onSaveDataOnPressed(View v) {
        model = model.getInstance();
        File file;
        file = new File(this.getFilesDir(), model.DEFAULT_BINARY_FILE_NAME);
        boolean success =  model.saveBinary(file);
        if (success) {
            Toast.makeText(this, "Data has been saved.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "ERROR: Data has NOT been saved.", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClearDataOnPressed(View v) {
        model = model.getInstance();
        File file;
        file = new File(this.getFilesDir(), model.DEFAULT_BINARY_FILE_NAME);
        boolean success =  model.deleteBinary(file);
        if (success) {
            Toast.makeText(this, "Data has been deleted.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "ERROR: Data has NOT been deleted.", Toast.LENGTH_SHORT).show();
        }
    }


}




