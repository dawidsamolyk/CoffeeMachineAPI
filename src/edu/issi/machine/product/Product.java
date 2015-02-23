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
 *         Produkt. Kolejnoœæ dodanych sk³adników determuje kolejnoœæ, w której
 *         bêd¹ one przygotowywane.
 */
public class Product extends ObjectWithIdentity implements Iterable<Ingredient> {
    private final OrderedElementsList<Ingredient> ingredients;

    /**
     * Konstruktor. Obiekt klasy Identity jest wymagany.
     * 
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
     * Dodanie nowego sk³adnika na koñcu listy sk³adników.
     * 
     * @param ingredient
     *            Sk³adnik, który zostanie dodany na koñcu listy.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli sk³adnik bêdzie pusty.
     */
    public void add(Ingredient ingredient) throws IllegalArgumentException {
	ingredients.add(ingredient);
    }

    /**
     * Pobranie sk³adnika spod podanego indeksu.
     * 
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
     * Zwraca liczbê sk³adników.
     * 
     * @return Liczba skladnikósw.
     * @see edu.issi.machine.product.OrderedElementsList#getNumberOfElements()
     */
    public int numberOfElements() {
	return ingredients.getNumberOfElements();
    }

    /**
     * Dodaje nowy sk³adnik pod wskazanym indeksem.
     * 
     * @param index
     *            Indeks, pod który ma zostaæ dodany sk³adnik.
     * @param ingredient
     *            Sk³adnik.
     * @throws UnsupportedOperationException
     *             Wyst¹pi, jeœli podano nieprawid³owy indeks.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli obiekt wejœciowy nie zosta³ utworzony.
     * @see edu.issi.machine.product.OrderedElementsList#addAt(int, Object)
     */
    public void addAt(int index, Ingredient ingredient) throws UnsupportedOperationException, IllegalArgumentException {
	ingredients.addAt(index, ingredient);
    }

    /**
     * Usuwa sk³adnik spod wybranego indeksu.
     * 
     * @param index
     *            Indeks, spod którego ma zostaæ usuniêty sk³adnik.
     * @throws NoSuchElementException
     *             Wyst¹pi, jeœli nie ma obiektu pod podanym indeksem.
     * @see edu.issi.machine.product.OrderedElementsList#remove(int)
     */
    public void remove(int index) throws NoSuchElementException {
	ingredients.remove(index);
    }

    /**
     * Zwraca iterator po sk³adnikach.
     * 
     * @return Iterator po skladnikach.
     * @see edu.issi.machine.product.OrderedElementsList#iterator()
     */
    @Override
    public Iterator<Ingredient> iterator() {
	return ingredients.iterator();
    }

    /**
     * Informuje czy sk³adniki zawieraj¹ siê w kolekcji, która jest parametrem
     * wejœciowym.
     * 
     * @param ingredients
     *            Sk³adniki.
     * @return Czy produkt zawiera tylko i wy³¹czie sk³adniki, które podano jako
     *         argument wejœciowy.
     * @throws IllegalArgumentException
     *             Wyst¹p, jeœli podano na wejœciu niestworzony lub
     *             nieprawid³owy zbiór.
     */
    public boolean containsIn(Collection<Ingredient> ingredients) throws IllegalArgumentException {
	return this.ingredients.containsIn(ingredients);
    }

    /**
     * Zwraca kopiê obiektu.
     * 
     * @return Skopiowany produkt.
     */
    @Override
    public Product clone() {
	Product result = new Product(Identity.Factory.newIdentity(this.getName()));

	for (Ingredient eachIngredient : this.ingredients) {
	    result.add(eachIngredient);
	}

	return result;
    }

}
