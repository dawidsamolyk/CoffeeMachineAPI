package edu.issi.machine.product;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.issi.machine.id.Identity;
import edu.issi.machine.id.ObjectWithIdentity;

/**
 * @author Dawid
 *
 */
public class Product extends ObjectWithIdentity implements Iterable<Ingredient> {
    private OrderedElementsList<Ingredient> ingredients;

    /**
     * @param id
     *            Numer ID.
     */
    public Product(final Identity id) {
	super(id);
	ingredients = new OrderedElementsList<Ingredient>();
    }

    /**
     * @param ingredient
     *            Sk�adnik, kt�ry zostanie dodany na ko�cu listy.
     * @see edu.issi.machine.product.OrderedElementsList#addAtTheEnd(Object)
     */
    public void addAtTheEnd(Ingredient ingredient) {
	ingredients.addAtTheEnd(ingredient);
    }

    /**
     * @param index
     *            Indeks, spod kt�rego ma zosta� pobrany sk�adnik.
     * @return Skladnik umieszczony na podanym indeksie.
     * @throws NoSuchElementException
     *             Wyst�pi, je�li pod podanym indeksem nie ma �adnego sk�adnika.
     * @see edu.issi.machine.product.OrderedElementsList#getElementAt(int)
     */
    public Ingredient getIngredientAt(int index) throws NoSuchElementException {
	return ingredients.getElementAt(index);
    }

    /**
     * @return Liczba skladnikow.
     * @see edu.issi.machine.product.OrderedElementsList#numberOfElements()
     */
    public int numberOfElements() {
	return ingredients.numberOfElements();
    }

    /**
     * @param index
     *            Indeks, pod kt�ry ma zosta� dodany sk�adnik.
     * @param ingredient
     *            Sk�adnik.
     * @see edu.issi.machine.product.OrderedElementsList#addAt(int, Object)
     */
    public void addAt(int index, Ingredient ingredient) {
	ingredients.addAt(index, ingredient);
    }

    /**
     * @param index
     *            Indeks, spod kt�rego ma zosta� usuni�ty sk�adnik.
     * @see edu.issi.machine.product.OrderedElementsList#removeAt(int)
     */
    public void removeAt(int index) {
	ingredients.removeAt(index);
    }

    /**
     * @return Iterator po skladnikach.
     * @see edu.issi.machine.product.OrderedElementsList#iterator()
     */
    public Iterator<Ingredient> iterator() {
	return ingredients.iterator();
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Product other = (Product) obj;
	if (ingredients == null) {
	    if (other.ingredients != null)
		return false;
	} else if (!ingredients.equals(other.ingredients))
	    return false;
	return true;
    }

}
