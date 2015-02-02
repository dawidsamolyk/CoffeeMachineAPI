package edu.issi.machine.mvc.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import edu.issi.machine.Validator;
import edu.issi.machine.configuration.MachineConfiguration;
import edu.issi.machine.controller.MachineController;
import edu.issi.machine.product.Product;
import edu.issi.machine.product.ingredient.Ingredient;

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
     */
    public Set<String> getIngredientsNamesForProductNamed(String productName) throws IllegalArgumentException {
	Product product = getProductByName(productName);

	if (product == null) {
	    throw new IllegalArgumentException("Maszyna nie obs�uguje produktu o nazwie " + productName);
	}

	Set<String> result = new HashSet<String>();
	
	for(Ingredient eachIngredient : product) {
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
}