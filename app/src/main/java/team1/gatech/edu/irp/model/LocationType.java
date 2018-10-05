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

    /**
     * @return the class standing
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
//        for (LocationType x : )
//        return type;
//
//        LocationType locT = LocationType.elements();
//        while (LocationType.hasMoreElements())
//            System.out.println(days.nextElement()); } }






}

