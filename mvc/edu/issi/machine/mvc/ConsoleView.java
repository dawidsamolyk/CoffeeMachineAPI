package edu.issi.machine.mvc;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import edu.issi.machine.mvc.Controller.ProductsListener;
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

    private void show(Throwable throwable) {
	System.err.println(throwable);
    }

    @Override
    public void showProducts(Map<Integer, String> products) {
	for (Integer eachProductId : products.keySet()) {
	    show("PRODUKT [" + eachProductId + "] " + products.get(eachProductId));
	}
    }

    @Override
    public void showProductIngredients(int productID, String productName, Map<Integer, String> ingredients) {
	show("PRODUKT [" + productID + "] " + productName);

	showIngredients(ingredients);
    }

    @Override
    public void showIngredients(Map<Integer, String> ingredients) {
	for (Integer eachIngredientId : ingredients.keySet()) {
	    show("SK£ADNIK [" + eachIngredientId + "] " + ingredients.get(eachIngredientId));
	}
    }

    @Override
    public void showIngredientProperties(int ingredientIdNumber, String ingredientName, Map<String, Unit> properties) {
	show("SK£ADNIK [" + ingredientIdNumber + "] " + ingredientName);

	for (String eachPropertyName : properties.keySet()) {
	    show("W£AŒCIWOŒÆ: " + eachPropertyName + " [" + properties.get(eachPropertyName) + "]");
	}
    }

    @Override
    public int getSelectedForPreparationProductIdNumber() {
	try {
	    return scanner.nextInt();
	}
	catch (InputMismatchException e) {
	    show(e);
	}

	return View.INVALID_ID;
    }

    @Override
    // TODO zmieñ nazwê funkcji na krótsz¹
    public Map<String, Float> getSelectedPropertiesForIngredientFromChoseProduct(int ingredientIdNumber,
	    String ingredientName) {

	Map<String, Float> result = new HashMap<String, Float>();

	// TODO Lista w³aœciwoœci powinna byæ parametrem wejœciowym fukcji
	// TODO Na wyjœciu powinna byæ stworzona mapa zgodna z map¹ wejœciow¹ -
	// nie powinny byæ dodane ¿adne dodatkowe w³aœciwoœci

	show("Podaj w³aœciwoœci dla SK£ADNIK [" + ingredientIdNumber + "] " + ingredientName);
	show("Komenda END zakoñczy dodawanie w³aœciwoœci.");

	String readLine = "";

	while (!readLine.equals("END")) {

	    readLine = scanner.next();

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
    public Map<Integer, String> getNewProductIngredients() {
	// TODO Na wejœciu powinny byæ podane dostêpne sk³adniki, które mo¿na
	// wybraæ
	return null;
    }

    @Override
    public Map<String, Float> getPropertiesForNewProductIngredient(int ingredientIdNumber, String ingredientName) {
	// TODO Na wejœciu powinny byæ podane dostêpne w³aœciwoœci dla danego
	// sk³adnika
	return null;
    }

    @Override
    public void addProductsListListener(ProductsListener productsListListener) {
	// TODO Ustaw ten listener dla klasy wewnêtrznej, która bêdzie
	// obs³ugiwa³a ca³e GUI @console
    }

}
