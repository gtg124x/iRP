package team1.gatech.edu.irp.model;

import android.support.annotation.NonNull;

/** Donation category Enum */
public enum CategoryENUM {

    /**
     *
     * This class represents the different categories of donations
     */

    CLOTHING ("Clothing"),
    HAT ("Hat"),
    KITCHEN ("Kitchen"),
    ELECTRONICS ("Electronics"),
    HOUSEHOLD ("Household"),
    OTHER ("Other");

    /** the full string representation of the category*/
    private final String type;


    /**
     * Constructor for the enumeration
     *
     * @param type   category
     */
    CategoryENUM(String type) {
        this.type = type;
    }

    /**
     *
     * @return the display string representation of the category
     */
    @NonNull
    @Override
    public String toString() { return type; }
}


