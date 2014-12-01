package edu.issi.machine.configuration;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.id.Identity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.product.Product;
import edu.issi.machine.subassembly.Subassembly;

@SuppressWarnings("javadoc")
public class MachineConfigurationTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldNotCreatesWhenSubassembliesAreNotSetted() {
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	List<Product> products = new ArrayList<Product>();
	products.add(mockProduct());

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(subassemblies, products);

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(null, products);
    }

    @Test
    public void shouldNotCreatesWhenProductsAreNotSetted() throws Exception {
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	subassemblies.add(new Subassembly(new Identity(0), new Operation(new Identity(1))));

	List<Product> products = new ArrayList<Product>();

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(subassemblies, products);

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(null, products);
    }

    public static Product mockProduct() {
	return new Product(Identity.SAMPLE);
    }

    public static MachineConfiguration mockMachineConfiguration() throws Exception {
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	subassemblies.add(new Subassembly(new Identity(0), new Operation(new Identity(1))));
	
	List<Product> products = new ArrayList<Product>();
	products.add(mockProduct());

	return new MachineConfiguration(subassemblies, products);
    }

}
