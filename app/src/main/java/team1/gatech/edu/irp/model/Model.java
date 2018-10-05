package team1.gatech.edu.irp.model;

import java.util.ArrayList;
import java.util.Arrays;
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

    /** Singleton instance */
    private static final Model _instance = new Model();
    public static Model getInstance() { return _instance; }

    /** the currently selected location, defaults to first course */
    private static Location _currentLocation;

    /** holds the list of all courses */
    private List<Location> locations;

    public static List<String> locationsArray = Arrays.asList((new Location()).toString());

    /**
     * make a new model
     */
    private Model() {
        locations = new ArrayList<>();
        locations.add(new Location());
    }

    public Location getCurrentLocation() { return _currentLocation; }

    public void setCurrentLocation(String currentLocation) {
        for (Location l : locations) {
            if (l.getName().equals(currentLocation)) {
                _currentLocation = l;
            }
        }
    }
}