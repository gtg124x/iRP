package team1.gatech.edu.irp.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
//     *    PERSISTENCE DATA ATTRIBUTE
//     ****************************************************************************************
//     */

//    /**
//     * File for persistence data
//     */
//    public final static String DEFAULT_BINARY_FILE_NAME = "data.bin";


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

    public void setAccountManager(AccountManager accountManager) { this.accountManager = accountManager; }
    public void setLocationManager(LocationManager locationManager) { this.locationManager = locationManager; }
    public void setItemManager(ItemManager itemManager) { this.itemManager = itemManager; }

    public AccountManager getAccountManager() { return accountManager; }
    public LocationManager getLocationManager() { return locationManager; }
    public ItemManager getItemManager() { return itemManager; }


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


//    /****************************************************************************************
//     *    ACCOUNT MANAGER METHODS
//     *    Notes: Pass through methods from Controller to Model, being from the
//     *           RegistrationActivity to AccountManager.
//     ****************************************************************************************
//     */

    /**
     * adds an account to the system
     *
     *  @param name an account name
     *  @param pword an account password
     *  @param cInfo an account contact info
     *  @param userTypeEnum an account type
     *  @return success
     */
    public RegistrationResultENUM addAccount(String name, String pword, String cInfo, UserTypeENUM userTypeEnum) {
        return accountManager.addToAccounts(name, pword, cInfo, userTypeEnum);
    }

    /**
     * validate the login information
     *
     *  @param name an account name
     *  @param pword an account password
     *
     *  @return success
     */
    public boolean validateLogin(String name, String pword) {
        return accountManager.loginCheck(name, pword);
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
//     *    LOCATION MANAGER METHODS
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


    /****************************************************************************************
     *    ITEM MANAGER METHODS
     *    Notes: Pass through methods from Controller to Model, being from the
     *           AddDonationActivity to ItemManager.
     ****************************************************************************************
     */

    public AddDonationResultENUM validateAndAddItemToInventory(String timeStamp, String dateStamp,
                                                               Location location, CategoryENUM category,
                                                               String dollarValue, String shortDescription,
                                                               String fullDescription) {
        return itemManager.validateAndAddItemToItemManager(timeStamp, dateStamp, location, category,
                dollarValue, shortDescription, fullDescription);
    }

//    /**
//     * tests whether or not the inventory is empty
//     *
//     * @return if the inventory is empty
//     */
//    public boolean inventoryEmpty() { return itemManager.itemListEmpty(); }

//    /**
//     * adds and item to the inventory
//     *
//     *  @param item a donation item
//     */
//    public void addToInventory(Item item) { itemManager.addToItemManager(item);}

//    /**
//     * a list of items that have been added to the app
//     *
//     * @return list of items objects
//     */
//    public List<Item> getInventoryAsItemArray() { return itemManager.getItemManagerAsItemArray(); }

//    /**
//     * a list of items represented as Strings that have been added to the app
//     *
//     * @return list of items represented as Strings
//     */
//    public List<String> getInvtoryAsStringArrary() { return itemManager.getItemManagerAsStringArray(); }

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
//        boolean success;
//        if( _currentItemList.size() == 0) {
//            success = true;
//        } else {
//            success = false;
//        }
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


////    /****************************************************************************************
////     *    PERSISTENCE DATA METHODS
////     ****************************************************************************************
////     */
//
//
//    /**
//     * Deletes the Binary file
//     *
//     * @param file the file that holds the persistence data
//     */
//    public boolean deleteBinary(File file) {
//        return file.delete();
//    }
//
//    /**
//     * Loads the Binary file
//     *
//     * @param file the file that holds the persistence data
//     */
//    public boolean loadBinary(File file) {
//        boolean success = true;
//        try {
////            /**
////             * To read, we must use the ObjectInputStream since we want to read our model in with
////             * a single read.
////             */
//            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
//            // assuming we saved our top level object, we read it back in with one line of code.
//            accountManager = (AccountManager) in.readObject();
//            locationManager =  (LocationManager) in.readObject();
//            itemManager = (ItemManager) in.readObject();
//            in.close();
//        } catch (IOException e) {
//            success = false;
//        } catch (ClassNotFoundException e) {
//           success = false;
//        }
//
//        return success;
//    }
//
//    /**
//     * Saves the Binary file
//     *
//     * @param file the file that holds the persistence data
//     */
//    public boolean saveBinary(File file) {
//        boolean success = true;
//        try {
//
////            /**
////             * For binary, we use Serialization, so everything we write has to implement
////             * the Serializable interface.  Fortunately all the collection classes and APi classes
////             * that we might use are already Serializable.  You just have to make sure your
////             * classes implement Serializable.
////             *
////             * We have to use an ObjectOutputStream to write objects.
////             * One thing to be careful of:  You cannot serialize static data.
////             *
////             */
//            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
//
////            /**
////             * We basically can save our entire data model with one write, since this will follow
////             * all the links and pointers to save everything.  Just save the top level object.
////             */
//            out.writeObject(accountManager);
//            out.writeObject(locationManager);
//            out.writeObject(itemManager);
//
//            out.close();
//
//        } catch (IOException e) {
//            success = false;
//        }
//        return success;
//    }

}