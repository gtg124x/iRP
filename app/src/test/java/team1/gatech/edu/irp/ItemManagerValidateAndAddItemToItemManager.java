package team1.gatech.edu.irp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import team1.gatech.edu.irp.model.AddDonationResultENUM;
import team1.gatech.edu.irp.model.CategoryENUM;
import team1.gatech.edu.irp.model.ItemManager;
import team1.gatech.edu.irp.model.ItemServiceFacade;
import team1.gatech.edu.irp.model.Location;
import team1.gatech.edu.irp.model.LocationTypeEnum;


/**
 * Created by Mitchell Alvarado
 */
@SuppressWarnings("ALL")
public class ItemManagerValidateAndAddItemToItemManager {

    private ItemServiceFacade itemServiceFacade;
    private ItemManager itemManager;

    @Before
    public void setUp() {
        itemServiceFacade = ItemServiceFacade.getInstance();
        itemManager = itemServiceFacade.getItemManager();
    }

    /**
     * Mitchell Alvarado Test
     */
    @Test
    public void testValidateAndAddItemToItemManager() {

        //Name Test
        //Test For: null, empty string, string of size 1, string of size 2, string of size 3, string of size 4,
        //          string of size 5

        Assert.assertSame("RESULT INCORRECT: Adding an item with timeStamp as null",
                AddDonationResultENUM.TIME_INVALID,
                itemManager.validateAndAddItemToItemManager(null,
                        "10-10-2014", new Location(10, "GOODWILL TEST",
                                35.00003, 35.00003,
                                "Main Steet", "Atlanta", "GA",
                                30043, LocationTypeEnum.STORE,
                                "999-999-9999", "www.why.com"),
                        CategoryENUM.CLOTHING, "1.12", "shirt",
        "red and old"));



        //(String timeStamp, String dateStamp, Location location, CategoryENUM category,
        //   String dollarValue, String shortDescription, String fullDescription) {

    }
}