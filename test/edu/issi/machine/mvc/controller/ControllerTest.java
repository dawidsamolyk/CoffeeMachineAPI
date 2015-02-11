package edu.issi.machine.mvc.controller;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.mvc.controller.fakes.FakeView;
import edu.issi.machine.mvc.controller.fakes.TestingController;
import edu.issi.machine.mvc.model.ModelTest;
import edu.issi.machine.mvc.model.fakes.FakeModel;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationStatus;
import edu.issi.machine.operation.Status;

@SuppressWarnings("javadoc")
public class ControllerTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldNotCreatesWithoutModel() {
	exception.expect(IllegalArgumentException.class);
	new Controller(null);
    }

    @Test
    public void controllerShouldNotAddAndInitializeNotCreatedView() throws Exception {
	Controller controller = getFixture();

	exception.expect(IllegalArgumentException.class);
	controller.addAndInitializeView(null);
    }

    @Test
    public void controllerShouldAddView() throws Exception {
	TestingController controller = new TestingController(ModelTest.getFixture());

	FakeView view = new FakeView();
	controller.addAndInitializeView(view);

	assertSame(1, controller.getNumViews());
    }

    @Test
    public void controllerShouldStartsMachine() throws Exception {
	FakeModel model = FakeModel.getFixture();
	TestingController controller = new TestingController(model);

	controller.startMachine();

	assertTrue(model.working);
    }

    @Test
    public void controllerShouldStopsMachine() throws Exception {
	FakeModel model = FakeModel.getFixture();
	TestingController controller = new TestingController(model);

	controller.startMachine();
	controller.stopMachine();

	assertFalse(model.working);
    }

    @Test
    public void controllerShouldShowProductsOnAllViewsWhenActionIsPerformed() throws Exception {
	FakeModel model = FakeModel.getFixture();
	TestingController controller = new TestingController(model);
	FakeView view = new FakeView();
	controller.addAndInitializeView(view);

	view.performActionOnProductsListener();

	assertEquals(model.getProductsNames().toString(), view.getLastMessage());
    }

    @Test
    public void controllerShouldShowAllIngredientsOnAllViewsWhenActionIsPerformed() throws Exception {
	FakeModel model = FakeModel.getFixture();
	TestingController controller = new TestingController(model);
	FakeView view = new FakeView();
	controller.addAndInitializeView(view);

	view.performActionOnIngredientsListener();

	assertEquals(model.getAllIngredientsNames().toString(), view.getLastMessage());
    }

    @Test
    public void controllerShouldShowIngredientsOfSpecifiedProductOnAllViewsWhenActionIsPerformed() throws Exception {
	FakeModel model = FakeModel.getFixture();
	TestingController controller = new TestingController(model);
	FakeView view = new FakeView();
	controller.addAndInitializeView(view);

	String productName = model.getProductsNames().iterator().next();

	view.performActionOnIngredientsListenerForProductNamed(productName);

	assertEquals(model.getIngredientsNamesForProductNamed(productName).toString(), view.getLastMessage());
    }

    @Test
    public void controllerShouldShowPropertiesForSpecifiedIngredientOnAllViewsWhenActionIsPerformed() throws Exception {
	FakeModel model = FakeModel.getFixture();
	TestingController controller = new TestingController(model);
	FakeView view = new FakeView();
	controller.addAndInitializeView(view);

	String ingredientName = model.getAllIngredientsNames().iterator().next();

	view.performActionOnPropertiesListenerForIngredientNamed(ingredientName);

	assertEquals(model.getPropertiesForIngredientNamed(ingredientName).toString(), view.getLastMessage());
    }

    @Test
    public void controllerShouldShowErrorOnAllViewsWhenIngredientForPropertiesIsNotSelected() throws Exception {
	FakeModel model = FakeModel.getFixture();
	TestingController controller = new TestingController(model);
	FakeView view = new FakeView();
	controller.addAndInitializeView(view);

	view.performActionOnPropertiesListener();

	assertEquals("Nie wybrano elementu, wi�c nie mo�na wy�wietli� w�a�ciwo�ci sk�adnika.", view.getLastMessage());
    }

    @Test
    public void controllerShouldConfigureOrderOnlyOnOneViewButShowOperationsStatusOnAllViews() throws Exception {
	FakeModel model = FakeModel.getFixture();
	TestingController controller = new TestingController(model);
	FakeView view = new FakeView();
	FakeView secondView = new FakeView();
	controller.addAndInitializeView(view);
	controller.addAndInitializeView(secondView);

	view.performActionOnOrderListener();

	assertEquals(Status.OK.name() + OperationStatus.Factory.ALL_VALID, secondView.getLastMessage());
    }

    @Test
    public void controllerShouldMakeOrderOnSelectedView() throws Exception {
	fail("Not implemented yet!");
    }

    private Controller getFixture() throws Exception {
	return new Controller(ModelTest.getFixture());
    }

}
