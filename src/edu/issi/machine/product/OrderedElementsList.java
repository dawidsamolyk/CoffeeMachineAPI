package edu.issi.machine.product;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import edu.issi.machine.Validator;

/**
 * @author Dawid Samo³yk
 * 
 *         Lista uporz¹dkowanych elementów.
 * @param <Type>
 *            Typ obiektów, które bêd¹ przechowywane w tej liœcie.
 */
public class OrderedElementsList<Type> implements Iterable<Type> {
    private final List<Type> elements;

    /**
     * 
     */
    public OrderedElementsList() {
	elements = new LinkedList<Type>();
    }

    /**
     * @param object
     *            Obiekt, który zostanie dodany na koñcu listy.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli obiekt wejœciowy nie zosta³ utworzony.
     */
    public void add(Type object) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(object, "Obiekt dodawany do listy elementów nie mo¿e byæ pusty!");
	elements.add(object);
    }

    /**
     * @param index
     *            Indeks, pod który ma zostaæ wstawiony nowy obiekt.
     * @param object
     *            Obiekt, który zostanie dodany do listy, pod wskazanym
     *            indeksem.
     * @throws UnsupportedOperationException
     *             Wyst¹pi, jeœli podano nieprawid³owy indeks.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli obiekt wejœciowy nie zosta³ utworzony.
     */
    public void addAt(int index, Type object) throws UnsupportedOperationException, IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(object, "Obiekt dodawany do listy elementów nie mo¿e byæ pusty!");

	if (index > elements.size() || index < 0) {
	    throw new UnsupportedOperationException("Nie mozna dodac elementu pod indeksem " + index + "!");
	}
	elements.add(index, object);
    }

    /**
     * @param index
     *            Indeks, spod którego ma zostaæ pobrany obiekt.
     * @return Skladnik na podanym indeksie.
     * @throws NoSuchElementException
     *             Wyst¹pi, jeœli nie ma obiektu pod podanym indeksem.
     */
    public Type getElement(int index) throws NoSuchElementException {
	Validator.throwExceptionWhenNoSuchElementAtIndex(elements, index, "Nie istnieje ¿aden element pod wskazanym indeksem!");
	return elements.get(index);
    }

    /**
     * @param index
     *            Indeks, spod którego ma zostaæ usuniêty obiekt.
     * @throws NoSuchElementException
     *             Wyst¹pi, jeœli nie ma obiektu pod podanym indeksem.
     */
    public void remove(int index) throws NoSuchElementException {
	Validator.throwExceptionWhenNoSuchElementAtIndex(elements, index, "Nie istnieje ¿aden element pod wskazanym indeksem!");
	elements.remove(index);
    }

    /**
     * @return Iterator po elementach.
     */
    @Override
    public Iterator<Type> iterator() {
	return elements.iterator();
    }

    /**
     * @return Liczba elementow.
     */
    public int getNumberOfElements() {
	return elements.size();
    }

    /**
     * @param objects
     *            Zbiór, wewn¹trz którego powinny zawieraæ siê elementy tej
     *            listy.
     * @return Czy lista zawiera tylko i wy³¹czie obiekty, które podano jako
     *         argument wejœciowy.
     * @throws IllegalArgumentException
     *             Wyst¹p, jeœli podano na wejœciu niestworzony lub
     *             nieprawid³owy zbiór.
     */
    public boolean containsOnly(Collection<Type> objects) throws IllegalArgumentException {
	Validator.throwExceptionWhenEmptyOrContainsEmptyObject(objects, "Podany zbiór do porówania jest nieprawid³owy!");
	return objects.containsAll(elements);
    }
}
