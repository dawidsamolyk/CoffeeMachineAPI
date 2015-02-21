package edu.issi.machine.mvc.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.mvc.controller.fakes.TestingController;
import edu.issi.machine.mvc.model.ModelTest;
import edu.issi.machine.mvc.model.fakes.FakeModel;
import edu.issi.machine.mvc.view.fakes.FakeView;
import edu.issi.machine.operation.OperationStatus;

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

	assertEquals("Nie wybrano elementu, wiêc nie mo¿na wyœwietliæ w³aœciwoœci sk³adnika.", view.getLastMessage());
    }

    @Test
    public void controllerShouldShowOperationsStatusOnAllViewsAfterOrderWasMade() throws Exception {
	FakeModel model = FakeModel.getFixture();
	String orderedProductName = model.getProductsNames().iterator().next();
	TestingController controller = new TestingController(model);
	FakeView view = new FakeView(orderedProductName);
	FakeView secondView = new FakeView();
	controller.addAndInitializeView(view);
	controller.addAndInitializeView(secondView);

	view.performActionOnOrderListener();
	
	assertEquals(OperationStatus.Factory.ALL_VALID.getCompensatedStatus(), secondView.getLastMessage());
    }
    
    @Test
    public void controllerShouldMakeOrderOnlyOnSelectedView() throws Exception {
	FakeModel model = FakeModel.getFixture();
	String productName = model.getProductsNames().iterator().next();
	TestingController controller = new TestingController(model);
	FakeView view = new FakeView(productName);
	FakeView secondView = new FakeView();
	controller.addAndInitializeView(view);
	controller.addAndInitializeView(secondView);

	view.performActionOnOrderListener();
	
	assertEquals(model.orderedProductName, view.orderedProductName);
	assertFalse(model.orderedProductName.equals(secondView.orderedProductName));
    }

    private Controller getFixture() throws Exception {
	return new Controller(ModelTest.getFixture());
    }

}
