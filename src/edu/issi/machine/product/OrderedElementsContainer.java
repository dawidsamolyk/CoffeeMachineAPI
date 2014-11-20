package edu.issi.machine.product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * @author Dawid
 * @param <Type>
 * 
 */
public class OrderedElementsContainer<Type> {
    private LinkedList<Type> elements;

    /**
     * 
     */
    public OrderedElementsContainer() {
	elements = new LinkedList<Type>();
    }

    /**
     * @param ingredient
     */
    public void addAtTheEnd(Type ingredient) {
	elements.add(ingredient);
    }

    /**
     * @param index
     * @param ingredient
     * @throws UnsupportedOperationException
     */
    public void addAt(int index, Type ingredient) throws UnsupportedOperationException {
	if (index >= elements.size() || index < 0) {
	    throw new UnsupportedOperationException("Nie mozna dodac elementu pod indeksem " + index + "!");
	}
	elements.add(index, ingredient);
    }

    /**
     * @param index
     * @return Skladnik na podanym indeksie.
     * @throws NoSuchElementException
     */
    public Type getElementAt(int index) throws NoSuchElementException {
	checkIsThereSuchElementAt(index);
	return elements.get(index);
    }

    /**
     * @param index
     * @throws NoSuchElementException
     */
    public void removeAt(int index) throws NoSuchElementException {
	checkIsThereSuchElementAt(index);
	elements.remove(index);
    }

    /**
     * @return Iterator po elementach.
     */
    public Iterator<Type> iterator() {
	return elements.iterator();
    }

    /**
     * @return Liczba elementow.
     */
    public int numberOfElements() {
	return elements.size();
    }

    private void checkIsThereSuchElementAt(int index) {
	if (index >= elements.size() || index < 0) {
	    throw new NoSuchElementException("Produkt nie zawiera elementu pod podanym indeksem!");
	}
    }
}
