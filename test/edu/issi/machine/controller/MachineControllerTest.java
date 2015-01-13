package edu.issi.machine.controller;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import javax.naming.directory.InvalidAttributeIdentifierException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.configuration.MachineConfiguration;
import edu.issi.machine.id.Identity;
import edu.issi.machine.product.Product;
import edu.issi.machine.subassembly.Subassembly;
import edu.issi.machine.subassembly.SubassemblyTest;

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
    }

    @Test
    public void shouldRestart() throws InvalidAttributeIdentifierException {
	MachineController fixture = new MachineController();

	ArrayList<Subassembly> subassemblies = new ArrayList<Subassembly>();
	subassemblies.add(SubassemblyTest.getFixture());

	ArrayList<Product> products = new ArrayList<Product>();
	products.add(new Product(Identity.Factory.newIdentity("Test")));

	fixture.setUpUsing(new MachineConfiguration(subassemblies, products));
	fixture.start();

	fixture.restart();
    }

    @Test
    public void shouldDeinitializes() {
	MachineController fixture = new MachineController();

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.tearDown();
    }

    @Test
    public void shouldNotDeinitializeWhenMachineIsWorking() throws InvalidAttributeIdentifierException {
	MachineController fixture = new MachineController();

	ArrayList<Subassembly> subassemblies = new ArrayList<Subassembly>();
	subassemblies.add(SubassemblyTest.getFixture());

	ArrayList<Product> products = new ArrayList<Product>();
	products.add(new Product(Identity.Factory.newIdentity("Test")));

	fixture.setUpUsing(new MachineConfiguration(subassemblies, products));
	fixture.start();

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.tearDown();
    }

    @Test
    public void shouldNotInitializeWhenMachineIsWorking() throws InvalidAttributeIdentifierException {
	MachineController fixture = new MachineController();

	ArrayList<Subassembly> subassemblies = new ArrayList<Subassembly>();
	subassemblies.add(SubassemblyTest.getFixture());

	ArrayList<Product> products = new ArrayList<Product>();
	products.add(new Product(Identity.Factory.newIdentity("Test")));

	fixture.setUpUsing(new MachineConfiguration(subassemblies, products));
	fixture.start();

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.setUpUsing(new MachineConfiguration(subassemblies, products));
    }

    @Test
    public void shouldNotInitializeWhenConfigurationIsEmpty() {
	MachineController fixture = new MachineController();

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.setUpUsing(null);
    }
}