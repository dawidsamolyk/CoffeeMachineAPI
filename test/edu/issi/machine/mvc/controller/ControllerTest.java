package edu.issi.machine.mvc.controller;

import javax.naming.directory.InvalidAttributeIdentifierException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.configuration.MachineConfigurationTest.Fixtures;
import edu.issi.machine.mvc.model.Model;

@SuppressWarnings("javadoc")
public class ControllerTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @SuppressWarnings("unused")
    @Test
    public void shouldNotCreatesWithoutModel() {
	exception.expect(IllegalArgumentException.class);
	new Controller(null);
    }
    
    @Test
    public void controllerShouldNotAddAndInitializeNotCreatedView() throws IllegalArgumentException, InvalidAttributeIdentifierException {
	Controller controller = new Controller(new Model(Fixtures.getFixture()));
	
	exception.expect(IllegalArgumentException.class);
	controller.addAndInitializeView(null);
    }
    
    
}
