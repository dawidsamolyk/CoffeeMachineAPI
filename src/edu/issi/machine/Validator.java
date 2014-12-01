package edu.issi.machine;

import java.util.List;
import java.util.Map;

/**
 * Sytuacja wyj¹tkowa podczas walidacji
 * 
 * @author Dawid
 * 
 */
public class Validator {

    private static int countNullObjects(Object[] table) {
	int nullObjects = 0;

	for (int index = 0; index < table.length; index++) {
	    if (table[index] == null) {
		nullObjects++;
	    }
	}

	return nullObjects;
    }

    /**
     * @param object
     *            Obiekt do sprawdzenia.
     * @param exceptionMessage
     *            Opis b³êdu. Zostanie ustawiony, jeœli b³¹d wyst¹pi.
     * @throws IllegalArgumentException
     *             Wygenerowany b³¹d.
     */
    public static void throwExceptionWhenObjectIsNotCreated(Object object, String exceptionMessage)
	    throws IllegalArgumentException {
	if (object == null) {
	    throw new IllegalArgumentException(exceptionMessage);
	}
    }

    /**
     * @param text
     *            Tekst do sprawdzenia.
     * @param exceptionMessage
     *            Opis b³êdu. Zostanie ustawiony, jeœli b³¹d wyst¹pi.
     * @throws IllegalArgumentException
     *             Wygenerowany b³¹d.
     */
    public static void throwExceptionWhenTextIsEmpty(String text, String exceptionMessage)
	    throws IllegalArgumentException {
	if (text == null || text.length() == 0) {
	    throw new IllegalArgumentException(exceptionMessage);
	}
    }

    /**
     * @param table
     *            Tablica obiektów do sprawdzenia.
     * @param exceptionMessage
     *            Opis b³êdu. Zostanie ustawiony, jeœli b³¹d wyst¹pi.
     * @throws IllegalArgumentException
     *             Wygenerowany b³¹d.
     */
    public static void throwExceptionWhenArrayContainsNullOrEmpty(Object[] table, String exceptionMessage)
	    throws IllegalArgumentException {
	if (table == null || table.length == 0 || countNullObjects(table) > 0) {
	    throw new IllegalArgumentException(exceptionMessage);
	}
    }

    /**
     * @param list
     *            Lista obiektów do sprawdzenia.
     * @param exceptionMessage
     *            Opis b³êdu. Zostanie ustawiony, jeœli b³¹d wyst¹pi.
     * @throws IllegalArgumentException
     *             Wygenerowany b³¹d.
     */
    public static void throwExceptionWhenEmpty(List<?> list, String exceptionMessage)
	    throws IllegalArgumentException {
	if (list == null || list.size() == 0 || (countNullObjects(list.toArray()) == list.size())) {
	    throw new IllegalArgumentException(exceptionMessage);
	}
    }

    /**
     * @param table
     *            Tablica obiektów do sprawdzenia.
     * @param exceptionMessage
     *            Opis b³êdu. Zostanie ustawiony, jeœli b³¹d wyst¹pi.
     * @throws IllegalArgumentException
     *             Wygenerowany b³¹d.
     */
    public static void throwExceptionWhenEmpty(Object[] table, String exceptionMessage)
	    throws IllegalArgumentException {
	if (table == null || table.length == 0 || countNullObjects(table) == table.length) {
	    throw new IllegalArgumentException(exceptionMessage);
	}
    }

    /**
     * @param list
     *            Lista obiektów do sprawdzenia.
     * @param exceptionMessage
     *            Opis b³êdu. Zostanie ustawiony, jeœli b³¹d wyst¹pi.
     * @throws IllegalArgumentException
     *             Wygenerowany b³¹d.
     */
    public static void throwExceptionWhenListContainsNullOrEmpty(List<?> list, String exceptionMessage)
	    throws IllegalArgumentException {
	if (list == null || list.size() == 0 || countNullObjects(list.toArray()) > 0) {
	    throw new IllegalArgumentException(exceptionMessage);
	}
    }

    /**
     * @param map
     *            Mapa obiektów do sprawdzenia.
     * @param exceptionMessage
     *            Opis b³êdu. Zostanie ustawiony, jeœli b³¹d wyst¹pi.
     * @throws IllegalArgumentException
     *             Wygenerowany b³¹d.
     */
    public static void throwExceptionWhenMapContainsNullOrEmpty(Map<?, ?> map, String exceptionMessage)
	    throws IllegalArgumentException {
	if (map == null || map.size() == 0 || countNullObjects(map.keySet().toArray()) == map.size()) {
	    throw new IllegalArgumentException(exceptionMessage);
	}
    }
}
