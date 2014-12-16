package edu.issi.machine.product;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.issi.machine.id.Identity;
import edu.issi.machine.id.ObjectWithIdentity;
import edu.issi.machine.product.ingredient.Ingredient;

/**
 * @author Dawid
 *
 */
public class Product extends ObjectWithIdentity implements Iterable<Ingredient> {
    private final OrderedElementsList<Ingredient> ingredients;

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
     * @see edu.issi.machine.product.OrderedElementsList#add(Object)
     */
    public void add(Ingredient ingredient) {
	ingredients.add(ingredient);
    }

    /**
     * @param index
     *            Indeks, spod kt�rego ma zosta� pobrany sk�adnik.
     * @return Skladnik umieszczony na podanym indeksie.
     * @throws NoSuchElementException
     *             Wyst�pi, je�li pod podanym indeksem nie ma �adnego sk�adnika.
     * @see edu.issi.machine.product.OrderedElementsList#getElement(int)
     */
    public Ingredient getIngredientAt(int index) throws NoSuchElementException {
	return ingredients.getElement(index);
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
     * @see edu.issi.machine.product.OrderedElementsList#remove(int)
     */
    public void remove(int index) {
	ingredients.remove(index);
    }

    /**
     * @return Iterator po skladnikach.
     * @see edu.issi.machine.product.OrderedElementsList#iterator()
     */
    @Override
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
	if (!getClass().equals(obj.getClass()))
	    return false;
	final Product other = (Product) obj;
	if (ingredients == null) {
	    if (other.ingredients != null)
		return false;
	} else if (!ingredients.equals(other.ingredients))
	    return false;
	return true;
    }

}
