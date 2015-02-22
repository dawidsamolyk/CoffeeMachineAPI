package edu.issi.machine.mvc.controller.fakes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.issi.machine.mvc.controller.Controller.CustomOrderListener;
import edu.issi.machine.mvc.controller.Controller.IngredientsListener;
import edu.issi.machine.mvc.controller.Controller.OrderListener;
import edu.issi.machine.mvc.controller.Controller.ProductsListener;
import edu.issi.machine.mvc.controller.Controller.PropertiesListener;
import edu.issi.machine.mvc.controller.EventArguments;
import edu.issi.machine.mvc.view.View;
import edu.issi.machine.operation.Status;
import edu.issi.machine.product.ingredient.Unit;

@SuppressWarnings("javadoc")
public class FakeView implements View {
    public String newProductName = "New test product name";
    public String orderedProductName = "Test product name";

    protected ProductsListener productsListListener;
    protected PropertiesListener propertiesListener;
    protected IngredientsListener ingredientsListener;
    protected OrderListener orderListener;
    protected CustomOrderListener customOrderListener;

    protected String lastMessage;

    public FakeView() {
    }

    public FakeView(String orderedProductName) {
	this.orderedProductName = orderedProductName;
    }

    @Override
    public void showProducts(List<String> products) {
	lastMessage = products.toString();
    }

    @Override
    public void showProductIngredients(String productName, List<String> ingredients) {
	lastMessage = ingredients.toString();
    }

    @Override
    public void showIngredients(List<String> ingredients) {
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
    public Map<String, Double> getPropertiesForIngredient(String ingredientName, Map<String, Unit> availableProperties) {
	Map<String, Double> result = new HashMap<String, Double>();

	for (String eachPropertyname : availableProperties.keySet()) {
	    result.put(eachPropertyname, 100.0);
	}

	return result;
    }

    @Override
    public void showOperationStatus(Status status, String description) {
	lastMessage = "[" + status + "]" + " " + description;
    }

    @Override
    public String getCustomProductName() {
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
    public List<String> getNewProductIngredients(List<String> availableIngredients) {
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

    @Override
    public void addCustomOrderListener(CustomOrderListener customOrderListener) {
	this.customOrderListener = customOrderListener;
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

    public void performActionOnCustomOrderListener() {
	customOrderListener.actionPerformed(new EventArguments(this));
    }
}
