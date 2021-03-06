package edu.issi.machine.product;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import edu.issi.machine.Validator;

/**
 * @author Dawid Samo�yk
 * 
 *         Lista uporz�dkowanych element�w.
 * @param <Type>
 *            Typ obiekt�w, kt�re b�d� przechowywane w tej li�cie.
 */
public class OrderedElementsList<Type> implements Iterable<Type> {
    private final List<Type> elements;

    /**
     * Konstruktor. Tworzy pust� list� obiekt�w podanego typu.
     */
    public OrderedElementsList() {
	elements = new LinkedList<Type>();
    }

    /**
     * Dodaje nowy element na ko�cu listy.
     * 
     * @param object
     *            Obiekt, kt�ry zostanie dodany na ko�cu listy.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li obiekt wej�ciowy nie zosta� utworzony.
     */
    public void add(Type object) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(object, "Obiekt dodawany do listy element�w nie mo�e by� pusty!");
	elements.add(object);
    }

    /**
     * Dodaje nowy element pod wskazany indeks listy.
     * 
     * @param index
     *            Indeks, pod kt�ry ma zosta� wstawiony nowy obiekt.
     * @param object
     *            Obiekt, kt�ry zostanie dodany do listy, pod wskazanym
     *            indeksem.
     * @throws UnsupportedOperationException
     *             Wyst�pi, je�li podano nieprawid�owy indeks.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li obiekt wej�ciowy nie zosta� utworzony.
     */
    public void addAt(int index, Type object) throws UnsupportedOperationException, IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(object, "Obiekt dodawany do listy element�w nie mo�e by� pusty!");

	if (index > elements.size() || index < 0) {
	    throw new UnsupportedOperationException("Nie mozna dodac elementu pod indeksem " + index + "!");
	}
	elements.add(index, object);
    }

    /**
     * Pobiera element spod wskazanego indeksu.
     * 
     * @param index
     *            Indeks, spod kt�rego ma zosta� pobrany obiekt.
     * @return Skladnik na podanym indeksie.
     * @throws NoSuchElementException
     *             Wyst�pi, je�li nie ma obiektu pod podanym indeksem.
     */
    public Type getElement(int index) throws NoSuchElementException {
	Validator.throwExceptionWhenNoSuchElementAtIndex(elements, index, "Nie istnieje �aden element pod wskazanym indeksem!");
	return elements.get(index);
    }

    /**
     * Usuwa element spod wskazanego indeksu.
     * 
     * @param index
     *            Indeks, spod kt�rego ma zosta� usuni�ty obiekt.
     * @throws NoSuchElementException
     *             Wyst�pi, je�li nie ma obiektu pod podanym indeksem.
     */
    public void remove(int index) throws NoSuchElementException {
	Validator.throwExceptionWhenNoSuchElementAtIndex(elements, index, "Nie istnieje �aden element pod wskazanym indeksem!");
	elements.remove(index);
    }

    /**
     * Dostarcza iteratora po elementach listy.
     * 
     * @return Iterator po elementach.
     */
    @Override
    public Iterator<Type> iterator() {
	return elements.iterator();
    }

    /**
     * Dostarcza liczb� element�w zawartych na li�cie.
     * 
     * @return Liczba elementow.
     */
    public int getNumberOfElements() {
	return elements.size();
    }

    /**
     * Inforuje czy lista zawiera si� w kolekcji, kt�ra zosta�a podana jako
     * argument wej�ciowy.
     * 
     * @param objects
     *            Zbi�r, wewn�trz kt�rego powinny zawiera� si� elementy tej
     *            listy.
     * @return Czy lista zawiera tylko i wy��czie obiekty, kt�re podano jako
     *         argument wej�ciowy.
     * @throws IllegalArgumentException
     *             Wyst�p, je�li podano na wej�ciu niestworzony lub
     *             nieprawid�owy zbi�r.
     */
    public boolean containsIn(Collection<Type> objects) throws IllegalArgumentException {
	Validator.throwExceptionWhenEmptyOrContainsEmptyObject(objects, "Podany zbi�r do por�wania jest nieprawid�owy!");
	return objects.containsAll(elements);
    }
}
