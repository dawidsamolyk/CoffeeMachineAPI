package edu.issi.machine.mvc;

import java.util.ArrayList;
import java.util.List;

import edu.issi.machine.Validator;

/**
 * @author DawidSamolyk
 *
 */
public class Controller {
    private Model model;
    private List<View> views = new ArrayList<View>();

    Controller(Model model) {
	this.model = model;
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
	
	view.addProductsListListener(new ProductsListener());
    }
    
    /**
     * @author DawidSamolyk
     *
     */
    public class ProductsListener implements EventListener {
	@Override
	public void actionPerformed() {
	    for(View eachView : views) {
		eachView.showProducts(model.getProducts());
	    }
	}
    }
    
    /**
     * @author DawidSamolyk
     *
     */
    public class ProductsIngredientsListener implements EventListener {
	@Override
	public void actionPerformed() {
	    for(View eachView : views) {
		eachView.showProducts(model.getProducts());
	    }
	}
    }
    
    
}