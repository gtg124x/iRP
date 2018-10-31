package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Model;
import team1.gatech.edu.irp.model.RegistrationResultENUM;
import team1.gatech.edu.irp.model.UserTypeENUM;
import android.widget.Toast;


/**
 * Account Registration Screen
 */
public class RegistrationActivity extends AppCompatActivity {
        //implements AdapterView.OnItemSelectedListener {

    private TextView loginName;
    private TextView password;
    private TextView contactInfo;
    private Spinner userTypeSpinner;
    //private String userT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

//        /**
//         * Grab the dialog widgets so we can get info for later
//         */
        loginName = findViewById(R.id.loginNameText);
        password = findViewById(R.id.passwordText);
        contactInfo = findViewById(R.id.contactInfoText);
        userTypeSpinner = findViewById(R.id.SpinnerUT);


//        /**
//         * Set up the adapter to display the allowable class standing in the spinner
//         */
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, UserTypeENUM.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userTypeSpinner.setAdapter(adapter);
    }

    /**
     * Button handler for the add new user button
     * Passes the user input to the model. Model passes it to the AccountManager for
     * validation and account creation. The result is passed back in the form of an enum inorder to
     * display the correct error and guide the user to a successful registration
     *
     * @param view the button
     */
    public void onAddPressed(View view) {
        Model model = Model.getInstance();
        String name = loginName.getText().toString();
        String pword = password.getText().toString();
        String cInfo = contactInfo.getText().toString();
        UserTypeENUM userTypeEnum = (UserTypeENUM) userTypeSpinner.getSelectedItem();

        RegistrationResultENUM registrationResult = model.addAccount(name, pword, cInfo, userTypeEnum);

        if (registrationResult == RegistrationResultENUM.NAME_INVALID) {
            Toast.makeText(this, "User Name must be at least 4 characters long.", Toast.LENGTH_SHORT).show();
        } else if (registrationResult == RegistrationResultENUM.NAME_TAKEN) {
            Toast.makeText(this, "User Name is already taken.", Toast.LENGTH_SHORT).show();
        } else if (registrationResult == RegistrationResultENUM.PASSWORD_INVALID) {
            Toast.makeText(this, "Password must be at least 4 characters long.", Toast.LENGTH_SHORT).show();
        } else if (registrationResult == RegistrationResultENUM.EMAIL_INVALID) {
            Toast.makeText(this, "Must Enter Valid Email Address.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Account Created.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, WelcomeActivity.class);
            startActivity(intent);
        }
    }

    /**
     * Sends them back to the Welcome Screen
     *
     * @param view the view
     */
    public void onCancelPressed(View view) {
        finish();
    }


//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//        userT = parent.getItemAtPosition(position).toString();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//        userT = "User";
//    }
//
//



}
