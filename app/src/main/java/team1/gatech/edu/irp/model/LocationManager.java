package team1.gatech.edu.irp.model;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import team1.gatech.edu.irp.R;

import android.content.res.Resources;
import android.view.View;

/**
 *
 * @author Mitchell_Alvarado
 */
class LocationManager implements Serializable {

//    /****************************************************************************************
//     *    LIST OF LOCATIONS ATTRIBUTES                                                    ***
//     *    Notes: I created both a list of location obj and of strings because the         ***
//     *    spinner displays the string description of a location. Both of these are        ***
//     *    initialized in the AdminActivity Class when an admin hits the load              ***
//     *    locations button.  The CSVFile class used and the data is parsed and            ***
//     *    locations are created.                                                          ***
//     ****************************************************************************************
//     */

    /**
     * holds the list of all locations
     */
    private final List<Location> locations = new ArrayList<>();

//    /**
//     * array to hold string representation of locations
//     */
//    private List<String> locationsAsStringArray;


    /****************************************************************************************
     *    LOCATION METHODS
     ****************************************************************************************
     */

    public boolean loadLocationsFromCSV(View v) {
        Resources resources = v.getResources();
        InputStream inputStream = resources.openRawResource(R.raw.locationdata);

        CSVFile csvFile = new CSVFile(inputStream);
        List<String[]> scoreList;
        scoreList = csvFile.read();

        for (int i = 1; i < scoreList.size(); i++) {
            Location tempLoc = new Location(Integer.parseInt(scoreList.get(i)[0]),
                    scoreList.get(i)[1],
                    Double.parseDouble(scoreList.get(i)[2]),
                    Double.parseDouble(scoreList.get(i)[3]),
                    scoreList.get(i)[4], scoreList.get(i)[5], scoreList.get(i)[6],
                    Integer.parseInt(scoreList.get(i)[7]),
                    LocationTypeEnum.convertType(scoreList.get(i)[8]),
                    scoreList.get(i)[9], scoreList.get(i)[10]);
            for (Location x : locations) {
                if ((x.equals(tempLoc))) {
                    //success = false;
                    return false;
                }
            }
            locations.add(tempLoc);

        }
        return true;
    }

    /**
     * tests whether or not the location list is empty
     *
     * @return if there are no locations entered in the app
     */
    public boolean locationListEmpty() {
        return (locations.isEmpty());
    }

    /**
     * returns a list of locations that have been added to the app
     *
     * @return list of Location objects
     */
    public List<Location> getLocationAsLocationArray() {
        return Collections.unmodifiableList(locations);
    }

    /**
     * returns a list of locations represented as Strings that have been added to the app
     *
     * @return list of locations represented as Strings
     */
    public List<String> getLocationAsStringArray() {
        List<String> locationsAsStringArray = new ArrayList<>();
        for (Location l : locations) {
            locationsAsStringArray.add(l.toString());
        }
        return Collections.unmodifiableList(locationsAsStringArray);
    }

    /**
     * returns a list of locations represented as Strings with All locations as first option
     * that have been added to the app
     *
     * @return list of locations represented as Strings with All locations as first option
     */
    public List<String> getLocationsAsStringArrayWithAllLocationOption() {
        List<String> locationsAsStringArrayWithAllLocationOption = new ArrayList<>();
        String allLocations = "All Locations";
        locationsAsStringArrayWithAllLocationOption.add(allLocations);
        locationsAsStringArrayWithAllLocationOption.addAll(getLocationAsStringArray());
        return locationsAsStringArrayWithAllLocationOption;
    }

}


