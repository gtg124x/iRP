package team1.gatech.edu.irp.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    public static List<Item> inventoryArray = new ArrayList<>();

    public static void addToInventory(Item item) {
        inventoryArray.add(item);
    }
    public List<Item> getInventoryAsArray() {
        return inventoryArray;
    }

    protected List<String> getInventoryAsStringArray() {
        List<String> inventoryStringArray = new ArrayList<>();
        for(Item i : inventoryArray) {
            inventoryStringArray.add(i.toString());
        }

        return inventoryStringArray;
    }

}
