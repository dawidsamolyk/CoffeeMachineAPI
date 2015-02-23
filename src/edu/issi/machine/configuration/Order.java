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
 *         Zam�wienie.
 */
public class Order {
    protected Product product;

    /**
     * Konstruktor. Wymagana jest nazwa produktu, kt�ry ma by� zam�wiony. Ten
     * konstruktor powinien by� u�ywany do realizacji zam�wienia produktu, kt�ry
     * samodzielnie definiuje u�ytkownik (tj. podaje sk�adniki oraz ich
     * w�a�ciwo�ci).
     * 
     * @param name
     *            Nazwa nowego produktu.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li nazwa produktu nie zostanie podana.
     */
    public Order(String name) throws IllegalArgumentException {
	Validator.throwExceptionWhenTextIsEmpty(name, "Nie podano nazwy produktu!");
	this.product = new Product(Identity.Factory.newIdentity(name));
    }

    /**
     * Konstruktor. Wymagany jest obiekt klasy Product, kt�ry b�dzie tworzony i
     * wydawany w ramach zam�wienia. W tej klasie zapami�tana zostanie kopia
     * obiektu Product.
     * 
     * @param product
     *            Produkt.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li produkt nie zosta� utworzony.
     */
    public Order(Product product) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(product, "Nie mo�na z�o�y� zam�wienia dla nieznanego produktu!");
	this.product = product.clone();
    }

    /**
     * Realizacja zam�wienia.
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
