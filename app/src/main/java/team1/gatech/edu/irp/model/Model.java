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

    /**
     * the currently selected location, defaults to first course
     */
    private static Location _currentLocation;

    /**
     * holds the list of all locations
     */
    private static List<Location> locations;

    //public static List<String> locationsArray = Arrays.asList((new Location()).toString());
    private static List<String> locationsArray;

    //= Arrays.asList((new Location()).toString());
    private static Inventory inventory;
    private static List<Item> inventoryArray;
    private static List<String> inventoryAsStringArray;

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
        inventory = new Inventory();

    }

    public List<Location> getLocation() {
        return locations;
    }
    public Inventory getInventory() { return inventory;
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

    public Item getCurrentItemDetails() {
        return _currentItemDetails;
    }

    public void setCurrentItemDetails(String currentItemDetails) {
        for (Item item : inventory.getInventoryAsArray()) {
            if (item.toString().equals(currentItemDetails)) {
                _currentItemDetails = item;
            }
        }
    }

    public List<String> getLocationsArray() {
        //for (int i = 0; i < locations.size(); i++) {
          //  locationsArray.add(locations.get(i).toString());
        //}
        return locationsArray;
    }

    public List<Item> getInventoryArray() {
        return inventory.getInventoryAsArray();
    }

    public List<String> getInventoryStringArray() {
        return inventory.getInventoryAsStringArray();
    }



}