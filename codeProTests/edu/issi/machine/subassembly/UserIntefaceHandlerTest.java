package edu.issi.machine.subassembly;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>UserIntefaceHandlerTest</code> contains tests for the class <code>{@link UserIntefaceHandler}</code>.
 *
 * @generatedBy CodePro at 27.11.14 17:52
 * @author Dawid
 * @version $Revision: 1.0 $
 */
public class UserIntefaceHandlerTest {
	/**
	 * An instance of the class being tested.
	 *
	 * @see UserIntefaceHandler
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	private UserIntefaceHandler fixture;

	/**
	 * Return an instance of the class being tested.
	 *
	 * @return an instance of the class being tested
	 *
	 * @see UserIntefaceHandler
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	public UserIntefaceHandler getFixture()
		throws Exception {
		if (fixture == null) {
			fixture = new UserIntefaceHandler();
		}
		return fixture;
	}

	/**
	 * Run the void run() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testRun_fixture_1()
		throws Exception {
		UserIntefaceHandler fixture2 = getFixture();

		fixture2.run();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.UnsupportedOperationException: Nie mo¿na wykonaæ pustej operacji!
		//       at edu.issi.machine.subassembly.Handler.run(Handler.java:36)
		//       at edu.issi.machine.subassembly.UserIntefaceHandler.run(UserIntefaceHandler.java:12)
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
		new org.junit.runner.JUnitCore().run(UserIntefaceHandlerTest.class);
	}
}