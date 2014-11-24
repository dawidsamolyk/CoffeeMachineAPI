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
     *            Obiekt do sprawdzenia.
     * @param exceptionMessage
     *            Opis b³êdu. Zostanie ustawiony, jeœli b³¹d wyst¹pi.
     * @throws NoSuchElementException
     *             Wygenerowany b³¹d.
     */
    public static void generateExceptionWhenObjectIsNotCreated(Object object, String exceptionMessage)
	    throws NoSuchElementException {
	if (object == null) {
	    throw new NoSuchElementException(exceptionMessage);
	}
    }

    /**
     * @param list
     *            Lista obiektów do sprawdzenia.
     * @param exceptionMessage
     *            Opis b³êdu. Zostanie ustawiony, jeœli b³¹d wyst¹pi.
     * @throws IllegalStateException
     *             Wygenerowany b³¹d.
     */
    public static void throwExceptionWhenEmpty(List<?> list, String exceptionMessage)
	    throws IllegalStateException {
	if (list == null || list.size() == 0) {
	    throw new IllegalStateException(exceptionMessage);
	}
    }
}
