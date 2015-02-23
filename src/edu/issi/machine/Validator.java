package edu.issi.machine;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * @author Dawid Samo�yk
 * 
 *         Walidator parametr�w.
 */
public class Validator {

    /**
     * Zostanie rzucony wyj�tek, gdy sprawdzany obiekt nie zosta� utworzony
     * (referencja do null).
     * 
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
     * Zostanie rzucony wyj�tek, gdy sprawdzany tekst nie zosta� utworzony lub
     * jest pusty (nie zawiera tre�ci).
     * 
     * @param text
     *            Tekst do sprawdzenia.
     * @param exceptionMessage
     *            Opis b��du. Zostanie ustawiony, je�li b��d wyst�pi.
     * @throws IllegalArgumentException
     *             Wygenerowany b��d.
     */
    public static void throwExceptionWhenTextIsEmpty(String text, String exceptionMessage) throws IllegalArgumentException {
	if (text == null || text.length() == 0) {
	    throw new IllegalArgumentException(exceptionMessage);
	}
    }

    /**
     * Zostanie rzucony wyj�tek, gdy sprawdzana kolekcja nie zosta�a utworzona
     * lub, gdy podany na wej�ciu indeks jest nieprawid�owy dla kolekcji.
     * 
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
    public static void throwExceptionWhenNoSuchElementAtIndex(Collection<?> list, int index, String exceptionMessage)
	    throws NoSuchElementException, IllegalArgumentException {

	throwExceptionWhenEmptyOrContainsEmptyObject(list, "Na podanej li�cie nie ma obiekt�w!");

	if (index < 0 || index >= list.size()) {
	    throw new NoSuchElementException("Nie ma elementu pod podanym indeksem!");
	}
    }

    /**
     * Zostanie rzucony wyj�tek, gdy sprawdzany zbi�r obiekt�w (iterowalny) nie
     * zosta� stworzony lub zawiera niestaworzone elementy (referencje do null).
     * 
     * @param itearable
     *            Zbi�r obiekt�w do sprawdzenia.
     * @param exceptionMessage
     *            Opis b��du. Zostanie ustawiony, je�li b��d wyst�pi.
     * @throws IllegalArgumentException
     *             Wygenerowany b��d.
     */
    public static void throwExceptionWhenEmptyOrContainsEmptyObject(Iterable<?> itearable, String exceptionMessage)
	    throws IllegalArgumentException {
	if (itearable == null || !itearable.iterator().hasNext() || containsNullObjects(itearable)) {
	    throw new IllegalArgumentException(exceptionMessage);
	}
    }

    /**
     * Zostanie rzucony wyj�tek, gdy sprawdzany zbi�r obiekt�w zawiera
     * nieutworzone elementy (referencje do null).
     * 
     * @param itearable
     *            Zbi�r obiekt�w do sprawdzenia.
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
