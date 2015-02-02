package edu.issi.machine.mvc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
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
    private JFrame frame;
    private JLabel statusLabel;
    private DefaultListModel<String> productsListModel = new DefaultListModel<String>();
    private DefaultListModel<String> ingredientsListModel = new DefaultListModel<String>();
    private DefaultListModel<String> propertiesListModel = new DefaultListModel<String>();

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
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[] { 10, 10, 10, 5 };
	gridBagLayout.rowHeights = new int[] { 5, 20, 5 };
	gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 0.0 };
	gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 0.0 };
	frame.getContentPane().setLayout(gridBagLayout);

	JLabel lblProdukty = new JLabel("Produkty");
	GridBagConstraints gbc_lblProdukty = new GridBagConstraints();
	gbc_lblProdukty.insets = new Insets(0, 0, 5, 5);
	gbc_lblProdukty.gridx = 0;
	gbc_lblProdukty.gridy = 0;
	frame.getContentPane().add(lblProdukty, gbc_lblProdukty);

	JLabel lblSkadniki = new JLabel("Sk\u0142adniki");
	GridBagConstraints gbc_lblSkadniki = new GridBagConstraints();
	gbc_lblSkadniki.insets = new Insets(0, 0, 5, 5);
	gbc_lblSkadniki.gridx = 1;
	gbc_lblSkadniki.gridy = 0;
	frame.getContentPane().add(lblSkadniki, gbc_lblSkadniki);

	JLabel lblWaciwoci = new JLabel("W\u0142a\u015Bciwo\u015Bci");
	GridBagConstraints gbc_lblWaciwoci = new GridBagConstraints();
	gbc_lblWaciwoci.insets = new Insets(0, 0, 5, 5);
	gbc_lblWaciwoci.gridx = 2;
	gbc_lblWaciwoci.gridy = 0;
	frame.getContentPane().add(lblWaciwoci, gbc_lblWaciwoci);

	final JList<String> productsList = new JList<String>();
	productsList.setModel(productsListModel);
	productsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	GridBagConstraints gbc_list = new GridBagConstraints();
	gbc_list.insets = new Insets(0, 0, 5, 5);
	gbc_list.fill = GridBagConstraints.BOTH;
	gbc_list.gridx = 0;
	gbc_list.gridy = 1;
	productsList.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		EventArguments arguments = new EventArguments(GraphicalView.this, productsList.getSelectedValue());
		ingredientsListener.actionPerformed(arguments);
	    }
	});
	frame.getContentPane().add(productsList, gbc_list);

	final JList<String> ingredientsList = new JList<String>();
	ingredientsList.setModel(ingredientsListModel);
	GridBagConstraints gbc_list_1 = new GridBagConstraints();
	gbc_list_1.insets = new Insets(0, 0, 5, 5);
	gbc_list_1.fill = GridBagConstraints.BOTH;
	gbc_list_1.gridx = 1;
	gbc_list_1.gridy = 1;
	ingredientsList.addMouseListener(new MouseAdapter() {

	    @Override
	    public void mousePressed(MouseEvent e) {
		EventArguments arguments = new EventArguments(GraphicalView.this, ingredientsList.getSelectedValue());
		propertiesListener.actionPerformed(arguments);
	    }
	});
	frame.getContentPane().add(ingredientsList, gbc_list_1);

	final JList<String> propertiesList = new JList<String>();
	propertiesList.setModel(propertiesListModel);
	GridBagConstraints gbc_list_2 = new GridBagConstraints();
	gbc_list_2.insets = new Insets(0, 0, 5, 5);
	gbc_list_2.fill = GridBagConstraints.BOTH;
	gbc_list_2.gridx = 2;
	gbc_list_2.gridy = 1;
	frame.getContentPane().add(propertiesList, gbc_list_2);

	JButton makeOrderButton = new JButton("Zamów!");
	GridBagConstraints gbc_makeOrderButton = new GridBagConstraints();
	gbc_makeOrderButton.insets = new Insets(0, 0, 5, 0);
	gbc_makeOrderButton.gridx = 3;
	gbc_makeOrderButton.gridy = 1;
	frame.getContentPane().add(makeOrderButton, gbc_makeOrderButton);

	statusLabel = new JLabel("Status...");
	GridBagConstraints gbc_status = new GridBagConstraints();
	gbc_status.insets = new Insets(0, 0, 5, 5);
	gbc_status.gridx = 0;
	gbc_status.gridy = 2;
	frame.getContentPane().add(statusLabel, gbc_status);

    }

    @Override
    public void start() {
	frame.setVisible(true);
    }

    @Override
    public void showProducts(Set<String> products) {
	productsListModel.clear();

	for (String each : products) {
	    productsListModel.addElement(each);
	}
    }

    @Override
    public void showProductIngredients(String productName, Set<String> ingredients) {
	showIngredients(ingredients);
    }

    @Override
    public void showIngredients(Set<String> ingredients) {
	ingredientsListModel.clear();
	propertiesListModel.clear();

	for (String each : ingredients) {
	    ingredientsListModel.addElement(each);
	}
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
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Map<String, Float> getPropertiesForIngredient(String ingredientName, Map<String, Unit> availableProperties) {
	// TODO Auto-generated method stub
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
	// TODO Auto-generated method stub

    }

    @Override
    public void addPropertiesListener(PropertiesListener propertiesListener) {
	this.propertiesListener = propertiesListener;
    }

}
