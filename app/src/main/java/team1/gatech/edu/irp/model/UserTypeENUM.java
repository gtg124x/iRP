package team1.gatech.edu.irp.model;

/**
 *
 * This class represents the different types of users
 */
public enum UserTypeENUM {

    USER ("User"),
    LOCALEMPLOYEE ("Local Employee"),
    MANAGER ("Manager"),
    ADMIN ("Admin");

    /** the full string representation of the user type */
    private final String type;


    /**
     * Constructor for the enumeration
     *
     * @param type   user type
     */
    UserTypeENUM(String type) {
        this.type = type;
    }

    /**
     *
     * @return   the user type
     */
    public String getType() { return type; }

    /**
     *
     * @return the display string representation of the user type
     */
    public String toString() { return type; }
}

