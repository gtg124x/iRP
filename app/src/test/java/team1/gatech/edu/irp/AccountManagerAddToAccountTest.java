package team1.gatech.edu.irp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import team1.gatech.edu.irp.model.AccountManager;
import team1.gatech.edu.irp.model.AccountServiceFacade;
import team1.gatech.edu.irp.model.RegistrationResultENUM;
import team1.gatech.edu.irp.model.UserTypeENUM;

/**
 * Created by Mitchell Alvarado
 */
@SuppressWarnings("ALL")
public class AccountManagerAddToAccountTest {

    private AccountServiceFacade accountServiceFacade;
    private AccountManager accountManager;

    @Before
    public void setUp() {
        accountServiceFacade = AccountServiceFacade.getInstance();
        accountManager = accountServiceFacade.getAccountManager();
    }

    /**
     * Mitchell Alvarado Test
     */
    @Test
    public void testAddToAccounts_NameNull() {
        Assert.assertSame("RESULT INCORRECT: Adding an account with name as null",
                RegistrationResultENUM.NAME_INVALID,
                accountManager.addToAccounts(null, "1234", "bob@gatech.com", UserTypeENUM.USER));
    }

    @Test
    public void testAddToAccounts_NameEmpty() {
        Assert.assertSame("RESULT INCORRECT: Adding an account with name as empty string",
                RegistrationResultENUM.NAME_INVALID,
                accountManager.addToAccounts("", "1234", "bob@gatech.com", UserTypeENUM.USER));
    }

    @Test
    public void testAddToAccounts_NameSizeOne() {
        Assert.assertSame("RESULT INCORRECT: Adding an account with name as 1 character",
                RegistrationResultENUM.NAME_INVALID,
                accountManager.addToAccounts("a", "1234", "bob@gatech.com", UserTypeENUM.USER));
    }

    @Test
    public void testAddToAccounts_NameSizeTwo() {
        Assert.assertSame("RESULT INCORRECT: Adding an account with name as 2 characters",
                RegistrationResultENUM.SUCCESS,
                accountManager.addToAccounts("ab", "1234", "bob@gatech.com", UserTypeENUM.USER));
    }

    @Test
    public void testAddToAccounts_NameSizeThree() {
        Assert.assertSame("RESULT INCORRECT: Adding an account with name as 3 characters",
                RegistrationResultENUM.SUCCESS,
                accountManager.addToAccounts("abc", "1234", "bob@gatech.com", UserTypeENUM.USER));
    }

    @Test
    public void testAddToAccounts_NameSizeFour() {
        Assert.assertSame("RESULT INCORRECT: Adding an account with name as 4 characters",
                RegistrationResultENUM.SUCCESS,
                accountManager.addToAccounts("abcd", "1234", "bob@gatech.com", UserTypeENUM.USER));
    }

    @Test
    public void testAddToAccounts_NameSizeFive() {
        Assert.assertSame("RESULT INCORRECT: Adding an account with name as 5 characters",
                RegistrationResultENUM.SUCCESS,
                accountManager.addToAccounts("abcdc", "1234", "bob@gatech.com", UserTypeENUM.USER));
    }

    @Test
    public void testAddToAccounts_NameTaken() {
        Assert.assertSame("RESULT INCORRECT: Adding an account with name as mitch",
                RegistrationResultENUM.SUCCESS,
                accountManager.addToAccounts("mitch", "1234", "bob@gatech.edu", UserTypeENUM.USER));
        Assert.assertSame("RESULT INCORRECT: Adding another account with name mitch",
                RegistrationResultENUM.NAME_TAKEN,
                accountManager.addToAccounts("mitch", "5678", "waters@gatech.edu", UserTypeENUM.ADMIN));
    }

    @Test
    public void testAddToAccounts_PasswordNull() {
        Assert.assertSame("RESULT INCORRECT: Adding an account with password as null",
                RegistrationResultENUM.PASSWORD_INVALID,
                accountManager.addToAccounts("bob", null, "bob@gatech.com", UserTypeENUM.USER));
    }

    @Test
    public void testAddToAccounts_PasswordEmpty() {
        Assert.assertSame("RESULT INCORRECT: Adding an account with password as empty string",
                RegistrationResultENUM.PASSWORD_INVALID,
                accountManager.addToAccounts("sally", "", "bob@gatech.com", UserTypeENUM.USER));
    }

    @Test
    public void testAddToAccounts_PasswordSizeOne() {
        Assert.assertSame("RESULT INCORRECT: Adding an account with password as 1 character",
                RegistrationResultENUM.PASSWORD_INVALID,
                accountManager.addToAccounts("Joe", "1", "bob@gatech.com", UserTypeENUM.USER));
    }

    @Test
    public void testAddToAccounts_PasswordSizeTwo() {
        Assert.assertSame("RESULT INCORRECT: Adding an account with password as 2 characters",
                RegistrationResultENUM.PASSWORD_INVALID,
                accountManager.addToAccounts("Josh", "ab", "bob@gatech.com", UserTypeENUM.USER));
    }

    @Test
    public void testAddToAccounts_PasswordSizeThree() {
        Assert.assertSame("RESULT INCORRECT: Adding an account with password as 3 characters",
                RegistrationResultENUM.PASSWORD_INVALID,
                accountManager.addToAccounts("may", "123", "bob@gatech.com", UserTypeENUM.USER));
    }

    @Test
    public void testAddToAccounts_PasswordSizeFour() {
        Assert.assertSame("RESULT INCORRECT: Adding an account with password as 4 characters",
                RegistrationResultENUM.SUCCESS,
                accountManager.addToAccounts("june", "1a2b", "bob@gatech.com", UserTypeENUM.USER));
    }

    @Test
    public void testAddToAccounts_PasswordSizeFive() {
        Assert.assertSame("RESULT INCORRECT: Adding an account with password as 5 characters",
                RegistrationResultENUM.SUCCESS,
                accountManager.addToAccounts("july", "1234a", "bob@gatech.com", UserTypeENUM.USER));
    }

    @Test
    public void testAddToAccounts_nullNameAndPassword() {
        Assert.assertSame("RESULT INCORRECT: Adding an account with null name and null password",
                RegistrationResultENUM.NAME_INVALID,
                accountManager.addToAccounts(null, null, "bob@gatech.com", UserTypeENUM.USER));
    }

    @Test
    public void testAddToAccounts_ContactInfoNull() {
        Assert.assertSame("RESULT INCORRECT: Adding an account with Contact Info as null",
                RegistrationResultENUM.EMAIL_INVALID,
                accountManager.addToAccounts("bob1", "12a4", null, UserTypeENUM.USER));
    }

    @Test
    public void testAddToAccounts_ContactInfoEmpty() {
        Assert.assertSame("RESULT INCORRECT: Adding an account with Contact Info as empty string",
                RegistrationResultENUM.EMAIL_INVALID,
                accountManager.addToAccounts("sally1", "acdc", "", UserTypeENUM.USER));
    }

    @Test
    public void testAddToAccounts_ContactInfoSizeOne() {
        Assert.assertSame("RESULT INCORRECT: Adding an account with Contact Info as 1 character",
                RegistrationResultENUM.EMAIL_INVALID,
                accountManager.addToAccounts("Joe1", "1asds", "b", UserTypeENUM.USER));
    }

    @Test
    public void testAddToAccounts_ContactInfoSizeTwo() {
        Assert.assertSame("RESULT INCORRECT: Adding an account with Contact Info as 2 characters",
                RegistrationResultENUM.EMAIL_INVALID,
                accountManager.addToAccounts("Josh1", "abas", "bo", UserTypeENUM.USER));
    }

    @Test
    public void testAddToAccounts_ContactInfoWithAt() {
        Assert.assertSame("RESULT INCORRECT: Adding an account with Contact Info with @ symbol",
                RegistrationResultENUM.EMAIL_INVALID,
                accountManager.addToAccounts("may1", "123s", "@", UserTypeENUM.USER));
    }

    @Test
    public void testAddToAccounts_ContactInfoWithAtNoPeriod() {
        Assert.assertSame("RESULT INCORRECT: Adding an account with Contact Info no period",
                RegistrationResultENUM.EMAIL_INVALID,
                accountManager.addToAccounts("june1", "1a2b", "bob@gatech", UserTypeENUM.USER));
    }

    @Test
    public void testAddToAccounts_ContactInfoWithValidInfo() {
        Assert.assertSame("RESULT INCORRECT: Adding an account with Contact Info valid",
                RegistrationResultENUM.SUCCESS,
                accountManager.addToAccounts("july1", "1234a", "bob@gatech.com", UserTypeENUM.USER));
    }


//        ItemManager.validateAndAddItemToItemManager()  // started someone can finish

    //      ItemManager.getItemListByLocation            check:  i.getLocation() for null and String location for null

    //     ItemManager.getItemListByCategoryAndLocation  check: i.getCategory(), i.getLocation() for null
    //    //                                                          and String name, String location for null

    //     ItemManager.getItemListByNameAndLocation      check: i.getShortDescription(), i.getLocation() for null
    //                                                          and String name, String location for null


//    Uses annotations and static methods
//    Annotations:  @xxxxxx  message to vm and compiler
//    @Test – identify a method implementing a test
//    @Before – identify a method to execute before each test
//    @After – identify a method to execute after each test
//    @Test (expected=IllegalArgumentException.class) run a test and expect the exception


//    Assert.assertTrue(message, condition)
//            Assert.assertEquals(message, expect, actual)
//            Assert.assertNull(message, variable)
//            Assert.assertSame(message, v1, v2)
//            Assert.assertNotSame(msg, v1, v2)
//            Assert.fail(message)



//    @Test
//    public void testDatabase() {
//        Database db = mock(Database.class);
//        when(db.getStudentIDFor("Bob")).thenReturn("XY32F14");
//        when(db.getStudentNameFor(1234)).thenReturn("Bob Waters");
//
//        assertEquals("XY32F14", db.getStudentIDFor("Bob"));
//        assertNull(db.getStudentIDFor("Sally"));
//
//        assertEquals("Bob Waters", db.getStudentNameFor(1234));
//        assertNull(db.getStudentNameFor(5463));
//    }

    }
