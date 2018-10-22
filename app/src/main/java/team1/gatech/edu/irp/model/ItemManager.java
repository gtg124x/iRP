package team1.gatech.edu.irp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    private ArrayList<Item> inventory = new ArrayList<>();

    /**
     * array to hold string representation of item in inventory
     */
    private ArrayList<String> inventoryStringArray = new ArrayList<>();





    /****************************************************************************************
     *    INVENTORY METHODS
     ****************************************************************************************
     */

    /**
     * adds an item to the inventory
     *
     * @param item a donated item at a location
     */
    public void addToItemManager(Item item) {
        inventory.add(item);
        inventoryStringArray.add(item.toString());
    }

    /**
     * returns a list of items that have been added to the app
     *
     * @return list of Item objects
     */
    public ArrayList<Item> getItemManagerAsItemArray() { return inventory; }

    /**
     * returns a list of items represented as Strings that have been added to the app
     *
     * @return list of items represented as Strings
     */
    public ArrayList<String> getItemManagerAsStringArray() {
        return inventoryStringArray;
    }

    public ArrayList<String> getItemListByLocation(Location location) {
        ArrayList<String> itemLocationList = new ArrayList<>();
        for (Item i : inventory) {
            if (i.getLocation().equals(location)) {
                itemLocationList.add(i.toString());
            }
        }
        return itemLocationList;
    }




}

