package team1.gatech.edu.irp.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/****************************************************************************************
 *    MODEL
 ****************************************************************************************
 */
public final class PersistenceServiceFacade {

//    /****************************************************************************************
//     *    MODEL STUFF
//     ****************************************************************************************
//     */

    /**
     * Singleton instance
     */
    private static final PersistenceServiceFacade _instance = new PersistenceServiceFacade();

    /**
     * getter for model
     *
     * @return  the model
     */
    public static PersistenceServiceFacade getInstance() {
        return _instance;
    }

    /**
     * make a new model
     */
    private PersistenceServiceFacade() {
    }

    /**
     * Deletes the Binary file
     *
     * Note: DOES NOT DELETE TEMP DATA IN ARRAY'S, JUST DELETES THE FILE!
     *
     * @param file the file that holds the persistence data
     * @return the success
     */
    public boolean deleteBinary(File file) {
        return file.delete();
    }

    /**
     * Loads the Binary file
     * To read, we must use the ObjectInputStream since we want to read our model in with
     * a single read.
     *
     * @param file the file that holds the persistence data
     * @return the success
     */
    public boolean loadBinary(File file) {
        boolean success = true;
        AccountServiceFacade accountServiceFacade = AccountServiceFacade.getInstance();
        LocationServiceFacade locationServiceFacade = LocationServiceFacade.getInstance();
        ItemServiceFacade itemServiceFacade = ItemServiceFacade.getInstance();
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

            setAccountManager(accountServiceFacade, (AccountManager) in.readObject());
            setLocationManager(locationServiceFacade, (LocationManager) in.readObject());
            setItemManager(itemServiceFacade, (ItemManager) in.readObject());

            in.close();
        } catch (IOException e) {
            success = false;
        } catch (ClassNotFoundException e) {
            success = false;
        }
        return success;
    }

    /**
     * Saves the Binary file
     *
     * For binary, we use Serialization, so everything we write has to implement
     * the Serializable interface.  Fortunately all the collection classes and APi classes
     * that we might use are already Serializable.  You just have to make sure your
     * classes implement Serializable.
     *
     * We have to use an ObjectOutputStream to write objects.
     * One thing to be careful of:  You cannot serialize static data.
     *
     * We basically can save our entire data model with one write, since this will follow
     * all the links and pointers to save everything.  Just save the top level object.
     *
     * @param file the file that holds the persistence data
     * @return the success
     */
    public boolean saveBinary(File file) {
        boolean success = true;
        AccountServiceFacade accountServiceFacade = AccountServiceFacade.getInstance();
        LocationServiceFacade locationServiceFacade = LocationServiceFacade.getInstance();
        ItemServiceFacade itemServiceFacade = ItemServiceFacade.getInstance();

        AccountManager accountManager = getAccountManager(accountServiceFacade);
        LocationManager locationManager = getLocationManager(locationServiceFacade);
        ItemManager itemManager = getItemManager(itemServiceFacade);
        try {
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(accountManager);
            out.writeObject(locationManager);
            out.writeObject(itemManager);
            out.close();
        } catch (IOException e) {
            success = false;
        }
        return success;
    }

    /**
     * sets the accountManager
     *
     * @param accountManager accountManager
     */
    private void setAccountManager(AccountServiceFacade accountServiceFacade,
                                   AccountManager accountManager) {
        accountServiceFacade.setAccountManager(accountManager);
    }

    /**
     * sets the locationManager
     *
     * @param locationManager locationManager
     */
    private void setLocationManager(LocationServiceFacade locationServiceFacade,
                                    LocationManager locationManager) {
        locationServiceFacade.setLocationManager(locationManager);
    }

    /**
     * sets the itemManager
     *
     * @param itemManager itemManager
     */
    private void setItemManager(ItemServiceFacade itemServiceFacade, ItemManager itemManager) {
        itemServiceFacade.setItemManager(itemManager);
    }

    /**
     * gets the account manager from the facade
     *
     * @param accountServiceFacade accountServiceFacade
     * @return the accountManager
     */
    private AccountManager getAccountManager(AccountServiceFacade accountServiceFacade) {
        return accountServiceFacade.getAccountManager();
    }

    /**
     * gets the location manager from the facade
     *
     * @param locationServiceFacade locationServiceFacade
     * @return the locationManager
     */
    private LocationManager getLocationManager(LocationServiceFacade locationServiceFacade) {
        return locationServiceFacade.getLocationManager();
    }

    /**
     * gets the item manager from the facade
     *
     * @param itemServiceFacade itemServiceFacade
     * @return the itemManager
     */
    private ItemManager getItemManager(ItemServiceFacade itemServiceFacade) {
        return itemServiceFacade.getItemManager();
    }

}