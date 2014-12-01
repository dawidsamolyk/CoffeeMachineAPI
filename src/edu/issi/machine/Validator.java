package edu.issi.machine;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Sytuacja wyj�tkowa podczas walidacji
 * 
 * @author Dawid
 * 
 */
public class Validator {

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
     */
    public static void throwExceptionWhenEmpty(List<?> list, String exceptionMessage) {
	if (list == null || list.size() == 0 || (countNullObjects(list.toArray()) == list.size())) {
	    throw new IllegalArgumentException(exceptionMessage);
	}
    }

    /**
     * @param table
     *            Tablica obiekt�w do sprawdzenia.
     * @param exceptionMessage
     *            Opis b��du. Zostanie ustawiony, je�li b��d wyst�pi.
     */
    public static void throwExceptionWhenContainsNullOrEmpty(Object[] table, String exceptionMessage) {
	if (table == null || table.length == 0 || countNullObjects(table) > 0) {
	    throw new IllegalArgumentException(exceptionMessage);
	}
    }

    /**
     * @param list
     *            Lista obiekt�w do sprawdzenia.
     * @param exceptionMessage
     *            Opis b��du. Zostanie ustawiony, je�li b��d wyst�pi.
     */
    public static void throwExceptionWhenContainsNullOrEmpty(List<?> list, String exceptionMessage) {
	if (list == null || list.size() == 0 || countNullObjects(list.toArray()) > 0) {
	    throw new IllegalArgumentException(exceptionMessage);
	}
    }

    /**
     * @param table
     *            Tablica obiekt�w do sprawdzenia.
     * @param exceptionMessage
     *            Opis b��du. Zostanie ustawiony, je�li b��d wyst�pi.
     */
    public static void throwExceptionWhenEmpty(Object[] table, String exceptionMessage) {
	if (table == null || table.length == 0 || countNullObjects(table) == table.length) {
	    throw new IllegalArgumentException(exceptionMessage);
	}
    }

    private static int countNullObjects(Object[] table) {
	int nullObjects = 0;
	for (int x = 0; x < table.length; x++) {
	    if (table[x] == null) {
		nullObjects++;
	    }
	}
	return nullObjects;
    }

    /**
     * @param map
     *            Mapa obiekt�w do sprawdzenia.
     * @param exceptionMessage
     *            Opis b��du. Zostanie ustawiony, je�li b��d wyst�pi.
     */
    public static void throwExceptionWhenContainsNullOrEmpty(Map<?, ?> map, String exceptionMessage) {
	if (map == null || map.size() == 0 || countNullObjects(map.keySet().toArray()) == map.size()) {
	    throw new IllegalArgumentException(exceptionMessage);
	}
    }
}
