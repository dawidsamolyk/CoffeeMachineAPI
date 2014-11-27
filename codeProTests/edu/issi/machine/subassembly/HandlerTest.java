package edu.issi.machine.subassembly;

import java.lang.reflect.Method;
import org.junit.*;
import static org.junit.Assert.*;
import edu.issi.machine.operation.Operation;

/**
 * The class <code>HandlerTest</code> contains tests for the class <code>{@link Handler}</code>.
 *
 * @generatedBy CodePro at 27.11.14 17:52
 * @author Dawid
 * @version $Revision: 1.0 $
 */
public class HandlerTest {
	/**
	 * An instance of the class being tested.
	 *
	 * @see Handler
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	private Handler fixture1;

	/**
	 * An instance of the class being tested.
	 *
	 * @see Handler
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	private Handler fixture2;

	/**
	 * Return an instance of the class being tested.
	 *
	 * @return an instance of the class being tested
	 *
	 * @see Handler
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	public Handler getFixture1()
		throws Exception {
		if (fixture1 == null) {
			fixture1 = new Handler();
		}
		return fixture1;
	}

	/**
	 * Return an instance of the class being tested.
	 *
	 * @return an instance of the class being tested
	 *
	 * @see Handler
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	public Handler getFixture2()
		throws Exception {
		if (fixture2 == null) {
			fixture2 = new Handler();
			fixture2.next(new Handler());
		}
		return fixture2;
	}

	/**
	 * Run the void doOperation(Operation) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testDoOperation_fixture1_1()
		throws Exception {
		Handler fixture = getFixture1();
		Operation operation = new Operation(Object.class.getMethods()[0]);

		fixture.doOperation(operation);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at edu.issi.machine.subassembly.Handler.doOperation(Handler.java:30)
	}

	/**
	 * Run the void doOperation(Operation) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testDoOperation_fixture2_1()
		throws Exception {
		Handler fixture = getFixture2();
		Operation operation = new Operation(Object.class.getMethods()[0]);

		fixture.doOperation(operation);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at edu.issi.machine.subassembly.Handler.doOperation(Handler.java:30)
		//       at edu.issi.machine.subassembly.Handler.doOperation(Handler.java:30)
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testEquals_fixture1_1()
		throws Exception {
		Handler fixture = getFixture1();
		Object obj = "1";

		boolean result = fixture.equals(obj);

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
	public void testEquals_fixture2_1()
		throws Exception {
		Handler fixture = getFixture2();
		Object obj = null;

		boolean result = fixture.equals(obj);

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
	public void testEquals_fixture1_2()
		throws Exception {
		Handler fixture = getFixture1();
		Object obj = new Handler();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testEquals_fixture2_2()
		throws Exception {
		Handler fixture = getFixture2();
		Handler obj = new Handler();
		obj.next(new Handler());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testEquals_fixture2_3()
		throws Exception {
		Handler fixture = getFixture2();
		Object obj = "1";

		boolean result = fixture.equals(obj);

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
	public void testEquals_fixture1_3()
		throws Exception {
		Handler fixture = getFixture1();
		Object obj = null;

		boolean result = fixture.equals(obj);

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
	public void testEquals_fixture2_4()
		throws Exception {
		Handler fixture = getFixture2();
		Object obj = new Handler();

		boolean result = fixture.equals(obj);

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
	public void testEquals_fixture1_4()
		throws Exception {
		Handler fixture = getFixture1();
		Handler obj = new Handler();
		obj.next(new Handler());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testHashCode_fixture1_1()
		throws Exception {
		Handler fixture = getFixture1();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(961, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testHashCode_fixture2_1()
		throws Exception {
		Handler fixture = getFixture2();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(30752, result);
	}

	/**
	 * Run the Handler next(Handler) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testNext_fixture1_1()
		throws Exception {
		Handler fixture = getFixture1();
		Handler handler = null;

		Handler result = fixture.next(handler);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Handler next(Handler) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testNext_fixture2_1()
		throws Exception {
		Handler fixture = getFixture2();
		Handler handler = null;

		Handler result = fixture.next(handler);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the void run() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testRun_fixture1_1()
		throws Exception {
		Handler fixture = getFixture1();

		fixture.run();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.UnsupportedOperationException: Nie mo¿na wykonaæ pustej operacji!
		//       at edu.issi.machine.subassembly.Handler.run(Handler.java:36)
	}

	/**
	 * Run the void run() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testRun_fixture2_1()
		throws Exception {
		Handler fixture = getFixture2();

		fixture.run();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.UnsupportedOperationException: Nie mo¿na wykonaæ pustej operacji!
		//       at edu.issi.machine.subassembly.Handler.run(Handler.java:36)
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
		new org.junit.runner.JUnitCore().run(HandlerTest.class);
	}
}