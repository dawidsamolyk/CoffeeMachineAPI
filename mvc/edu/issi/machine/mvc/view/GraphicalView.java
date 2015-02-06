package edu.issi.machine.mvc.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Window.Type;
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
    private PropertiesListener propertiesListener;
    private IngredientsListener ingredientsListener;
    private OrderListener orderListener;
    private JFrame frame;
    private JLabel statusLabel;
    private DefaultListModel<String> productsListModel = new DefaultListModel<String>();
    private DefaultListModel<String> ingredientsListModel = new DefaultListModel<String>();
    private DefaultListModel<String> propertiesListModel = new DefaultListModel<String>();
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
	GridBagLayout frameGridBagLayout = new GridBagLayout();
	frameGridBagLayout.columnWidths = new int[] { 10, 10, 10, 5 };
	frameGridBagLayout.rowHeights = new int[] { 5, 20, 5 };
	frameGridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 0.0 };
	frameGridBagLayout.rowWeights = new double[] { 1.0, 1.0, 0.0 };
	frame.getContentPane().setLayout(frameGridBagLayout);

	JLabel productsLabel = new JLabel("Produkty");
	GridBagConstraints produktyLabelConstraints = new GridBagConstraints();
	produktyLabelConstraints.insets = new Insets(0, 0, 5, 5);
	produktyLabelConstraints.gridx = 0;
	produktyLabelConstraints.gridy = 0;
	frame.getContentPane().add(productsLabel, produktyLabelConstraints);

	JLabel ingredientsLabel = new JLabel("Sk\u0142adniki");
	GridBagConstraints ingredientsLabelConstraints = new GridBagConstraints();
	ingredientsLabelConstraints.insets = new Insets(0, 0, 5, 5);
	ingredientsLabelConstraints.gridx = 1;
	ingredientsLabelConstraints.gridy = 0;
	frame.getContentPane().add(ingredientsLabel, ingredientsLabelConstraints);

	JLabel propertiesLabel = new JLabel("W\u0142a\u015Bciwo\u015Bci");
	GridBagConstraints propertiesLabelConstraints = new GridBagConstraints();
	propertiesLabelConstraints.insets = new Insets(0, 0, 5, 5);
	propertiesLabelConstraints.gridx = 2;
	propertiesLabelConstraints.gridy = 0;
	frame.getContentPane().add(propertiesLabel, propertiesLabelConstraints);

	productsList = new JList<String>();
	productsList.setModel(productsListModel);
	productsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	GridBagConstraints productsListContraints = new GridBagConstraints();
	productsListContraints.insets = new Insets(0, 0, 5, 5);
	productsListContraints.fill = GridBagConstraints.BOTH;
	productsListContraints.gridx = 0;
	productsListContraints.gridy = 1;
	productsList.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		EventArguments arguments = new EventArguments(GraphicalView.this, productsList.getSelectedValue());
		ingredientsListener.actionPerformed(arguments);
	    }
	});
	frame.getContentPane().add(productsList, productsListContraints);

	final JList<String> ingredientsList = new JList<String>();
	ingredientsList.setModel(ingredientsListModel);
	ingredientsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	GridBagConstraints ingredientsListConstraints = new GridBagConstraints();
	ingredientsListConstraints.insets = new Insets(0, 0, 5, 5);
	ingredientsListConstraints.fill = GridBagConstraints.BOTH;
	ingredientsListConstraints.gridx = 1;
	ingredientsListConstraints.gridy = 1;
	ingredientsList.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		EventArguments arguments = new EventArguments(GraphicalView.this, ingredientsList.getSelectedValue());
		propertiesListener.actionPerformed(arguments);
	    }
	});
	frame.getContentPane().add(ingredientsList, ingredientsListConstraints);

	final JList<String> propertiesList = new JList<String>();
	propertiesList.setModel(propertiesListModel);
	propertiesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	GridBagConstraints propertiesListConstraints = new GridBagConstraints();
	propertiesListConstraints.insets = new Insets(0, 0, 5, 5);
	propertiesListConstraints.fill = GridBagConstraints.BOTH;
	propertiesListConstraints.gridx = 2;
	propertiesListConstraints.gridy = 1;
	frame.getContentPane().add(propertiesList, propertiesListConstraints);

	JButton makeOrderButton = new JButton("Zam�w!");
	GridBagConstraints makeOrderButtonConstraints = new GridBagConstraints();
	makeOrderButtonConstraints.insets = new Insets(0, 0, 5, 0);
	makeOrderButtonConstraints.gridx = 3;
	makeOrderButtonConstraints.gridy = 1;
	makeOrderButton.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		EventArguments arguments = new EventArguments(GraphicalView.this, productsList.getSelectedValue());
		orderListener.actionPerformed(arguments);
	    }
	});
	frame.getContentPane().add(makeOrderButton, makeOrderButtonConstraints);

	statusLabel = new JLabel("Status...");
	GridBagConstraints statusLabelConstraints = new GridBagConstraints();
	statusLabelConstraints.insets = new Insets(0, 0, 0, 5);
	statusLabelConstraints.gridx = 0;
	statusLabelConstraints.gridy = 2;
	frame.getContentPane().add(statusLabel, statusLabelConstraints);

	JButton customProductButton = new JButton("W\u0142asny produkt");
	GridBagConstraints customProductButtonConstraints = new GridBagConstraints();
	customProductButtonConstraints.insets = new Insets(0, 0, 0, 5);
	customProductButtonConstraints.gridx = 1;
	customProductButtonConstraints.gridy = 2;
	frame.getContentPane().add(customProductButton, customProductButtonConstraints);

	JButton endButton = new JButton("Zako\u0144cz");
	GridBagConstraints endButtonConstraints = new GridBagConstraints();
	endButtonConstraints.gridx = 3;
	endButtonConstraints.gridy = 2;
	endButton.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		frame.dispose();
	    }
	});
	frame.getContentPane().add(endButton, endButtonConstraints);

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
	refresh(ingredientsListModel);
	refresh(propertiesListModel);
	showOn(ingredients, ingredientsListModel);
    }

    @Override
    public void showIngredientProperties(String ingredientName, Map<String, Unit> properties) {
	propertiesListModel.clear();

	for (String each : properties.keySet()) {
	    Unit unit = properties.get(each);
	    propertiesListModel.addElement(each + " [" + unit.name() + "]");
	}
    }

    @Override
    public String getSelectedForPreparationProductName() {
	return productsList.getSelectedValue();
    }

    @Override
    public Map<String, Float> getPropertiesForIngredient(String ingredientName, Map<String, Unit> availableProperties) {
	JFrame frame = new JFrame("Ustaw w�a�ciowo�ci sk�adnika " + ingredientName);
	frame.setType(Type.UTILITY);
	frame.setBounds(new Rectangle(300, 300));
	Container contentPane = frame.getContentPane();
	contentPane.setLayout(new FlowLayout());

	Map<String, JTextField> propertiesValuesFields = new HashMap<String, JTextField>(availableProperties.size());

	for (String eachPropertyName : availableProperties.keySet()) {
	    Unit propertyUnit = availableProperties.get(eachPropertyName);
	    contentPane.add(new JLabel(eachPropertyName + " [" + propertyUnit + "]"));
	    
	    JTextField valueField = new JTextField();
	    propertiesValuesFields.put(eachPropertyName, valueField);
	}
	
	frame.setVisible(true);
	
	

	return null;
    }

    @Override
    public void showOperationStatus(Status status, String description) {
	statusLabel.setText("[" + status.name() + "] " + description);
    }

    @Override
    public String getNewProductName() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Set<String> getNewProductIngredients(Set<String> availableIngredients) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void addProductsListener(ProductsListener productsListener) {
	productsListener.actionPerformed(new EventArguments(this));
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
