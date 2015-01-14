package edu.issi.machine.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.naming.directory.InvalidAttributeIdentifierException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.configuration.MachineConfigurationTest;

@SuppressWarnings("javadoc")
public class MachineControllerTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldCreateMachineController() {
	MachineController result = new MachineController();
	assertNotNull(result);
    }

    @Test
    public void shouldNotRestartWithoutInitialization() {
	MachineController fixture = new MachineController();

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.restart();
    }

    @Test
    public void shouldNotStartWithoutInitialization() {
	MachineController fixture = new MachineController();

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.start();
    }

    @Test
    public void shouldStops() {
	MachineController fixture = new MachineController();

	fixture.stop();
	assertFalse(fixture.running);
    }

    @Test
    public void shouldRestart() throws InvalidAttributeIdentifierException {
	MachineController fixture = new MachineController();

	fixture.setUpUsing(MachineConfigurationTest.getFixture());

	fixture.restart();
	assertTrue(fixture.running);
    }

    @Test
    public void tearingDownMachineShouldBeExecutedWhenTheresAnyConfigurationSetted() {
	MachineController fixture = new MachineController();

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.tearDown();
    }

    @Test
    public void tearingDownMachineShouldNotBeDoneWhenMachineIsWorking() throws IllegalStateException, IllegalArgumentException, InvalidAttributeIdentifierException {
	MachineController fixture = new MachineController();

	fixture.setUpUsing(MachineConfigurationTest.getFixture());
	fixture.start();

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.tearDown();
    }

    @Test
    public void shouldNotInitializeWhenMachineIsWorking() throws IllegalStateException, IllegalArgumentException, InvalidAttributeIdentifierException {
	MachineController fixture = new MachineController();

	fixture.setUpUsing(MachineConfigurationTest.getFixture());
	fixture.start();

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.setUpUsing(MachineConfigurationTest.getFixture());
    }

    @Test
    public void shouldNotInitializeWhenConfigurationIsEmpty() {
	MachineController fixture = new MachineController();

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.setUpUsing(null);
    }
}