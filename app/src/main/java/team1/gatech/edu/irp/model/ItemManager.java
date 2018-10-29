package team1.gatech.edu.irp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/****************************************************************************************
 *    ITEM MANAGER
 *    Notes: information holder
 ****************************************************************************************
 */
public class ItemManager implements Serializable {

    /****************************************************************************************
     *    INVENTORY ATTRIBUTES
     *    Notes: Same as locations, I created two arrays one to hold Item obj and one to hold
     *    the toString of the obj for display on the spinner
     ****************************************************************************************
     */

    /**
     * holds the items that are donated
     */
    private List<Item> inventory = new ArrayList<>();

    /**
     * array to hold string representation of item in inventory
     */
    private List<String> inventoryStringArray;

    /**
     * used to test if inventory is empty
     */
    private static final int EMPTY = 0;

    /****************************************************************************************
     *    INVENTORY METHODS
     ****************************************************************************************
     */

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
    public AddDonationResultENUM validateAndAddItemToItemManager(String timeStamp, String dateStamp, Location location,
                                                                 CategoryENUM category, String dollarValue,
                                                                 String shortDescription, String fullDescription) {
        if (!validiateTimeStamp(timeStamp)) {
            return AddDonationResultENUM.TIME_INVALID;
        } else if (!validiateDateStamp(dateStamp)) {
            return AddDonationResultENUM.DATE_INVALID;
        } else if (!validiateDollarValue(dollarValue)) {
            return AddDonationResultENUM.VALUE_INVALID;
        } else if (shortDescription.length() < 3) {
            return AddDonationResultENUM.SHORTDESCRIPTION_INVALID_TO_SHORT;
        } else if (shortDescription.length() > 15 ) {
            return AddDonationResultENUM.SHORTDESCRIPTION_INVALID_TO_LONG;
        } else if (fullDescription.length() < 3) {
            return AddDonationResultENUM.LONGDESCRIPTION_INVALID_TO_SHORT;
        } else {
            Item item = new Item(timeStamp, dateStamp, location, category, dollarValue, shortDescription, fullDescription);
            inventory.add(item);
            return AddDonationResultENUM.SUCCESS;
        }
    }

    /**
     * helper method to validate the user input for the time stamp field
     *
     * @param time the time stamp
     *
     * @return the result success of the validation
     */
    private boolean validiateTimeStamp(String time) {
        if (time.length() != 8) { return false; }
        String firstColen = "" + time.charAt(2);
        String secondColen = "" + time.charAt(5);
        if (!(firstColen.equals(":")) || !(secondColen.equals(":"))) { return false; }

        String hourAsString = "" + time.charAt(0) + time.charAt(1);
        String minAsString = "" + time.charAt(3) + time.charAt(4);
        String secAsString = "" + time.charAt(6) + time.charAt(7);

        try {
            int hourAsInt = Integer.parseInt(hourAsString);
            int minAsInt = Integer.parseInt(minAsString);
            int secAsInt = Integer.parseInt(secAsString);

            if (hourAsInt < 0 || hourAsInt >= 24) { return false; }
            else if (minAsInt < 0 || minAsInt >= 60) { return false; }
            else if (secAsInt < 0 || secAsInt >= 60) { return false; }
            else { return true; }

        } catch (NumberFormatException e) {
            return false;
        }

    }

    /**
     * helper method to validate the user input for the date stamp field
     *
     * @param date the date stamp
     *
     * @return the result success of the validation
     */
    private boolean validiateDateStamp(String date) {
        if (date.length() != 10) { return false; }
        String firstDast = "" + date.charAt(2);
        String secondDash = "" + date.charAt(5);
        if (!(firstDast.equals("-")) || !(secondDash.equals("-"))) { return false; }

        String monthAsString = "" + date.charAt(0) + date.charAt(1);
        String dateString = "" + date.charAt(3) + date.charAt(4);
        String yearAsString = "" + date.charAt(6) + date.charAt(7) + date.charAt(8) + date.charAt(9);

        try {
            int monthAsInt = Integer.parseInt(monthAsString);
            int dateAsInt = Integer.parseInt(dateString);
            int yearAsInt = Integer.parseInt(yearAsString);

            if (monthAsInt < 1 || monthAsInt > 12) { return false; }
            else if (dateAsInt < 0 || dateAsInt >= 31) { return false; }
            else if (yearAsInt < 2000 || yearAsInt >= 2020) { return false; }
            else if ((monthAsInt == 4 || monthAsInt == 6 || monthAsInt == 9 || monthAsInt == 11)
                    && (dateAsInt > 30)) { return false; }
            else if (monthAsInt == 2 && dateAsInt > 28) { return false; }
            else { return true; }

        } catch (NumberFormatException e) {
            return false;
        }

    }

    /**
     * helper method to validate the user input for the dollarValue field
     *
     * @param dollarValue the dollarValue
     *
     * @return the result success of the validation
     */
    private boolean validiateDollarValue(String dollarValue) {
        if (dollarValue.length() < 4) { return false; }

        String change = "" + dollarValue.charAt(dollarValue.length() - 2) + dollarValue.charAt(dollarValue.length() - 1);
        String dollars = "" + dollarValue.substring(0, dollarValue.length() - 3);
        String decimalPoint = "" + dollarValue.charAt(dollarValue.length() - 3);
        if (!(decimalPoint.equals("."))) { return false; }

        try {
            int changeAsInt = Integer.parseInt(change);
            int dollarsAsInt = Integer.parseInt(dollars);

            if (changeAsInt < 0 || changeAsInt > 99) { return false; }
            else if (dollarsAsInt < 0) { return false; }
            else if (dollarsAsInt == 0 && changeAsInt == 0) { return false; }
            else { return true; }

        } catch (NumberFormatException e) {
            return false;
        }

    }

    /**
     * adds an item to the inventory
     *
     * @param item a donated item at a location
     */
    public void addToItemManager(Item item) {
        inventory.add(item);
    }

    /**
     * returns a list of items that have been added to the app
     *
     * @return list of Item objects
     */
    public List<Item> getItemManagerAsItemArray() { return inventory; }

    /**
     * returns a list of items represented as Strings that have been added to the app
     *
     * @return list of items represented as Strings
     */
    public List<String> getItemManagerAsStringArray() {
        inventoryStringArray = new ArrayList<>();
        for (Item i : inventory) {
            inventoryStringArray.add(i.toString());
        }
        return inventoryStringArray;
    }

    /**
     * finds the items sorted by location
     *
     * @param location store location
     *
     * @return list of items in inventory at a particular location
     */
    public List<String> getItemListByLocation(Location location) {
        List<String> itemLocationList = new ArrayList<>();
        for (Item i : inventory) {
            if (i.getLocation().equals(location)) {
                itemLocationList.add(i.toString());
            }
        }
        return itemLocationList;
    }

    /**
     * finds the items sorted by location and category
     *
     * @param category item category
     * @param location store location
     *
     * @return list of items in inventory at a particular location and category
     */
    public List<String> getItemListByCategoryAndLocation(CategoryENUM category, String location) {
        List<String> itemLocationList = new ArrayList<>();
        if (location.equals("All Locations")) {
            for (Item i : inventory) {
                if (i.getCategory().equals(category)) {
                    itemLocationList.add(i.toString());
                }
            }
        } else {
            for (Item i : inventory) {
                if (i.getLocation().toString().equals(location) && i.getCategory().equals(category)) {
                    itemLocationList.add(i.toString());
                }
            }
        }
        return itemLocationList;
    }

    /**
     * finds the items sorted by location and name
     *
     * @param name item name
     * @param location store location
     *
     * @return list of items in inventory at a particular location and name
     */
    public List<String> getItemListByNameAndLocation(String name, String location) {
        List<String> itemLocationList = new ArrayList<>();
        if (location.equals("All Locations")) {
            for (Item i : inventory) {
                if (i.getShortDescripiton().equals(name)) {
                    itemLocationList.add(i.toString());
                }
            }
        } else {
            for (Item i : inventory) {
                if (i.getLocation().toString().equals(location) && i.getShortDescripiton().equals(name)) {
                    itemLocationList.add(i.toString());
                }
            }
        }
        return itemLocationList;
    }

    /**
     * tests whether or not the inventory is empty
     *
     * @return if the inventory is empty
     */
    public boolean itemListEmpty() {
        boolean success;
        if (inventory.size() == 0) {
            success = true;
        } else {
            success = false;
        }
        return success;
    }

    /**
     * determines if the inventory at a location is empty or no
     *
     * @param  location currently selected location to analyze for inventory size
     * @return if the inventory is empty
     */
    public boolean isItemListByLocationEmpty(Location location) {
        List<String> itemLocationList = new ArrayList<>();
        for (Item i : inventory) {
            if (i.getLocation().equals(location)) {
                itemLocationList.add(i.toString());
            }
        }
        return itemLocationList.size() == EMPTY;
    }



}
