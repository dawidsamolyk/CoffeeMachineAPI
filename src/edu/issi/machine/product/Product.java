package edu.issi.machine.product;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.issi.machine.Identity;
import edu.issi.machine.ObjectWithId;

/**
 * @author Dawid
 *
 */
public class Product extends ObjectWithId {
    private OrderedElementsContainer<Ingredient> ingredients;

    /**
     * @param id
     */
    public Product(final Identity id) {
	super(id);
	ingredients = new OrderedElementsContainer<Ingredient>();
    }

    /**
     * @param ingredient
     * @see edu.issi.machine.product.OrderedElementsContainer#addAtTheEnd(Object)
     */
    public void addAtTheEnd(Ingredient ingredient) {
	ingredients.addAtTheEnd(ingredient);
    }

    /**
     * @param index
     * @return Skladnik umieszczony na podanym indeksie.
     * @throws NoSuchElementException
     * @see edu.issi.machine.product.OrderedElementsContainer#getElementAt(int)
     */
    public Ingredient getIngredientAt(int index) throws NoSuchElementException {
	return ingredients.getElementAt(index);
    }

    /**
     * @return Liczba skladnikow.
     * @see edu.issi.machine.product.OrderedElementsContainer#numberOfElements()
     */
    public int numberOfElements() {
	return ingredients.numberOfElements();
    }

    /**
     * @param index
     * @param ingredient
     * @see edu.issi.machine.product.OrderedElementsContainer#addAt(int, Object)
     */
    public void addAt(int index, Ingredient ingredient) {
	ingredients.addAt(index, ingredient);
    }

    /**
     * @param index
     * @see edu.issi.machine.product.OrderedElementsContainer#removeAt(int)
     */
    public void removeAt(int index) {
	ingredients.removeAt(index);
    }

    /**
     * @return Iterator po skladnikach.
     * @see edu.issi.machine.product.OrderedElementsContainer#iterator()
     */
    public Iterator<Ingredient> iterator() {
	return ingredients.iterator();
    }
}
