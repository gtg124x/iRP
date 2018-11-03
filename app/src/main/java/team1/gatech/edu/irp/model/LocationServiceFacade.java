package team1.gatech.edu.irp.model;

import java.util.List;
import android.view.View;

/****************************************************************************************
 *    MODEL
 ****************************************************************************************
 */
public final class LocationServiceFacade {

//    /****************************************************************************************
//     *    MODEL STUFF
//     ****************************************************************************************
//     */

    /**
     * Singleton instance
     */
    private static final LocationServiceFacade _instance = new LocationServiceFacade();

    /**
     * getter for model
     *
     * @return  the model
     */
    public static LocationServiceFacade getInstance() {
        return _instance;
    }

    /**
     * make a new model
     */
    private LocationServiceFacade() {
        locationManager = new LocationManager();
    }


//    /****************************************************************************************
//     *     DATA MANGER ATTRIBUTES
//     ****************************************************************************************
//     */

    /**
     *  holds the locations
     */
    private LocationManager locationManager;

    /**
     *  get the location manager
     *
     *  @return the location manager
     */
    public LocationManager getLocationManager(){
        return locationManager;
    }

    /**
     *  sets the location manager
     *
     *  @param locationManagerImport the location manager
     */
    public void setLocationManager(LocationManager locationManagerImport){
        locationManager = locationManagerImport;
    }

//    /****************************************************************************************
//     *    LOCATION MANAGER PASS THROUGH METHODS
//     *    Notes: Pass through methods from Controller to Model, being from the
//     *           AdminActivity to LocationManager.
//     ****************************************************************************************
//     */

    /**
     * loads the locations from CSV file to app
     *
     * @param v the view
     * @return list of Location objects
     */
    public boolean loadLocations(View v) { return locationManager.loadLocationsFromCSV(v); }

    /**
     * tests whether or not the location list is empty
     *
     * @return if there are no locations entered in the app
     */
    public boolean noLocations() { return locationManager.locationListEmpty(); }

    /**
     * a list of locations that have been added to the app
     *
     * @return list of Location objects
     */
    public List<Location> getLocations() { return locationManager.getLocationAsLocationArray(); }

    /**
     * a list of locations represented as Strings that have been added to the app
     *
     * @return list of locations represented as Strings
     */
    public List<String> getLocationsAsString() {
        return locationManager.getLocationAsStringArray();
    }

    /**
     * a list of locations represented as Strings that have been added to the app with All
     * locations as first option
     *
     * @return list of locations represented as Strings with All locations as first option
     */
    public List<String> getLocationsAsStringWithAllLocationOption() {
        return locationManager.getLocationsAsStringArrayWithAllLocationOption();
    }

}