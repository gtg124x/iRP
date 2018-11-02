package team1.gatech.edu.irp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
    private final Collection<Item> inventory = new ArrayList<>();

    private static final int MAX_HOURS = 24;
    private static final int MAX_MINUTES = 24;
    private static final int MAX_SECONDS = 60;
    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int APRIL = 4;
    private static final int JUNE = 6;
    private static final int SEPTEMBER = 9;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;

    private static final int FEBRUARY_MONTH_MAX = 29;
    private static final int MONTH_LOW_MAX = 30;
    private static final int MONTH_HIGH_MAX = 31;
    private static final int YEAR_LOW_MAX = 2000;
    private static final int YEAR_HIGH_MAX = 3000;

    private static final int MAX_DOLLARS = 99;

    private static final int MAX_SHORT_DESCRIPTION = 15;

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
    public AddDonationResultENUM validateAndAddItemToItemManager(String timeStamp,
                                                                 String dateStamp,
                                                                 Location location,
                                                                 CategoryENUM category,
                                                                 String dollarValue,
                                                                 String shortDescription,
                                                                 String fullDescription) {
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
            Item item = new Item(timeStamp, dateStamp, location, category, dollarValue,
                    shortDescription, fullDescription);
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
        if ("".equals(time)) { return true; }
        if (time.length() != 8) { return true; }
        String firstColon = "" + time.charAt(2);
        String secondColon = "" + time.charAt(5);
        if (!(":".equals(firstColon)) || !(":".equals(secondColon))) { return true; }

        String hourAsString = "" + time.charAt(0) + time.charAt(1);
        String minAsString = "" + time.charAt(3) + time.charAt(4);
        String secAsString = "" + time.charAt(6) + time.charAt(7);

        try {
            int hourAsInt = Integer.parseInt(hourAsString);
            int minAsInt = Integer.parseInt(minAsString);
            int secAsInt = Integer.parseInt(secAsString);

            return ((hourAsInt < 0) || (hourAsInt >= MAX_HOURS) || (minAsInt < 0)
                    || (minAsInt >= MAX_MINUTES) || (secAsInt < 0) || (secAsInt >= MAX_SECONDS));

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
        if ("".equals(date)) { return true; }
        if (date.length() != 10) { return true; }
        String firstDash = "" + date.charAt(2);
        String secondDash = "" + date.charAt(5);
        if (!("-".equals(firstDash)) || !("-".equals(secondDash))) { return true; }

        String monthAsString = "" + date.charAt(0) + date.charAt(1);
        String dateString = "" + date.charAt(3) + date.charAt(4);
        String yearAsString = "" + date.charAt(6) + date.charAt(7) + date.charAt(8)
                + date.charAt(9);

        try {
            int monthAsInt = Integer.parseInt(monthAsString);
            int dateAsInt = Integer.parseInt(dateString);
            int yearAsInt = Integer.parseInt(yearAsString);

            return ((monthAsInt < JANUARY) || (monthAsInt > DECEMBER) || (dateAsInt < 0)
                    || (dateAsInt > MONTH_HIGH_MAX) || (yearAsInt < YEAR_LOW_MAX)
                    || (yearAsInt >= YEAR_HIGH_MAX)
                    || (((monthAsInt == APRIL) || (monthAsInt == JUNE) || (monthAsInt == SEPTEMBER)
                    || (monthAsInt == NOVEMBER)) && (dateAsInt > MONTH_LOW_MAX))
                    || ((monthAsInt == FEBRUARY) && (dateAsInt > FEBRUARY_MONTH_MAX)));

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
        if ("".equals(dollarValue)) { return true; }
        if (dollarValue.length() < 4) { return true; }

        String change = "" + dollarValue.charAt(dollarValue.length() - 2)
                + dollarValue.charAt(dollarValue.length() - 1);
        String dollars = "" + dollarValue.substring(0, dollarValue.length() - 3);
        String decimalPoint = "" + dollarValue.charAt(dollarValue.length() - 3);
        if (!(".".equals(decimalPoint))) { return true; }

        try {
            int changeAsInt = Integer.parseInt(change);
            int dollarsAsInt = Integer.parseInt(dollars);

            return ((changeAsInt < 0) || (changeAsInt > MAX_DOLLARS) || (dollarsAsInt < 0)
                    || ((dollarsAsInt == 0) && (changeAsInt == 0)));

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
        return (shortD.length() >= MAX_SHORT_DESCRIPTION);
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
     * finds the items sorted by location
     *
     * @param location store location
     *
     * @return list of items in inventory at a particular location
     */
    public List<Item> getItemListByLocation(Location location) {
        List<Item> itemLocationList = new ArrayList<>();
        for (Item i : inventory) {
            Location currentLocation = i.getLocation();
//            if (currentLocation.equals(location)) {
            if (locationsEqual(currentLocation, location)) {
                itemLocationList.add(i);
            }
        }
        return itemLocationList;
    }

    /**
     * checks if the current location equals the location
     *
     * @param location1 first location
     * @param location2 second location
     * @return success
     */
    private boolean locationsEqual(Location location1, Location location2) {
        return location1.equals(location2);
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
        for (Item i : inventory) {
            CategoryENUM itemCategory = i.getCategory();
            Location currentLocation = i.getLocation();
            String currentLocationString = currentLocation + "";
            if ("All Locations".equals(location) && itemCategory.equals(category)) {
                    itemLocationList.add(i);
            } else if (currentLocationString.equals(location)
                        && itemCategory.equals(category)) {
                    itemLocationList.add(i);
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
        for (Item i : inventory) {
            String shortDescription = i.getShortDescription();
            Location currentLocation = i.getLocation();
            String currentLocationString = currentLocation + "";
            if ("All Locations".equals(location) && shortDescription.equals(name)) {
                itemLocationList.add(i);
            } else if (currentLocationString.equals(location)
                    && shortDescription.equals(name)) {
                    itemLocationList.add(i);
            }
        }
        return itemLocationList;
    }

}

