package edu.issi.machine;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Dawid Samo³yk
 * 
 *         Walidator parametrów.
 */
public class Validator {

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
     * @param list
     *            Lista obiektów do sprawdzenia.
     * @param index
     *            Indeks, pod którym sprawdzamy czy jest obecny obiekt.
     * @param exceptionMessage
     *            Opis b³êdu. Zostanie ustawiony, jeœli b³¹d wyst¹pi.
     * @throws NoSuchElementException
     *             Wygenerowany b³¹d.
     * @throws IllegalArgumentException
     *             Wygenerowany b³¹d.
     */
    public static void throwExceptionWhenNoSuchElementAtIndex(List<?> list, int index, String exceptionMessage)
	    throws NoSuchElementException, IllegalArgumentException {

	throwExceptionWhenContainsNullOrEmpty(list, "Na podanej liœcie nie ma obiektów!");

	if (index < 0 || index >= list.size()) {
	    throw new NoSuchElementException("Nie ma elementu pod podanym indeksem!");
	}
    }

    /**
     * @param itearable
     *            Zbiór obiektów do sprawdzenia.
     * @param exceptionMessage
     *            Opis b³êdu. Zostanie ustawiony, jeœli b³¹d wyst¹pi.
     * @throws IllegalArgumentException
     *             Wygenerowany b³¹d.
     */
    public static void throwExceptionWhenContainsNullOrEmpty(Iterable<?> itearable, String exceptionMessage)
	    throws IllegalArgumentException {
	if (itearable == null || !itearable.iterator().hasNext() || containsNullObjects(itearable)) {
	    throw new IllegalArgumentException(exceptionMessage);
	}
    }

    /**
     * @param itearable
     *            Zbiór obiektów do sprawdzenia.
     * @return Czy zawiera puste referencje.
     */
    public static boolean containsNullObjects(Iterable<?> itearable) {
	for (Object eachElement : itearable) {
	    if (eachElement == null) {
		return true;
	    }
	}
	return false;
    }
}
