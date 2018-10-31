package team1.gatech.edu.irp.model;

import java.util.List;
import android.view.View;

/****************************************************************************************
 *    MODEL
 ****************************************************************************************
 */
public class Model {

//    /****************************************************************************************
//     *    MODEL STUFF
//     ****************************************************************************************
//     */

    /**
     * Singleton instance
     */
    private static final Model _instance = new Model();

    /**
     * getter for model
     *
     * @return  the model
     */
    public static Model getInstance() {
        return _instance;
    }

    /**
     * make a new model
     */
    private Model() {
        accountManager = new AccountManager();
        locationManager = new LocationManager();
        itemManager = new ItemManager();
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
     *  holds the locations
     */
    private LocationManager locationManager;

    /**
     *  holds the items
     */
    private ItemManager itemManager;

//    /****************************************************************************************
//     *    PASS THROUGH VALUES FROM SPINNERS TO ACTIVITY PAGES
//     ****************************************************************************************
//     */

    /**
     * the currently item list from ItemSearchByCategoryActivity
     */
    private List<String> _currentItemList;

    /**
     * the currently selected location of the LocationListActivity
     */
    private Location _currentLocation;

    /**
     * the currently selected location, defaults to first location for AddDonationActivity
     */
    private Location _currentLocationAddDonation;

    /**
     * convert string to location for LocationDetailActivity
     */
    private Item _currentItemDetails;

    /**
     * convert string to CategoryENUM for AddDonationActivity
     */
    private CategoryENUM _currentCategory;

    /**
     * convert string to UserTypeENUM for RegistrationActivity
     */
    private UserTypeENUM _currentUserType;

//    /****************************************************************************************
//     *    DATA MANAGER GETTERS AND SETTERS
//     ****************************************************************************************
//     */

    /**
     * gets the accountManager
     *
     * @return the accountManager
     */
    public AccountManager getAccountManager() { return accountManager; }

    /**
     * gets the locationManager
     *
     * @return the locationManager
     */
    public LocationManager getLocationManager() { return locationManager; }

    /**
     * gets the itemManager
     *
     * @return the itemManager
     */
    public ItemManager getItemManager() { return itemManager; }

    /**
     * sets the accountManager
     *
     * @param accountManager the accountManager
     */
    public void setAccountManager(AccountManager accountManager) { this.accountManager = accountManager; }

    /**
     * sets the locationManager
     *
     * @param locationManager the locationManager
     */
    public void setLocationManager(LocationManager locationManager) { this.locationManager = locationManager; }

    /**
     * sets the itemManager
     *
     * @param itemManager the itemManager
     */
    public void setItemManager(ItemManager itemManager) { this.itemManager = itemManager; }


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
    public RegistrationResultENUM addAccount(String name, String passwordString, String cInfo, UserTypeENUM userTypeEnum) {
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
    public boolean validateLogin(String name, String passwordString) {
        return accountManager.loginCheck(name, passwordString);
    }

    /**
     * retrieves the user type from a valid account
     *
     *  @param name an account name
     *
     *  @return user type
     */
    public UserTypeENUM getUserType(String name) {
        return accountManager.lookupUserType(name);
    }


//    /****************************************************************************************
//     *    LOCATION MANAGER PASS THROUGH METHODS
//     *    Notes: Pass through methods from Controller to Model, being from the
//     *           AdminActivity to LocationManager.
//     ****************************************************************************************
//     */

    /**
     * loads the locations from CSV file to app
     *
     * @return list of Location objects
     */
    public boolean loadLocations(View v) { return locationManager.loadLocationsFromCSV(v); }

    /**
     * tests whether or not the location list is empty
     *
     * @return if there are no locations entered in the app
     */
    public boolean noLocations() { return locationManager.locationListEmpty(); }

    /**
     * a list of locations that have been added to the app
     *
     * @return list of Location objects
     */
    public List<Location> getLocations() { return locationManager.getLocationAsLocationArray(); }

    /**
     * a list of locations represented as Strings that have been added to the app
     *
     * @return list of locations represented as Strings
     */
    public List<String> getLocationsAsString() { return locationManager.getLocationAsStringArray(); }

    /**
     * a list of locations represented as Strings that have been added to the app with All locations as first option
     *
     * @return list of locations represented as Strings with All locations as first option
     */
    public List<String> getLocationsAsStringWithAllLocationOption() { return locationManager.getLocationsAsStringArrayWithAllLocationOption(); }


//    /****************************************************************************************
//     *    ITEM MANAGER PASS THROUGH METHODS
//     *    Notes: Pass through methods from Controller to Model, being from the
//     *           AddDonationActivity to ItemManager.
//     ****************************************************************************************
//     */

    /**
     * Validates the user input then adds the item into the inventory
     *
     * @param timeStamp         the account login name
     * @param dateStamp         date stamp for the item
     * @param location          location for the item
     * @param category          category for the item
     * @param dollarValue       dollar value for the item
     * @param shortDescription   short description for the item
     * @param fullDescription    full description for the item
     *
     * @return the result of the adding and item to inventory in the form of AddDonationResultENUM
     */
    public AddDonationResultENUM validateAndAddItemToInventory(String timeStamp, String dateStamp,
                                                               Location location, CategoryENUM category,
                                                               String dollarValue, String shortDescription,
                                                               String fullDescription) {
        return itemManager.validateAndAddItemToItemManager(timeStamp, dateStamp, location, category,
                dollarValue, shortDescription, fullDescription);
    }

    /**
     * a list of items represented as Strings that have been added to the a selected location
     *
     * @param  location currently selected location to view
     * @return list of items represented as Strings
     */
    public List<String> getInventoryByLocation(Location location) { return itemManager.getItemListByLocation(location); }

    /**
     * determines if the inventory at a location is empty or no
     *
     * @param  location currently selected location to analyze for inventory size
     * @return if the inventory is empty
     */
    public boolean isInventoryByLocationEmpty(Location location) { return itemManager.isItemListByLocationEmpty(location); }

    /**
     * finds the items sorted by location and category
     *
     * @param category item category
     * @param locationString store location
     *
     * @return list of items in inventory at a particular location and category
     */
    public List<String> getInventoryByCategoryAndLocation(CategoryENUM category, String locationString ) {
        return itemManager.getItemListByCategoryAndLocation(category, locationString);
    }

    /**
     * finds the items sorted by location and name
     *
     * @param name item name
     * @param locationString store location
     *
     * @return list of items in inventory at a particular location and name
     */
    public List<String> getInventoryByNameAndLocation(String name, String locationString ) {
        return itemManager.getItemListByNameAndLocation(name, locationString);
    }


//    /****************************************************************************************
//     *    PASS THROUGH METHODS TO PASS VALUES FROM SPINNERS TO OTHER ACTIVITY PAGES
//     ****************************************************************************************
//     */

    /**
     * set the selected Item on the spinner
     *
     * @param currentItemList the currently selected Item
     */
    public void setCurrentItemList(List<String> currentItemList) {
        _currentItemList = currentItemList;
    }

    /**
     * get the selected Item on the spinner
     *
     * @return the currently selected item
     */
    public List<String> getCurrentItemList() {
       return _currentItemList;
    }

    /**
     * determines if the inventory selected by a spinner is empty or not
     *
     * @return if the inventory is empty
     */
    public boolean isCurrentItemListEmpty() {
        return ( _currentItemList.size() == 0);
    }

    /**
     * passes through the selected Location on the LocationListActivity spinner
     *
     * @return the currently selected location of the LocationListActivity
     */
    public Location getCurrentLocation() {
        return _currentLocation;
    }

    /**
     * sets the selected Location on the LocationListActivity spinner
     *
     * @param currentLocation the currently selected location on the LocationListActivity spinner
     */
    public void setCurrentLocation(String currentLocation) {
        for (Location l : locationManager.getLocationAsLocationArray()) {
            if (l.toString().equals(currentLocation)) {
                _currentLocation = l;
            }
        }
    }

    /**
     * passes through the selected Location on the AddDonationActivity spinner
     *
     * @return the currently selected location of the AddDonationActivity
     */
    public Location getCurrentLocationAddDonation() {
        return _currentLocationAddDonation;
    }

    /**
     * sets the selected Location on the AddDonationActivity spinner
     *
     * @param currentLocationAddDonation the currently selected location on the AddDonationActivity spinner
     */
    public void setCurrentLocationAddDonation(String currentLocationAddDonation) {
        for (Location l : locationManager.getLocationAsLocationArray()) {
            if (l.toString().equals(currentLocationAddDonation)) {
                _currentLocationAddDonation = l;
            }
        }
    }

    /**
     * passes through the selected Item on the LocationDetailActivity spinner
     *
     * @return the currently selected item of the LocationDetailActivity
     */
    public Item getCurrentItemDetails() {
        return _currentItemDetails;
    }

    /**
     * sets the selected item on the LocationDetailActivity spinner
     *
     * @param currentItemDetails the currently selected item on the LocationDetailActivity spinner
     */
    public void setCurrentItemDetails(String currentItemDetails) {
        for (Item item : itemManager.getItemManagerAsItemArray()) {
            if (item.toString().equals(currentItemDetails)) {
                _currentItemDetails = item;
            }
        }
    }

    /**
     * passes through the selected Category on the LocationDetailActivity spinner
     *
     * @return the currently selected Category of the LocationDetailActivity
     */
    public CategoryENUM getCurrentCategoryAddDonation() {
        return _currentCategory;
    }

    /**
     * sets the selected Category on the LocationDetailActivity spinner
     *
     * @param currentItemDetails the currently selected Category on the LocationDetailActivity spinner
     */
    public void setCurrentCategoryAddDonation(String currentItemDetails) {
        for (CategoryENUM category : CategoryENUM.values()) {
            if (category.toString().equals(currentItemDetails)) {
                _currentCategory = category;
            }
        }
    }

    /**
     * passes through the selected UserType on the RegistrationActivity spinner
     *
     * @return the currently selected UserType of the RegistrationActivity
     */
    public UserTypeENUM getCurrentUserTypeRegistration() {
        return _currentUserType;
    }

    /**
     * sets the selected UserType on the RegistrationActivity spinner
     *
     * @param currentUserType the currently selected UserType on the RegistrationActivity spinner
     */
    public void setCurrentUserTypeRegistration(String currentUserType) {
        for (UserTypeENUM userType : UserTypeENUM.values()) {
            if (userType.toString().equals(currentUserType)) {
                _currentUserType = userType;
            }
        }
    }


}