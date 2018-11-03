package team1.gatech.edu.irp.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.List;
//import android.view.View;

/****************************************************************************************
 *    MODEL
 ****************************************************************************************
 */
public final class Model {

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
    private List<Item> _currentItemList;

    /**
     * the currently selected location of the LocationListActivity
     */
    private Location selectedLocation;

    /**
     * convert string to location for LocationDetailActivity
     */
    private Item selectedItemFromItemList;

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


//    /****************************************************************************************
//     *    LOCATION MANAGER PASS THROUGH METHODS
//     *    Notes: Pass through methods from Controller to Model, being from the
//     *           AdminActivity to LocationManager.
//     ****************************************************************************************
//     */

//    /**
//     * loads the locations from CSV file to app
//     *
//     * @param v the view
//     * @return list of Location objects
//     */
//    public boolean loadLocations(View v) { return locationManager.loadLocationsFromCSV(v); }

//    /**
//     * tests whether or not the location list is empty
//     *
//     * @return if there are no locations entered in the app
//     */
//    public boolean noLocations() { return locationManager.locationListEmpty(); }

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

//    /**
//     * a list of locations represented as Strings that have been added to the app with All
//     * locations as first option
//     *
//     * @return list of locations represented as Strings with All locations as first option
//     */
//    public List<String> getLocationsAsStringWithAllLocationOption() {
//        return locationManager.getLocationsAsStringArrayWithAllLocationOption();
//    }


//    /****************************************************************************************
//     *    ITEM MANAGER PASS THROUGH METHODS
//     *    Notes: Pass through methods from Controller to Model, being from the
//     *           AddDonationActivity to ItemManager.
//     ****************************************************************************************
//     */

//    /**
//     * Validates the user input then adds the item into the inventory
//     *
//     * @param timeStamp         the account login name
//     * @param dateStamp         date stamp for the item
//     * @param location          location for the item
//     * @param category          category for the item
//     * @param dollarValue       dollar value for the item
//     * @param shortDescription   short description for the item
//     * @param fullDescription    full description for the item
//     *
//     * @return the result of the adding and item to inventory in the form of AddDonationResultENUM
//     */
//    public AddDonationResultENUM validateAndAddItemToInventory(String timeStamp,
//                                                               String dateStamp,
//                                                               Location location,
//                                                               CategoryENUM category,
//                                                               String dollarValue,
//                                                               String shortDescription,
//                                                               String fullDescription) {
//        return itemManager.validateAndAddItemToItemManager(timeStamp, dateStamp, location,
//                category, dollarValue, shortDescription, fullDescription);
//    }

    /**
     * a list of items represented as Strings that have been added to the a selected location
     *
     * @return the inventory at a location
     */
    public List<Item> getInventoryByLocation() {
        _currentItemList = itemManager.getItemListByLocation(selectedLocation);
        return _currentItemList;
    }

//    /**
//     * finds the items sorted by location and category
//     *
//     * @param category item category
//     * @param location store location
//     *
//     */
//    public void setInventoryByCategoryAndLocation(CategoryENUM category,
//                                                        String location ) {
//        _currentItemList = itemManager.getItemListByCategoryAndLocation(category, location);
//    }

//    /**
//     * finds the items sorted by location and name
//     *
//     * @param name item name
//     * @param location store location
//     *
//     */
//    public void setInventoryByNameAndLocation(String name, String location ) {
//        _currentItemList = itemManager.getItemListByNameAndLocation(name, location);
//    }

//    /****************************************************************************************
//     *    PASS THROUGH METHODS TO PASS VALUES FROM SPINNERS TO OTHER ACTIVITY PAGES
//     ****************************************************************************************
//     */


//    /**
//     * get the selected Item on the spinner
//     *
//     * @return the currently selected item
//     */
//    public List<Item> getCurrentItemList() {
//       return _currentItemList;
//    }


    /**
     * sets the selected Location on the LocationListActivity spinner
     *
     * @param currentLocation the currently selected location on the LocationListActivity spinner
     */
    public void setCurrentLocation(String currentLocation) {
        for (Location l : locationManager.getLocationAsLocationArray()) {
            String currentLocationName = l.toString();
            if (currentLocationName.equals(currentLocation)) {
                selectedLocation = l;
            }
        }
    }

//    /**
//     * gets the details of selected Item
//     *
//     * @return item details in a string
//     */
//    public List<String> getSelectedItemFromItemListAndSendToItemDetails() {
//        return Item.getSelectedItemDetailsForItemsDetailsActivity(selectedItemFromItemList);
//    }

    /**
     * sets the selected item from the spinner on the Item List page and sends it to the item
     * details page.
     *
     * @param selectionNumber the number of the selected item from the spinner
     */
    public void setSelectedItemFromItemListAndSendToItemDetails(int selectionNumber) {
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

    /**
     * Deletes the Binary file
     *
     * Note: DOES NOT DELETE TEMP DATA IN ARRAY'S, JUST DELETES THE FILE!
     *
     * @param file the file that holds the persistence data
     * @return the success
     */
    public boolean deleteBinary(File file) {
        return file.delete();
    }

    /**
     * Loads the Binary file
     * To read, we must use the ObjectInputStream since we want to read our model in with
     * a single read.
     *
     * @param file the file that holds the persistence data
     * @return the success
     */
    public boolean loadBinary(File file) {
        boolean success = true;
        try {
            //Model model = Model.getInstance();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            // assuming we saved our top level object, we read it back in with one line of code.
            accountManager = (AccountManager) in.readObject();
            locationManager = (LocationManager) in.readObject();
            itemManager = (ItemManager) in.readObject();
            in.close();
        } catch (IOException e) {
            success = false;
        } catch (ClassNotFoundException e) {
            success = false;
        }
        return success;
    }

    /**
     * Saves the Binary file
     *
     * For binary, we use Serialization, so everything we write has to implement
     * the Serializable interface.  Fortunately all the collection classes and APi classes
     * that we might use are already Serializable.  You just have to make sure your
     * classes implement Serializable.
     *
     * We have to use an ObjectOutputStream to write objects.
     * One thing to be careful of:  You cannot serialize static data.
     *
     * We basically can save our entire data model with one write, since this will follow
     * all the links and pointers to save everything.  Just save the top level object.
     *
     * @param file the file that holds the persistence data
     * @return the success
     */
    public boolean saveBinary(File file) {
        boolean success = true;
        try {
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(accountManager);
            out.writeObject(locationManager);
            out.writeObject(itemManager);
            out.close();
        } catch (IOException e) {
            success = false;
        }
        return success;
    }

}