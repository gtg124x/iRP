package team1.gatech.edu.irp.model;

public enum Category {

    /**
     * Created by mitchellalvarado on 10/14/18.
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
    Category(String type) {
        this.type = type;
    }

    /**
     *
     * @return   the category
     */
    public String getCategory() { return type; }

    /**
     *
     * @return the display string representation of the category
     */
    public String toString() { return type; }
}

