package team1.gatech.edu.irp.model;

public enum RegistrationResultENUM {

    /**
     * Created by mitchellalvarado on 9/28/18.
     *
     * This class represents the different types of users
     */

    NAME_INVALID ("Name Invalid"),
    NAME_TAKEN ("Name Taken"),
    PASSWORD_INVALID ("Password Invalid"),
    EMAIL_INVALID ("Email Invalid"),
    SUCCESS ("Success");


    /** the full string representation of the user type */
    private final String result;


    /**
     * Constructor for the enumeration
     *
     * @param result   the registration result
     */
    RegistrationResultENUM(String result) {
        this.result = result;
    }

    /**
     *
     * @return   the registration result
     */
    public String getReuslt() { return result; }

    /**
     *
     * @return the display string representation of the registration result
     */
    public String toString() { return result; }

}