package edu.issi.machine.configuration;

import java.util.ArrayList;
import java.util.List;

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
     */
    public Order(String name) {
	Validator.throwExceptionWhenTextIsEmpty(name, "Nie podano nazwy produktu!");
	this.product = new Product(Identity.Factory.newIdentity(name));
    }

    /**
     * @param product
     */
    public Order(Product product) {
	Validator.throwExceptionWhenObjectIsNotCreated(product, "Nie mo¿na z³o¿yæ zamówienia dla pustego produktu!");
	this.product = product.clone();
    }

    /**
     * @return Status wykonanych operacji.
     */
    public OperationStatus execute() {
	List<OperationStatus> result = new ArrayList<OperationStatus>();
	
	for(Ingredient eachIngredient : product) {
	    List<OperationStatus> operationsStatus = eachIngredient.doOperations();
	    result.addAll(operationsStatus);
	}
	
	return OperationStatus.Factory.getFrom(result);
    }
}
