package edu.issi.machine.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.InvalidAttributeIdentifierException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.id.IdentityTest;
import edu.issi.machine.operation.EmptyOperation;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.product.Product;
import edu.issi.machine.subassembly.Subassembly;
import edu.issi.machine.subassembly.TestingSubassembly;

@SuppressWarnings("javadoc")
public class MachineConfigurationTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void subassembliesShouldBeSetted() throws InvalidAttributeIdentifierException {
	List<Product> products = new ArrayList<Product>();
	products.add(mockProduct());

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(null, products);
    }

    @Test
    public void subassembliesListShouldNotBeEmpty() throws InvalidAttributeIdentifierException {
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	
	List<Product> products = new ArrayList<Product>();
	products.add(MachineConfigurationTest.mockProduct());

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(subassemblies, products);
    }

    @Test
    public void productsShouldBeSetted() throws Exception {
	Operation operation = new EmptyOperation(IdentityTest.getIdentityFixture());
	Subassembly subassembly = TestingSubassembly.getFixtureWith(operation);

	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	subassemblies.add(subassembly);

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(subassemblies, null);
    }

    @Test
    public void productsListShouldNotBeEmpty() throws InvalidAttributeIdentifierException {
	Operation operation = new EmptyOperation(IdentityTest.getIdentityFixture());
	Subassembly subassembly = TestingSubassembly.getFixtureWith(operation);

	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	subassemblies.add(subassembly);

	List<Product> products = new ArrayList<Product>();

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(subassemblies, products);
    }

    public static Product mockProduct() throws InvalidAttributeIdentifierException {
	return new Product(IdentityTest.getIdentityFixture());
    }

    public static MachineConfiguration mockMachineConfiguration() throws Exception {
	Operation operation = new EmptyOperation(IdentityTest.getIdentityFixture());
	Subassembly subassembly = TestingSubassembly.getFixtureWith(operation);

	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	subassemblies.add(subassembly);

	List<Product> products = new ArrayList<Product>();
	products.add(mockProduct());

	return new MachineConfiguration(subassemblies, products);
    }

}
