package edu.issi.machine.mvc.controller.fakes;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import edu.issi.machine.mvc.controller.Controller;
import edu.issi.machine.mvc.controller.Controller.IngredientsListener;
import edu.issi.machine.mvc.controller.Controller.OrderListener;
import edu.issi.machine.mvc.controller.Controller.ProductsListener;
import edu.issi.machine.mvc.controller.Controller.PropertiesListener;
import edu.issi.machine.mvc.view.View;
import edu.issi.machine.operation.Status;
import edu.issi.machine.product.ingredient.Unit;

@SuppressWarnings("javadoc")
public class FakeView implements View {
    public static final String NEW_TEST_PRODUCT_NAME = "New test product name";
    public static final String ORDERED_PRODUCT_NAME = "Test";

    protected ProductsListener productsListListener;
    protected PropertiesListener propertiesListener;
    protected IngredientsListener ingredientsListener;
    protected OrderListener orderListener;

    protected String lastMessage;

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
	return ORDERED_PRODUCT_NAME;
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
	return NEW_TEST_PRODUCT_NAME;
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

    @Override
    public void showError(String description) {
	lastMessage = description;
    }

}
