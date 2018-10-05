package team1.gatech.edu.irp.model;

/**
 * Created by mitchellalvarado on 9/20/18.
 *
 * This is our facade to the Model.  We are using a Singleton design pattern to allow
 * access to the model from each controller.
 *
 *
 */
public class Model {

    /** Singleton instance */
    private static final Model _instance = new Model();
    public static Model getInstance() { return _instance; }


    /**
     * make a new model
     */
    private Model() {
    }

}