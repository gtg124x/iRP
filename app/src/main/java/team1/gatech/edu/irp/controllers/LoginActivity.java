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
     */
    public void onCancelLoginPressed(View v) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    /**
     * Login Button Handler.
     * Valid the login and get the user type to determine which screen to navigate towards
     * Graps the user input and sends it to model for verification.
     */
    public void onLoginPressed(View v) {
        Model model = Model.getInstance();

        String name = userName.getText().toString();
        String pword = password.getText().toString();

        if (model.validateLogin(name, pword)) {
            UserTypeENUM userType = model.getUserType(name);
            if (userType == UserTypeENUM.ADMIN) {
                Intent intent = new Intent(this, AdminActivity.class);
                startActivity(intent);
            } else if (userType == UserTypeENUM.LOCALEMPLOYEE) {
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
            Toast.makeText(this, "Invalid Username/Password combination", Toast.LENGTH_SHORT).show();
        }
    }

}
