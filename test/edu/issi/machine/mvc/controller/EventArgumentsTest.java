package edu.issi.machine.mvc.controller;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.mvc.controller.fakes.FakeView;
import edu.issi.machine.mvc.view.View;

@SuppressWarnings("javadoc")
public class EventArgumentsTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @SuppressWarnings("unused")
    @Test
    public void eventArgumentsShouldNotCreatesWithoutSpecifiedCaller() {
	exception.expect(IllegalArgumentException.class);
	new EventArguments(null);
    }
    
    @SuppressWarnings("unused")
    @Test
    public void eventArgumentsShouldNotCreatesWithoutSelectedElementName() {
	exception.expect(IllegalArgumentException.class);
	new EventArguments(new FakeView(), null);
    }
    
    @SuppressWarnings("unused")
    @Test
    public void eventArgumentsShouldNotCreatesWithEmptySelectedElementName() {
	exception.expect(IllegalArgumentException.class);
	new EventArguments(new FakeView(), "");
    }
    
    @Test
    public void eventArgumentsShouldRecognizeCaller() {
	View caller = new FakeView();
	EventArguments fixture = new EventArguments(caller);
	
	assertTrue(fixture.isCalledBy(caller));
    }
    
    @Test
    public void eventArgumentsShouldProvideSelectedElementNameWhenItsGiven() {
	String selectedElementName = "Coffee";
	EventArguments fixture = new EventArguments(new FakeView(), selectedElementName);
	
	assertEquals(selectedElementName, fixture.getSelectedElementName());
    }
    
    @Test
    public void eventArgumentsShouldIndicateWhenSelectedElementNameIsGiven() {
	EventArguments fixture = new EventArguments(new FakeView(), "Coffee");
	
	assertTrue(fixture.hasSelectedElementName());
    }
    
    @Test
    public void eventArgumentsShouldIndicateWhenSelectedElementNameIsNotGiven() {
	EventArguments fixture = new EventArguments(new FakeView());
	
	assertFalse(fixture.hasSelectedElementName());
    }
}
