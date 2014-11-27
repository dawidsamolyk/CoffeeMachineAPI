package edu.issi.machine.configuration;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>IteratorForMachineConfigurationTest</code> contains tests for the class <code>{@link IteratorForMachineConfiguration}</code>.
 *
 * @generatedBy CodePro at 27.11.14 17:52
 * @author Dawid
 * @version $Revision: 1.0 $
 */
public class IteratorForMachineConfigurationTest {
	/**
	 * An instance of the class being tested.
	 *
	 * @see IteratorForMachineConfiguration
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	private IteratorForMachineConfiguration fixture;

	/**
	 * Return an instance of the class being tested.
	 *
	 * @return an instance of the class being tested
	 *
	 * @see IteratorForMachineConfiguration
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	public IteratorForMachineConfiguration getFixture()
		throws Exception {
		if (fixture == null) {
			fixture = new IteratorForMachineConfiguration(new ArrayList<Object>());
		}
		return fixture;
	}

	/**
	 * Run the IteratorForMachineConfiguration(List<Type>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testIteratorForMachineConfiguration_1()
		throws Exception {
		List<Object> list = new ArrayList<Object>();

		IteratorForMachineConfiguration result = new IteratorForMachineConfiguration(list);

		// add additional test code here
		assertNotNull(result);
		assertEquals(false, result.hasNext());
	}

	/**
	 * Run the IteratorForMachineConfiguration(List<Type>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testIteratorForMachineConfiguration_2()
		throws Exception {
		List<Object> list = new LinkedList<Object>();

		IteratorForMachineConfiguration result = new IteratorForMachineConfiguration(list);

		// add additional test code here
		assertNotNull(result);
		assertEquals(false, result.hasNext());
	}

	/**
	 * Run the IteratorForMachineConfiguration(List<Type>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testIteratorForMachineConfiguration_3()
		throws Exception {
		List<Object> list = new Vector<Object>();

		IteratorForMachineConfiguration result = new IteratorForMachineConfiguration(list);

		// add additional test code here
		assertNotNull(result);
		assertEquals(false, result.hasNext());
	}

	/**
	 * Run the boolean hasNext() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testHasNext_fixture_1()
		throws Exception {
		IteratorForMachineConfiguration fixture2 = getFixture();

		boolean result = fixture2.hasNext();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the Object next() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testNext_fixture_1()
		throws Exception {
		IteratorForMachineConfiguration fixture2 = getFixture();

		Object result = fixture2.next();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.util.NoSuchElementException
		//       at java.util.ArrayList$Itr.next(Unknown Source)
		//       at edu.issi.machine.configuration.IteratorForMachineConfiguration.next(IteratorForMachineConfiguration.java:32)
		assertNotNull(result);
	}

	/**
	 * Run the void remove() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test(expected = java.lang.UnsupportedOperationException.class)
	public void testRemove_fixture_1()
		throws Exception {
		IteratorForMachineConfiguration fixture2 = getFixture();

		fixture2.remove();

		// add additional test code here
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
		new org.junit.runner.JUnitCore().run(IteratorForMachineConfigurationTest.class);
	}
}