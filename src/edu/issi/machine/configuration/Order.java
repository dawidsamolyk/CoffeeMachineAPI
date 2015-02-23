package edu.issi.machine.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import edu.issi.machine.Validator;
import edu.issi.machine.id.Identity;
import edu.issi.machine.operation.OperationStatus;
import edu.issi.machine.product.Product;
import edu.issi.machine.product.ingredient.Ingredient;

/**
 * @author Dawid
 *         Zamówienie.
 */
public class Order {
    protected Product product;

    /**
     * Konstruktor. Wymagana jest nazwa produktu, który ma byæ zamówiony. Ten
     * konstruktor powinien byæ u¿ywany do realizacji zamówienia produktu, który
     * samodzielnie definiuje u¿ytkownik (tj. podaje sk³adniki oraz ich
     * w³aœciwoœci).
     * 
     * @param name
     *            Nazwa nowego produktu.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli nazwa produktu nie zostanie podana.
     */
    public Order(String name) throws IllegalArgumentException {
	Validator.throwExceptionWhenTextIsEmpty(name, "Nie podano nazwy produktu!");
	this.product = new Product(Identity.Factory.newIdentity(name));
    }

    /**
     * Konstruktor. Wymagany jest obiekt klasy Product, który bêdzie tworzony i
     * wydawany w ramach zamówienia. W tej klasie zapamiêtana zostanie kopia
     * obiektu Product.
     * 
     * @param product
     *            Produkt.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli produkt nie zosta³ utworzony.
     */
    public Order(Product product) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(product, "Nie mo¿na z³o¿yæ zamówienia dla nieznanego produktu!");
	this.product = product.clone();
    }

    /**
     * Realizacja zamówienia.
     * 
     * @return Status wykonanych operacji.
     */
    public OperationStatus execute() {
	List<OperationStatus> result = new ArrayList<OperationStatus>();

	for (Ingredient eachIngredient : product) {
	    Collection<OperationStatus> operationsStatus = eachIngredient.doOperations();
	    result.addAll(operationsStatus);
	}

	return OperationStatus.Factory.getFrom(result);
    }

    /**
     * @author Dawid
     *
     */
    public class Configurator {

	/**
	 * @param index
	 *            Indeks, pod który ma zostaæ dodany sk³adnik.
	 * @param ingredient
	 *            Sk³adnik, który zostanie dodany do produktu.
	 * @throws UnsupportedOperationException
	 *             Wyst¹pi, jeœli podano nieprawid³owy indeks.
	 * @throws IllegalArgumentException
	 *             Wyst¹pi, jeœli obiekt wejœciowy nie zosta³ utworzony.
	 * @see #Product.addAt(int, Ingredient)
	 */
	public void addAt(int index, Ingredient ingredient) throws UnsupportedOperationException, IllegalArgumentException {
	    product.addAt(index, ingredient);
	}

	/**
	 * @param index
	 *            Indeks, spod którego ma zostaæ usuniêty sk³adnik.
	 * @throws NoSuchElementException
	 *             Wyst¹pi, jeœli nie ma obiektu pod podanym indeksem.
	 * @see #Product.remove(int)
	 */
	public void remove(int index) throws NoSuchElementException {
	    product.remove(index);
	}

    }
}
