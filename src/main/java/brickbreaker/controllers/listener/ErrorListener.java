package brickbreaker.controllers.listener;

import java.util.ArrayList;
import java.util.List;

import brickbreaker.common.Error;

/**
 * Class to save detected error.
 */
public class ErrorListener {

    private static List<Error> error;

    /**
     * Error listener constructor.
     */
    public ErrorListener() {
        error = new ArrayList<Error>();
    }

    /**
     * Method add the error to the list of detected errors.
     * 
     * @param maploaderError the error to add
     */
    public static void notifyError(final Error maploaderError) {
        error.add(maploaderError);
    }

    /**
     * @return if there was an error
     */
    public boolean getErrorPresent() {
        return error.size() > 0;
    }

    /**
     * @return the list of detected errors
     */
    public List<Error> getErrorList() {
        return ErrorListener.error;
    }

}
