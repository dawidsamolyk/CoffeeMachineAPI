package edu.issi.machine.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.InvalidAttributeIdentifierException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.operation.OperationTest;
import edu.issi.machine.product.Product;
import edu.issi.machine.product.ProductTest;
import edu.issi.machine.subassembly.Subassembly;
import edu.issi.machine.subassembly.TestingSubassembly;

@SuppressWarnings("javadoc")
public class MachineConfigurationTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void subassembliesShouldBeSetted() throws InvalidAttributeIdentifierException {
	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(null, ProductTest.getManyFixtures());
    }

    @Test
    public void subassembliesListShouldNotBeEmpty() throws InvalidAttributeIdentifierException {
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(subassemblies, ProductTest.getManyFixtures());
    }

    @Test
    public void productsShouldBeSetted() throws Exception {
	Subassembly subassembly = TestingSubassembly.getFixtureWith(OperationTest.getFixture());

	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	subassemblies.add(subassembly);

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(subassemblies, null);
    }

    @Test
    public void productsListShouldNotBeEmpty() throws InvalidAttributeIdentifierException {
	Subassembly subassembly = TestingSubassembly.getFixtureWith(OperationTest.getFixture());

	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	subassemblies.add(subassembly);

	List<Product> products = new ArrayList<Product>();

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(subassemblies, products);
    }

    public static MachineConfiguration getFixture() throws IllegalArgumentException, InvalidAttributeIdentifierException {
	Subassembly subassembly = TestingSubassembly.getFixtureWith(OperationTest.getFixture());

	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	subassemblies.add(subassembly);

	return new MachineConfiguration(subassemblies, ProductTest.getManyFixtures());
    }

}
