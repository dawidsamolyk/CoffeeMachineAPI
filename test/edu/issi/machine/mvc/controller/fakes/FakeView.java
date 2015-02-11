package edu.issi.machine.mvc.controller.fakes;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import edu.issi.machine.mvc.controller.Controller.IngredientsListener;
import edu.issi.machine.mvc.controller.Controller.OrderListener;
import edu.issi.machine.mvc.controller.Controller.ProductsListener;
import edu.issi.machine.mvc.controller.Controller.PropertiesListener;
import edu.issi.machine.mvc.controller.EventArguments;
import edu.issi.machine.mvc.view.View;
import edu.issi.machine.operation.Status;
import edu.issi.machine.product.Product;
import edu.issi.machine.product.ingredient.Unit;

@SuppressWarnings("javadoc")
public class FakeView implements View {
    public String newProductName = "New test product name";
    public String orderedProductName = "Test";

    protected ProductsListener productsListListener;
    protected PropertiesListener propertiesListener;
    protected IngredientsListener ingredientsListener;
    protected OrderListener orderListener;

    protected String lastMessage;

    public FakeView() {
    }

    public FakeView(Product orderedProduct) {
	this.orderedProductName = orderedProduct.getName();
    }

    @Override
    public void showProducts(Set<String> products) {
	lastMessage = products.toString();
    }

    @Override
    public void showProductIngredients(String productName, Set<String> ingredients) {
	lastMessage = ingredients.toString();
    }

    @Override
    public void showIngredients(Set<String> ingredients) {
	lastMessage = ingredients.toString();
    }

    @Override
    public void showIngredientProperties(String ingredientName, Map<String, Unit> properties) {
	lastMessage = properties.toString();
    }

    @Override
    public String getSelectedForPreparationProductName() {
	return orderedProductName;
    }

    @Override
    public Map<String, Float> getPropertiesForIngredient(String ingredientName, Map<String, Unit> availableProperties) {
	Map<String, Float> result = new HashMap<String, Float>();

	for (String eachPropertyname : availableProperties.keySet()) {
	    result.put(eachPropertyname, 100f);
	}

	return result;
    }

    @Override
    public void showOperationStatus(Status status, String description) {
	lastMessage = description;
    }

    @Override
    public String getNewProductName() {
	return newProductName;
    }

    @Override
    public void showError(String description) {
	lastMessage = description;
    }

    public String getLastMessage() {
	return lastMessage;
    }

    @Override
    public Set<String> getNewProductIngredients(Set<String> availableIngredients) {
	return availableIngredients;
    }

    @Override
    public void addProductsListener(ProductsListener productsListListener) {
	this.productsListListener = productsListListener;
    }

    @Override
    public void addIngredientsListener(IngredientsListener ingredientsListener) {
	this.ingredientsListener = ingredientsListener;
    }

    @Override
    public void addPropertiesListener(PropertiesListener propertiesListener) {
	this.propertiesListener = propertiesListener;
    }

    @Override
    public void addOrderListener(OrderListener orderListener) {
	this.orderListener = orderListener;
    }

    public void performActionOnProductsListener() {
	productsListListener.actionPerformed(new EventArguments(this));
    }

    public void performActionOnIngredientsListener() {
	ingredientsListener.actionPerformed(new EventArguments(this));
    }

    public void performActionOnIngredientsListenerForProductNamed(String productName) {
	ingredientsListener.actionPerformed(new EventArguments(this, productName));
    }

    public void performActionOnPropertiesListener() {
	propertiesListener.actionPerformed(new EventArguments(this));
    }

    public void performActionOnPropertiesListenerForIngredientNamed(String ingredientName) {
	propertiesListener.actionPerformed(new EventArguments(this, ingredientName));
    }

    public void performActionOnOrderListener() {
	orderListener.actionPerformed(new EventArguments(this));
    }
}
