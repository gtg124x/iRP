package team1.gatech.edu.irp.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

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
     * get the categories as a String List for Spinner
     * Done to take care of warnings about casting
     *
     * @return   the category
     */
    public static List<String> getUserTypeStringList() {
        List<String> UserTypeENUMList = new ArrayList<>();
        for (UserTypeENUM userType : UserTypeENUM.values()) {
            UserTypeENUMList.add(userType.toString());
        }
        return UserTypeENUMList; }



    /**
     *
     * @return the display string representation of the user type
     */
    @NonNull
    @Override
    public String toString() { return type; }
}

