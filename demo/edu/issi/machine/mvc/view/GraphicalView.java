package edu.issi.machine.mvc.view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import edu.issi.machine.mvc.controller.Controller.IngredientsListener;
import edu.issi.machine.mvc.controller.Controller.OrderListener;
import edu.issi.machine.mvc.controller.Controller.ProductsListener;
import edu.issi.machine.mvc.controller.Controller.PropertiesListener;
import edu.issi.machine.mvc.controller.EventArguments;
import edu.issi.machine.operation.Status;
import edu.issi.machine.product.ingredient.Unit;

/**
 * @author DawidSamolyk
 *
 */
public class GraphicalView implements View {
    private MenuPanel menu = new MenuPanel();
    private ErrorPanel error = new ErrorPanel();

    private ProductsListener productsListener;
    private PropertiesListener propertiesListener;
    private IngredientsListener ingredientsListener;
    private OrderListener orderListener;

    private JFrame frame;

    /**
     * Create the application.
     */
    public GraphicalView() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.setContentPane(menu);

	frame.setVisible(true);
    }

    @Override
    public void showError(String description) {
	frame.setContentPane(error);
	error.show(description);
    }

    @Override
    public void showProducts(Set<String> products) {
	// TODO 
    }

    @Override
    public void showProductIngredients(String productName, Set<String> ingredients) {
	showIngredients(ingredients);
    }

    @Override
    public void showIngredients(Set<String> ingredients) {

    }

    @Override
    public void showIngredientProperties(String ingredientName, Map<String, Unit> properties) {

    }

    @Override
    public String getSelectedForPreparationProductName() {
	return null;
    }

    @Override
    public Map<String, Float> getPropertiesForIngredient(String ingredientName, Map<String, Unit> availableProperties) {
	final JFrame propertiesFrame = new JFrame("Ustaw w≥aúciowoúci sk≥adnika " + ingredientName);
	propertiesFrame.setType(Type.UTILITY);
	propertiesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	propertiesFrame.setBounds(new Rectangle(300, 300));
	Container contentPane = propertiesFrame.getContentPane();
	int propertiesQuantity = availableProperties.size();
	contentPane.setLayout(new GridLayout(propertiesQuantity + 1, 2));

	final Map<String, JTextField> propertiesValuesFields = new HashMap<String, JTextField>(propertiesQuantity);

	for (String eachPropertyName : availableProperties.keySet()) {
	    Unit propertyUnit = availableProperties.get(eachPropertyName);
	    contentPane.add(new JLabel(eachPropertyName + " [" + propertyUnit + "]"));

	    JTextField valueField = new JTextField();
	    propertiesValuesFields.put(eachPropertyName, valueField);
	    contentPane.add(valueField);
	}

	JButton okButton = new JButton("Zatwierdü");
	okButton.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		if (areAllTextFieldsFilled(propertiesValuesFields)) {
		    propertiesFrame.dispose();
		}
	    }
	});
	contentPane.add(okButton);

	propertiesFrame.setVisible(true);

	// while(!areAllTextFieldsFilled(propertiesValuesFields)) {
	//
	// }

	return toValuesMap(propertiesValuesFields);
    }

    private Map<String, Float> toValuesMap(Map<String, JTextField> propertiesValuesFields) {
	Map<String, Float> result = new HashMap<String, Float>();

	for (String eachName : propertiesValuesFields.keySet()) {
	    JTextField textField = propertiesValuesFields.get(eachName);

	    result.put(eachName, Float.valueOf(textField.getText()));
	}

	return result;
    }

    private boolean areAllTextFieldsFilled(Map<String, JTextField> propertiesValuesFields) {
	for (String eachName : propertiesValuesFields.keySet()) {
	    JTextField textField = propertiesValuesFields.get(eachName);

	    if (textField.getText().isEmpty()) {
		return false;
	    }
	}
	return true;
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
    public void addProductsListener(ProductsListener productsListener) {
	this.productsListener = productsListener;
	this.productsListener.actionPerformed(new EventArguments(this));
    }

    @Override
    public void addIngredientsListener(IngredientsListener ingredientsListener) {
	this.ingredientsListener = ingredientsListener;
    }

    @Override
    public void addOrderListener(OrderListener orderListener) {
	this.orderListener = orderListener;
    }

    @Override
    public void addPropertiesListener(PropertiesListener propertiesListener) {
	this.propertiesListener = propertiesListener;
    }

    public class IngredientListener extends MouseAdapter {
	private JList<String> productsList;

	public IngredientListener(JList<String> productsList) {
	    this.productsList = productsList;
	}

	@Override
	public void mousePressed(MouseEvent e) {
	    EventArguments arguments = new EventArguments(GraphicalView.this, productsList.getSelectedValue());
	    ingredientsListener.actionPerformed(arguments);
	}
    }
}
