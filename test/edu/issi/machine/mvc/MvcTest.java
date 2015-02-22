package edu.issi.machine.mvc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;

import edu.issi.machine.configuration.MachineConfiguration;
import edu.issi.machine.configuration.MachineConfigurationTest;
import edu.issi.machine.mvc.controller.Controller;
import edu.issi.machine.mvc.controller.fakes.FakeView;
import edu.issi.machine.mvc.model.Model;

@SuppressWarnings("javadoc")
public class MvcTest {

    @Test
    public void shouldShowAllProducts() {
	MachineConfiguration config = MachineConfigurationTest.Fixtures.getFixture();
	Model model = new Model(config);
	Controller controller = new Controller(model);
	FakeView view = new FakeView();
	controller.addAndInitializeView(view);
	controller.startMachine();
	String productToMake = config.getProductsIterator().next().getName();
	view.orderedProductName = productToMake;

	view.performActionOnProductsListener();

	assertEquals(model.getProductsNames().toString(), view.getLastMessage());
    }

    @Test
    public void shouldShowIngredientsOfSelectedProduct() {
	MachineConfiguration config = MachineConfigurationTest.Fixtures.getFixture();
	Model model = new Model(config);
	Controller controller = new Controller(model);
	FakeView view = new FakeView();
	controller.addAndInitializeView(view);
	controller.startMachine();
	String productName = config.getProductsIterator().next().getName();

	view.performActionOnIngredientsListenerForProductNamed(productName);

	assertEquals(model.getIngredientsNamesForProductNamed(productName).toString(), view.getLastMessage());
    }
    
    @Test
    public void shouldShowAllIngredients() {
	MachineConfiguration config = MachineConfigurationTest.Fixtures.getFixture();
	Model model = new Model(config);
	Controller controller = new Controller(model);
	FakeView view = new FakeView();
	controller.addAndInitializeView(view);
	controller.startMachine();

	view.performActionOnIngredientsListener();

	assertEquals(model.getAllIngredientsNames().toString(), view.getLastMessage());
    }
    
    @Test
    public void shouldShowPropertiesOfSelectedIngredient() {
	MachineConfiguration config = MachineConfigurationTest.Fixtures.getFixture();
	Model model = new Model(config);
	Controller controller = new Controller(model);
	FakeView view = new FakeView();
	controller.addAndInitializeView(view);
	controller.startMachine();
	String ingredientName = config.getIngredientsIterator().next().getName();

	view.performActionOnPropertiesListenerForIngredientNamed(ingredientName);

	assertEquals(model.getPropertiesForIngredientNamed(ingredientName).toString(), view.getLastMessage());
    }
    
    @Test
    public void shouldShowErrorWhenTryingToShowPropertiesWithoutIngredientSelected() {
	MachineConfiguration config = MachineConfigurationTest.Fixtures.getFixture();
	Model model = new Model(config);
	Controller controller = new Controller(model);
	FakeView view = new FakeView();
	controller.addAndInitializeView(view);
	controller.startMachine();

	view.performActionOnPropertiesListener();

	assertEquals("Nie wybrano produktu, wiêc nie mo¿na wyœwietliæ w³aœciwoœci sk³adnika.", view.getLastMessage());
    }
    
    @Test
    public void shouldMakeOrderOnSelectedProduct() {
	MachineConfiguration config = MachineConfigurationTest.Fixtures.getFixture();
	Model model = new Model(config);
	Controller controller = new Controller(model);
	FakeView view = new FakeView();
	controller.addAndInitializeView(view);
	controller.startMachine();
	view.orderedProductName = config.getProductsIterator().next().getName();

	view.performActionOnOrderListener();

	assertEquals("[OK] Wszystkie operacje wykonano pomyœlnie! ", view.getLastMessage());
    } 
    
    @Test
    public void shouldNotMakeOrderWithoutSelectedProduct() {
	MachineConfiguration config = MachineConfigurationTest.Fixtures.getFixture();
	Model model = new Model(config);
	Controller controller = new Controller(model);
	FakeView view = new FakeView();
	controller.addAndInitializeView(view);
	controller.startMachine();
	view.orderedProductName = null;

	view.performActionOnOrderListener();

	assertEquals("Nie mo¿na z³o¿yæ zamówienia dla nieznanego produktu!", view.getLastMessage());
    } 
    
    @Test
    public void shouldNotMakeOrderWithUnknownProduct() {
	MachineConfiguration config = MachineConfigurationTest.Fixtures.getFixture();
	Model model = new Model(config);
	Controller controller = new Controller(model);
	FakeView view = new FakeView();
	controller.addAndInitializeView(view);
	controller.startMachine();
	view.orderedProductName = "Unknown product name";

	view.performActionOnOrderListener();

	assertEquals("Nie mo¿na z³o¿yæ zamówienia dla nieznanego produktu!", view.getLastMessage());
    }
    
    @Test
    public void shouldMakeOrderWithCustomProduct() {
	MachineConfiguration config = MachineConfigurationTest.Fixtures.getFixture();
	Model model = new Model(config);
	Controller controller = new Controller(model);
	FakeView view = new FakeView();
	controller.addAndInitializeView(view);
	controller.startMachine();
	view.newProductName = "Herbatka u Tadka";
	
	view.performActionOnCustomOrderListener();
	
	assertEquals("[OK] Wszystkie operacje wykonano pomyœlnie! ", view.getLastMessage());
    }
    
    public static void main(String[] args) {
	JUnitCore.runClasses(new Class[] { edu.issi.machine.mvc.MvcTest.class });
    }
}
