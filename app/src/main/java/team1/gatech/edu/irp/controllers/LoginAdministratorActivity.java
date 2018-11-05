package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.AccountServiceFacade;
import team1.gatech.edu.irp.model.UserTypeENUM;

/**
 * The Administrator login Screen
 */
public class LoginAdministratorActivity extends AppCompatActivity {

    private TextView userName;
    private TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_administrator);

//        /**
//         * Grab the dialog widgets so we can get info for later
//         */
        userName = findViewById(R.id.userName_Input_Admin);
        password = findViewById(R.id.textPassword_Input_Admin);

    }

    /**
     * Cancel Button Handler.
     * Return to previous screen when pressed
     *
     * @param v the view
     */
    public void onAdministratorCancelPressed(View v) {
//        Intent intent = new Intent(this, WelcomeActivity.class);
//        startActivity(intent);
        finish();
    }

    /**
     * Login Button Handler.
     * Valid the login and get the user type to determine which screen to navigate towards
     * Grabs the user input and sends it to model for verification.
     *
     * @param v the view
     */
    public void onAdministratorLoginPressed(View v) {
        CharSequence nameChar = userName.getText();

        String name = nameChar.toString();
        String passwordString = password.getText() + "";

        if (validateLoginToModelAdmin(name, passwordString)) {
            //if (validateAdmin()) {
                Intent intent = new Intent(this, AdminActivity.class);
                startActivity(intent);
            //}
        } else {
            Toast.makeText(this, "Invalid Username/Password combination",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * send selected item to details page
     *
     * @param name the name
     * @param passwordString password
     * @return the User Type
     */
    private boolean validateLoginToModelAdmin(String name, String passwordString) {
        AccountServiceFacade accountServiceFacade = AccountServiceFacade.getInstance();
        return accountServiceFacade.validateLoginAdmin(name, passwordString);
    }









}
