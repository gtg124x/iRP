package team1.gatech.edu.irp.model;

import java.io.Serializable;
import java.util.ArrayList;

public class AccountManager implements Serializable {


    /****************************************************************************************
     *    ACCOUNT ATTRIBUTES
     *    Notes: accounts is just a list of account objects that are created in
     *    RegistrationActivity when the user clicks the add button. The validation of the
     *    data is done there then the Account obj is added to the accountDataBase
     ****************************************************************************************
     */

    /**
     * list of account objects
     */
    private ArrayList<Account> accounts = new ArrayList<>();




    /****************************************************************************************
     *    ACCOUNT METHODS
     ****************************************************************************************
     */

    /**
     * adds an account to the app
     *
     * @param newAccount a new account from the registration screen
     */
    public void addToAccounts(Account newAccount) {
        accounts.add(newAccount);
    }

    /**
     * gets the list of Account objects
     *
     * @return a list of Account objects
     */
    public ArrayList<Account> getAccounts() {
        return accounts;
    }




}
