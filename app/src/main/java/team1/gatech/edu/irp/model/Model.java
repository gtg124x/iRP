package team1.gatech.edu.irp.model;

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
public class Model {

    /**
     * Singleton instance
     */
    private static final Model _instance = new Model();
    public static Model getInstance() {
        return _instance;
    }


    /****************************************************************************************
     *    ACCOUNT ATTRIBUTES
     *    Notes: accountDataBase is just a list of account objects that are created in
     *    RegistrationActivity when the user clicks the add button. The validation of the
     *    data is done there then the Account obj is added to the accountDataBase
     ****************************************************************************************
     */

    /**
     * list of account objects
     */
    public ArrayList<Account> accountDataBase;



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
     * holds the list of all locations as a string
     */
    private List<String> locationsArray;

    /**
     * the currently selected location of the ____ spinner used for ______
     */
    private Location _currentLocation;



    /****************************************************************************************
     *    INVENTORY ATTRIBUTES
     *    Notes:
     ****************************************************************************************
     */
    private List<String> inventoryArray;



    private List<Item> inventory;
    //private List<Item> inventoryArray;
    //private List<String> inventoryAsStringArray;







    /**
     * the currently selected location, defaults to first location for Add Donation
     */
    private static Location _currentLocationAddDonation;

    /**
     * convert string to location for Add Donation Activity
     */
    private static Item _currentItemDetails;

    /**
     * make a new model
     */
    private Model() {
        locations = new ArrayList<>();
        locationsArray = new ArrayList<>();
        inventory = new ArrayList<>();
        inventoryArray = new ArrayList<>();
        accountDataBase = new ArrayList<>();

    }


    public void addToAccountDatabase(Account newAccount) {
        accountDataBase.add(newAccount);
    }

    public ArrayList<Account> getAccountDataBase() {
        return accountDataBase;
    }




    public List<Location> getLocation() {
        return locations;
    }

    public Location getCurrentLocation() {
        return _currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        for (Location l : locations) {
            if (l.toString().equals(currentLocation)) {
                _currentLocation = l;
            }
        }
    }


    public Location getCurrentLocationAddDonation() {
        return _currentLocationAddDonation;
    }

    public void setCurrentLocationAddDonation(String currentLocationAddDonation) {
        for (Location l : locations) {
            if (l.toString().equals(currentLocationAddDonation)) {
                _currentLocationAddDonation = l;
            }
        }
    }
    public List<String> getLocationsArray() {
        return locationsArray;
    }






    public Item getCurrentItemDetails() {
        return _currentItemDetails;
    }

    public void setCurrentItemDetails(String currentItemDetails) {
        for (Item item : inventory) {
            if (item.toString().equals(currentItemDetails)) {
                _currentItemDetails = item;
            }
        }
    }



    // inventory getters for String Array for Spinner
//    public List<Item> getInventoryArray() {
//        return inventory.getInventoryAsArray();
//    }
//    public List<String> getInventoryStringArray() {
//        return inventory.getInventoryAsStringArray();
//    }


    public List<Item> getInventory() { return inventory; }

    public void addToInventory(Item item) {
        inventory.add(item);
        inventoryArray.add(item.toString());
    }

    public List<String> getInventoryAsArray() {
        return inventoryArray;
    }

    public List<String> getInventoryAsStringArray() {
//        List<String> inventoryStringArray = new ArrayList<>();
//        for(Item i : inventory) {
//            inventoryStringArray.add(i.toString());
//        }
        return inventoryArray;
    }





}