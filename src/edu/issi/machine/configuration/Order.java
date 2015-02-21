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
	Validator.throwExceptionWhenObjectIsNotCreated(product, "Nie mo�na z�o�y� zam�wienia dla pustego produktu!");
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
	 *            Indeks, pod kt�ry ma zosta� dodany sk�adnik.
	 * @param ingredient
	 *            Sk�adnik, kt�ry zostanie dodany do produktu.
	 * @throws UnsupportedOperationException
	 *             Wyst�pi, je�li podano nieprawid�owy indeks.
	 * @throws IllegalArgumentException
	 *             Wyst�pi, je�li obiekt wej�ciowy nie zosta� utworzony.
	 * @see #Product.addAt(int, Ingredient)
	 */
	public void addAt(int index, Ingredient ingredient) throws UnsupportedOperationException, IllegalArgumentException {
	    product.addAt(index, ingredient);
	}

	/**
	 * @param index
	 *            Indeks, spod kt�rego ma zosta� usuni�ty sk�adnik.
	 * @throws NoSuchElementException
	 *             Wyst�pi, je�li nie ma obiektu pod podanym indeksem.
	 * @see #Product.remove(int)
	 */
	public void remove(int index) throws NoSuchElementException {
	    product.remove(index);
	}
    }
}
