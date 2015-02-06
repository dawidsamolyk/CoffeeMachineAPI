package edu.issi.machine.mvc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.issi.machine.Validator;
import edu.issi.machine.configuration.MachineConfiguration;
import edu.issi.machine.controller.MachineController;
import edu.issi.machine.id.PropertyIdentity;
import edu.issi.machine.operation.OperationStatus;
import edu.issi.machine.product.Product;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.product.ingredient.Unit;

/**
 * @author DawidSamolyk
 * 
 */
public class Model {
    private MachineConfiguration configuration;
    private MachineController controller;

    /**
     * @param configuration
     *            Konfiguracja maszyny.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li konfiguracja maszyny jest pusta.
     */
    public Model(MachineConfiguration configuration) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(configuration,
		"Nie mo�na utworzy� modelu aplikacji z pust� konfiguracj� maszyny!");

	this.configuration = configuration;
	this.controller = new MachineController(configuration);
    }

    /**
     * Uruchomienie maszyny.
     */
    public void startMachine() {
	controller.start();
    }

    /**
     * Zatrzymanie pracy maszyny.
     */
    public void stopMachine() {
	controller.stop();
    }

    /**
     * @param product
     *            Produkt, kt�ry ma zosta� dodany do konfiguracji maszyny.
     */
    public void addProduct(Product product) {
	Validator.throwExceptionWhenObjectIsNotCreated(product, "Nie mo�na doda� pustego produktu!");
	configuration.addProduct(product);
    }

    /**
     * @return Nazwy dost�pnych produkt�w.
     */
    public Set<String> getProductsNames() {
	Set<String> result = new HashSet<String>();
	Iterator<Product> productsIterator = configuration.getProductsIterator();

	while (productsIterator.hasNext()) {
	    Product product = productsIterator.next();
	    result.add(product.getName());
	}

	return result;
    }

    /**
     * @return Nazwy wszystkich dost�pnych sk�adnik�w.
     */
    public Set<String> getAllIngredientsNames() {
	Set<String> result = new HashSet<String>();
	Iterator<Ingredient> ingredientsIterator = configuration.getIngredientsIterator();

	while (ingredientsIterator.hasNext()) {
	    Ingredient ingredient = ingredientsIterator.next();
	    result.add(ingredient.getName());
	}

	return result;
    }

    /**
     * @param productName
     *            Nazwa produktu.
     * @return Nazwy sk�adnik�w wybranego produktu.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li nazwa produktu b�dzie pusta lub gdy maszyna
     *             nie obs�uguje produktu o podanej nazwie.
     */
    public Set<String> getIngredientsNamesForProductNamed(String productName) throws IllegalArgumentException {
	Validator.throwExceptionWhenTextIsEmpty(productName, "Nazwa produktu nie mo�e by� pusta!");
	Product product = getProductByName(productName);

	if (product == null) {
	    throw new IllegalArgumentException("Maszyna nie obs�uguje produktu o nazwie " + productName);
	}

	Set<String> result = new HashSet<String>();

	for (Ingredient eachIngredient : product) {
	    result.add(eachIngredient.getName());
	}

	return result;
    }

    private Product getProductByName(String productName) {
	Iterator<Product> iterator = configuration.getProductsIterator();

	Product product = null;
	while (iterator.hasNext()) {
	    Product eachProduct = iterator.next();

	    if (eachProduct.getName().equals(productName)) {
		product = eachProduct;
		break;
	    }
	}
	return product;
    }

    /**
     * @param ingredientName
     *            Nazwa sk�adnika.
     * @return W�a�ciow�ci sk�adnika.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li nazwa sk�adnika b�dzie pusta lub gdy maszyna
     *             nie obs�uguje sk�adnika o podanej nazwie.
     */
    public Map<String, Unit> getPropertiesForIngredientNamed(String ingredientName) throws IllegalArgumentException {
	Validator.throwExceptionWhenTextIsEmpty(ingredientName, "Nazwa sk�adnika nie mo�e by� pusta!");

	Ingredient ingredient = getIngredientByName(ingredientName);

	if (ingredient == null) {
	    throw new IllegalArgumentException("Maszyna nie obs�uguje sk�adnika o nazwie " + ingredientName);
	}

	Map<String, Unit> result = new HashMap<String, Unit>();

	Map<PropertyIdentity, Double> ingredientProperties = ingredient.getProperties();

	for (PropertyIdentity eachProperty : ingredientProperties.keySet()) {
	    result.put(eachProperty.getName(), eachProperty.getUnit());
	}

	return result;
    }

    private Ingredient getIngredientByName(String ingredientName) {
	Iterator<Ingredient> iterator = configuration.getIngredientsIterator();

	Ingredient ingredient = null;
	while (iterator.hasNext()) {
	    Ingredient eachIngredient = iterator.next();

	    if (eachIngredient.getName().equals(ingredientName)) {
		ingredient = eachIngredient;
		break;
	    }
	}
	return ingredient;
    }

    /**
     * @param orderedProductName
     *            Nazwa zamawianago produktu.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li nie wybrano produktu lub produkt nie jest
     *             wpisany w konfiguracji maszyny. Mo�e r�wnie� wyst�pi� w
     *             przypadku b��du wykonywania operacji na sk�adnikach produktu.
     */
    public void makeOrder(String orderedProductName) throws IllegalArgumentException {
	Validator.throwExceptionWhenTextIsEmpty(orderedProductName, "Nie wybrano produktu!");

	Product orderedProduct = getProductByName(orderedProductName);

	if (orderedProduct == null) {
	    throw new IllegalArgumentException("Wybrano nieznany produkt!");
	}

	List<OperationStatus> operationsStatuses = makeProduct(orderedProduct);
	// TODO przeka� statusy operacji dalej do analizy
    }

    private List<OperationStatus> makeProduct(Product orderedProduct) throws IllegalArgumentException {
	List<OperationStatus> allOperationStatuses = new ArrayList<OperationStatus>();

	for (Iterator<Ingredient> iterator = orderedProduct.iterator(); iterator.hasNext();) {
	    Ingredient ingredient = iterator.next();

	    List<OperationStatus> ingredientOperationStatuses = ingredient.doOperations();
	    allOperationStatuses.addAll(ingredientOperationStatuses);
	}

	return allOperationStatuses;
    }
}