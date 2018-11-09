package team1.gatech.edu.irp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import team1.gatech.edu.irp.model.CategoryENUM;
import team1.gatech.edu.irp.model.Item;
import team1.gatech.edu.irp.model.ItemManager;
import team1.gatech.edu.irp.model.ItemServiceFacade;
import team1.gatech.edu.irp.model.Location;
import team1.gatech.edu.irp.model.LocationTypeEnum;


/**
 * Created by Mitchell Alvarado
 */
@SuppressWarnings("ALL")
public class getItemListByLocationTest {

    private ItemServiceFacade itemServiceFacade;
    private ItemManager itemManager;

    @Before
    public void setUp() {
        itemServiceFacade = ItemServiceFacade.getInstance();
        itemManager = itemServiceFacade.getItemManager();
    }

    @Test
    public void testValidLocationEmptyItemList() {
        List<Item> emptyItemLocationList = new ArrayList<>();
        Location location = new Location(10, "GOODWILL TEST",
                35.00003, 35.00003,
                "Main Steet", "Atlanta", "GA",
                30043, LocationTypeEnum.STORE,
                "999-999-9999", "www.why.com");
        Assert.assertEquals("RESULT INCORRECT: Valid location as input but empty list",
                emptyItemLocationList,
                itemManager.getItemListByLocation(location));
    }

    @Test
    public void testValidLocationNull() {
        List<Item> emptyItemLocationList = new ArrayList<>();
        Location location = null;
        Assert.assertEquals("RESULT INCORRECT: location null",
                emptyItemLocationList,
                itemManager.getItemListByLocation(location));
    }

    @Test
    public void testLocationsMatches() {
        List<Item> itemLocationList = new ArrayList<>();
        Location locationMatch = new Location(10, "GOODWILL TEST",
                35.00003, 35.00003,
                "Main Steet", "Atlanta", "GA",
                30043, LocationTypeEnum.STORE,
                "999-999-9999", "www.why.com");

        Location badLocation = new Location(11, "BADLOCATION",
                32.00003, 32.00003,
                "Main Court", "Denver", "LA",
                20043, LocationTypeEnum.DROP_OFF,
                "999-939-9999", "www.me.com");

        Item itemMatch = new Item("01:01:01", "10-10-2014", locationMatch,
                CategoryENUM.CLOTHING, "1.12", "shirt",
                "red and old");

        Item itemBad = new Item("01:01:01", "10-10-2014", badLocation,
                CategoryENUM.CLOTHING, "1.12", "shirt",
                "red and old");

        itemManager.validateAndAddItemToItemManager("01:01:01", "10-10-2014", locationMatch,
                CategoryENUM.CLOTHING, "1.12", "shirt",
                "red and old");

        itemManager.validateAndAddItemToItemManager("01:01:01", "10-10-2014", badLocation,
                CategoryENUM.CLOTHING, "1.12", "shirt",
                "red and old");


        itemLocationList.add(itemMatch);

        Assert.assertEquals("RESULT INCORRECT: location matches item's location",
                itemLocationList,
                itemManager.getItemListByLocation(locationMatch));
    }

    @Test
    public void testLocationsDoesNotMatch() {
        List<Item> itemLocationList = new ArrayList<>();
        Location locationMatch = new Location(10, "GOODWILL TEST",
                35.00003, 35.00003,
                "Main Steet", "Atlanta", "GA",
                30043, LocationTypeEnum.STORE,
                "999-999-9999", "www.why.com");

        Location badLocation = new Location(11, "BADLOCATION",
                32.00003, 32.00003,
                "Main Court", "Denver", "LA",
                20043, LocationTypeEnum.DROP_OFF,
                "999-939-9999", "www.me.com");

        Item itemMatch = new Item("01:01:01", "10-10-2014", locationMatch,
                CategoryENUM.CLOTHING, "1.12", "shirt",
                "red and old");

        Item itemBad = new Item("01:01:01", "10-10-2014", badLocation,
                CategoryENUM.CLOTHING, "1.12", "shirt",
                "red and old");

        itemManager.validateAndAddItemToItemManager("01:01:01", "10-10-2014", locationMatch,
                CategoryENUM.CLOTHING, "1.12", "shirt",
                "red and old");


        itemLocationList.add(itemMatch);

        Assert.assertEquals("RESULT INCORRECT: location matches item's location",
                itemLocationList,
                itemManager.getItemListByLocation(locationMatch));

        itemManager.clearInventory();
    }



}

//validateAndAddItemToItemManager
