package team1.gatech.edu.irp.model;

import android.support.annotation.NonNull;

/**
 *
 * This class represents the different types of locations
 */
public enum LocationTypeEnum {

    DROP_OFF("Drop off"),
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
    LocationTypeEnum(String type) {
        this.type = type;
    }


    /**
     * @return the display string representation of the location type
     */
    @NonNull
    @Override
    public String toString() {
        return type;
    }

    /**
     * @return the location type
     */
    public static LocationTypeEnum convertType(String typeAsString) {
        if (typeAsString.equalsIgnoreCase("Drop off")) {
            return LocationTypeEnum.DROP_OFF;
        } else if (typeAsString.equalsIgnoreCase("Store")) {
            return LocationTypeEnum.STORE;
        } else if (typeAsString.equalsIgnoreCase("Warehouse")) {
            return LocationTypeEnum.WAREHOUSE;
        } else {
            return LocationTypeEnum.DROP_OFF;
        }
    }


}


