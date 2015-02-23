package edu.issi.machine.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import edu.issi.machine.Validator;
import edu.issi.machine.configuration.Order;
import edu.issi.machine.configuration.Order.Configurator;
import edu.issi.machine.mvc.model.Model;
import edu.issi.machine.mvc.view.View;
import edu.issi.machine.operation.OperationStatus;
import edu.issi.machine.product.Product;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.product.ingredient.Unit;
import edu.issi.machine.id.PropertyIdentity;

/**
 * @author DawidSamolyk
 *         Kontroler (MVC).
 */
public class Controller {
    private Model model;
    protected List<View> views = new ArrayList<View>();

    /**
     * Konstruktor. Model jest wymagany.
     * 
     * @param model
     *            Model.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li obiekt Model nie zosta� utworzony (referencja
     *             do null).
     */
    public Controller(Model model) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(model, "Nie podano modelu aplikacji!");
	this.model = model;
    }

    /**
     * Dodaje oraz inicjalizuje widok.
     * 
     * @param view
     *            Widok, kt�ry ma zosta� dodany.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li zajdzie pr�ba dodania pustego widoku.
     */
    public void addAndInitializeView(View view) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(view, "Nie mo�na doda� pustego widoku!");

	views.add(view);

	view.addProductsListener(new ProductsListener());
	view.addIngredientsListener(new IngredientsListener());
	view.addPropertiesListener(new PropertiesListener());
	view.addOrderListener(new OrderListener());
	view.addCustomOrderListener(new CustomOrderListener());
    }

    /**
     * Uruchamia maszyn�.
     */
    public void startMachine() {
	model.startMachine();
    }

    /**
     * Zatrzymuje maszyn�.
     */
    public void stopMachine() {
	model.stopMachine();
    }

    private void showErrorOnAllViews(String message) {
	for (View eachView : views) {
	    eachView.showError(message);
	}
    }

    private void showOnAllViews(OperationStatus operationStatus) {
	for (View eachView : views) {
	    eachView.showOperationStatus(operationStatus.getStatus(), operationStatus.getDescription());
	}
    }

    private View getCaller(EventArguments arguments) {
	View caller = null;

	for (View eachView : views) {
	    if (arguments.isCalledBy(eachView)) {
		caller = eachView;
	    }
	}
	return caller;
    }

    /**
     * @author DawidSamolyk
     *         Obiekt nas�uchuj�cy wydarzen zwi�zanych z produktami.
     */
    public class ProductsListener implements EventListener {
	private ProductsListener() {
	}

	@Override
	public void actionPerformed(EventArguments arguments) throws IllegalArgumentException {
	    Validator.throwExceptionWhenObjectIsNotCreated(arguments,
		    "Nie mo�na wykona� akcji wy�wietlenia produkt�w bez podanych argument�w!");

	    for (View eachView : views) {
		eachView.showProducts(model.getProductsNames());
	    }
	}
    }

    /**
     * @author DawidSamolyk
     *         Obiekt nas�uchuj�cy wydarzen zwi�zanych ze sk�adnikami.
     */
    public class IngredientsListener implements EventListener {
	private IngredientsListener() {
	}

	@Override
	public void actionPerformed(EventArguments arguments) throws IllegalArgumentException {
	    Validator.throwExceptionWhenObjectIsNotCreated(arguments,
		    "Nie mo�na wykona� akcji wy�wietlenia sk�adnik�w bez podanych argument�w!");

	    if (arguments.hasSelectedElementName()) {
		String selectedElementName = arguments.getSelectedElementName();

		for (View eachView : views) {
		    List<String> ingredients = model.getIngredientsNamesForProductNamed(selectedElementName);
		    eachView.showProductIngredients(selectedElementName, ingredients);
		}
	    }
	    else {
		for (View eachView : views) {
		    eachView.showIngredients(model.getAllIngredientsNames());
		}
	    }
	}
    }

    /**
     * @author DawidSamolyk
     *         Obiekt nas�uchuj�cy wydarzen zwi�zanych z w�a�ciwo�ciami
     *         sk�adnik�w.
     */
    public class PropertiesListener implements EventListener {
	private PropertiesListener() {
	}

	@Override
	public void actionPerformed(EventArguments arguments) throws IllegalArgumentException {
	    Validator.throwExceptionWhenObjectIsNotCreated(arguments, "Nie mo�na wykona� akcji bez podanych argument�w!");

	    if (arguments.hasSelectedElementName()) {
		String selectedIngredientName = arguments.getSelectedElementName();

		for (View eachView : views) {
		    Map<String, Unit> properties = model.getPropertiesForIngredientNamed(selectedIngredientName);
		    eachView.showIngredientProperties(selectedIngredientName, properties);
		}
	    }
	    else {
		showErrorOnAllViews("Nie wybrano produktu, wi�c nie mo�na wy�wietli� w�a�ciwo�ci sk�adnika.");
	    }
	}
    }

    /**
     * @author DawidSamolyk
     *         Obiekt nas�uchuj�cy wydarzen zwi�zanych ze z�o�eniem zam�wienia.
     */
    public class OrderListener implements EventListener {
	private OrderListener() {
	}

	@Override
	public void actionPerformed(EventArguments arguments) throws IllegalArgumentException {
	    Validator.throwExceptionWhenObjectIsNotCreated(arguments, "Nie mo�na wykona� akcji bez podanych argument�w!");

	    View caller = getCaller(arguments);

	    try {
		OperationStatus operationsStatus = makeOrderOn(caller);
		showOnAllViews(operationsStatus);
	    }
	    catch (IllegalArgumentException e) {
		showErrorOnAllViews(e.getMessage());
	    }
	    catch (NoSuchElementException e) {
		showErrorOnAllViews(e.getMessage());
	    }
	}

	protected OperationStatus makeOrderOn(View view) throws IllegalArgumentException {
	    String orderedProductName = view.getSelectedForPreparationProductName();
	    Product orderedProduct = model.getProductByName(orderedProductName);

	    return new Order(orderedProduct).execute();
	}
    }

    /**
     * @author Dawid
     *         Obiekt nas�uchuj�cy wydarzen zwi�zanych ze z�o�eniem zam�wienia
     *         produktu definiowanego przez u�ytkownika.
     */
    public class CustomOrderListener extends OrderListener {
	private CustomOrderListener() {
	}

	@Override
	protected OperationStatus makeOrderOn(View view) throws IllegalArgumentException {
	    String orderedProductName = view.getCustomProductName();

	    Order order = new Order(orderedProductName);
	    Configurator orderConfigurator = order.new Configurator();

	    configureIngredients(view, orderConfigurator);

	    return order.execute();
	}

	private void configureIngredients(View view, Configurator orderConfigurator) {
	    List<String> ingredients = view.getNewProductIngredients(model.getAllIngredientsNames());

	    for (int p = 0; p < ingredients.size(); p++) {
		String ingredientName = ingredients.get(p);
		Ingredient ingredient = model.getIngredientByName(ingredientName);

		Map<PropertyIdentity, Double> resultProperties = getIngredientProperties(view, ingredientName);
		ingredient.set(resultProperties);

		orderConfigurator.addAt(p, ingredient);
	    }
	}

	private Map<PropertyIdentity, Double> getIngredientProperties(View view, String ingredientName) {
	    Map<PropertyIdentity, Double> resultProperties = new HashMap<PropertyIdentity, Double>();

	    Map<String, Unit> availableIngredientProperties = model.getPropertiesForIngredientNamed(ingredientName);
	    Map<String, Double> ingredientProperties = view.getPropertiesForIngredient(ingredientName,
		    availableIngredientProperties);

	    for (String eachPropertyName : ingredientProperties.keySet()) {
		PropertyIdentity property = model.getPropertyByName(eachPropertyName);
		Double value = ingredientProperties.get(eachPropertyName);

		resultProperties.put(property, value);
	    }

	    return resultProperties;
	}
    }
}