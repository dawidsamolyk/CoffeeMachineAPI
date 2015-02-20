package edu.issi.machine.product;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.issi.machine.id.Identity;
import edu.issi.machine.id.ObjectWithIdentity;
import edu.issi.machine.product.ingredient.Ingredient;

/**
 * @author Dawid Samo�yk
 *
 *         Produkt.
 */
public class Product extends ObjectWithIdentity implements Iterable<Ingredient> {
    private final OrderedElementsList<Ingredient> ingredients;

    /**
     * @param id
     *            Identyfikator.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li identyfikator b�dzie pusty.
     */
    public Product(final Identity id) throws IllegalArgumentException {
	super(id);

	ingredients = new OrderedElementsList<Ingredient>();
    }

    /**
     * @param ingredient
     *            Sk�adnik, kt�ry zostanie dodany na ko�cu listy.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li sk�adnik b�dzie pusty.
     */
    public void add(Ingredient ingredient) throws IllegalArgumentException {
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
     * @return Liczba skladnik�sw.
     * @see edu.issi.machine.product.OrderedElementsList#getNumberOfElements()
     */
    public int numberOfElements() {
	return ingredients.getNumberOfElements();
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

    /**
     * @return Czy produkt zawiera tylko i wy��czie sk�adniki, kt�re podano jako
     *         argument wej�ciowy.
     */
    public boolean containsOnly(Collection<Ingredient> ingredients) {
	return this.ingredients.containsOnly(ingredients);
    }
}
