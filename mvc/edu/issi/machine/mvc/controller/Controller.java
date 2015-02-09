package edu.issi.machine.mvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
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
	@Override
	public void actionPerformed(EventArguments arguments) {
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
	@Override
	public void actionPerformed(EventArguments arguments) {
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
	@Override
	public void actionPerformed(EventArguments arguments) {
	    if (arguments.hasSelectedElementName()) {
		String selectedIngredientName = arguments.getSelectedElementName();

		for (View eachView : views) {
		    Map<String, Unit> properties = model.getPropertiesForIngredientNamed(selectedIngredientName);
		    eachView.showIngredientProperties(selectedIngredientName, properties);
		}
	    }
	}
    }

    /**
     * @author DawidSamolyk
     *
     */
    public class OrderListener implements EventListener {
	@Override
	public void actionPerformed(EventArguments arguments) {
	    for (View eachView : views) {
		if (arguments.isCalledBy(eachView)) {
		    List<OperationStatus> operationsStatuses = makeOrderOn(eachView);

		    if (operationsStatuses != null) {
			OperationStatus operationsStatus = OperationStatus.Factory.getFrom(operationsStatuses);
			eachView.showOperationStatus(operationsStatus.getStatus(), operationsStatus.getDescription());
		    }
		}
	    }
	}

	private List<OperationStatus> makeOrderOn(View view) {
	    String orderedProductName = view.getSelectedForPreparationProductName();

	    try {
		Set<String> ingredients = model.getIngredientsNamesForProductNamed(orderedProductName);

		for (String eachIngredient : ingredients) {
		    Map<String, Unit> properties = model.getPropertiesForIngredientNamed(eachIngredient);
		    Map<String, Float> userProperties = view.getPropertiesForIngredient(eachIngredient, properties);
		}

		return model.makeOrder(orderedProductName);
	    }
	    catch (IllegalArgumentException e) {
		OperationStatus error = OperationStatus.Factory.createError(e.getMessage());
		return Arrays.asList(error);
	    }
	}
    }
}