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

    /** the full string representation of the class standing */
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
     * @return   the class standing
     */
    public String getType() { return type; }

    /**
     *
     * @return the display string representation of the course
     */
    public String toString() { return type; }
    }

