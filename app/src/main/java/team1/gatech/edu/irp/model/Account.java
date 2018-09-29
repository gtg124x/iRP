package team1.gatech.edu.irp.model;

public class Account {

    /** login name for the account */
    private String userName;

    /** password for the account */
    private String password;

    /** contact information which is an email address */
    private String contactInfo;

    /** account state (locked or unlocked)*/
    private AccountState accountState;

    /** account type admin, user, local emp, or manager*/
    private UserType userType;

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.contactInfo = password; }

    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    public AccountState getAccountState() { return accountState; }
    public void setAccountState(AccountState accountState) { this.accountState = accountState; }

    public UserType getUserType() { return userType; }
    public void setUserType(UserType userType) { this.userType = userType; }

    /**
     * Make a new account
     * @param userName         the account login name
     * @param password          the account password
     * @param contactInfo       the account contact Information
     * @param userType          the type of user
     * @param accountState      the state of the account
     *
     */
    public Account(String userName, String password, String contactInfo, UserType userType, AccountState accountState) {
        this.userName = userName;
        this.password = password;
        this.contactInfo = contactInfo;
        this.userType = userType;
        this.accountState = accountState;
    }

    /**
     * Make a new account
     * @param userName         the account login name
     * @param password          the account password
     * @param contactInfo       the account contact Information
     * @param userType          the type of user
     *
     */
    public Account(String userName, String password, String contactInfo, UserType userType) {
        this(userName, password, contactInfo, userType,  AccountState.UNLOCKED);
    }

    /**
     * Make a new account
     * @param userName         the account login name
     * @param password          the account password
     * @param contactInfo       the account contact Information
     *
     */
    public Account(String userName, String password, String contactInfo) {
        this(userName, password, contactInfo, UserType.USER, AccountState.UNLOCKED);
    }

    /**
     * No param constructor -- DO NOT CALL NORMALLY
     * This constructor only for GUI use in edit/new account dialog
     */
    public Account() {
        this("enter new name" , "NA", "enter email address", UserType.USER, AccountState.UNLOCKED);
    }

    /**
     *
     * @return the display string representation
     */
    @Override
    public String toString() {
        return userName + " " + contactInfo + " " + userType;
    }






}
