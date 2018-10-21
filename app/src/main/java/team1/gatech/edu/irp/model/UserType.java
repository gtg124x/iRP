package team1.gatech.edu.irp.model;

public enum UserType {

    /**
     * Created by mitchellalvarado on 9/28/18.
     *
     * This class represents the different types of users
     */

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
    UserType(String type) {
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

