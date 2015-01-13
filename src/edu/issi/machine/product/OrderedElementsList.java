package edu.issi.machine.product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import edu.issi.machine.Validator;

/**
 * @author Dawid
 * @param <Type>
 *            Typ obiekt�w, kt�re b�d� przechowywane w tej li�cie.F
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
     *            Obiekt, kt�ry zostanie dodany na ko�cu listy.
     * @throws IllegalArgumentException 
     */
    public void add(Type object) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(object, "Obiekt dodawany do listy element�w nie mo�e by� pusty!");
	
	elements.add(object);
    }

    /**
     * @param index
     *            Indeks, pod kt�ry ma zosta� wstawiony nowy obiekt.
     * @param object
     *            Obiekt, kt�ry zostanie dodany do listy, pod wskazanym
     *            indeksem.
     * @throws UnsupportedOperationException
     *             Wyst�pi, je�li podano nieprawid�owy indeks.
     * @throws IllegalArgumentException 
     */
    public void addAt(int index, Type object) throws UnsupportedOperationException, IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(object, "Obiekt dodawany do listy element�w nie mo�e by� pusty!");
	
	if (index >= elements.size() || index < 0) {
	    throw new UnsupportedOperationException("Nie mozna dodac elementu pod indeksem " + index + "!");
	}
	elements.add(index, object);
    }

    /**
     * @param index
     *            Indeks, spod kt�rego ma zosta� pobrany obiekt.
     * @return Skladnik na podanym indeksie.
     * @throws NoSuchElementException
     *             Wyst�pi, je�li nie ma obiektu pod podanym indeksem.
     */
    public Type getElement(int index) throws NoSuchElementException {
	Validator.throwExceptionWhenThereIsNotSuchElementAtSpecifiedIndex(elements, index,
		"Nie istnieje �aden element pod wskazanym indeksem!");

	return elements.get(index);
    }

    /**
     * @param index
     *            Indeks, spod kt�rego ma zosta� usuni�ty obiekt.
     * @throws NoSuchElementException
     *             Wyst�pi, je�li nie ma obiektu pod podanym indeksem.
     */
    public void remove(int index) throws NoSuchElementException {
	Validator.throwExceptionWhenThereIsNotSuchElementAtSpecifiedIndex(elements, index,
		"Nie istnieje �aden element pod wskazanym indeksem!");

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
    public int numberOfElements() {
	return elements.size();
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((elements == null) ? 0 : elements.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!getClass().equals(obj.getClass()))
	    return false;
	final OrderedElementsList<?> other = (OrderedElementsList<?>) obj;
	if (elements == null) {
	    if (other.elements != null)
		return false;
	} else if (!elements.equals(other.elements))
	    return false;
	return true;
    }

}
