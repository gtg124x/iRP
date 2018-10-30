package team1.gatech.edu.irp.model;

import android.support.annotation.NonNull;

/**
 *
 * This class represents the results from registration attempt
 */
public enum RegistrationResultENUM {

    NAME_INVALID ("Name Invalid"),
    NAME_TAKEN ("Name Taken"),
    PASSWORD_INVALID ("Password Invalid"),
    EMAIL_INVALID ("Email Invalid"),
    SUCCESS ("Success");


    /** the full string representation of the result */
    private final String result;


    /**
     * Constructor for the enumeration
     *
     * @param result   the registration result
     */
    RegistrationResultENUM(String result) {
        this.result = result;
    }

//    /**
//     *
//     * @return   the registration result
//     */
//    public String getReuslt() { return result; }

    /**
     *
     * @return the display string representation of the registration result
     */
    @NonNull
    @Override
    public String toString() { return result; }

}