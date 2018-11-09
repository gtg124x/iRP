package team1.gatech.edu.irp.model;

import android.support.annotation.NonNull;

/**
 *
 * This class represents the different types of locations
 *
 * @author Mitchell_Alvarado
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
     *  converts the type of location as a string to a enum
     *
     * @param typeAsString the type of location as a string
     * @return the location type
     */
    public static LocationTypeEnum convertType(String typeAsString) {
        if ("Drop off".equalsIgnoreCase(typeAsString)) {
            return LocationTypeEnum.DROP_OFF;
        } else if ("Store".equalsIgnoreCase(typeAsString)) {
            return LocationTypeEnum.STORE;
        } else if ("Warehouse".equalsIgnoreCase(typeAsString)) {
            return LocationTypeEnum.WAREHOUSE;
        } else {
            return LocationTypeEnum.DROP_OFF;
        }
    }


}


