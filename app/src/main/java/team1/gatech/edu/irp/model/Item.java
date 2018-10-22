package team1.gatech.edu.irp.model;

import java.io.Serializable;

public class Item implements Serializable {

    /** time stamp for the item */
    private String timeStamp;

    /** date stamp for the item */
    private String dateStamp;

    /** location for the item */
    private Location location;

    /** category for the item */
    private Category category;

    /** dollar value for the item */
    private String dollarValue;

    /** short description for the item */
    private String shortDescripiton;

    /** full description for the item */
    private String fullDescripiton;

    public String getTimeStamp() { return timeStamp; }
    public void setTimeStamp(String timeStamp) { this.timeStamp = timeStamp; }

    public String getDateStamp() { return dateStamp; }
    public void setDateStamp(String dateStamp) { this.dateStamp = dateStamp; }

    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public String getDollarValue() { return dollarValue; }
    public void setDollarValue(String dollarValue) { this.dollarValue = dollarValue; }

    public String getShortDescripiton() { return shortDescripiton; }
    public void setShortDescripiton(String shortDescripiton) { this.shortDescripiton = shortDescripiton; }

    public String getFullDescripiton() { return fullDescripiton; }
    public void setFullDescripiton(String fullDescripiton) { this.fullDescripiton = fullDescripiton; }


    /**
     * Make a new account
     * @param timeStamp         the account login name
     * @param dateStamp         date stamp for the item
     * @param location          location for the item
     * @param category          category for the item
     * @param dollarValue       dollar value for the item
     * @param shortDescripiton   short description for the item
     * @param fullDescripiton    full description for the item
     *
     */
    public Item(String timeStamp, String dateStamp, Location location, Category category, String dollarValue,
                String shortDescripiton, String fullDescripiton) {
        this.timeStamp = timeStamp;
        this.dateStamp = dateStamp;
        this.location = location;
        this.category = category;
        this.dollarValue = dollarValue;
        this.shortDescripiton = shortDescripiton;
        this.fullDescripiton = fullDescripiton;
    }

    /**
     * No param constructor -- DO NOT CALL NORMALLY
     * This constructor only for GUI use in edit/new account dialog
     */
    public Item() {
        this("12:00:00" , "12-25-2018", new Location(), Category.CLOTHING,
                "10.00", "Best Shirt Ever", "Really Old Shirt");
    }

    /**
     *
     * @return the display string representation
     */
    @Override
    public String toString() {
        return shortDescripiton;
    }


    @Override
    public boolean equals(Object o) {
        Item i = (Item) o;
        return (i.getShortDescripiton().equals(shortDescripiton));
    }



}
