package edu.issi.machine.mvc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import edu.issi.machine.Validator;
import edu.issi.machine.configuration.MachineConfiguration;
import edu.issi.machine.controller.MachineController;
import edu.issi.machine.id.PropertyIdentity;
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
     * @return Nazwy dostêpnych produktów.
     */
    public List<String> getProductsNames() {
	List<String> result = new ArrayList<String>();
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
    public List<String> getAllIngredientsNames() {
	List<String> result = new ArrayList<String>();
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
    public List<String> getIngredientsNamesForProductNamed(String productName) throws IllegalArgumentException, NoSuchElementException {
	Validator.throwExceptionWhenTextIsEmpty(productName, "Nazwa produktu nie mo¿e byæ pusta!");
	Product product = getProductByName(productName);

	List<String> result = new ArrayList<String>();

	for (Ingredient eachIngredient : product) {
	    result.add(eachIngredient.getName());
	}

	return result;
    }

    /**
     * @param ingredientName
     *            Nazwa sk³adnika.
     * @return W³aœciowœci sk³adnika.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli nazwa sk³adnika bêdzie pusta lub gdy maszyna
     *             nie obs³uguje sk³adnika o podanej nazwie.
     */
    public Map<String, Unit> getPropertiesForIngredientNamed(String ingredientName) throws IllegalArgumentException, NoSuchElementException {
	Validator.throwExceptionWhenTextIsEmpty(ingredientName, "Nazwa sk³adnika nie mo¿e byæ pusta!");

	Ingredient ingredient = getIngredientByName(ingredientName);

	Map<String, Unit> result = new HashMap<String, Unit>();

	Map<PropertyIdentity, Double> ingredientProperties = ingredient.getProperties();

	for (PropertyIdentity eachProperty : ingredientProperties.keySet()) {
	    result.put(eachProperty.getName(), eachProperty.getUnit());
	}

	return result;
    }
    
    /**
     * @param productName
     *            Nazwa produktu.
     * @return Produkt.
     */
    public Product getProductByName(String productName) throws NoSuchElementException {
	Iterator<Product> iterator = configuration.getProductsIterator();

	while (iterator.hasNext()) {
	    Product eachProduct = iterator.next();

	    if (eachProduct.getName().equals(productName)) {
		return eachProduct;
	    }
	}
	throw new NoSuchElementException("Nie znaleziono podanego produktu w konfiguracji maszyny!");
    }

    /**
     * @param ingredientName
     *            Nazwa sk³adnika.
     * @return Sk³adnik.
     */
    public Ingredient getIngredientByName(String ingredientName) throws NoSuchElementException {
	Iterator<Ingredient> iterator = configuration.getIngredientsIterator();

	while (iterator.hasNext()) {
	    Ingredient eachIngredient = iterator.next();

	    if (eachIngredient.getName().equals(ingredientName)) {
		return eachIngredient;
	    }
	}
	throw new NoSuchElementException("Nie znaleziono podanego sk³adnika w konfiguracji maszyny!");
    }

    /**
     * @param propertyName
     *            Nazwa w³aœciwoœci.
     * @return Identyfikator w³aœciwoœci.
     * @throws NoSuchElementException 
     */
    public PropertyIdentity getPropertyByName(String propertyName) throws NoSuchElementException {
	Iterator<Ingredient> iterator = configuration.getIngredientsIterator();

	while (iterator.hasNext()) {
	    Ingredient eachIngredient = iterator.next();

	    Map<PropertyIdentity, Double> properties = eachIngredient.getProperties();
	    for (PropertyIdentity eachProperty : properties.keySet()) {
		if (eachProperty.getName().equals(propertyName)) {
		    return eachProperty;
		}
	    }
	}
	throw new NoSuchElementException("Nie znaleziono podanej w³aœciwoœci sk³adnika w konfiguracji maszyny!");
    }

}