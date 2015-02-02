package edu.issi.machine.mvc.view;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import edu.issi.machine.mvc.controller.Controller.IngredientsListener;
import edu.issi.machine.mvc.controller.Controller.ProductsListener;
import edu.issi.machine.operation.Status;
import edu.issi.machine.product.ingredient.Unit;

/**
 * @author DawidSamolyk
 *
 */
public class ConsoleView implements View {
    private Scanner scanner = new Scanner(System.in);

    private void show(String text) {
	System.out.println(text);
    }

    @Override
    public void showProducts(Set<String> products) {
	for (String eachProductName : products) {
	    show("PRODUKT [" + eachProductName + "] ");
	}
    }

    @Override
    public void showProductIngredients(String productName, Set<String> ingredients) {
	show("PRODUKT [" + productName + "] ");

	showIngredients(ingredients);
    }

    @Override
    public void showIngredients(Set<String> ingredients) {
	for (String eachIngredientName : ingredients) {
	    show("SK£ADNIK [" + eachIngredientName + "] ");
	}
    }

    @Override
    public void showIngredientProperties(String ingredientName, Map<String, Unit> properties) {
	show("SK£ADNIK [" + ingredientName + "] ");

	for (String eachPropertyName : properties.keySet()) {
	    show("W£AŒCIWOŒÆ: " + eachPropertyName + " [" + properties.get(eachPropertyName) + "]");
	}
    }

    @Override
    public String getSelectedForPreparationProductName() {
	return scanner.next();
    }

    @Override
    public Map<String, Float> getPropertiesForIngredient(String ingredientName, Map<String, Unit> availableProperties) {
	Map<String, Float> result = new HashMap<String, Float>();

	show("Podaj w³aœciwoœci dla SK£ADNIK [" + ingredientName + "]");

	for (String propertyName : availableProperties.keySet()) {
	    Unit propertyUnit = availableProperties.get(propertyName);
	    show("W£AŒCIWOŒÆ [" + propertyName + "] , JEDNOSTKA [" + propertyUnit.name() + "]");
	    show("Podaj wartoœæ: ");

	    Float value = scanner.nextFloat();

	    result.put(propertyName, value);
	}

	return result;
    }

    @Override
    public void showOperationStatus(Status status, String description) {
	show("STATUS [" + status.name() + "] " + description);
    }

    @Override
    public String getNewProductName() {
	return scanner.next();
    }

    @Override
    public Set<String> getNewProductIngredients(Set<String> availableIngredients) {
	Set<String> result = new HashSet<String>();

	show("Wybierz sk³adniki dla przygotowywanego napoju");

	for (String eachIngredient : availableIngredients) {
	    show("SK£ADNIK [" + eachIngredient + "]");
	    show("Wpisz T i potwierdŸ (Enter), jeœli ten sk³adnik ma zostaæ dodany do przygotowywanego napoju");

	    String userAnswer = scanner.next();
	    if (userAnswer.equals("T")) {
		result.add(eachIngredient);
	    }
	}

	return result;
    }

    @Override
    public void addProductsListener(ProductsListener productsListListener) {
	// TODO zaimplementuj
    }

    @Override
    public void addIngredientsListener(IngredientsListener ingredientsListener) {
	// TODO zaimplementuj
    }

}
