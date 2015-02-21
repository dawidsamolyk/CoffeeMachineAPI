package edu.issi.machine.mvc.view;

import java.awt.Container;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.issi.machine.mvc.controller.Controller.IngredientsListener;
import edu.issi.machine.mvc.controller.Controller.OrderListener;
import edu.issi.machine.mvc.controller.Controller.ProductsListener;
import edu.issi.machine.mvc.controller.Controller.PropertiesListener;
import edu.issi.machine.mvc.controller.EventArguments;
import edu.issi.machine.operation.Status;
import edu.issi.machine.product.ingredient.Unit;

@SuppressWarnings({ "javadoc", "serial" })
public class GraphicalView extends JFrame implements View {
    private Container contentPane;
    private MenuPanel menuPanel = new MenuPanel();
    private OrderPanel orderPanel = new OrderPanel();

    public GraphicalView() {
	contentPane = getContentPane();
	initialize();
    }

    private void initialize() {
	setBounds(100, 100, 450, 300);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
    }

    private void switchTo(JPanel panel) {
	contentPane.removeAll();
	contentPane.add(panel);
    }

    @Override
    public void showError(String description) {

    }

    @Override
    public void showProducts(Set<String> products) {

    }

    @Override
    public void showProductIngredients(String productName, Set<String> ingredients) {

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
	return null;
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
	switchTo(menuPanel);
	productsListener.actionPerformed(new EventArguments(this));
    }

    @Override
    public void addIngredientsListener(IngredientsListener ingredientsListener) {

    }

    @Override
    public void addOrderListener(OrderListener orderListener) {

    }

    @Override
    public void addPropertiesListener(PropertiesListener propertiesListener) {

    }

}
