package edu.issi.machine.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.configuration.MachineConfigurationTest.Fixtures;

@SuppressWarnings("javadoc")
public class MachineControllerTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void configurationShouldBeProvided() throws IllegalArgumentException {
	exception.expect(IllegalArgumentException.class);
	new MachineController(null);
    }

    @Test
    public void shouldStops() throws IllegalArgumentException {
	MachineController fixture = new MachineController(Fixtures.getFixture());

	fixture.stop();
	assertFalse(fixture.isWorking());
    }
    
    @Test
    public void machineShouldRestarts() throws Exception {
	MachineController fixture = new MachineController(Fixtures.getFixture());
	
	fixture.start();

	fixture.restart();
	assertTrue(fixture.isWorking());
    }

    @Test
    public void machineShouldRestartsEvenWhenAlreadyIsNotWorking() throws Exception {
	MachineController fixture = new MachineController(Fixtures.getFixture());

	fixture.restart();
	assertTrue(fixture.isWorking());
    }
}