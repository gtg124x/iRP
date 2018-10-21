package team1.gatech.edu.irp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//package com.javapapers.android.csvfileread.app;

import android.app.Activity;
import android.os.Parcelable;
import android.os.Bundle;
import android.widget.ListView;
import java.io.InputStream;
import java.util.List;


/**
 * Created by mitchellalvarado on 9/20/18.
 *
 * This is our facade to the Model.  We are using a Singleton design pattern to allow
 * access to the model from each controller.
 *
 *
 */
public class Model implements Serializable {

    /**
     * Singleton instance
     */
    private static final Model _instance = new Model();
    public static Model getInstance() {
        return _instance;
    }

    /**
     *  holds the accounts
     */
    private AccountManager accountManager;

    /****************************************************************************************
     *    LIST OF LOCATIONS ATTRIBUTES                                                    ***
     *    Notes: I created both a list of location obj and of strings because the         ***
     *    spinner displays the string description of a location. Both of these are        ***
     *    initialized in the AdminActivity Class when an admin hits the load              ***
     *    locations button.  The CSVFile class used and the data is parsed and            ***
     *    locations are created.                                                          ***
     ****************************************************************************************
     */

    /**
     * holds the list of all locations
     */
    private List<Location> locations;

    /**
     * array to hold string representation of locations
     */
    private List<String> locationsArray;


    /****************************************************************************************
     *    INVENTORY ATTRIBUTES
     *    Notes: Same as locations, I created two arrays one to hold Item obj and one to hold
     *    the toString of the obj for display on the spinner
     ****************************************************************************************
     */

    /**
     * holds the items that are donated
     */
    private List<Item> inventory;

    /**
     * array to hold string representation of item in inventory
     */
    private List<String> inventoryArray;



    /****************************************************************************************
     *    PASS THROUGH VALUES FROM SPINNERS TO OTHER ACTIVITY PAGES
     ****************************************************************************************
     */

    /**
     * the currently selected location of the LocationListActivity
     */
    private Location _currentLocation;

    /**
     * the currently selected location, defaults to first location for AddDonationActivity
     */
    private Location _currentLocationAddDonation;

    /**
     * convert string to location for LocationDetailActivity
     */
    private Item _currentItemDetails;

    /**
     * make a new model
     */
    private Model() {
        locations = new ArrayList<>();
        locationsArray = new ArrayList<>();
        inventory = new ArrayList<>();
        inventoryArray = new ArrayList<>();
        accountManager = new AccountManager();

    }

    /****************************************************************************************
     *    ACCOUNT MANAGER METHODS
     ****************************************************************************************
     *
     */

    /**
     * a list of the accounts
     *
     *  @return a list of Account objects
     */
    public ArrayList<Account> getAccounts() { return accountManager.getAccounts(); }

    /**
     * adds and account to the list of the accounts
     *
     *  @param account a user account
     */
    public void addAccount(Account account) { accountManager.addToAccounts(account);}


    /****************************************************************************************
     *    LOCATION METHODS
     ****************************************************************************************
     */

    /**
     * returns a list of locations that have been added to the app
     *
     * @return list of Location objects
     */
    public List<Location> getLocation() {
        return locations;
    }

    /**
     * returns a list of locations represented as Strings that have been added to the app
     *
     * @return list of locations represented as Strings
     */
    public List<String> getLocationsArray() {
        return locationsArray;
    }


    /****************************************************************************************
     *    INVENTORY METHODS
     ****************************************************************************************
     */

    /**
     * adds an item to the inventory
     *
     * @param item a donated item at a location
     */
    public void addToInventory(Item item) {
        inventory.add(item);
        inventoryArray.add(item.toString());
    }

    /**
     * returns a list of items that have been added to the app
     *
     * @return list of Item objects
     */
    public List<Item> getInventory() { return inventory; }

    /**
     * returns a list of items represented as Strings that have been added to the app
     *
     * @return list of items represented as Strings
     */
    public List<String> getInventoryAsStringArray() {
        return inventoryArray;
    }



    /****************************************************************************************
     *    PASS THROUGH METHODS TO PASS VALUES FROM SPINNERS TO OTHER ACTIVITY PAGES
     ****************************************************************************************
     */


    /**
     * passes through the selected Location on the LocationListActivity spinner
     *
     * @return the currently selected location of the LocationListActivity
     */
    public Location getCurrentLocation() {
        return _currentLocation;
    }

    /**
     * sets the selected Location on the LocationListActivity spinner
     *
     * @param currentLocation the currently selected location on the LocationListActivity spinner
     */
    public void setCurrentLocation(String currentLocation) {
        for (Location l : locations) {
            if (l.toString().equals(currentLocation)) {
                _currentLocation = l;
            }
        }
    }

    /**
     * passes through the selected Location on the AddDonationActivity spinner
     *
     * @return the currently selected location of the AddDonationActivity
     */
    public Location getCurrentLocationAddDonation() {
        return _currentLocationAddDonation;
    }

    /**
     * sets the selected Location on the AddDonationActivity spinner
     *
     * @param currentLocationAddDonation the currently selected location on the AddDonationActivity spinner
     */
    public void setCurrentLocationAddDonation(String currentLocationAddDonation) {
        for (Location l : locations) {
            if (l.toString().equals(currentLocationAddDonation)) {
                _currentLocationAddDonation = l;
            }
        }
    }

    /**
     * passes through the selected Item on the LocationDetailActivity spinner
     *
     * @return the currently selected item of the LocationDetailActivity
     */
    public Item getCurrentItemDetails() {
        return _currentItemDetails;
    }

    /**
     * sets the selected item on the LocationDetailActivity spinner
     *
     * @param currentItemDetails the currently selected item on the LocationDetailActivity spinner
     */
    public void setCurrentItemDetails(String currentItemDetails) {
        for (Item item : inventory) {
            if (item.toString().equals(currentItemDetails)) {
                _currentItemDetails = item;
            }
        }
    }


}