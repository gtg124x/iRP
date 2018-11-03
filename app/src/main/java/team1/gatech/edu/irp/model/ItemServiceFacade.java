package team1.gatech.edu.irp.model;

import java.util.List;

/****************************************************************************************
 *    MODEL
 ****************************************************************************************
 */
public final class ItemServiceFacade {

//    /****************************************************************************************
//     *    MODEL STUFF
//     ****************************************************************************************
//     */

    /**
     * Singleton instance
     */
    private static ItemServiceFacade _instance = new ItemServiceFacade();

    /**
     * getter for model
     *
     * @return  the model
     */
    public static ItemServiceFacade getInstance() {
        return _instance;
    }

    /**
     * make a new model
     */
    private ItemServiceFacade() {
        itemManager = new ItemManager();
    }


//    /****************************************************************************************
//     *     DATA MANGER ATTRIBUTES
//     ****************************************************************************************
//     */

    /**
     *  holds the items
     */
    private ItemManager itemManager;

    /**
     *  get the account manager
     *
     *  @return the account manager
     */
    public ItemManager getItemManager(){
        return itemManager;
    }

    /**
     *  sets the account manager
     *
     *  @param itemManagerImport the account manager
     */
    public void setItemManager(ItemManager itemManagerImport){
        itemManager = itemManagerImport;
    }

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

    /**
     * a list of items represented as Strings that have been added to the a selected location
     *
     * @return the inventory at a location
     */
    public List<Item> getInventoryByLocation() {
        _currentItemList = itemManager.getItemListByLocation(selectedLocation);
        return _currentItemList;
    }

    /**
     * finds the items sorted by location and category
     *
     * @param category item category
     * @param location store location
     *
     */
    public void setInventoryByCategoryAndLocation(CategoryENUM category,
                                                  String location ) {
        _currentItemList = itemManager.getItemListByCategoryAndLocation(category, location);
    }

    /**
     * finds the items sorted by location and name
     *
     * @param name item name
     * @param location store location
     *
     */
    public void setInventoryByNameAndLocation(String name, String location ) {
        _currentItemList = itemManager.getItemListByNameAndLocation(name, location);
    }

//    /****************************************************************************************
//     *    PASS THROUGH METHODS TO PASS VALUES FROM SPINNERS TO OTHER ACTIVITY PAGES
//     ****************************************************************************************
//     */


    /**
     * get the selected Item on the spinner
     *
     * @return the currently selected item
     */
    public List<Item> getCurrentItemList() {
        return _currentItemList;
    }


    /**
     * sets the selected Location on the LocationListActivity spinner
     *
     * @param currentLocation the currently selected location on the LocationListActivity spinner
     */
    public void setCurrentLocation(String currentLocation) {
        LocationServiceFacade locationServiceFacade = LocationServiceFacade.getInstance();
//        LocationManager locationManager = locationServiceFacade.getLocationManager();
        LocationManager locationManager = getLocationManager(locationServiceFacade);

        List<Location> locationArray = getLocation(locationManager);

//        for (Location l : locationManager.getLocationAsLocationArray()) {

        for (Location l : locationArray) {
            String currentLocationName = l.toString();
            if (currentLocationName.equals(currentLocation)) {
                selectedLocation = l;
            }
        }
    }

    /**
     * gets the location manager from the facade
     *
     * @param locationServiceFacade locationServiceFacade
     * @return the locationManager
     */
    private LocationManager getLocationManager(LocationServiceFacade locationServiceFacade) {
        return locationServiceFacade.getLocationManager();
    }

    /**
     * gets the locations
     *
     * @param locationManager locationManager
     * @return the locations in an array
     */
    private List<Location> getLocation(LocationManager locationManager) {
        return locationManager.getLocationAsLocationArray();
    }


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

}