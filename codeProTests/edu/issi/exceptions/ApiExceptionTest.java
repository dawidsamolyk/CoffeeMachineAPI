package edu.issi.exceptions;

import org.junit.*;
import static org.junit.Assert.*;
import edu.issi.machine.operation.Status;

/**
 * The class <code>ApiExceptionTest</code> contains tests for the class <code>{@link ApiException}</code>.
 *
 * @generatedBy CodePro at 27.11.14 17:52
 * @author Dawid
 * @version $Revision: 1.0 $
 */
public class ApiExceptionTest {
	/**
	 * An instance of the class being tested.
	 *
	 * @see ApiException
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	private ApiException fixture;

	/**
	 * Return an instance of the class being tested.
	 *
	 * @return an instance of the class being tested
	 *
	 * @see ApiException
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	public ApiException getFixture()
		throws Exception {
		if (fixture == null) {
			fixture = new ApiException();
		}
		return fixture;
	}

	/**
	 * Run the Status getStatus() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testGetStatus_fixture_1()
		throws Exception {
		ApiException fixture2 = getFixture();

		Status result = fixture2.getStatus();

		// add additional test code here
		assertNotNull(result);
		assertEquals("ERROR", result.name());
		assertEquals("ERROR", result.toString());
		assertEquals(2, result.ordinal());
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
		new org.junit.runner.JUnitCore().run(ApiExceptionTest.class);
	}
}