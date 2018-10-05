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


    /**
     * make a new model
     */
    private Model() {
        locations = new ArrayList<>();
        locationsArray = new ArrayList<>();
        //


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


    public List<String> getLocationsArray() {
        //for (int i = 0; i < locations.size(); i++) {
          //  locationsArray.add(locations.get(i).toString());
        //}
        return locationsArray;
    }






}