package edu.issi.machine.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Iterator;
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

    @SuppressWarnings("unused")
    @Test
    public void subassembliesShouldBeSetted() throws InvalidAttributeIdentifierException {
	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(null, ProductTest.getManyFixtures());
    }

    @SuppressWarnings("unused")
    @Test
    public void subassembliesListShouldNotBeEmpty() throws InvalidAttributeIdentifierException {
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(subassemblies, ProductTest.getManyFixtures());
    }

    @SuppressWarnings("unused")
    @Test
    public void productsShouldBeSetted() throws Exception {
	Subassembly subassembly = TestingSubassembly.getFixtureWith(OperationTest.getFixture());

	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	subassemblies.add(subassembly);

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(subassemblies, null);
    }

    @SuppressWarnings("unused")
    @Test
    public void productsListShouldNotBeEmpty() throws InvalidAttributeIdentifierException {
	Subassembly subassembly = TestingSubassembly.getFixtureWith(OperationTest.getFixture());

	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	subassemblies.add(subassembly);

	List<Product> products = new ArrayList<Product>();

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(subassemblies, products);
    }

    @Test
    public void shouldProvidesIteratorForProducts() throws InvalidAttributeIdentifierException {
	MachineConfiguration fixture = MachineConfigurationTest.getFixture();

	assertNotNull(fixture.products());
    }

    @Test
    public void shouldAddNewProduct() throws InvalidAttributeIdentifierException {
	// Tutaj dostarczone s¹ ju¿ przyk³adowe produkty
	MachineConfiguration fixture = MachineConfigurationTest.getFixture();

	Product product = ProductTest.getFixture();
	fixture.addProduct(product);

	// Pobieram ostatni produkt, poniewa¿ nowo dodany produkt bêdzie na
	// koñcu listy
	Iterator<Product> iterator = fixture.products();
	Product productToCheck = null;
	while (iterator.hasNext()) {
	    productToCheck = iterator.next();
	}

	assertEquals(product, productToCheck);
    }

    @Test
    public void shouldAddNewSubassembly() throws InvalidAttributeIdentifierException {
	// Tutaj dostarczone s¹ ju¿ przyk³adowe podzespo³y
	MachineConfiguration fixture = MachineConfigurationTest.getFixture();

	Subassembly subassembly = TestingSubassembly.getFixtureWith(OperationTest.getFixture());
	fixture.addSubassembly(subassembly);

	// Pobieram ostatni podzespó³, poniewa¿ nowo dodany bêdzie na
	// koñcu listy
	Iterator<Subassembly> iterator = fixture.subassemblies();
	Subassembly subassemblyToCheck = null;
	while (iterator.hasNext()) {
	    subassemblyToCheck = iterator.next();
	}

	assertEquals(subassembly, subassemblyToCheck);
    }

    @Test
    public void shouldNotAddEmptyProduct() throws InvalidAttributeIdentifierException {
	MachineConfiguration fixture = MachineConfigurationTest.getFixture();

	exception.expect(IllegalArgumentException.class);
	fixture.addProduct(null);
    }

    @Test
    public void shouldNotAddEmptySubassembly() throws InvalidAttributeIdentifierException {
	MachineConfiguration fixture = MachineConfigurationTest.getFixture();

	exception.expect(IllegalArgumentException.class);
	fixture.addSubassembly(null);
    }

    public static MachineConfiguration getFixture() throws IllegalArgumentException,
	    InvalidAttributeIdentifierException {
	Subassembly subassembly = TestingSubassembly.getFixtureWith(OperationTest.getFixture());

	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	subassemblies.add(subassembly);

	return new MachineConfiguration(subassemblies, ProductTest.getManyFixtures());
    }

}
