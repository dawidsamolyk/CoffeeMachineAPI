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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

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
    private ProductsListener productsListener;
    private PropertiesListener propertiesListener;
    private IngredientsListener ingredientsListener;
    private OrderListener orderListener;
    private JFrame frame;
    private JLabel statusLabel;
    private DefaultListModel<String> productsListModel = new DefaultListModel<String>();
    private JList<String> productsList;

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
	Container contentPane = frame.getContentPane();
	contentPane.setLayout(new GridLayout(2, 2));

	productsList = new JList<String>();
	productsList.setModel(productsListModel);
	productsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	productsList.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		EventArguments arguments = new EventArguments(GraphicalView.this, productsList.getSelectedValue());
		ingredientsListener.actionPerformed(arguments);
	    }
	});
	contentPane.add(productsList);

	JButton makeOrderButton = new JButton("Zamów!");
	makeOrderButton.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		String selectedProduct = productsList.getSelectedValue();

		if (selectedProduct == null) {
		    showError("Nie wybrano produktu!");
		}
		else {
		    EventArguments arguments = new EventArguments(GraphicalView.this, selectedProduct);
		    orderListener.actionPerformed(arguments);
		}
	    }
	});
	contentPane.add(makeOrderButton);

	statusLabel = new JLabel("Status...");
	contentPane.add(statusLabel);

	JButton customProductButton = new JButton("W\u0142asny produkt");
	makeOrderButton.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		// TODO implementacja w³asnego produktu
	    }
	});
	contentPane.add(customProductButton);

	frame.setVisible(true);
    }

    @Override
    public void showError(String description) {
	JOptionPane.showMessageDialog(frame, description);
    }

    private void refresh(DefaultListModel<String> listModel) {
	listModel.clear();
    }

    private void showOn(Set<String> content, DefaultListModel<String> listModel) {
	for (String each : content) {
	    listModel.addElement(each);
	}
    }

    @Override
    public void showProducts(Set<String> products) {
	refresh(productsListModel);
	showOn(products, productsListModel);
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
	return productsList.getSelectedValue();
    }

    @Override
    public Map<String, Float> getPropertiesForIngredient(String ingredientName, Map<String, Unit> availableProperties) {
	final JFrame propertiesFrame = new JFrame("Ustaw w³aœciowoœci sk³adnika " + ingredientName);
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

	JButton okButton = new JButton("ZatwierdŸ");
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
	statusLabel.setText("[" + status.name() + "] " + description);
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

}
