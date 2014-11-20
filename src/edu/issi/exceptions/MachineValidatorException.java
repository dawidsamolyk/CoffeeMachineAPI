package edu.issi.exceptions;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Dawid
 * 
 */
public class MachineValidatorException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param object
     * @param exceptionMessage
     * @throws NoSuchElementException
     */
    public static void generateExceptionWhenObjectIsNotCreated(Object object, String exceptionMessage)
	    throws NoSuchElementException {
	if (object == null) {
	    throw new NoSuchElementException(exceptionMessage);
	}
    }

    /**
     * @param list
     * @param exceptionMessage
     * @throws IllegalStateException
     */
    public static void generateExceptionWhenIsEmpty(List<?> list, String exceptionMessage)
	    throws IllegalStateException {
	if (list == null || list.size() == 0) {
	    throw new IllegalStateException(exceptionMessage);
	}
    }
}
