package team1.gatech.edu.irp.controllers;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.GradientDrawable;
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
import android.support.constraint.ConstraintLayout;

import java.io.File;
import java.util.Random;

import android.view.MotionEvent;
import android.graphics.Color;


/**
 * THIS IS OUR TOP_LEVEL WINDOW THAT THE USER FIRST SEES IN THE APPLICATION!
 *
 * An activity representing login and register options.
 *
 *
 * @author Mitchell_Alvarado
 */
public class WelcomeActivity extends AppCompatActivity {



private ConstraintLayout cl;


    private static final String EMAIL = "email";
    CallbackManager callbackManager;
    TextView txtStatus;

    boolean FBLogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        cl = (ConstraintLayout) findViewById(R.id.background);

        AnimationDrawable aD = (AnimationDrawable)cl.getBackground();

        aD.setEnterFadeDuration(2000);

        aD.setExitFadeDuration(4000);

        aD.start();

        cl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String[] color1 = {

                        "#89216B",
                        "3c1053",
                        "4b134f",
                        "642B73",
                        "45a247",
                        "8e44ad"
                };


                String[] color2 = {

                        "#DA4453",
                        "ad5389",
                        "C6426E",
                        "159957",
                        "1CB5E0",
                        "1CB5E0"
                };

                Random random = new Random();

                GradientDrawable gb = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,
                        new int[] {Color.parseColor(color1[random.nextInt(6)]), Color.parseColor(color2[random.nextInt(6)])}
                );

                cl.setBackgroundDrawable(gb);

                return false;

            }

        });





        /**
         Facebook login code below
         */
        FacebookSdk.sdkInitialize(getApplicationContext());



        callbackManager = CallbackManager.Factory.create();

        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        txtStatus = (TextView)findViewById(R.id.txtStatus);
        loginButton.setReadPermissions(Arrays.asList(EMAIL));


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                txtStatus.setText("Login Successful\n" + loginResult.getAccessToken());
                FBLogin = true;
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

    public void onFBLoginClicked(View v) {
        if (FBLogin) {
            Intent intent = new Intent(this, AppActivity.class);
            startActivity(intent);
        }

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

    //public void onFBLoginClicked(View v) {
    //}



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




