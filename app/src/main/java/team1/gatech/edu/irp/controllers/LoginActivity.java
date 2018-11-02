package team1.gatech.edu.irp.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;
import team1.gatech.edu.irp.R;
import android.view.View;
import team1.gatech.edu.irp.model.Model;
import team1.gatech.edu.irp.model.UserTypeENUM;
import android.content.Intent;
import android.widget.Toast;

/**
 * The login Screen
 */
public class LoginActivity extends AppCompatActivity {

    private TextView userName;
    private TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        /**
//         * Grab the dialog widgets so we can get info for later
//         */
        userName = findViewById(R.id.UserName_Input);
        password = findViewById(R.id.Password_Input);

    }


    /**
     * Cancel Button Handler.
     * Return to previous screen when pressed
     *
     * @param v the view
     */
    public void onCancelLoginPressed(View v) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    /**
     * Login Button Handler.
     * Valid the login and get the user type to determine which screen to navigate towards
     * Grabs the user input and sends it to model for verification.
     *
     * @param v the view
     */
    public void onLoginPressed(View v) {
        Model model = Model.getInstance();

        CharSequence nameChar = userName.getText();

        String name = nameChar.toString();
        String passwordString = password.getText() + "";

//        UserTypeENUM userType = model.validateLogin(name, passwordString);
        UserTypeENUM userType = validateLoginToModel(model, name, passwordString);


        if (userType != null) {
            if (userType == UserTypeENUM.ADMIN) {
                Intent intent = new Intent(this, AdminActivity.class);
                startActivity(intent);
            } else if (userType == UserTypeENUM.LOCAL_EMPLOYEE) {
                Intent intent = new Intent(this, LocalEmployeeActivity.class);
                startActivity(intent);
            } else if (userType == UserTypeENUM.MANAGER) {
                Intent intent = new Intent(this, ManagerActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, AppActivity.class);
                startActivity(intent);
            }
        } else {
            Toast.makeText(this, "Invalid Username/Password combination",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * send selected item to details page
     *
     * @param model the model
     * @param name the name
     * @param passwordString password
     * @return the User Type
     */
    private UserTypeENUM validateLoginToModel(Model model, String name, String passwordString) {
        return model.validateLogin(name, passwordString);
    }

}
