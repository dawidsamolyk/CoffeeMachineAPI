package edu.issi.machine.mvc.view;

import java.util.Map;
import java.util.Set;

import edu.issi.machine.mvc.controller.Controller.IngredientsListener;
import edu.issi.machine.mvc.controller.Controller.OrderListener;
import edu.issi.machine.mvc.controller.Controller.ProductsListener;
import edu.issi.machine.mvc.controller.Controller.PropertiesListener;
import edu.issi.machine.operation.Status;
import edu.issi.machine.product.ingredient.Unit;

/**
 * @author Dawid
 *
 */
public class EmptyView implements View {

    @Override
    public void showProducts(Set<String> products) {

    }

    @Override
    public String getSelectedForPreparationProductName() {
	return null;
    }

    @Override
    public void showProductIngredients(String productName, Set<String> ingredients) {

    }

    @Override
    public void showIngredients(Set<String> ingredients) {

    }

    @Override
    public void showIngredientProperties(String ingredientName, Map<String, Unit> properties) {

    }

    @Override
    public Map<String, Float> getPropertiesForIngredient(String ingredientName, Map<String, Unit> availableProperties) {
	return null;
    }

    @Override
    public void showOperationStatus(Status status, String description) {

    }

    @Override
    public String getNewProductName() {
	return null;
    }

    @Override
    public Set<String> getNewProductIngredients(Set<String> availableIngredients) {
	return null;
    }

    @Override
    public void addProductsListener(ProductsListener productsListListener) {

    }

    @Override
    public void addIngredientsListener(IngredientsListener ingredientsListener) {

    }

    @Override
    public void addPropertiesListener(PropertiesListener propertiesListener) {

    }

    @Override
    public void addOrderListener(OrderListener orderListener) {

    }

    @Override
    public void showError(String description) {

    }

}
