package edu.issi.machine.subassembly;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>SubassemblyHandlerTest</code> contains tests for the class <code>{@link SubassemblyHandler}</code>.
 *
 * @generatedBy CodePro at 27.11.14 17:52
 * @author Dawid
 * @version $Revision: 1.0 $
 */
public class SubassemblyHandlerTest {
	/**
	 * An instance of the class being tested.
	 *
	 * @see SubassemblyHandler
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	private SubassemblyHandler fixture;

	/**
	 * Return an instance of the class being tested.
	 *
	 * @return an instance of the class being tested
	 *
	 * @see SubassemblyHandler
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	public SubassemblyHandler getFixture()
		throws Exception {
		if (fixture == null) {
			fixture = new SubassemblyHandler();
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
		SubassemblyHandler fixture2 = getFixture();

		fixture2.run();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.UnsupportedOperationException: Nie mo¿na wykonaæ pustej operacji!
		//       at edu.issi.machine.subassembly.Handler.run(Handler.java:36)
		//       at edu.issi.machine.subassembly.SubassemblyHandler.run(SubassemblyHandler.java:12)
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
		new org.junit.runner.JUnitCore().run(SubassemblyHandlerTest.class);
	}
}