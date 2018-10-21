package team1.gatech.edu.irp.model;

public enum LocationType {

    /**
     * Created by mitchellalvarado on 10/05/18.
     *
     * This class represents the different types of users
     */

    DROPOFF("Drop off"),
    STORE("Store"),
    WAREHOUSE("Warehouse");

    /**
     * the full string representation of the location type
     */
    private final String type;


    /**
     * Constructor for the enumeration
     *
     * @param type location type
     */
    LocationType(String type) {
        this.type = type;
    }

    /**
     * @return the location type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the display string representation of the location type
     */
    public String toString() {
        return type;
    }

    /**
     * @return the location type
     */
    public static LocationType convertType(String typeAsString) {
        if (typeAsString.equalsIgnoreCase("Drop off")) {
            return LocationType.DROPOFF;
        } else if (typeAsString.equalsIgnoreCase("Store")) {
            return LocationType.STORE;
        } else if (typeAsString.equalsIgnoreCase("Warehouse")) {
            return LocationType.WAREHOUSE;
        } else {
            return LocationType.DROPOFF;
        }
    }


}

