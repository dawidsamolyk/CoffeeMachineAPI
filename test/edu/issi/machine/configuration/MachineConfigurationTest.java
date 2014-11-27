package edu.issi.machine.configuration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.naming.directory.InvalidAttributeValueException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.id.Identity;
import edu.issi.machine.product.Product;
import edu.issi.machine.subassembly.Subassembly;
import edu.issi.machine.subassembly.SubassemblyTest;

@SuppressWarnings("javadoc")
public class MachineConfigurationTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldNotCreatesWhenSubassembliesAreNotSetted() {
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	List<Product> products = new ArrayList<Product>();
	products.add(mockProduct());

	exception.expect(IllegalStateException.class);
	new MachineConfiguration(subassemblies, products);

	exception.expect(IllegalStateException.class);
	new MachineConfiguration(null, products);
    }

    @Test
    public void shouldNotCreatesWhenProductsAreNotSetted() throws Exception {
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	subassemblies.add(SubassemblyTest.mockSubassembly());

	List<Product> products = new ArrayList<Product>();

	exception.expect(IllegalStateException.class);
	new MachineConfiguration(subassemblies, products);

	exception.expect(IllegalStateException.class);
	new MachineConfiguration(null, products);
    }

    @Test
    public void shouldProvideIteratorForSubassembliesWithRestrictionToNotRemoveElements() throws Exception {
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	subassemblies.add(SubassemblyTest.mockSubassembly());
	List<Product> products = new ArrayList<Product>();
	products.add(mockProduct());

	MachineConfiguration conf = new MachineConfiguration(subassemblies, products);

	Iterator<Subassembly> iterator = conf.subassemblies();
	iterator.next();
	exception.expect(UnsupportedOperationException.class);
	iterator.remove();
    }

    @Test
    public void shouldProvideIteratorForProductsWithRestrictionToNotRemoveElements() throws Exception {
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	subassemblies.add(SubassemblyTest.mockSubassembly());
	List<Product> products = new ArrayList<Product>();
	products.add(mockProduct());

	MachineConfiguration conf = new MachineConfiguration(subassemblies, products);

	Iterator<Product> iterator = conf.products();
	iterator.next();
	exception.expect(UnsupportedOperationException.class);
	iterator.remove();
    }

    public static Product mockProduct() {
	return new Product(Identity.SAMPLE);
    }

    public static MachineConfiguration mockMachineConfiguration() throws Exception {
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	subassemblies.add(SubassemblyTest.mockSubassembly());
	List<Product> products = new ArrayList<Product>();
	products.add(mockProduct());

	return new MachineConfiguration(subassemblies, products);
    }

}
