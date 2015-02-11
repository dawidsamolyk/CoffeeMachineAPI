package edu.issi.machine.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.issi.machine.Validator;
import edu.issi.machine.mvc.model.Model;
import edu.issi.machine.mvc.view.View;
import edu.issi.machine.operation.OperationStatus;
import edu.issi.machine.product.ingredient.Unit;

/**
 * @author DawidSamolyk
 *
 */
public class Controller {
    private Model model;
    protected List<View> views = new ArrayList<View>();

    /**
     * @param model
     *            Model.
     */
    public Controller(Model model) {
	Validator.throwExceptionWhenObjectIsNotCreated(model, "Nie podano modelu aplikacji!");
	this.model = model;
    }

    /**
     * 
     */
    public void startMachine() {
	model.startMachine();
    }

    /**
     * 
     */
    public void stopMachine() {
	model.stopMachine();
    }

    /**
     * @param view
     *            Widok, który ma zostaæ dodany.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli zajdzie próba dodania pustego widoku.
     */
    public void addAndInitializeView(View view) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(view, "Nie mo¿na dodaæ pustego widoku!");

	views.add(view);

	view.addProductsListener(new ProductsListener());
	view.addIngredientsListener(new IngredientsListener());
	view.addPropertiesListener(new PropertiesListener());
	view.addOrderListener(new OrderListener());
    }

    /**
     * @author DawidSamolyk
     *
     */
    public class ProductsListener implements EventListener {
	private ProductsListener() {
	}

	@Override
	public void actionPerformed(EventArguments arguments) throws IllegalArgumentException {
	    Validator.throwExceptionWhenObjectIsNotCreated(arguments, "Nie mo¿na wykonaæ akcji bez podanych argumentów!");

	    for (View eachView : views) {
		eachView.showProducts(model.getProductsNames());
	    }
	}
    }

    /**
     * @author DawidSamolyk
     *
     */
    public class IngredientsListener implements EventListener {
	private IngredientsListener() {
	}

	@Override
	public void actionPerformed(EventArguments arguments) throws IllegalArgumentException {
	    Validator.throwExceptionWhenObjectIsNotCreated(arguments, "Nie mo¿na wykonaæ akcji bez podanych argumentów!");
	    
	    if (arguments.hasSelectedElementName()) {
		String selectedElementName = arguments.getSelectedElementName();

		for (View eachView : views) {
		    Set<String> ingredients = model.getIngredientsNamesForProductNamed(selectedElementName);
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
     *
     */
    public class PropertiesListener implements EventListener {
	private PropertiesListener() {
	}

	@Override
	public void actionPerformed(EventArguments arguments) throws IllegalArgumentException {
	    Validator.throwExceptionWhenObjectIsNotCreated(arguments, "Nie mo¿na wykonaæ akcji bez podanych argumentów!");
	    
	    // TODO strategia
	    if (arguments.hasSelectedElementName()) {
		String selectedIngredientName = arguments.getSelectedElementName();

		for (View eachView : views) {
		    Map<String, Unit> properties = model.getPropertiesForIngredientNamed(selectedIngredientName);
		    eachView.showIngredientProperties(selectedIngredientName, properties);
		}
	    }
	    else {
		for (View eachView : views) {
		    eachView.showError("Nie wybrano elementu, wiêc nie mo¿na wyœwietliæ w³aœciwoœci sk³adnika.");
		}
	    }
	}
    }

    /**
     * @author DawidSamolyk
     *
     */
    public class OrderListener implements EventListener {
	private OrderListener() {
	}

	@Override
	public void actionPerformed(EventArguments arguments) throws IllegalArgumentException {
	    Validator.throwExceptionWhenObjectIsNotCreated(arguments, "Nie mo¿na wykonaæ akcji bez podanych argumentów!");
	    
	    // TODO refaktoryzuj
	    View activeView = null;

	    for (View eachView : views) {
		if (arguments.isCalledBy(eachView)) {
		    activeView = eachView;
		    break;
		}
	    }

	    if (activeView != null) {
		List<OperationStatus> operationsStatuses = null;

		try {
		    operationsStatuses = makeOrderOn(activeView);
		}
		catch (IllegalArgumentException e) {
		    for (View eachView : views) {
			eachView.showError(e.getMessage());
		    }
		}

		if (operationsStatuses != null) {
		    OperationStatus operationsStatus = OperationStatus.Factory.getFrom(operationsStatuses);

		    for (View eachView : views) {
			eachView.showOperationStatus(operationsStatus.getStatus(), operationsStatus.getDescription());
		    }
		}
	    }
	}

	private List<OperationStatus> makeOrderOn(View view) throws IllegalArgumentException {
	    String orderedProductName = view.getSelectedForPreparationProductName();

	    // TODO pobierz w³aœciwoœci sk³adników przed realizacj¹ zamówienia
	    // Set<String> ingredients =
	    // model.getIngredientsNamesForProductNamed(orderedProductName);
	    //
	    // for (String eachIngredient : ingredients) {
	    // Map<String, Unit> properties =
	    // model.getPropertiesForIngredientNamed(eachIngredient);
	    // Map<String, Float> userProperties =
	    // view.getPropertiesForIngredient(eachIngredient, properties);
	    // }

	    return model.makeOrder(orderedProductName);
	}
    }
}