package team1.gatech.edu.irp.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Account;
import team1.gatech.edu.irp.model.Model;
import team1.gatech.edu.irp.model.UserType;

import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * THIS IS OUR TOP_LEVEL WINDOW THAT THE USER FIRST SEES IN THE APPLICATION!
 *
 * An activity representing login and register options.
 *
 */
public class WelcomeActivity extends AppCompatActivity {
    public final static String DEFAULT_BINARY_FILE_NAME = "data.bin";
    private Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Model model = Model.getInstance();
        Account account = new Account("mitch", "1234", "@.", UserType.ADMIN);
        model.addAccount(account);


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
        File file;
        //create a file object in the local files section
        file = new File(this.getFilesDir(), DEFAULT_BINARY_FILE_NAME);
        //Log.d("MY APP", "Loading Binary Data");
        try {
            /*
              To read, we must use the ObjectInputStream since we want to read our model in with
              a single read.
             */
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            // assuming we saved our top level object, we read it back in with one line of code.
            model = (Model) in.readObject();
            //sm.regenMap();
            in.close();
        } catch (IOException e) {
            Log.e("UserManagementFacade", "Error reading an entry from binary file",e);
            Toast.makeText(this, "Error reading an entry from binary file.", Toast.LENGTH_SHORT).show();
        } catch (ClassNotFoundException e) {
            Log.e("UserManagementFacade", "Error casting a class from the binary file",e);
            Toast.makeText(this, "Error casting a class from the binary file.", Toast.LENGTH_SHORT).show();

        }
        //reset adapter to new data that has come in.
        //myAdapter.updateList(umf.getStudentsAsList());
        //Log.d("MY APP", "New Adaptor set");

    }

    public void onSaveDataOnPressed(View v) {
        File file;
        file = new File(this.getFilesDir(), DEFAULT_BINARY_FILE_NAME);
        try {
            /*
               For binary, we use Serialization, so everything we write has to implement
               the Serializable interface.  Fortunately all the collection classes and APi classes
               that we might use are already Serializable.  You just have to make sure your
               classes implement Serializable.

               We have to use an ObjectOutputStream to write objects.

               One thing to be careful of:  You cannot serialize static data.
             */


            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            // We basically can save our entire data model with one write, since this will follow
            // all the links and pointers to save everything.  Just save the top level object.
            out.writeObject(model);
            out.close();

        } catch (IOException e) {
            Log.e("UserManagerFacade", "Error writing an entry from binary file",e);
            Toast.makeText(this, "Error writing an entry from binary file.", Toast.LENGTH_SHORT).show();
        }
    }



}




