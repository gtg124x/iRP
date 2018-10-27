package team1.gatech.edu.irp.model;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import team1.gatech.edu.irp.R;


import team1.gatech.edu.irp.model.CSVFile;
import team1.gatech.edu.irp.model.Location;
import team1.gatech.edu.irp.model.LocationType;
import team1.gatech.edu.irp.model.Model;
import android.view.View;
import android.widget.Toast;
import java.io.InputStream;
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
    private List<Location> locations = new ArrayList<>();;

    /**
     * array to hold string representation of locations
     */
    private List<String> locationsAsStringArray = new ArrayList<>();

    /**
     * array to hold string representation of locations with All locations as first option
     */
    private List<String> locationsAsStringArrayWithAllLocationOption = new ArrayList<>();
    private String allLocations = "All Locations";

    /****************************************************************************************
     *    LOCATION METHODS
     ****************************************************************************************
     */

    public boolean loadLocationsFromCSV(View v) {

        InputStream inputStream = v.getResources().openRawResource(R.raw.locationdata);
        CSVFile csvFile = new CSVFile(inputStream);
        ArrayList<String[]> scoreList;
        scoreList = csvFile.read();
        boolean success = true;

        for (int i = 1; i < scoreList.size(); i++) {
            Location tempLoc = new Location(Integer.parseInt(scoreList.get(i)[0]), scoreList.get(i)[1],
                    Double.parseDouble(scoreList.get(i)[2]), Double.parseDouble(scoreList.get(i)[3]),
                    scoreList.get(i)[4], scoreList.get(i)[5], scoreList.get(i)[6],
                    Integer.parseInt(scoreList.get(i)[7]), LocationType.convertType(scoreList.get(i)[8]),
                    scoreList.get(i)[9], scoreList.get(i)[10]);
            for (Location x : locations) {
                if ((x.equals(tempLoc))) {
                    success = false;
                    return success;
                }
            }
            locationsAsStringArray.add(tempLoc.toString());
            locations.add(tempLoc);

        }
        return success;
    }

    /**
     * tests whether or not the location list is empty
     *
     * @return if there are no locations entered in the app
     */
    public boolean locationListEmpty() {
        boolean success;
        if (locations.size() == 0) {
            success = true;
        } else {
            success = false;
        }
        return success;
    }



    /**
     * returns a list of locations that have been added to the app
     *
     * @return list of Location objects
     */
    public List<Location> getLocationAsLocationArray() {
        return locations;
    }

    /**
     * returns a list of locations represented as Strings that have been added to the app
     *
     * @return list of locations represented as Strings
     */
    public List<String> getLocationAsStringArray() {
        return locationsAsStringArray;
    }

    public Location convertStringToLocation(String locationString) {
        for (Location l : locations) {
            if (l.getName().equals(locationString)) {
                return l;
            }
        }
        return new Location();
    }

    /**
     * returns a list of locations represented as Strings with All locations as first option
     * that have been added to the app
     *
     * @return list of locations represented as Strings with All locations as first option
     */
    public List<String> getLocationsAsStringArrayWithAllLocationOption() {
        locationsAsStringArrayWithAllLocationOption.add(allLocations);
        locationsAsStringArrayWithAllLocationOption.addAll(locationsAsStringArray);
        return locationsAsStringArrayWithAllLocationOption;
    }

}


