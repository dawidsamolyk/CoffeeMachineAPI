package edu.issi.machine.id;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>ObjectWithIdentityTest</code> contains tests for the class <code>{@link ObjectWithIdentity}</code>.
 *
 * @generatedBy CodePro at 27.11.14 17:52
 * @author Dawid
 * @version $Revision: 1.0 $
 */
public class ObjectWithIdentityTest {
	/**
	 * An instance of the class being tested.
	 *
	 * @see ObjectWithIdentity
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	private ObjectWithIdentity fixture;

	/**
	 * Return an instance of the class being tested.
	 *
	 * @return an instance of the class being tested
	 *
	 * @see ObjectWithIdentity
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	public ObjectWithIdentity getFixture()
		throws Exception {
		if (fixture == null) {
			fixture = new ObjectWithIdentity((Identity) null);
		}
		return fixture;
	}

	/**
	 * Run the ObjectWithIdentity(Identity) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testObjectWithIdentity_1()
		throws Exception {
		Identity id = null;

		ObjectWithIdentity result = new ObjectWithIdentity(id);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testEquals_fixture_1()
		throws Exception {
		ObjectWithIdentity fixture2 = getFixture();
		Object obj = "1";

		boolean result = fixture2.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testEquals_fixture_2()
		throws Exception {
		ObjectWithIdentity fixture2 = getFixture();
		Object obj = null;

		boolean result = fixture2.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testEquals_fixture_3()
		throws Exception {
		ObjectWithIdentity fixture2 = getFixture();
		Object obj = new ObjectWithIdentity((Identity) null);

		boolean result = fixture2.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testHashCode_fixture_1()
		throws Exception {
		ObjectWithIdentity fixture2 = getFixture();

		int result = fixture2.hashCode();

		// add additional test code here
		assertEquals(31, result);
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
		new org.junit.runner.JUnitCore().run(ObjectWithIdentityTest.class);
	}
}