package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import team1.gatech.edu.irp.model.Account;
import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Model;
import team1.gatech.edu.irp.model.UserType;
import android.widget.AdapterView;
import android.widget.Toast;

import java.io.File;


public class RegistrationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView loginName;
    private TextView password;
    private TextView contactInfo;
    private Spinner userTypeSpinner;
    private Account account;
    private String userT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        /**
         * Grab the dialog widgets so we can get info for later
         */
        loginName = (TextView) findViewById(R.id.loginNameText);
        password = (TextView) findViewById(R.id.passwordText);
        contactInfo = (TextView) findViewById(R.id.contactInfoText);
        userTypeSpinner = (Spinner) findViewById(R.id.SpinnerUT);


    /*
      Set up the adapter to display the allowable class standing in the spinner
     */
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, UserType.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userTypeSpinner.setAdapter(adapter);


    }

    /**
     * Button handler for the add new user button
     * @param view the button
     */
    public void onAddPressed(View view) {
        Model model = Model.getInstance();
        String name = loginName.getText().toString();
        String pword = password.getText().toString();
        String cInfo = contactInfo.getText().toString();
        UserType userTypeEnum = (UserType) userTypeSpinner.getSelectedItem();
        if (name.length() < 4) {
            Toast.makeText(this, "User Name must be at least 4 characters long.", Toast.LENGTH_SHORT).show();
        } else if (userNameIsTaken(name)) {
            Toast.makeText(this, "User Name is already taken.", Toast.LENGTH_SHORT).show();
        } else if (pword.length() < 4) {
            Toast.makeText(this, "Password must be at least 4 characters long.", Toast.LENGTH_SHORT).show();
        } else if (!cInfo.contains("@") || !cInfo.contains(".")) {
            Toast.makeText(this, "Must Enter Valid Email Address.", Toast.LENGTH_SHORT).show();
        } else {
            account = new Account(name, pword, cInfo, userTypeEnum);
            model.addAccount(account);





                Toast.makeText(this, "Account Created.", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, WelcomeActivity.class);
                startActivity(intent);


            //} else {

                //Toast.makeText(this, "Account Not Added.", Toast.LENGTH_SHORT).show();
            //}

        }
    }

    /**
     * Button handler for cancel
     *
     * @param view the button pressed
     */
    public void onCancelPressed(View view) {
        finish();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        userT = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        userT = "User";
    }


    public boolean userNameIsTaken(String uName) {
        Model model = Model.getInstance();
        for (int i = 0; i < model.getAccounts().size(); i++) {
            if (!(model.getAccounts().get(i) == null)) {
                //return false;
                //}
                String Lname = model.getAccounts().get(i).getUserName();
                if (uName.equals(Lname)) {
                    return true;
                }
            }
        }
        return false;
    }


}
