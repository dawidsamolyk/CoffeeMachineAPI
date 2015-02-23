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
 *         Produkt. Kolejno�� dodanych sk�adnik�w determuje kolejno��, w kt�rej
 *         b�d� one przygotowywane.
 */
public class Product extends ObjectWithIdentity implements Iterable<Ingredient> {
    private final OrderedElementsList<Ingredient> ingredients;

    /**
     * Konstruktor. Obiekt klasy Identity jest wymagany.
     * 
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
     * Dodanie nowego sk�adnika na ko�cu listy sk�adnik�w.
     * 
     * @param ingredient
     *            Sk�adnik, kt�ry zostanie dodany na ko�cu listy.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li sk�adnik b�dzie pusty.
     */
    public void add(Ingredient ingredient) throws IllegalArgumentException {
	ingredients.add(ingredient);
    }

    /**
     * Pobranie sk�adnika spod podanego indeksu.
     * 
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
     * Zwraca liczb� sk�adnik�w.
     * 
     * @return Liczba skladnik�sw.
     * @see edu.issi.machine.product.OrderedElementsList#getNumberOfElements()
     */
    public int numberOfElements() {
	return ingredients.getNumberOfElements();
    }

    /**
     * Dodaje nowy sk�adnik pod wskazanym indeksem.
     * 
     * @param index
     *            Indeks, pod kt�ry ma zosta� dodany sk�adnik.
     * @param ingredient
     *            Sk�adnik.
     * @throws UnsupportedOperationException
     *             Wyst�pi, je�li podano nieprawid�owy indeks.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li obiekt wej�ciowy nie zosta� utworzony.
     * @see edu.issi.machine.product.OrderedElementsList#addAt(int, Object)
     */
    public void addAt(int index, Ingredient ingredient) throws UnsupportedOperationException, IllegalArgumentException {
	ingredients.addAt(index, ingredient);
    }

    /**
     * Usuwa sk�adnik spod wybranego indeksu.
     * 
     * @param index
     *            Indeks, spod kt�rego ma zosta� usuni�ty sk�adnik.
     * @throws NoSuchElementException
     *             Wyst�pi, je�li nie ma obiektu pod podanym indeksem.
     * @see edu.issi.machine.product.OrderedElementsList#remove(int)
     */
    public void remove(int index) throws NoSuchElementException {
	ingredients.remove(index);
    }

    /**
     * Zwraca iterator po sk�adnikach.
     * 
     * @return Iterator po skladnikach.
     * @see edu.issi.machine.product.OrderedElementsList#iterator()
     */
    @Override
    public Iterator<Ingredient> iterator() {
	return ingredients.iterator();
    }

    /**
     * Informuje czy sk�adniki zawieraj� si� w kolekcji, kt�ra jest parametrem
     * wej�ciowym.
     * 
     * @param ingredients
     *            Sk�adniki.
     * @return Czy produkt zawiera tylko i wy��czie sk�adniki, kt�re podano jako
     *         argument wej�ciowy.
     * @throws IllegalArgumentException
     *             Wyst�p, je�li podano na wej�ciu niestworzony lub
     *             nieprawid�owy zbi�r.
     */
    public boolean containsIn(Collection<Ingredient> ingredients) throws IllegalArgumentException {
	return this.ingredients.containsIn(ingredients);
    }

    /**
     * Zwraca kopi� obiektu.
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
