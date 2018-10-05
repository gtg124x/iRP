package team1.gatech.edu.irp.model;

public enum LocationType {

    /**
     * Created by mitchellalvarado on 10/05/18.
     *
     * This class represents the different types of users
     */

    DROPOFFONLY("Dropoff-only"),
    STORE("Drop-off and Sales"),
    WAREHOUSE("Inventory Storage Only");

    /**
     * the full string representation of the class standing
     */
    private final String type;


    /**
     * Constructor for the enumeration
     *
     * @param type user type
     */
    LocationType(String type) {
        this.type = type;
    }

    /**
     * @return the class standing
     */
    public String getType() {
        return type;
    }

    /**
     * @return the display string representation of the course
     */
    public String toString() {
        return type;
    }
}

