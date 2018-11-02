package team1.gatech.edu.irp.model;

import java.util.Collections;
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
    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    /**
     * sets the locationManager
     *
     * @param locationManager the locationManager
     */
    public void setLocationManager(LocationManager locationManager) {
        this.locationManager = locationManager;
    }

    /**
     * sets the itemManager
     *
     * @param itemManager the itemManager
     */
    public void setItemManager(ItemManager itemManager) { this.itemManager = itemManager; }

//    /****************************************************************************************
//     *    PASS THROUGH VALUES FROM SPINNERS TO ACTIVITY PAGES
//     ****************************************************************************************
//     */

    /**
     * the currently item list from ItemSearchByCategoryActivity
     */
    private List<Item> _currentItemList;

    /**
     * the currently selected location of the LocationListActivity
     */
    private Location selectedLocation;

//    /**
//     * the currently selected location, defaults to first location for AddDonationActivity
//     */
//    private Location _currentLocationAddDonation;

    /**
     * convert string to location for LocationDetailActivity
     */
    private Item selectedItemFromItemList;

//    /**
//     * convert string to CategoryENUM for AddDonationActivity
//     */
//    private CategoryENUM _currentCategory;

    /**
     * convert string to UserTypeENUM for RegistrationActivity
     */
    private UserTypeENUM _currentUserType;

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
     * @param v the view
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
    public List<String> getLocationsAsString() {
        return locationManager.getLocationAsStringArray();
    }

    /**
     * a list of locations represented as Strings that have been added to the app with All
     * locations as first option
     *
     * @return list of locations represented as Strings with All locations as first option
     */
    public List<String> getLocationsAsStringWithAllLocationOption() {
        return locationManager.getLocationsAsStringArrayWithAllLocationOption();
    }


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
    public AddDonationResultENUM validateAndAddItemToInventory(String timeStamp,
                                                               String dateStamp,
                                                               Location location,
                                                               CategoryENUM category,
                                                               String dollarValue,
                                                               String shortDescription,
                                                               String fullDescription) {
        return itemManager.validateAndAddItemToItemManager(timeStamp, dateStamp, location,
                category, dollarValue, shortDescription, fullDescription);
    }

//    /**
//     * a list of items represented as Strings that have been added to the a selected location
//     *
//     * @param  location currently selected location to view
//     * @return list of items represented as Strings
//     */
//    public List<Item> getInventoryByLocation(Location location) {
//
//        return itemManager.getItemListByLocation(location);
//    }
    /**
     * a list of items represented as Strings that have been added to the a selected location
     *
     * @return the inventory at a location
     */
    public List<Item> getInventoryByLocation() {
        _currentItemList = itemManager.getItemListByLocation(selectedLocation);
        return Collections.unmodifiableList(_currentItemList);
    }

//    /**
//     * determines if the inventory at a location is empty or no
//     *
//     * @param  location currently selected location to analyze for inventory size
//     * @return if the inventory is empty
//     */
//    public boolean isInventoryByLocationEmpty(Location location) {
//        return itemManager.isItemListByLocationEmpty(location);
//    }

//    /**
//     * finds the items sorted by location and category
//     *
//     * @param category item category
//     * @param locationString store location
//     *
//     * @return list of items in inventory at a particular location and category
//     */
//    public List<Item> getInventoryByCategoryAndLocation(CategoryENUM category,
//                                                        String locationString ) {
//        _currentItemList = itemManager.getItemListByCategoryAndLocation(category, locationString)
//        return _currentItemList;
//    }

    /**
     * finds the items sorted by location and category
     *
     * @param category item category
     * @param locationString store location
     *
     */
    public void setInventoryByCategoryAndLocation(CategoryENUM category,
                                                        String locationString ) {
        _currentItemList = itemManager.getItemListByCategoryAndLocation(category, locationString);
        //return _currentItemList;
    }

    /**
     * finds the items sorted by location and name
     *
     * @param name item name
     * @param locationString store location
     *
     */
    public void setInventoryByNameAndLocation(String name, String locationString ) {
        _currentItemList = itemManager.getItemListByNameAndLocation(name, locationString);
    }

//    /**
//     * converts list of items to strings
//     *
//     * @param itemList item list
//     *
//     * @return list of items in as strings
//     */
//    public List<String> getInventoryAsString(List<Item> itemList ) {
//        return itemManager.getItemListAsString(itemList);
//    }

//    /****************************************************************************************
//     *    PASS THROUGH METHODS TO PASS VALUES FROM SPINNERS TO OTHER ACTIVITY PAGES
//     ****************************************************************************************
//     */

//    /**
//     * set the selected Item on the spinner
//     *
//     * @param currentItemList the currently selected Item
//     */
//    public void setCurrentItemList(List<Item> currentItemList) {
//        _currentItemList = currentItemList;
//    }

    /**
     * get the selected Item on the spinner
     *
     * @return the currently selected item
     */
    public List<Item> getCurrentItemList() {
       return _currentItemList;
    }

//    /**
//     * determines if the inventory selected by a spinner is empty or not
//     *
//     * @return if the inventory is empty
//     */
//    public boolean isCurrentItemListEmpty() {
//        return ( _currentItemList.isEmpty());
//    }

//    /**
//     * passes through the selected Location on the LocationListActivity spinner
//     *
//     * @return the currently selected location of the LocationListActivity
//     */
//    public Location getCurrentLocation() {
//        return selectedLocation;
//    }

    /**
     * sets the selected Location on the LocationListActivity spinner
     *
     * @param currentLocation the currently selected location on the LocationListActivity spinner
     */
    public void setCurrentLocation(String currentLocation) {
        for (Location l : locationManager.getLocationAsLocationArray()) {
            if (l.toString().equals(currentLocation)) {
                selectedLocation = l;
            }
        }
    }

//    /**
//     * passes through the selected Location on the AddDonationActivity spinner
//     *
//     * @return the currently selected location of the AddDonationActivity
//     */
//    public Location getCurrentLocationAddDonation() {
//        return _currentLocationAddDonation;
//    }

//    /**
//     * sets the selected Location on the AddDonationActivity spinner
//     *
//     * @param currentLocationAddDonation the currently selected location on the
//     *                                   AddDonationActivity spinner
//     */
//    public void setCurrentLocationAddDonation(String currentLocationAddDonation) {
//        for (Location l : locationManager.getLocationAsLocationArray()) {
//            if (l.toString().equals(currentLocationAddDonation)) {
//                _currentLocationAddDonation = l;
//            }
//        }
//    }

//    /**
//     * passes through the selected Item on the LocationDetailActivity spinner
//     *
//     * @return the currently selected item of the LocationDetailActivity
//     */
//    public Item getCurrentItemDetails() {
//        return selectedItemFromItemList;
//    }

    /**
     * gets the details of selected Item
     *
     * @return item details in a string
     */
    public List<String> getSelectedItemFromItemListAndSendToItemDetails() {
        return Item.getSelectedItemDetailsForItemsDetailsActivity(selectedItemFromItemList);
    }

    /**
     * sets the selected item from the spinner on the Item List page and sends it to the item
     * details page.
     *
     * @param selectionNumber the number of the selected item from the spinner
     */
    public void setSelectedItemFromItemListAndSendToItemDetails(int selectionNumber) {
//        for (Item item : itemManager.getItemManagerAsItemArray()) {
//            if (item.toString().equals(currentItemDetails) && item.) {
//                _currentItemDetails = item;
//            }
//        }

        selectedItemFromItemList = _currentItemList.get(selectionNumber);


    }

    /**
     * gets the the item details in a string from a selected item
     *
     * @return the item details in a string
     */
    public List<String> getSelectedLocationFromLocationListAndSendToLocationDetails() {
        return Location.getSelectedLocationDetailsForLocationDetailsActivity(selectedLocation);
    }





//    /**
//     * passes through the selected Category on the LocationDetailActivity spinner
//     *
//     * @return the currently selected Category of the LocationDetailActivity
//     */
//    public CategoryENUM getCurrentCategoryAddDonation() {
//        return _currentCategory;
//    }

//    /**
//     * sets the selected Category on the LocationDetailActivity spinner
//     *
//     * @param currentItemDetails the currently selected Category on the
//     *                           LocationDetailActivity spinner
//     */
//    public void setCurrentCategoryAddDonation(String currentItemDetails) {
//        for (CategoryENUM category : CategoryENUM.values()) {
//            if (category.toString().equals(currentItemDetails)) {
//                _currentCategory = category;
//            }
//        }
//    }

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