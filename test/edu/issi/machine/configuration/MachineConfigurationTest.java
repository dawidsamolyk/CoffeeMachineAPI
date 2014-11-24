package edu.issi.machine.configuration;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import edu.issi.machine.Identity;
import edu.issi.machine.product.Product;
import edu.issi.machine.subassembly.Subassembly;
import edu.issi.machine.subassembly.SubassemblyTest;

@SuppressWarnings("javadoc")
public class MachineConfigurationTest {

    @Test
    public void shouldNotCreatesWhenSubassembliesAreNotSetted() {
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	List<Product> products = new ArrayList<Product>();
	products.add(mockProduct());

	try {
	    new MachineConfiguration(subassemblies, products);
	    fail("Powinien wystapic blad!");
	} catch (IllegalStateException e) {
	}

	try {
	    new MachineConfiguration(null, products);
	    fail("Powinien wystapic blad!");
	} catch (IllegalStateException e) {
	}
    }

    @Test
    public void shouldNotCreatesWhenProductsAreNotSetted() throws Exception {
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	subassemblies.add(SubassemblyTest.mockSubassembly());

	List<Product> products = new ArrayList<Product>();

	try {
	    new MachineConfiguration(subassemblies, products);
	    fail("Powinien wystapic blad!");
	} catch (IllegalStateException e) {
	}

	try {
	    new MachineConfiguration(null, products);
	    fail("Powinien wystapic blad!");
	} catch (IllegalStateException e) {
	}
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldProvideIteratorForSubassembliesWithRestrictionToNotRemoveElements() throws Exception {
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	subassemblies.add(SubassemblyTest.mockSubassembly());
	List<Product> products = new ArrayList<Product>();
	products.add(mockProduct());

	MachineConfiguration conf = new MachineConfiguration(subassemblies, products);

	Iterator<Subassembly> iterator = conf.subassemblies();
	iterator.next();
	iterator.remove();
    }

    public Product mockProduct() {
	return new Product(Identity.SAMPLE);
    }

}
