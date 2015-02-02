package edu.issi.machine.mvc;

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
	configuration.addProduct(product);
    }

    /**
     * @return Nazwy dostêpnych produktów.
     */
    public Set<String> getProductsNames() {
	Set<String> result = new HashSet<String>();
	Iterator<Product> productsIterator = configuration.getProductsIterator();

	while (productsIterator.hasNext()) {
	    String productName = productsIterator.next().getName();
	    result.add(productName);
	}

	return result;
    }

    /**
     * @return Nazwy dostêpnych sk³adników.
     */
    public Set<String> getIngredientsNames() {
	Set<String> result = new HashSet<String>();
	Iterator<Product> productsIterator = configuration.getProductsIterator();

	while (productsIterator.hasNext()) {
	    Iterator<Ingredient> ingredientsIterator = productsIterator.next().iterator();

	    while (ingredientsIterator.hasNext()) {
		String ingredientName = ingredientsIterator.next().getName();
		result.add(ingredientName);
	    }
	}

	return result;
    }
}