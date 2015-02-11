package edu.issi.machine.mvc.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.mvc.controller.fakes.FakeView;
import edu.issi.machine.mvc.controller.fakes.TestingController;
import edu.issi.machine.mvc.model.ModelTest;
import edu.issi.machine.mvc.model.fakes.FakeModel;

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

    private Controller getFixture() throws Exception {
	return new Controller(ModelTest.getFixture());
    }

}
