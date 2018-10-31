package team1.gatech.edu.irp.model;

import android.support.annotation.NonNull;

import java.io.Serializable;


/****************************************************************************************
 *    ITEM
 *    Notes: information holder
 ****************************************************************************************
 */
public class Item implements Serializable {

///*********************************************************************************************
// *    ATTRIBUTES
// *****************************************************************************************
// */

    /** time stamp for the item */
    private String timeStamp;

    /** date stamp for the item */
    private String dateStamp;

    /** location for the item */
    private Location location;

    /** category for the item */
    private CategoryENUM category;

    /** dollar value for the item */
    private String dollarValue;

    /** short description for the item */
    private String shortDescription;

    /** full description for the item */
    private String fullDescription;


///*********************************************************************************************
// *    CONSTRUCTORS
// *    ****************************************************************************************
// */

    /**
     * Make a new item
     * @param timeStamp         the account login name
     * @param dateStamp         date stamp for the item
     * @param location          location for the item
     * @param category          category for the item
     * @param dollarValue       dollar value for the item
     * @param shortDescription   short description for the item
     * @param fullDescription    full description for the item
     *
     */
    public Item(String timeStamp, String dateStamp, Location location, CategoryENUM category, String dollarValue,
                String shortDescription, String fullDescription) {
        this.timeStamp = timeStamp;
        this.dateStamp = dateStamp;
        this.location = location;
        this.category = category;
        this.dollarValue = dollarValue;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
    }

//    /**
//     * No param constructor -- DO NOT CALL NORMALLY
//     */
//    public Item() {
//        this("12:00:00" , "12-25-2018", new Location(), CategoryENUM.CLOTHING,
//                "10.00", "Best Shirt Ever", "Really Old Shirt");
//    }


///*********************************************************************************************
// *    GETTERS AND SETTERS
// *****************************************************************************************
// */

    /**
     * getter for the timeStamp
     *
     * @return the  timeStamp
     */
    public String getTimeStamp() { return timeStamp; }

//    /**
//     * sets the timeStamp
//     *
//     * @param timeStamp the timeStamp
//     */
//    public void setTimeStamp(String timeStamp) { this.timeStamp = timeStamp; }

    /**
     * getter for the dateStamp
     *
     * @return the dateStamp
     */
    public String getDateStamp() { return dateStamp; }

//    /**
//     * sets the dateStamp
//     *
//     * @param dateStamp the dateStamp
//     */
//    public void setDateStamp(String dateStamp) { this.dateStamp = dateStamp; }

    /**
     * getter for the location
     *
     * @return the location
     */
    public Location getLocation() { return location; }

//    /**
//     * sets the location
//     *
//     * @param location the location
//     */
//    public void setLocation(Location location) { this.location = location; }

    /**
     * getter for the category
     *
     * @return the category
     */
    public CategoryENUM getCategory() { return category; }

//    /**
//     * sets the category
//     *
//     * @param category the category
//     */
//    public void setCategory(CategoryENUM category) { this.category = category; }

    /**
     * getter for the dollarValue
     *
     * @return the dollarValue
     */
    public String getDollarValue() { return dollarValue; }

//    /**
//     * sets the dollarValue
//     *
//     * @param dollarValue the dollarValue
//     */
//    public void setDollarValue(String dollarValue) { this.dollarValue = dollarValue; }

    /**
     * getter for the shortDescription
     *
     * @return the shortDescription
     */
    public String getShortDescription() { return shortDescription; }

//    /**
//     * sets the shortDescription
//     *
//     * @param shortDescription the shortDescription
//     */
//    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

    /**
     * getter for the fullDescription
     *
     * @return the fullDescription
     */
    public String getFullDescription() { return fullDescription; }

//    /**
//     * sets the fullDescription
//     *
//     * @param fullDescription the fullDescription
//     */
//    public void setFullDescription(String fullDescription) { this.fullDescription = fullDescription; }



    /**
     * Override the toString to just return the "Short Description"
     *
     * @return the display string representation
     */
    @NonNull
    @Override
    public String toString() {
        return shortDescription;
    }

    /**
     * Override the equals to just check the "Short Description"
     *
     * @return the success of the equals test
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Item)) {
            return false;
        }
        Item i = (Item) o;
        return (i.getShortDescription().equals(shortDescription));
    }



}
