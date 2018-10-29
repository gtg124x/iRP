package team1.gatech.edu.irp.model;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/****************************************************************************************
 *    ACCOUNT MANAGER
 *    Notes: accounts is just a list of account objects that are created in
 *    RegistrationActivity when the user clicks the add button. The validation of the
 *    data is done there then the Account obj is added to the accountDataBase
 ****************************************************************************************
 */

public class AccountManager implements Serializable {

    /**
     * list of account objects
     */
    private Map<String, Account> accounts = new HashMap<>();



    /****************************************************************************************
     *    ACCOUNT METHODS
     ****************************************************************************************
     */

    /**
     * adds an account to the system
     *
     *  @param name an account name
     *  @param pword an account password
     *  @param cInfo an account contact info
     *  @param userTypeEnum an account type
     *  @return result of registration
     */
    public RegistrationResultENUM addToAccounts(String name, String pword, String cInfo, UserTypeENUM userTypeEnum) {
        if (accountNameNotValid(name)) {
            return RegistrationResultENUM.NAME_INVALID;
        } else if (accountNameIsTaken(name)) {
            return RegistrationResultENUM.NAME_TAKEN;
        } else if (accountPasswordNotValid(pword)) {
            return RegistrationResultENUM.PASSWORD_INVALID;
        } else if (accountEmailNotValid(cInfo)) {
            return RegistrationResultENUM.EMAIL_INVALID;
        } else {
            return createAccounts(name, pword, cInfo, userTypeEnum);
        }
    }

    /**
     * validates that the user input in the name field is valid
     *
     *  @param name the account name
     */
    private boolean accountNameNotValid(String name) {
        if (name.length() < 4) {
            return true;
        }
        return false;
    }

    /**
     * validates that the user input in the name field has not already been taken
     *
     *  @param uName the account name
     */
    private boolean accountNameIsTaken(String uName) {
        if (accounts.containsKey(uName)) {
            return true;
        }
        return false;
    }

    /**
     * validates that the user input in the password field is valid
     *
     *  @param password the account password
     */
    private boolean accountPasswordNotValid(String password) {
        if (password.length() < 4) {
            return true;
        }
        return false;
    }

    /**
     * validates that the user input in the email field is valid
     *
     *  @param email the account email
     */
    private boolean accountEmailNotValid(String email) {
        if (!email.contains("@") || !email.contains(".")) {
            return true;
        }
        return false;
    }

    /**
     * adds an account to the system
     *
     *  @param name an account name
     *  @param pword an account password
     *  @param cInfo an account contact info
     *  @param userTypeEnum an account type
     *
     *  @return success
     */
    private RegistrationResultENUM createAccounts(String name, String pword, String cInfo, UserTypeENUM userTypeEnum) {
        Account newAccount = new Account(name, pword, cInfo, userTypeEnum);
        accounts.put(name, newAccount);
        return RegistrationResultENUM.SUCCESS;
    }

    /**
     * checks is user name and passord match
     *
     *  @param name an account name
     *  @param pword an account password
     *
     *  @return success
     */
    public boolean loginCheck(String name, String pword) {
        boolean success = false;
        if (accounts.containsKey(name)) {
            if (accounts.get(name).getPassword().equals(pword)) {
                success = true;
            }
        } else {
            success = false;
        }
        return success;
    }

    /**
     * looks up the user type given a user name
     *
     *  @param name an account name
     *
     *  @return the user type
     */
    public UserTypeENUM lookupUserType(String name) {
        return accounts.get(name).getUserType();
    }

}
