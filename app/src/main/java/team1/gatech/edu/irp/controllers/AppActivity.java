package team1.gatech.edu.irp.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team1.gatech.edu.irp.R;
import team1.gatech.edu.irp.model.Model;
import android.view.View;
import android.widget.Toast;

/**
 * User home screen that appears after login
 */
public class AppActivity extends AppCompatActivity {

    private Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

    }

    /**
     * When the Logout Button is pressed it sends the user back to the welcome screen
     *
     * @param v the view
     */
    public void onLogoutClicked(View v) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    /**
     * When the View Locations Button is pressed it sends the user to the a screen that displays the locations in a spinner
     *
     * @param v the view
     */
    public void onViewLocationUserOnPress(View v) {
        model = Model.getInstance();
        if (model.noLocations()) {
            Toast.makeText(this, "No Locations have been loaded by Admin.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, LocationListActivity.class);
            startActivity(intent);
        }
    }

    /**
     * When the Search By Name Button is pressed is sends you to a screen where the user can search the inventory by name
     *
     * @param v the view
     */
    public void onItemSearchByNameOnPress(View v) {
        Intent intent = new Intent(this, ItemSearchByNameActivity.class);
        startActivity(intent);
    }

    /**
     * When the Search By Category Button is pressed is sends you to a screen where the user can search the inventory by category
     *
     * @param v the view
     */
    public void onItemSearchByCategoryOnPress(View v) {
        Intent intent = new Intent(this, ItemSearchByCategoryActivity.class);
        startActivity(intent);
    }
}
