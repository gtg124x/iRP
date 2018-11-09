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
 *
 * @author Mitchell_Alvarado
 */
public class AccountManager implements Serializable {

    /**
     * list of account objects
     */
    private final Map<String, Account> accounts = new HashMap<>();

    /**
     * adds an account to the system
     *
     *  @param name an account name
     *  @param password an account password
     *  @param cInfo an account contact info
     *  @param userTypeEnum an account type
     *  @return result of registration
     */
    public RegistrationResultENUM addToAccounts(String name, String password, String cInfo,
                                                UserTypeENUM userTypeEnum) {
        if (accountNameNotValid(name)) {
            return RegistrationResultENUM.NAME_INVALID;
        } else if (accountNameIsTaken(name)) {
            return RegistrationResultENUM.NAME_TAKEN;
        } else if (accountPasswordNotValid(password)) {
            return RegistrationResultENUM.PASSWORD_INVALID;
        } else if (accountEmailNotValid(cInfo)) {
            return RegistrationResultENUM.EMAIL_INVALID;
        } else {
            createAccounts(name, password, cInfo, userTypeEnum);
            return RegistrationResultENUM.SUCCESS;
        }
    }

    /**
     * validates that the user input in the name field is valid
     *
     *  @param name the account name
     *  @return success
     */
    private boolean accountNameNotValid(String name) {
        return ((name == null) || (name.length() < 2));
    }

    /**
     * validates that the user input in the name field has not already been taken
     *
     *  @param uName the account name
     *  @return success
     */
    private boolean accountNameIsTaken(String uName) {
        return accounts.containsKey(uName);
    }

    /**
     * validates that the user input in the password field is valid
     *
     *  @param password the account password
     *  @return success
     */
    private boolean accountPasswordNotValid(String password) {
        return ((password == null) || (password.length() < 4));
    }

    /**
     * validates that the user input in the email field is valid
     *
     *  @param email the account email
     *  @return success
     */
    private boolean accountEmailNotValid(String email) {
        return ((email == null) || (!email.contains("@") || !email.contains(".")));
    }

    /**
     * adds an account to the system
     *
     *  @param name an account name
     *  @param password an account password
     *  @param cInfo an account contact info
     *  @param userTypeEnum an account type
     *
     */
    private void createAccounts(String name, String password, String cInfo,
                                UserTypeENUM userTypeEnum) {
        Account newAccount = new Account(name, password, cInfo, userTypeEnum,
                AccountStateENUM.UNLOCKED);
        accounts.put(name, newAccount);
    }

    /**
     * checks is user name and password match
     *
     *  @param name an account name
     *  @param password an account password
     *
     *  @return success
     */
    public UserTypeENUM loginCheck(String name, String password) {
        UserTypeENUM userType = null;
        if (accounts.containsKey(name)) {
            Account accountName = getAccountName(name);
            if (verifyPasswordAndState(accountName, password)) {
                userType = getAccountUserType(accountName);
            }
        }
        return userType;
    }

    /**
     * gets and account user type
     * does the null check and keeps the code checker happy
     *
     *  @param account an account
     *
     *  @return the user type
     */
    private UserTypeENUM getAccountUserType(Account account) {
        if (account != null) {
            return account.getUserType();
        }
        return UserTypeENUM.USER;
    }

    /**
     * gets and account given a name
     * does the null check and keeps the code checker happy
     *
     *  @param name an account name
     *
     *  @return the account
     */
    private Account getAccountName(String name) {
        if (name != null) {
            return accounts.get(name);
        }
        return new Account();
    }

    /**
     * verifies account and password match
     *
     *  @param accountName an account
     *  @param password an account password
     *
     *  @return success
     */
    private boolean verifyPasswordAndState(Account accountName, String password) {
        boolean success = false;
        String accountPassword = accountName.getPassword();
        if ((accountPassword.equals(password))
                && (accountName.getAccountState() == AccountStateENUM.UNLOCKED)) {
            success = true;
        }
        return success;
    }



}
