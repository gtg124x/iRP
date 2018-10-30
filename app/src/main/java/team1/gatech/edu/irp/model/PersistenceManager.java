package team1.gatech.edu.irp.model;

import android.view.Display;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersistenceManager {
//    /****************************************************************************************
//     *    PERSISTENCE DATA METHODS
//     ****************************************************************************************
//     */


    /**
     * Deletes the Binary file
     *
     * @param file the file that holds the persistence data
     */
    public static boolean deleteBinary(File file) {
        return file.delete();
    }

    /**
     * Loads the Binary file
     *
     * @param file the file that holds the persistence data
     */
    public static boolean loadBinary(File file) {
        boolean success = true;
        try {
//            /**
//             * To read, we must use the ObjectInputStream since we want to read our model in with
//             * a single read.
//             */
            Model model = Model.getInstance();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            // assuming we saved our top level object, we read it back in with one line of code.
            model.setAccountManager((AccountManager) in.readObject());
            model.setLocationManager((LocationManager) in.readObject());
            model.setItemManager((ItemManager) in.readObject());
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
     * @param file the file that holds the persistence data
     */
    public static boolean saveBinary(File file) {
        boolean success = true;
        try {
            Model model = Model.getInstance();
//            /**
//             * For binary, we use Serialization, so everything we write has to implement
//             * the Serializable interface.  Fortunately all the collection classes and APi classes
//             * that we might use are already Serializable.  You just have to make sure your
//             * classes implement Serializable.
//             *
//             * We have to use an ObjectOutputStream to write objects.
//             * One thing to be careful of:  You cannot serialize static data.
//             *
//             */
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));

//            /**
//             * We basically can save our entire data model with one write, since this will follow
//             * all the links and pointers to save everything.  Just save the top level object.
//             */
            out.writeObject(model.getAccountManager());
            out.writeObject(model.getLocationManager());
            out.writeObject(model.getItemManager());

            out.close();

        } catch (IOException e) {
            success = false;
        }
        return success;
    }
}
