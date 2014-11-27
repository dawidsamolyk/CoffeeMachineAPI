package edu.issi.machine.subassembly;

import java.lang.reflect.Method;
import org.junit.*;
import static org.junit.Assert.*;
import edu.issi.machine.id.Identity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.properties.Properties;

/**
 * The class <code>SubassemblyTest</code> contains tests for the class <code>{@link Subassembly}</code>.
 *
 * @generatedBy CodePro at 27.11.14 17:52
 * @author Dawid
 * @version $Revision: 1.0 $
 */
public class SubassemblyCodeProTest {
	/**
	 * Run the Subassembly(Identity,Properties,Operation[]) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testSubassembly_1()
		throws Exception {
		Identity id = Identity.SAMPLE;
		Properties properties = new Properties();
		Operation operation1 = new Operation(Object.class.getMethods()[0]);
		Operation operation2 = null;

		Subassembly result = new Subassembly(id, properties, operation1, operation2);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at edu.issi.machine.subassembly.Subassembly.getNewListWithDefaultHandler(Subassembly.java:50)
		//       at edu.issi.machine.subassembly.Subassembly.<init>(Subassembly.java:45)
		assertNotNull(result);
	}

	/**
	 * Run the Subassembly(Identity,Properties,Operation[]) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testSubassembly_2()
		throws Exception {
		Identity id = Identity.SAMPLE;
		Properties properties = new Properties();
		Operation operation1 = new Operation(Object.class.getMethods()[0]);

		Subassembly result = new Subassembly(id, properties, operation1);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at edu.issi.machine.subassembly.Subassembly.getNewListWithDefaultHandler(Subassembly.java:50)
		//       at edu.issi.machine.subassembly.Subassembly.<init>(Subassembly.java:45)
		assertNotNull(result);
	}

	/**
	 * Run the Subassembly(Identity,Properties,Operation[]) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testSubassembly_3()
		throws Exception {
		Identity id = new Identity(0);
		Properties properties = new Properties();
		Operation operation1 = new Operation(Object.class.getMethods()[0]);
		Operation operation2 = null;

		Subassembly result = new Subassembly(id, properties, operation1, operation2);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at edu.issi.machine.subassembly.Subassembly.getNewListWithDefaultHandler(Subassembly.java:50)
		//       at edu.issi.machine.subassembly.Subassembly.<init>(Subassembly.java:45)
		assertNotNull(result);
	}

	/**
	 * Run the Subassembly(Identity,Properties,Operation[]) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testSubassembly_4()
		throws Exception {
		Identity id = new Identity(0);
		Properties properties = new Properties();
		Operation operation1 = new Operation(Object.class.getMethods()[0]);

		Subassembly result = new Subassembly(id, properties, operation1);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at edu.issi.machine.subassembly.Subassembly.getNewListWithDefaultHandler(Subassembly.java:50)
		//       at edu.issi.machine.subassembly.Subassembly.<init>(Subassembly.java:45)
		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(SubassemblyCodeProTest.class);
	}
}