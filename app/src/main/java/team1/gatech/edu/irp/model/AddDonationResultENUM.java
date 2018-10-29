package team1.gatech.edu.irp.model;

/** Result of adding a donation Enum */
public enum AddDonationResultENUM {

    TIME_INVALID ("Time Invalid"),
    DATE_INVALID ("Date Taken"),
    VALUE_INVALID ("Value Invalid"),
    SHORTDESCRIPTION_INVALID_TO_SHORT ("Short Description To Short Invalid"),
    SHORTDESCRIPTION_INVALID_TO_LONG ("Short Description To Long Invalid"),
    LONGDESCRIPTION_INVALID_TO_SHORT ("Long Description Invalid"),
    SUCCESS ("Success");


    /** the full string representation of the user type */
    private final String result;


    /**
     * Constructor for the enumeration
     *
     * @param result result of adding a donation
     */
    AddDonationResultENUM(String result) {
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
    public String toString() { return result; }

}