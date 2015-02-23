package edu.issi.machine;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * @author Dawid Samo³yk
 * 
 *         Walidator parametrów.
 */
public class Validator {

    /**
     * Zostanie rzucony wyj¹tek, gdy sprawdzany obiekt nie zosta³ utworzony
     * (referencja do null).
     * 
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
     * Zostanie rzucony wyj¹tek, gdy sprawdzany tekst nie zosta³ utworzony lub
     * jest pusty (nie zawiera treœci).
     * 
     * @param text
     *            Tekst do sprawdzenia.
     * @param exceptionMessage
     *            Opis b³êdu. Zostanie ustawiony, jeœli b³¹d wyst¹pi.
     * @throws IllegalArgumentException
     *             Wygenerowany b³¹d.
     */
    public static void throwExceptionWhenTextIsEmpty(String text, String exceptionMessage) throws IllegalArgumentException {
	if (text == null || text.length() == 0) {
	    throw new IllegalArgumentException(exceptionMessage);
	}
    }

    /**
     * Zostanie rzucony wyj¹tek, gdy sprawdzana kolekcja nie zosta³a utworzona
     * lub, gdy podany na wejœciu indeks jest nieprawid³owy dla kolekcji.
     * 
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
    public static void throwExceptionWhenNoSuchElementAtIndex(Collection<?> list, int index, String exceptionMessage)
	    throws NoSuchElementException, IllegalArgumentException {

	throwExceptionWhenEmptyOrContainsEmptyObject(list, "Na podanej liœcie nie ma obiektów!");

	if (index < 0 || index >= list.size()) {
	    throw new NoSuchElementException("Nie ma elementu pod podanym indeksem!");
	}
    }

    /**
     * Zostanie rzucony wyj¹tek, gdy sprawdzany zbiór obiektów (iterowalny) nie
     * zosta³ stworzony lub zawiera niestaworzone elementy (referencje do null).
     * 
     * @param itearable
     *            Zbiór obiektów do sprawdzenia.
     * @param exceptionMessage
     *            Opis b³êdu. Zostanie ustawiony, jeœli b³¹d wyst¹pi.
     * @throws IllegalArgumentException
     *             Wygenerowany b³¹d.
     */
    public static void throwExceptionWhenEmptyOrContainsEmptyObject(Iterable<?> itearable, String exceptionMessage)
	    throws IllegalArgumentException {
	if (itearable == null || !itearable.iterator().hasNext() || containsNullObjects(itearable)) {
	    throw new IllegalArgumentException(exceptionMessage);
	}
    }

    /**
     * Zostanie rzucony wyj¹tek, gdy sprawdzany zbiór obiektów zawiera
     * nieutworzone elementy (referencje do null).
     * 
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
