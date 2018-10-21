package team1.gatech.edu.irp.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;
import team1.gatech.edu.irp.R;
import android.view.View;

import team1.gatech.edu.irp.model.Model;
import team1.gatech.edu.irp.model.UserType;

import android.content.Intent;
import android.widget.Toast;

import java.io.File;


public class LoginActivity extends AppCompatActivity {

    private TextView userName;
    private TextView password;
    private UserType userType = UserType.USER;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /**
         * Grab the dialog widgets so we can get info for later
         */
        userName = (TextView) findViewById(R.id.UserName_Input);
        password = (TextView) findViewById(R.id.Password_Input);

    }



    public void onCancelLoginPressed(View v) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    public void onLoginPressed(View v) {
        String name = userName.getText().toString();
        String pword = password.getText().toString();


        if (validateLogin(name, pword)) {
            if (userType == UserType.ADMIN) {
                Intent intent = new Intent(this, AdminActivity.class);
                startActivity(intent);
            } else if (userType == UserType.LOCALEMPLOYEE) {
                Intent intent = new Intent(this, LocalEmployeeActivity.class);
                startActivity(intent);
            } else if (userType == UserType.MANAGER) {
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

    public boolean validateLogin(String uName, String password) {
        Model model = Model.getInstance();
        if (uName.length() == 0 || password.length() == 0) {
            return false;
        }
        for (int i = 0; i < model.getAccounts().size(); i++) {
            if (model.getAccounts().get(i) == null) {
                return false;
            }
            String Lname = model.getAccounts().get(i).getUserName();
            String pword = model.getAccounts().get(i).getPassword();
            if (uName.equals(Lname) && password.equals(pword)) {
                userType = model.getAccounts().get(i).getUserType();
                return true;
            }
        }
        return false;
    }


}
