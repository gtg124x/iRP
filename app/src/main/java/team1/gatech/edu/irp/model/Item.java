package team1.gatech.edu.irp.model;

import java.io.Serializable;


/****************************************************************************************
 *    ITEM
 *    Notes: information holder
 ****************************************************************************************
 */
public class Item implements Serializable {

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
    private String shortDescripiton;

    /** full description for the item */
    private String fullDescripiton;


    /**
     * Make a new item
     * @param timeStamp         the account login name
     * @param dateStamp         date stamp for the item
     * @param location          location for the item
     * @param category          category for the item
     * @param dollarValue       dollar value for the item
     * @param shortDescripiton   short description for the item
     * @param fullDescripiton    full description for the item
     *
     */
    public Item(String timeStamp, String dateStamp, Location location, CategoryENUM category, String dollarValue,
                String shortDescripiton, String fullDescripiton) {
        this.timeStamp = timeStamp;
        this.dateStamp = dateStamp;
        this.location = location;
        this.category = category;
        this.dollarValue = dollarValue;
        this.shortDescripiton = shortDescripiton;
        this.fullDescripiton = fullDescripiton;
    }

//    /**
//     * No param constructor -- DO NOT CALL NORMALLY
//     */
//    public Item() {
//        this("12:00:00" , "12-25-2018", new Location(), CategoryENUM.CLOTHING,
//                "10.00", "Best Shirt Ever", "Really Old Shirt");
//    }


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
     * getter for the shortDescripiton
     *
     * @return the shortDescripiton
     */
    public String getShortDescripiton() { return shortDescripiton; }

//    /**
//     * sets the shortDescripiton
//     *
//     * @param shortDescripiton the shortDescripiton
//     */
//    public void setShortDescripiton(String shortDescripiton) { this.shortDescripiton = shortDescripiton; }

    /**
     * getter for the fullDescripiton
     *
     * @return the fullDescripiton
     */
    public String getFullDescripiton() { return fullDescripiton; }

//    /**
//     * sets the fullDescripiton
//     *
//     * @param fullDescripiton the fullDescripiton
//     */
//    public void setFullDescripiton(String fullDescripiton) { this.fullDescripiton = fullDescripiton; }



    /**
     * Override the toString to just return the "Short Description"
     *
     * @return the display string representation
     */
    @Override
    public String toString() {
        return shortDescripiton;
    }

    /**
     * Override the equals to just check the "Short Description"
     *
     * @return the success of the equals test
     */
    @Override
    public boolean equals(Object o) {
        Item i = (Item) o;
        return (i.getShortDescripiton().equals(shortDescripiton));
    }



}
