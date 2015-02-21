package edu.issi.machine.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import edu.issi.machine.Validator;
import edu.issi.machine.id.Identity;
import edu.issi.machine.operation.OperationStatus;
import edu.issi.machine.product.Product;
import edu.issi.machine.product.ingredient.Ingredient;

/**
 * @author Dawid
 *
 */
public class Order {
    protected Product product;

    /**
     * @param name
     * @throws IllegalArgumentException 
     */
    public Order(String name) throws IllegalArgumentException {
	Validator.throwExceptionWhenTextIsEmpty(name, "Nie podano nazwy produktu!");
	this.product = new Product(Identity.Factory.newIdentity(name));
    }

    /**
     * @param product
     * @throws IllegalArgumentException 
     */
    public Order(Product product) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(product, "Nie mo¿na z³o¿yæ zamówienia dla pustego produktu!");
	this.product = product.clone();
    }

    /**
     * @return Status wykonanych operacji.
     */
    public OperationStatus execute() {
	List<OperationStatus> result = new ArrayList<OperationStatus>();

	for (Ingredient eachIngredient : product) {
	    List<OperationStatus> operationsStatus = eachIngredient.doOperations();
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
