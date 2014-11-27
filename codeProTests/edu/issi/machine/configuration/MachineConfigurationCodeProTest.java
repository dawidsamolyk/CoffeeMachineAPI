package edu.issi.machine.configuration;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.product.Product;
import edu.issi.machine.properties.Properties;
import edu.issi.machine.subassembly.Subassembly;

/**
 * The class <code>MachineConfigurationTest</code> contains tests for the class
 * <code>{@link MachineConfiguration}</code>.
 *
 * @generatedBy CodePro at 27.11.14 17:52
 * @author Dawid
 * @version $Revision: 1.0 $
 */
public class MachineConfigurationCodeProTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    /**
     * Run the MachineConfiguration(List<Subassembly>,List<Product>) constructor
     * test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testMachineConfiguration_1() throws Exception {
	List<Subassembly> subassemblies = null;
	List<Product> products = null;

	exception.expect(IllegalArgumentException.class);
	MachineConfiguration result = new MachineConfiguration(subassemblies, products);

	// add additional test code here
	assertNotNull(result);
    }

    /**
     * Run the MachineConfiguration(List<Subassembly>,List<Product>,Properties)
     * constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testMachineConfiguration_2() throws Exception {
	List<Subassembly> subassemblies = null;
	List<Product> products = null;
	Properties properties = null;

	exception.expect(IllegalArgumentException.class);
	MachineConfiguration result = new MachineConfiguration(subassemblies, products, properties);

	// add additional test code here
	assertNotNull(result);
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Before
    public void setUp() throws Exception {
	// add additional set up code here
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *             if the clean-up fails for some reason
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @After
    public void tearDown() throws Exception {
	// Add additional tear down code here
    }

    /**
     * Launch the test.
     *
     * @param args
     *            the command line arguments
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    public static void main(String[] args) {
	new org.junit.runner.JUnitCore().run(MachineConfigurationCodeProTest.class);
    }
}