package team1.gatech.edu.irp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mitchellalvarado on 10/5/18.
 *
 * This class holds the locations in a list form
 *
 * structure
 */
public class LocationDataBase {

    /** holds the list of all locations */
    /** a demonstration of using something other than an enum for holding choices */

    public static List<String> locations = Arrays.asList((new Location()).toString());




//    public static int count = 0;
//
//    public static void addToAccountDatabase(Account newAccount) {
//        if (count < 10) {
//            accountArray[count] = newAccount;
//            count++;
//        }
//    }









//    /** the currently selected course, defaults to first course */
//    public Location _currentLocation;
//
//    /** Null Object pattern, returned when no course is found */
//    public final Location theNullLocation = new Location();
//
//
//    /**
//     * populate the model with some dummy data.  The full app would not require this.
//     * comment out when adding new courses functionality is present.
//     */
//    private void loadDummyData() {
//        _locations.add(new Location());
//    }
//
//    /**
//     * get the locations
//     * @return a list of the locations in the app
//     */
//    public List<Location> getLocations() { return _locations; }
//
//    /**
//     * add a location to the app.  checks if the location is already entered
//     *
//     * uses O(n) linear search for location
//     *
//     * @param location  the location to be added
//     * @return true if added, false if a duplicate
//     */
//    public boolean addLocation(Location location) {
//        for (Location l : _locations ) {
//            if (l.equals(location)) return false;
//        }
//        _locations.add(location);
//        return true;
//    }
//
//    /**
//     *
//     * @return  the currently selected location
//     */
//    public Location getCurrentLocation() { return _currentLocation;}
//
//    public void setCurrentLocation(Location location) { _currentLocation = location; }
//
//
//    /**
//     * Return a course that has the matching id
//     * This uses a linear O(n) search
//     *
//     * @param id the id number of the course
//     * @return the course with this id or theNullCourse if no such id exists.
//     */
//    public Location getLocationById(int id) {
//        for (Location l : _locations ) {
//            if (l.getId() == id) {
//                return l;
//            }
//        }
//        return theNullLocation;
//    }



//    /**
//     * Replace an existing locations data with new data
//     *
//     * @param location the student being edited
//     */
//    public void replaceLocationData(Location location) {
//        Location existing = _currentLocation.getLocationById(location.getId());
//
//        //if existing comes back null, something is seriously wrong
//        if (BuildConfig.DEBUG && (existing == null)) { throw new AssertionError(); }
//
//        //update the name
//        existing.setName(student.getName());
//
//        //update the major
//        existing.setMajor(student.getMajor());
//
//        //update the class standing
//        existing.setClassStanding(student.getClassStanding());
//    }
}
