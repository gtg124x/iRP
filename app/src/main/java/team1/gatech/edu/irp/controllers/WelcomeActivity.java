package team1.gatech.edu.irp.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.PersistenceServiceFacade;

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
     * @param v the view
     */
    public void onLoginClicked(View v) {
        Intent intent = new Intent(this, LoginAdministratorActivity.class);
        startActivity(intent);
    }

    //    /**
//     * When the user clicks the login button it sends them to the loginActivity
//     *
//     * @param v the view
//     */
//    public void onLoginAdministratorClicked(View v) {
//        Intent intent = new Intent(this, LoginAdministratorActivity.class);
//        startActivity(intent);
//    }
//
//    /**
//     * When the user clicks the login button it sends them to the loginActivity
//     *
//     * @param v the view
//     */
//    public void onLoginLocalEmployeeClicked(View v) {
//        Intent intent = new Intent(this, LoginLocalEmployeeActivity.class);
//        startActivity(intent);
//    }
//
//    /**
//     * When the user clicks the login button it sends them to the loginActivity
//     *
//     * @param v the view
//     */
//    public void onLoginManagerClicked(View v) {
//        Intent intent = new Intent(this, LoginManagerActivity.class);
//        startActivity(intent);
//    }
//
//    /**
//     * When the user clicks the login button it sends them to the loginActivity
//     *
//     * @param v the view
//     */
//    public void onLoginUserClicked(View v) {
//        Intent intent = new Intent(this, LoginUserActivity.class);
//        startActivity(intent);
//    }

    /**
     * When the user clicks the register button it sends them to the RegistrationActivity
     *
     * @param v the view
     */
    public void onRegistrationClicked(View v) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }


    /**
     * When the user clicks the load data button it loads the saved data
     *
     * @param v the view
     */
    public void onLoadDataOnPressed(View v) {
        PersistenceServiceFacade persistenceServiceFacade = PersistenceServiceFacade.getInstance();
        File file;
        file = new File(this.getFilesDir(), "data.bin");
        boolean success = load(persistenceServiceFacade, file);
        if (success) {
            Toast.makeText(this, "Data has been loaded.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "ERROR: No saved data to load.",
                    Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * load binary file
     *
     * @param persistenceServiceFacade the persistenceServiceFacade
     * @return success
     */
    private boolean load(PersistenceServiceFacade persistenceServiceFacade, File file) {
        return persistenceServiceFacade.loadBinary(file);
    }

    /**
     * When the user clicks the save data button it saves the data
     *
     * @param v the view
     */
    public void onSaveDataOnPressed(View v) {
        PersistenceServiceFacade persistenceServiceFacade = PersistenceServiceFacade.getInstance();
        File file;
        file = new File(this.getFilesDir(), "data.bin");
        boolean success = save(persistenceServiceFacade, file);
        if (success) {
            Toast.makeText(this, "Data has been saved.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "ERROR: Data has NOT been saved.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * save binary file
     *
     * @param persistenceServiceFacade the persistenceServiceFacade
     * @return success
     */
    private boolean save(PersistenceServiceFacade persistenceServiceFacade, File file) {
        return persistenceServiceFacade.saveBinary(file);
    }

    /**
     * When the user clicks the clear data button it erases the data
     *
     * @param v the view
     */
    public void onClearDataOnPressed(View v) {
        PersistenceServiceFacade persistenceServiceFacade = PersistenceServiceFacade.getInstance();
        File file = new File(this.getFilesDir(), "data.bin");
        boolean success = clear(persistenceServiceFacade, file);
        if (success) {
            Toast.makeText(this, "Data has been deleted.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "ERROR: Data has NOT been deleted.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * clear binary file
     *
     * @param persistenceServiceFacade the persistenceServiceFacade
     * @return success
     */
    private boolean clear(PersistenceServiceFacade persistenceServiceFacade, File file) {
        return persistenceServiceFacade.deleteBinary(file);
    }

}




