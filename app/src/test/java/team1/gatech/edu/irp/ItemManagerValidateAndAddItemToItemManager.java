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
 * Updated by Casey Wood
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
     * Casey Wood Test
     */
    @Test
    public void testValidateAndAddItemToItemManager() {


//      Test for invalid time stamp format
        Assert.assertSame("RESULT INCORRECT: Adding an item with timeStamp as null",
                AddDonationResultENUM.TIME_INVALID,
                itemManager.validateAndAddItemToItemManager("05:02",
                        "10-10-2014", new Location(10, "GOODWILL TEST",
                                35.00003, 35.00003,
                                "Main Steet", "Atlanta", "GA",
                                30043, LocationTypeEnum.STORE,
                                "999-999-9999", "www.why.com"),
                        CategoryENUM.CLOTHING, "1.12", "shirt",
                        "red and old"));

//      Test for invalid date stamp format
        Assert.assertSame("RESULT INCORRECT: Incorrect DateStamp formatting.",
                AddDonationResultENUM.DATE_INVALID,
                itemManager.validateAndAddItemToItemManager("05:02:02",
                        "10-10-14", new Location(10, "GOODWILL TEST",
                                35.00003, 35.00003,
                                "Main Steet", "Atlanta", "GA",
                                30043, LocationTypeEnum.STORE,
                                "999-999-9999", "www.why.com"),
                        CategoryENUM.CLOTHING, "1.12", "shirt",
                        "red and old"));

//      Test for invalid dollar value format
        Assert.assertSame("RESULT INCORRECT: Incorrect DateStamp formatting.",
                AddDonationResultENUM.VALUE_INVALID,
                itemManager.validateAndAddItemToItemManager("05:02:02",
                        "10-10-2014", new Location(10, "GOODWILL TEST",
                                35.00003, 35.00003,
                                "Main Steet", "Atlanta", "GA",
                                30043, LocationTypeEnum.STORE,
                                "999-999-9999", "www.why.com"),
                        CategoryENUM.CLOTHING, "1.1222222222", "shirt",
                        "red and old"));

//      Test for short description being too short
        Assert.assertSame("RESULT INCORRECT: Short Description is too short.",
                AddDonationResultENUM.SHORT_DESCRIPTION_INVALID_TO_SHORT,
                itemManager.validateAndAddItemToItemManager("05:02:02",
                        "10-10-2014", new Location(10, "GOODWILL TEST",
                                35.00003, 35.00003,
                                "Main Steet", "Atlanta", "GA",
                                30043, LocationTypeEnum.STORE,
                                "999-999-9999", "www.why.com"),
                        CategoryENUM.CLOTHING, "1.12", "s",
                        "red and old"));

//      Test for short description being too long
        Assert.assertSame("RESULT INCORRECT: Short Description is too long.",
                AddDonationResultENUM.SHORT_DESCRIPTION_INVALID_TO_LONG,
                itemManager.validateAndAddItemToItemManager("05:02:02",
                        "10-10-2014", new Location(10, "GOODWILL TEST",
                                35.00003, 35.00003,
                                "Main Steet", "Atlanta", "GA",
                                30043, LocationTypeEnum.STORE,
                                "999-999-9999", "www.why.com"),
                        CategoryENUM.CLOTHING, "1.12", "shirts shirts shirts shirts shirts",
                        "red and old"));

//      Test for long description being too short
        Assert.assertSame("RESULT INCORRECT: Long Description is too short.",
                AddDonationResultENUM.LONG_DESCRIPTION_INVALID_TO_SHORT,
                itemManager.validateAndAddItemToItemManager("05:02:02",
                        "10-10-2014", new Location(10, "GOODWILL TEST",
                                35.00003, 35.00003,
                                "Main Steet", "Atlanta", "GA",
                                30043, LocationTypeEnum.STORE,
                                "999-999-9999", "www.why.com"),
                        CategoryENUM.CLOTHING, "1.12", "shirt",
                        "r"));

//      Tests a completely correct input
        Assert.assertSame("RESULT CORRECT",
                AddDonationResultENUM.SUCCESS,
                itemManager.validateAndAddItemToItemManager("05:02:02",
                        "10-10-2014", new Location(10, "GOODWILL TEST",
                                35.00003, 35.00003,
                                "Main Steet", "Atlanta", "GA",
                                30043, LocationTypeEnum.STORE,
                                "999-999-9999", "www.why.com"),
                        CategoryENUM.CLOTHING, "1.12", "shirt",
                        "red and old"));

    }

}