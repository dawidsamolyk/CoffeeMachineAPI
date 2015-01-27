package edu.issi.machine.mvc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import edu.issi.machine.Validator;
import edu.issi.machine.configuration.MachineConfiguration;
import edu.issi.machine.controller.MachineController;
import edu.issi.machine.product.Product;

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
     * @return Iterator po produktach dostêpnych w konfiguracji maszyny.
     */
    public Map<Integer, String> getProducts() {
	Map<Integer, String> products = new HashMap<Integer, String>();

	Iterator<Product> productsIterator = configuration.getProductsIterator();
	
	while (productsIterator.hasNext()) {
	    Product eachProduct = productsIterator.next();
	    
	    products.put(eachProduct.getIdNumber(), eachProduct.getName());
	}

	return products;
    }
}