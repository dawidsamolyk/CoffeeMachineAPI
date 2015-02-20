package edu.issi.machine.product;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.issi.machine.id.Identity;
import edu.issi.machine.id.ObjectWithIdentity;
import edu.issi.machine.product.ingredient.Ingredient;

/**
 * @author Dawid Samo³yk
 *
 *         Produkt.
 */
public class Product extends ObjectWithIdentity implements Iterable<Ingredient> {
    private final OrderedElementsList<Ingredient> ingredients;

    /**
     * @param id
     *            Identyfikator.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli identyfikator bêdzie pusty.
     */
    public Product(final Identity id) throws IllegalArgumentException {
	super(id);

	ingredients = new OrderedElementsList<Ingredient>();
    }

    /**
     * @param ingredient
     *            Sk³adnik, który zostanie dodany na koñcu listy.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli sk³adnik bêdzie pusty.
     */
    public void add(Ingredient ingredient) throws IllegalArgumentException {
	ingredients.add(ingredient);
    }

    /**
     * @param index
     *            Indeks, spod którego ma zostaæ pobrany sk³adnik.
     * @return Skladnik umieszczony na podanym indeksie.
     * @throws NoSuchElementException
     *             Wyst¹pi, jeœli pod podanym indeksem nie ma ¿adnego sk³adnika.
     * @see edu.issi.machine.product.OrderedElementsList#getElement(int)
     */
    public Ingredient getIngredientAt(int index) throws NoSuchElementException {
	return ingredients.getElement(index);
    }

    /**
     * @return Liczba skladnikósw.
     * @see edu.issi.machine.product.OrderedElementsList#getNumberOfElements()
     */
    public int numberOfElements() {
	return ingredients.getNumberOfElements();
    }

    /**
     * @param index
     *            Indeks, pod który ma zostaæ dodany sk³adnik.
     * @param ingredient
     *            Sk³adnik.
     * @see edu.issi.machine.product.OrderedElementsList#addAt(int, Object)
     */
    public void addAt(int index, Ingredient ingredient) {
	ingredients.addAt(index, ingredient);
    }

    /**
     * @param index
     *            Indeks, spod którego ma zostaæ usuniêty sk³adnik.
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

    /**
     * @return Czy produkt zawiera tylko i wy³¹czie sk³adniki, które podano jako
     *         argument wejœciowy.
     */
    public boolean containsOnly(Collection<Ingredient> ingredients) {
	return this.ingredients.containsOnly(ingredients);
    }
}
