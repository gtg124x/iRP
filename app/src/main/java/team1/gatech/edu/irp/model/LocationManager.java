package team1.gatech.edu.irp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LocationManager implements Serializable {

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
    private ArrayList<Location> locations = new ArrayList<>();;

    /**
     * array to hold string representation of locations
     */
    private ArrayList<String> locationsArray = new ArrayList<>();

    /****************************************************************************************
     *    LOCATION METHODS
     ****************************************************************************************
     */

    /**
     * returns a list of locations that have been added to the app
     *
     * @return list of Location objects
     */
    public ArrayList<Location> getLocationArray() {
        return locations;
    }

    /**
     * returns a list of locations represented as Strings that have been added to the app
     *
     * @return list of locations represented as Strings
     */
    public ArrayList<String> getLocationStringArray() {
        return locationsArray;
    }



}
