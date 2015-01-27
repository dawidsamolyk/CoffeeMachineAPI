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
	    show("SK�ADNIK [" + eachIngredientId + "] " + ingredients.get(eachIngredientId));
	}
    }

    @Override
    public void showIngredientProperties(int ingredientIdNumber, String ingredientName, Map<String, Unit> properties) {
	show("SK�ADNIK [" + ingredientIdNumber + "] " + ingredientName);

	for (String eachPropertyName : properties.keySet()) {
	    show("W�A�CIWO��: " + eachPropertyName + " [" + properties.get(eachPropertyName) + "]");
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
    // TODO zmie� nazw� funkcji na kr�tsz�
    public Map<String, Float> getSelectedPropertiesForIngredientFromChoseProduct(int ingredientIdNumber,
	    String ingredientName) {

	Map<String, Float> result = new HashMap<String, Float>();

	// TODO Lista w�a�ciwo�ci powinna by� parametrem wej�ciowym fukcji
	// TODO Na wyj�ciu powinna by� stworzona mapa zgodna z map� wej�ciow� -
	// nie powinny by� dodane �adne dodatkowe w�a�ciwo�ci

	show("Podaj w�a�ciwo�ci dla SK�ADNIK [" + ingredientIdNumber + "] " + ingredientName);
	show("Komenda END zako�czy dodawanie w�a�ciwo�ci.");

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
	// TODO Na wej�ciu powinny by� podane dost�pne sk�adniki, kt�re mo�na
	// wybra�
	return null;
    }

    @Override
    public Map<String, Float> getPropertiesForNewProductIngredient(int ingredientIdNumber, String ingredientName) {
	// TODO Na wej�ciu powinny by� podane dost�pne w�a�ciwo�ci dla danego
	// sk�adnika
	return null;
    }

    @Override
    public void addProductsListListener(ProductsListener productsListListener) {
	// TODO Ustaw ten listener dla klasy wewn�trznej, kt�ra b�dzie
	// obs�ugiwa�a ca�e GUI @console
    }

}
