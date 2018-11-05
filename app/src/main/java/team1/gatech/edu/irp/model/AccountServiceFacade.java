package team1.gatech.edu.irp.model;


    /****************************************************************************************
     *    MODEL
     ****************************************************************************************
     */
    public final class AccountServiceFacade {

//    /****************************************************************************************
//     *    MODEL STUFF
//     ****************************************************************************************
//     */

        /**
         * Singleton instance
         */
        private static final AccountServiceFacade _instance = new AccountServiceFacade();

        /**
         * getter for model
         *
         * @return  the model
         */
        public static AccountServiceFacade getInstance() {
            return _instance;
        }

        /**
         * make a new model
         */
        private AccountServiceFacade() {
            accountManager = new AccountManager();
        }


//    /****************************************************************************************
//     *     DATA MANGER ATTRIBUTES
//     ****************************************************************************************
//     */

        /**
         *  holds the accounts
         */
        private AccountManager accountManager;

        /**
         *  get the account manager
         *
         *  @return the account manager
         */
        public AccountManager getAccountManager(){
            return accountManager;
        }

        /**
         *  sets the account manager
         *
         *  @param accountManagerImport the account manager
         */
        public void setAccountManager(AccountManager accountManagerImport){
            accountManager = accountManagerImport;
        }




//    /****************************************************************************************
//     *    ACCOUNT MANAGER PASS THROUGH METHODS
//     *    Notes: Pass through methods from Controller to Model, being from the
//     *           RegistrationActivity to AccountManager.
//     ****************************************************************************************
//     */

        /**
         * adds an account to the system
         *
         *  @param name an account name
         *  @param passwordString an account password
         *  @param cInfo an account contact info
         *  @param userTypeEnum an account type
         *  @return success
         */
        public RegistrationResultENUM addAccount(String name, String passwordString, String cInfo,
                                                 UserTypeENUM userTypeEnum) {
            return accountManager.addToAccounts(name, passwordString, cInfo, userTypeEnum);
        }

        /**
         * validate the login information
         *
         *  @param name an account name
         *  @param passwordString an account password
         *
         *  @return success
         */
        public UserTypeENUM validateLogin(String name, String passwordString) {
            return accountManager.loginCheck(name, passwordString);
        }

    }