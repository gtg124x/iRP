package team1.gatech.edu.irp.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import team1.gatech.edu.irp.model.Account;
import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.AccountDataBase;
import team1.gatech.edu.irp.model.UserType;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;






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
        String name = loginName.getText().toString();
        String pword = password.getText().toString();
        String cInfo = contactInfo.getText().toString();
        UserType userTypeEnum = (UserType) userTypeSpinner.getSelectedItem();

        account = new Account(name, pword, cInfo, userTypeEnum);
        AccountDataBase.addToAccountDatabase(account);
        finish();
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
        userT = "Admin";
    }





}
