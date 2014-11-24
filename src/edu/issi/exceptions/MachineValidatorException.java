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
     *            Opis b��du. Zostanie ustawiony, je�li b��d wyst�pi.
     * @throws NoSuchElementException
     *             Wygenerowany b��d.
     */
    public static void generateExceptionWhenObjectIsNotCreated(Object object, String exceptionMessage)
	    throws NoSuchElementException {
	if (object == null) {
	    throw new NoSuchElementException(exceptionMessage);
	}
    }

    /**
     * @param list
     *            Lista obiekt�w do sprawdzenia.
     * @param exceptionMessage
     *            Opis b��du. Zostanie ustawiony, je�li b��d wyst�pi.
     * @throws IllegalStateException
     *             Wygenerowany b��d.
     */
    public static void throwExceptionWhenEmpty(List<?> list, String exceptionMessage)
	    throws IllegalStateException {
	if (list == null || list.size() == 0) {
	    throw new IllegalStateException(exceptionMessage);
	}
    }
}
