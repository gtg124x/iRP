package team1.gatech.edu.irp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/****************************************************************************************
 *    ITEM MANAGER
 *    Notes: information holder
 ****************************************************************************************
 */
class ItemManager implements Serializable {

//    /***************************************************************************************
//     *    INVENTORY ATTRIBUTES
//     *    Notes: Same as locations, I created two arrays one to hold Item obj and one to hold
//     *    the toString of the obj for display on the spinner
//     ****************************************************************************************
//     */

    /**
     * holds the items that are donated
     */
    private final List<Item> inventory = new ArrayList<>();

    /**
     * used to test if inventory is empty
     */
    private static final int EMPTY = 0;



//    /***************************************************************************************
//     *    INVENTORY METHODS
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
    public AddDonationResultENUM validateAndAddItemToItemManager(String timeStamp, String dateStamp, Location location,
                                                                 CategoryENUM category, String dollarValue,
                                                                 String shortDescription, String fullDescription) {
        if (validateTimeStamp(timeStamp)) {
            return AddDonationResultENUM.TIME_INVALID;
        } else if (validateDateStamp(dateStamp)) {
            return AddDonationResultENUM.DATE_INVALID;
        } else if (validateDollarValue(dollarValue)) {
            return AddDonationResultENUM.VALUE_INVALID;
        } else if (validateShortDescription(shortDescription)) {
            return AddDonationResultENUM.SHORT_DESCRIPTION_INVALID_TO_SHORT;
        } else if (validateShortDescriptionLong(shortDescription) ) {
            return AddDonationResultENUM.SHORT_DESCRIPTION_INVALID_TO_LONG;
        } else if (validateFullDescription(fullDescription)) {
            return AddDonationResultENUM.LONG_DESCRIPTION_INVALID_TO_SHORT;
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
    private boolean validateTimeStamp(String time) {
        if (time.equals("")) { return true; }
        if (time.length() != 8) { return true; }
        String firstColon = "" + time.charAt(2);
        String secondColon = "" + time.charAt(5);
        if (!(firstColon.equals(":")) || !(secondColon.equals(":"))) { return true; }

        String hourAsString = "" + time.charAt(0) + time.charAt(1);
        String minAsString = "" + time.charAt(3) + time.charAt(4);
        String secAsString = "" + time.charAt(6) + time.charAt(7);

        try {
            int hourAsInt = Integer.parseInt(hourAsString);
            int minAsInt = Integer.parseInt(minAsString);
            int secAsInt = Integer.parseInt(secAsString);

            return (hourAsInt < 0 || hourAsInt >= 24 || minAsInt < 0 || minAsInt >= 60 || secAsInt < 0 || secAsInt >= 60);

        } catch (NumberFormatException e) {
            return true;
        }

    }

    /**
     * helper method to validate the user input for the date stamp field
     *
     * @param date the date stamp
     *
     * @return the result success of the validation
     */
    private boolean validateDateStamp(String date) {
        if (date.equals("")) { return true; }
        if (date.length() != 10) { return true; }
        String firstDash = "" + date.charAt(2);
        String secondDash = "" + date.charAt(5);
        if (!(firstDash.equals("-")) || !(secondDash.equals("-"))) { return true; }

        String monthAsString = "" + date.charAt(0) + date.charAt(1);
        String dateString = "" + date.charAt(3) + date.charAt(4);
        String yearAsString = "" + date.charAt(6) + date.charAt(7) + date.charAt(8) + date.charAt(9);

        try {
            int monthAsInt = Integer.parseInt(monthAsString);
            int dateAsInt = Integer.parseInt(dateString);
            int yearAsInt = Integer.parseInt(yearAsString);

            return (monthAsInt < 1 || monthAsInt > 12 || dateAsInt < 0 || dateAsInt > 31 || yearAsInt < 2000 || yearAsInt >= 2020
                    || ((monthAsInt == 4 || monthAsInt == 6 || monthAsInt == 9 || monthAsInt == 11) && (dateAsInt > 30))
                    || (monthAsInt == 2 && dateAsInt > 29));

        } catch (NumberFormatException e) {
            return true;
        }

    }

    /**
     * helper method to validate the user input for the dollarValue field
     *
     * @param dollarValue the dollarValue
     *
     * @return the result success of the validation
     */
    private boolean validateDollarValue(String dollarValue) {
        if (dollarValue.equals("")) { return true; }
        if (dollarValue.length() < 4) { return true; }

        String change = "" + dollarValue.charAt(dollarValue.length() - 2) + dollarValue.charAt(dollarValue.length() - 1);
        String dollars = "" + dollarValue.substring(0, dollarValue.length() - 3);
        String decimalPoint = "" + dollarValue.charAt(dollarValue.length() - 3);
        if (!(decimalPoint.equals("."))) { return true; }

        try {
            int changeAsInt = Integer.parseInt(change);
            int dollarsAsInt = Integer.parseInt(dollars);

            return (changeAsInt < 0 || changeAsInt > 99 || dollarsAsInt < 0 || (dollarsAsInt == 0 && changeAsInt == 0));

        } catch (NumberFormatException e) {
            return true;
        }

    }


    /**
     * helper method to validate the user input for the short description field if to short
     *
     * @param shortD the short description
     *
     * @return the result success of the validation
     */
    private boolean validateShortDescription(String shortD) {
        return (shortD.length() < 2);
    }

    /**
     * helper method to validate the user input for the short description field if to long
     *
     * @param shortD the short description
     *
     * @return the result success of the validation
     */
    private boolean validateShortDescriptionLong(String shortD) {
        return (shortD.length() >= 15);
    }

    /**
     * helper method to validate the user input for the full description field if to short
     *
     * @param fullD the full description
     *
     * @return the result success of the validation
     */
    private boolean validateFullDescription(String fullD) {
        return (fullD.length() < 3);
    }

    /**
     * returns a list of items that have been added to the app
     *
     * @return list of Item objects
     */
    public List<Item> getItemManagerAsItemArray() { return inventory; }

    /**
     * finds the items sorted by location
     *
     * @param location store location
     *
     * @return list of items in inventory at a particular location
     */
    public List<Item> getItemListByLocation(Location location) {
        List<Item> itemLocationList = new ArrayList<>();
        for (Item i : inventory) {
            if (i.getLocation().equals(location)) {
                itemLocationList.add(i);
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
    public List<Item> getItemListByCategoryAndLocation(CategoryENUM category, String location) {
        List<Item> itemLocationList = new ArrayList<>();
        if (location.equals("All Locations")) {
            for (Item i : inventory) {
                if (i.getCategory().equals(category)) {
                    itemLocationList.add(i);
                }
            }
        } else {
            for (Item i : inventory) {
                if (i.getLocation().toString().equals(location) && i.getCategory().equals(category)) {
                    itemLocationList.add(i);
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
    public List<Item> getItemListByNameAndLocation(String name, String location) {
        List<Item> itemLocationList = new ArrayList<>();
        if (location.equals("All Locations")) {
            for (Item i : inventory) {
                if (i.getShortDescription().equals(name)) {
                    itemLocationList.add(i);
                }
            }
        } else {
            for (Item i : inventory) {
                if (i.getLocation().toString().equals(location) && i.getShortDescription().equals(name)) {
                    itemLocationList.add(i);
                }
            }
        }
        return itemLocationList;
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

    /**
     * converts list of items to strings
     *
     * @param itemList item list
     *
     * @return list of items in as strings
     */
    public List<String> getItemListAsString(List<Item> itemList ) {
        List<String> itemLocationList = new ArrayList<>();
        for (Item i : itemList) {
            itemLocationList.add(i.toString());
            }
        return itemLocationList;
    }


}

