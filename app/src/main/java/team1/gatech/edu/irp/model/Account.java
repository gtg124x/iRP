package team1.gatech.edu.irp.model;

import android.support.annotation.NonNull;

import java.io.Serializable;

/****************************************************************************************
 *    ACCOUNT
 *    Notes: information holder
 ****************************************************************************************
 */
class Account implements Serializable {


///*********************************************************************************************
// *    ATTRIBUTES
// *****************************************************************************************
// */

    /** login name for the account */
    private String userName;

    /** password for the account */
    private String password;

    /** contact information which is an email address */
    private String contactInfo;

    /** account state (locked or unlocked)*/
    private AccountStateENUM accountState;

    /** account type admin, user, local emp, or manager*/
    private UserTypeENUM userType;


///*********************************************************************************************
// *    CONSTRUCTORS
// *    ****************************************************************************************
// */

    /**
     * Make a new account
     * @param userName         the account login name
     * @param password          the account password
     * @param contactInfo       the account contact Information
     * @param userType          the type of user
     * @param accountState      the state of the account
     *
     */
    public Account(String userName, String password, String contactInfo, UserTypeENUM userType, AccountStateENUM accountState) {
        this.userName = userName;
        this.password = password;
        this.contactInfo = contactInfo;
        this.userType = userType;
        this.accountState = accountState;
    }

    /**
     * No param constructor -- DO NOT CALL NORMALLY
     * This constructor only for GUI use in edit/new account dialog
     */
    public Account() {
        this("bob_waters" , "cs2340", "bob@gatech.edu", UserTypeENUM.USER, AccountStateENUM.LOCKED);
    }


///*********************************************************************************************
// *    GETTERS AND SETTERS
// *****************************************************************************************
// */

//    /**
//     * getter for the user name
//     *
//     * @return the user name
//     */
//    public String getUserName() { return userName; }

//    /**
//     * sets the user name
//     *
//     * @param userName the user name
//     */
//    public void setUserName(String userName) { this.userName = userName; }

    /**
     * getter for the password
     *
     * @return the password
     */
    public String getPassword() { return password; }

//    /**
//     * sets the password
//     *
//     * @param password the password
//     */
//    public void setPassword(String password) { this.contactInfo = password; }

//    /**
//     * getter for the contact info
//     *
//     * @return the contact info
//     */
//    public String getContactInfo() { return contactInfo; }

//    /**
//     * sets the contact info
//     *
//     * @param contactInfo the contact info
//     */
//    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    /**
     * getter for the account state
     *
     * @return the account state
     */
    public AccountStateENUM getAccountState() { return accountState; }

//    /**
//     * sets the account state
//     *
//     * @param accountState the account state
//     */
//    public void setAccountState(AccountStateENUM accountState) { this.accountState = accountState; }

    /**
     * getter for the user type
     *
     * @return the user type
     */
    public UserTypeENUM getUserType() { return userType; }

//    /**
//     * sets the user type
//     *
//     * @param userType the user type
//     */
//    public void setUserType(UserTypeENUM userType) { this.userType = userType; }

    /**
     *
     * @return the display string representation
     */
    @NonNull
    @Override
    public String toString() {
        return userName + " " + contactInfo + " " + userType;
    }


}
