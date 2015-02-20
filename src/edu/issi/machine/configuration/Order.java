package edu.issi.machine.configuration;

import edu.issi.machine.Validator;
import edu.issi.machine.id.Identity;
import edu.issi.machine.product.Product;

/**
 * @author Dawid
 *
 */
public class Order {
    private Product product;

    /**
     * @param name
     */
    public Order(String name) {
	Validator.throwExceptionWhenTextIsEmpty(name, "Nie podano nazwy produktu!");
	this.product = new Product(Identity.Factory.newIdentity(name));
    }

    /**
     * @param product
     * @throws CloneNotSupportedException
     */
    public Order(Product product) throws CloneNotSupportedException {
	Validator.throwExceptionWhenObjectIsNotCreated(product, "Nie mo¿na z³o¿yæ zamówienia dla pustego produktu!");
	this.product = product.getClone();
    }

    public void f() {
	product.iterator();
    }
}
