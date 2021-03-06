package team1.gatech.edu.irp.model;

import android.support.annotation.NonNull;

/**
 *
 * This class represents the different types of users
 *
 * @author Mitchell_Alvarado
 */
public enum UserTypeENUM {

    USER ("User"),
    LOCAL_EMPLOYEE ("Local Employee"),
    MANAGER ("Manager"),
    ADMIN ("Admin"),
    LOCKED ("Locked");

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
     * @return the display string representation of the user type
     */
    @NonNull
    @Override
    public String toString() { return type; }
}

