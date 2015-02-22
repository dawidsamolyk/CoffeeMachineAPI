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
     * @return Nazwy dost�pnych produkt�w.
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
     * @return Nazwy wszystkich dost�pnych sk�adnik�w.
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
     * @return Nazwy sk�adnik�w wybranego produktu.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li nazwa produktu b�dzie pusta lub gdy maszyna
     *             nie obs�uguje produktu o podanej nazwie.
     */
    public List<String> getIngredientsNamesForProductNamed(String productName) throws IllegalArgumentException, NoSuchElementException {
	Validator.throwExceptionWhenTextIsEmpty(productName, "Nazwa produktu nie mo�e by� pusta!");
	Product product = getProductByName(productName);

	List<String> result = new ArrayList<String>();

	for (Ingredient eachIngredient : product) {
	    result.add(eachIngredient.getName());
	}

	return result;
    }

    /**
     * @param ingredientName
     *            Nazwa sk�adnika.
     * @return W�a�ciow�ci sk�adnika.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li nazwa sk�adnika b�dzie pusta lub gdy maszyna
     *             nie obs�uguje sk�adnika o podanej nazwie.
     */
    public Map<String, Unit> getPropertiesForIngredientNamed(String ingredientName) throws IllegalArgumentException, NoSuchElementException {
	Validator.throwExceptionWhenTextIsEmpty(ingredientName, "Nazwa sk�adnika nie mo�e by� pusta!");

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
     *            Nazwa sk�adnika.
     * @return Sk�adnik.
     */
    public Ingredient getIngredientByName(String ingredientName) throws NoSuchElementException {
	Iterator<Ingredient> iterator = configuration.getIngredientsIterator();

	while (iterator.hasNext()) {
	    Ingredient eachIngredient = iterator.next();

	    if (eachIngredient.getName().equals(ingredientName)) {
		return eachIngredient;
	    }
	}
	throw new NoSuchElementException("Nie znaleziono podanego sk�adnika w konfiguracji maszyny!");
    }

    /**
     * @param propertyName
     *            Nazwa w�a�ciwo�ci.
     * @return Identyfikator w�a�ciwo�ci.
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
	throw new NoSuchElementException("Nie znaleziono podanej w�a�ciwo�ci sk�adnika w konfiguracji maszyny!");
    }

}