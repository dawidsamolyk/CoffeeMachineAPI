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
     *             Wyst¹pi, jeœli konfiguracja maszyny jest pusta.
     */
    public Model(MachineConfiguration configuration) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(configuration,
		"Nie mo¿na utworzyæ modelu aplikacji z pust¹ konfiguracj¹ maszyny!");

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
     *            Produkt, który ma zostaæ dodany do konfiguracji maszyny.
     */
    public void addProduct(Product product) {
	Validator.throwExceptionWhenObjectIsNotCreated(product, "Nie mo¿na dodaæ pustego produktu!");
	configuration.addProduct(product);
    }

    /**
     * @return Nazwy dostêpnych produktów.
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
     * @return Nazwy wszystkich dostêpnych sk³adników.
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
     * @return Nazwy sk³adników wybranego produktu.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli nazwa produktu bêdzie pusta lub gdy maszyna
     *             nie obs³uguje produktu o podanej nazwie.
     */
    public Set<String> getIngredientsNamesForProductNamed(String productName) throws IllegalArgumentException {
	Validator.throwExceptionWhenTextIsEmpty(productName, "Nazwa produktu nie mo¿e byæ pusta!");
	Product product = getProductByName(productName);

	if (product == null) {
	    throw new IllegalArgumentException("Maszyna nie obs³uguje produktu o nazwie " + productName);
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
     *            Nazwa sk³adnika.
     * @return W³aœciowœci sk³adnika.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli nazwa sk³adnika bêdzie pusta lub gdy maszyna
     *             nie obs³uguje sk³adnika o podanej nazwie.
     */
    public Map<String, Unit> getPropertiesForIngredientNamed(String ingredientName) throws IllegalArgumentException {
	Validator.throwExceptionWhenTextIsEmpty(ingredientName, "Nazwa sk³adnika nie mo¿e byæ pusta!");

	Ingredient ingredient = getIngredientByName(ingredientName);

	if (ingredient == null) {
	    throw new IllegalArgumentException("Maszyna nie obs³uguje sk³adnika o nazwie " + ingredientName);
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
     *             Wyst¹pi, jeœli nie wybrano produktu lub produkt nie jest
     *             wpisany w konfiguracji maszyny. Mo¿e równie¿ wyst¹piæ w
     *             przypadku b³êdu wykonywania operacji na sk³adnikach produktu.
     */
    public void makeOrder(String orderedProductName) throws IllegalArgumentException {
	Validator.throwExceptionWhenTextIsEmpty(orderedProductName, "Nie wybrano produktu!");

	Product orderedProduct = getProductByName(orderedProductName);

	if (orderedProduct == null) {
	    throw new IllegalArgumentException("Wybrano nieznany produkt!");
	}

	List<OperationStatus> operationsStatuses = makeProduct(orderedProduct);
	// TODO przeka¿ statusy operacji dalej do analizy
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