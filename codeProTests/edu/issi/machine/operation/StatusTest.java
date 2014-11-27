package edu.issi.machine.operation;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>StatusTest</code> contains tests for the class <code>{@link Status}</code>.
 *
 * @generatedBy CodePro at 27.11.14 17:52
 * @author Dawid
 * @version $Revision: 1.0 $
 */
public class StatusTest {
	/**
	 * Run the boolean requiresAttention(Status) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testRequiresAttention_1()
		throws Exception {
		Status status = Status.ERROR;

		boolean result = Status.requiresAttention(status);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean requiresAttention(Status) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testRequiresAttention_2()
		throws Exception {
		Status status = Status.OK;

		boolean result = Status.requiresAttention(status);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean requiresAttention(Status) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testRequiresAttention_3()
		throws Exception {
		Status status = Status.WARNING;

		boolean result = Status.requiresAttention(status);

		// add additional test code here
		assertEquals(true, result);
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
		new org.junit.runner.JUnitCore().run(StatusTest.class);
	}
}