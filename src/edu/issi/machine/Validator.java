package edu.issi.machine;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * @author Dawid Samo�yk
 * 
 *         Walidator parametr�w.
 */
public class Validator {

    /**
     * @param object
     *            Obiekt do sprawdzenia.
     * @param exceptionMessage
     *            Opis b��du. Zostanie ustawiony, je�li b��d wyst�pi.
     * @throws IllegalArgumentException
     *             Wygenerowany b��d.
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
     *            Opis b��du. Zostanie ustawiony, je�li b��d wyst�pi.
     * @throws IllegalArgumentException
     *             Wygenerowany b��d.
     */
    public static void throwExceptionWhenTextIsEmpty(String text, String exceptionMessage)
	    throws IllegalArgumentException {
	if (text == null || text.length() == 0) {
	    throw new IllegalArgumentException(exceptionMessage);
	}
    }

    /**
     * @param list
     *            Lista obiekt�w do sprawdzenia.
     * @param exceptionMessage
     *            Opis b��du. Zostanie ustawiony, je�li b��d wyst�pi.
     * @throws IllegalArgumentException
     *             Wygenerowany b��d.
     */
    public static void throwExceptionWhenEmptyOrContainsNullObjects(List<?> list, String exceptionMessage)
	    throws IllegalArgumentException {

	if (list == null || list.size() == 0 || containsNullObjects(list)) {
	    throw new IllegalArgumentException(exceptionMessage);
	}
    }

    /**
     * @param table
     *            Tablica obiekt�w do sprawdzenia.
     * @param exceptionMessage
     *            Opis b��du. Zostanie ustawiony, je�li b��d wyst�pi.
     * @throws IllegalArgumentException
     *             Wygenerowany b��d.
     */
    public static void throwExceptionWhenEmptyOrContainsNullObjects(Object[] table, String exceptionMessage)
	    throws IllegalArgumentException {
	if (table == null || table.length == 0 || containsNullObjects(table)) {
	    throw new IllegalArgumentException(exceptionMessage);
	}
    }

    /**
     * @param list
     *            Lista obiekt�w do sprawdzenia.
     * @param exceptionMessage
     *            Opis b��du. Zostanie ustawiony, je�li b��d wyst�pi.
     * @throws IllegalArgumentException
     *             Wygenerowany b��d.
     */
    public static void throwExceptionWhenListContainsNullOrEmpty(List<?> list, String exceptionMessage)
	    throws IllegalArgumentException {
	if (list == null || list.size() == 0 || containsNullObjects(list)) {
	    throw new IllegalArgumentException(exceptionMessage);
	}
    }

    /**
     * @param map
     *            Mapa obiekt�w do sprawdzenia.
     * @param exceptionMessage
     *            Opis b��du. Zostanie ustawiony, je�li b��d wyst�pi.
     * @throws IllegalArgumentException
     *             Wygenerowany b��d.
     */
    public static void throwExceptionWhenMapContainsNullOrEmpty(Map<?, ?> map, String exceptionMessage)
	    throws IllegalArgumentException {
	if (map == null || map.size() == 0 || map.isEmpty() || containsNullObjects(map.values())) {
	    throw new IllegalArgumentException(exceptionMessage);
	}
    }

    /**
     * @param list
     *            Lista obiekt�w do sprawdzenia.
     * @param index
     *            Indeks, pod kt�rym sprawdzamy czy jest obecny obiekt.
     * @param exceptionMessage
     *            Opis b��du. Zostanie ustawiony, je�li b��d wyst�pi.
     * @throws NoSuchElementException
     *             Wygenerowany b��d.
     * @throws IllegalArgumentException
     *             Wygenerowany b��d.
     */
    public static void throwExceptionWhenThereIsNotSuchElementAtSpecifiedIndex(List<?> list, int index,
	    String exceptionMessage) throws NoSuchElementException, IllegalArgumentException {

	throwExceptionWhenEmptyOrContainsNullObjects(list, "Na podanej li�cie nie ma obiekt�w!");

	if (index < 0 || index >= list.size()) {
	    throw new NoSuchElementException("Nie ma elementu pod podanym indeksem!");
	}
    }

    /**
     * @param itearable
     *            Zbi�r obiekt�w do sprawdzenia.
     * @param exceptionMessage
     *            Opis b��du. Zostanie ustawiony, je�li b��d wyst�pi.
     * @throws IllegalArgumentException
     *             Wygenerowany b��d.
     */
    public static void throwExceptionWhenContainsNullOrEmpty(Iterable<?> itearable, String exceptionMessage)
	    throws IllegalArgumentException {
	if (containsNullObjects(itearable) || !itearable.iterator().hasNext()) {
	    throw new IllegalArgumentException(exceptionMessage);
	}
    }

    /**
     * @param itearable
     *            Zbi�r obiekt�w do sprawdzenia.
     * @return Czy zawiera puste referencje.
     */
    public static boolean containsNullObjects(Iterable<?> itearable) {
	Iterator<?> iterator = itearable.iterator();

	while (iterator.hasNext()) {
	    if (iterator.next() != null) {
		return false;
	    }
	}

	return true;
    }

    /**
     * @param table
     *            Tablica do sprawdzenia.
     * @return Czy zawiera puste referencje.
     */
    public static boolean containsNullObjects(Object[] table) {
	for (int index = 0; index < table.length; index++) {
	    if (table[index] == null) {
		return true;
	    }
	}

	return false;
    }
}
