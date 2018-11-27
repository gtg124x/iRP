package team1.gatech.edu.irp.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.PersistenceServiceFacade;

import android.view.View;
import android.content.Intent;
import android.widget.Toast;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.LoginResult;
import java.util.Arrays;

import java.io.File;


/**
 * THIS IS OUR TOP_LEVEL WINDOW THAT THE USER FIRST SEES IN THE APPLICATION!
 *
 * An activity representing login and register options.
 *
 *
 * @author Mitchell_Alvarado
 */
public class WelcomeActivity extends AppCompatActivity {

    private static final String EMAIL = "email";
    CallbackManager callbackManager;
    TextView txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_welcome);



        callbackManager = CallbackManager.Factory.create();

        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        txtStatus = (TextView)findViewById(R.id.txtStatus);
        loginButton.setReadPermissions(Arrays.asList(EMAIL));


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                txtStatus.setText("Login Successful\n" + loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                txtStatus.setText("Login Cancelled");
            }

            @Override
            public void onError(FacebookException exception) {
                txtStatus.setText("Login error: " + exception.getMessage());
            }
        });

        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }


    /**
     * When the user clicks the login button it sends them to the loginActivity
     *
     * @param v the view
     */
    public void onLoginClicked(View v) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }



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




