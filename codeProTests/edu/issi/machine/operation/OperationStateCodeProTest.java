package edu.issi.machine.operation;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>OperationStateTest</code> contains tests for the class <code>{@link OperationState}</code>.
 *
 * @generatedBy CodePro at 27.11.14 17:52
 * @author Dawid
 * @version $Revision: 1.0 $
 */
public class OperationStateCodeProTest {
	/**
	 * An instance of the class being tested.
	 *
	 * @see OperationState
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	private OperationState fixture1;

	/**
	 * An instance of the class being tested.
	 *
	 * @see OperationState
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	private OperationState fixture2;

	/**
	 * An instance of the class being tested.
	 *
	 * @see OperationState
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	private OperationState fixture3;

	/**
	 * Return an instance of the class being tested.
	 *
	 * @return an instance of the class being tested
	 *
	 * @see OperationState
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	public OperationState getFixture1()
		throws Exception {
		if (fixture1 == null) {
			fixture1 = new OperationState(Status.ERROR, 0);
		}
		return fixture1;
	}

	/**
	 * Return an instance of the class being tested.
	 *
	 * @return an instance of the class being tested
	 *
	 * @see OperationState
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	public OperationState getFixture2()
		throws Exception {
		if (fixture2 == null) {
			fixture2 = new OperationState(Status.OK, "0123456789");
		}
		return fixture2;
	}

	/**
	 * Return an instance of the class being tested.
	 *
	 * @return an instance of the class being tested
	 *
	 * @see OperationState
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	public OperationState getFixture3()
		throws Exception {
		if (fixture3 == null) {
			fixture3 = new OperationState(Status.OK, 1);
		}
		return fixture3;
	}

	/**
	 * Run the OperationState(Status) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testOperationState_1()
		throws Exception {
		Status status = Status.OK;

		OperationState result = new OperationState(status);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getDescription());
		assertEquals("[OK] ", result.getCompensatedStatus());
	}

	/**
	 * Run the OperationState(Status) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test(expected = java.lang.IllegalStateException.class)
	public void testOperationState_2()
		throws Exception {
		Status status = Status.ERROR;

		OperationState result = new OperationState(status);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the OperationState(Status) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test(expected = java.lang.IllegalStateException.class)
	public void testOperationState_3()
		throws Exception {
		Status status = Status.WARNING;

		OperationState result = new OperationState(status);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the OperationState(Status,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testOperationState_4()
		throws Exception {
		Status status = Status.ERROR;
		int stateCodeNumber = 0;

		OperationState result = new OperationState(status, stateCodeNumber);

		// add additional test code here
		assertNotNull(result);
		assertEquals("Blad numer: 0", result.getDescription());
		assertEquals("[ERROR] Blad numer: 0", result.getCompensatedStatus());
	}

	/**
	 * Run the OperationState(Status,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testOperationState_5()
		throws Exception {
		Status status = Status.OK;
		int stateCodeNumber = 1;

		OperationState result = new OperationState(status, stateCodeNumber);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getDescription());
		assertEquals("[OK] ", result.getCompensatedStatus());
	}

	/**
	 * Run the OperationState(Status,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testOperationState_6()
		throws Exception {
		Status status = Status.WARNING;
		int stateCodeNumber = 7;

		OperationState result = new OperationState(status, stateCodeNumber);

		// add additional test code here
		assertNotNull(result);
		assertEquals("Blad numer: 7", result.getDescription());
		assertEquals("[WARNING] Blad numer: 7", result.getCompensatedStatus());
	}

	/**
	 * Run the OperationState(Status,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testOperationState_7()
		throws Exception {
		Status status = Status.OK;
		int stateCodeNumber = 0;

		OperationState result = new OperationState(status, stateCodeNumber);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getDescription());
		assertEquals("[OK] ", result.getCompensatedStatus());
	}

	/**
	 * Run the OperationState(Status,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testOperationState_8()
		throws Exception {
		Status status = Status.WARNING;
		int stateCodeNumber = 1;

		OperationState result = new OperationState(status, stateCodeNumber);

		// add additional test code here
		assertNotNull(result);
		assertEquals("Blad numer: 1", result.getDescription());
		assertEquals("[WARNING] Blad numer: 1", result.getCompensatedStatus());
	}

	/**
	 * Run the OperationState(Status,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testOperationState_9()
		throws Exception {
		Status status = Status.ERROR;
		int stateCodeNumber = 7;

		OperationState result = new OperationState(status, stateCodeNumber);

		// add additional test code here
		assertNotNull(result);
		assertEquals("Blad numer: 7", result.getDescription());
		assertEquals("[ERROR] Blad numer: 7", result.getCompensatedStatus());
	}

	/**
	 * Run the OperationState(Status,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testOperationState_10()
		throws Exception {
		Status status = Status.WARNING;
		int stateCodeNumber = 0;

		OperationState result = new OperationState(status, stateCodeNumber);

		// add additional test code here
		assertNotNull(result);
		assertEquals("Blad numer: 0", result.getDescription());
		assertEquals("[WARNING] Blad numer: 0", result.getCompensatedStatus());
	}

	/**
	 * Run the OperationState(Status,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testOperationState_11()
		throws Exception {
		Status status = Status.ERROR;
		int stateCodeNumber = 1;

		OperationState result = new OperationState(status, stateCodeNumber);

		// add additional test code here
		assertNotNull(result);
		assertEquals("Blad numer: 1", result.getDescription());
		assertEquals("[ERROR] Blad numer: 1", result.getCompensatedStatus());
	}

	/**
	 * Run the OperationState(Status,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testOperationState_12()
		throws Exception {
		Status status = Status.OK;
		int stateCodeNumber = 7;

		OperationState result = new OperationState(status, stateCodeNumber);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getDescription());
		assertEquals("[OK] ", result.getCompensatedStatus());
	}

	/**
	 * Run the OperationState(Status,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testOperationState_13()
		throws Exception {
		Status status = Status.OK;
		String description = "0123456789";

		OperationState result = new OperationState(status, description);

		// add additional test code here
		assertNotNull(result);
		assertEquals("0123456789", result.getDescription());
		assertEquals("[OK] 0123456789", result.getCompensatedStatus());
	}

	/**
	 * Run the OperationState(Status,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testOperationState_14()
		throws Exception {
		Status status = Status.WARNING;
		String description = "0123456789";

		OperationState result = new OperationState(status, description);

		// add additional test code here
		assertNotNull(result);
		assertEquals("0123456789", result.getDescription());
		assertEquals("[WARNING] 0123456789", result.getCompensatedStatus());
	}

	/**
	 * Run the OperationState(Status,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testOperationState_15()
		throws Exception {
		Status status = Status.OK;
		String description = "";

		OperationState result = new OperationState(status, description);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getDescription());
		assertEquals("[OK] ", result.getCompensatedStatus());
	}

	/**
	 * Run the OperationState(Status,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testOperationState_16()
		throws Exception {
		Status status = Status.ERROR;
		String description = "0123456789";

		OperationState result = new OperationState(status, description);

		// add additional test code here
		assertNotNull(result);
		assertEquals("0123456789", result.getDescription());
		assertEquals("[ERROR] 0123456789", result.getCompensatedStatus());
	}

	/**
	 * Run the OperationState(Status,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test(expected = java.lang.IllegalStateException.class)
	public void testOperationState_17()
		throws Exception {
		Status status = Status.ERROR;
		String description = "";

		OperationState result = new OperationState(status, description);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the OperationState(Status,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test(expected = java.lang.IllegalStateException.class)
	public void testOperationState_18()
		throws Exception {
		Status status = Status.WARNING;
		String description = "";

		OperationState result = new OperationState(status, description);

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
	public void testEquals_fixture1_1()
		throws Exception {
		OperationState fixture = getFixture1();
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
		OperationState fixture = getFixture2();
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
	public void testEquals_fixture3_1()
		throws Exception {
		OperationState fixture = getFixture3();
		Object obj = new OperationState(Status.ERROR, 0);

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
		OperationState fixture = getFixture1();
		Object obj = new OperationState(Status.OK, "0123456789");

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
	public void testEquals_fixture2_2()
		throws Exception {
		OperationState fixture = getFixture2();
		Object obj = new OperationState(Status.OK, 1);

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
		OperationState fixture = getFixture1();
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
	public void testEquals_fixture2_3()
		throws Exception {
		OperationState fixture = getFixture2();
		Object obj = new OperationState(Status.ERROR, 0);

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
	public void testEquals_fixture3_2()
		throws Exception {
		OperationState fixture = getFixture3();
		Object obj = new OperationState(Status.OK, "0123456789");

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
		OperationState fixture = getFixture1();
		Object obj = new OperationState(Status.OK, 1);

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
	public void testEquals_fixture3_3()
		throws Exception {
		OperationState fixture = getFixture3();
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
	public void testEquals_fixture1_5()
		throws Exception {
		OperationState fixture = getFixture1();
		Object obj = new OperationState(Status.ERROR, 0);

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
	public void testEquals_fixture2_4()
		throws Exception {
		OperationState fixture = getFixture2();
		Object obj = new OperationState(Status.OK, "0123456789");

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
	public void testEquals_fixture3_4()
		throws Exception {
		OperationState fixture = getFixture3();
		Object obj = new OperationState(Status.OK, 1);

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
	public void testEquals_fixture2_5()
		throws Exception {
		OperationState fixture = getFixture2();
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
	public void testEquals_fixture3_5()
		throws Exception {
		OperationState fixture = getFixture3();
		Object obj = null;

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the String getCompensatedStatus() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testGetCompensatedStatus_fixture1_1()
		throws Exception {
		OperationState fixture = getFixture1();

		String result = fixture.getCompensatedStatus();

		// add additional test code here
		assertEquals("[ERROR] Blad numer: 0", result);
	}

	/**
	 * Run the String getCompensatedStatus() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testGetCompensatedStatus_fixture2_1()
		throws Exception {
		OperationState fixture = getFixture2();

		String result = fixture.getCompensatedStatus();

		// add additional test code here
		assertEquals("[OK] 0123456789", result);
	}

	/**
	 * Run the String getCompensatedStatus() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testGetCompensatedStatus_fixture3_1()
		throws Exception {
		OperationState fixture = getFixture3();

		String result = fixture.getCompensatedStatus();

		// add additional test code here
		assertEquals("[OK] ", result);
	}

	/**
	 * Run the String getDescription() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testGetDescription_fixture1_1()
		throws Exception {
		OperationState fixture = getFixture1();

		String result = fixture.getDescription();

		// add additional test code here
		assertEquals("Blad numer: 0", result);
	}

	/**
	 * Run the String getDescription() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testGetDescription_fixture2_1()
		throws Exception {
		OperationState fixture = getFixture2();

		String result = fixture.getDescription();

		// add additional test code here
		assertEquals("0123456789", result);
	}

	/**
	 * Run the String getDescription() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testGetDescription_fixture3_1()
		throws Exception {
		OperationState fixture = getFixture3();

		String result = fixture.getDescription();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Status getStatus() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testGetStatus_fixture1_1()
		throws Exception {
		OperationState fixture = getFixture1();

		Status result = fixture.getStatus();

		// add additional test code here
		assertNotNull(result);
		assertEquals("ERROR", result.name());
		assertEquals("ERROR", result.toString());
		assertEquals(2, result.ordinal());
	}

	/**
	 * Run the Status getStatus() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testGetStatus_fixture2_1()
		throws Exception {
		OperationState fixture = getFixture2();

		Status result = fixture.getStatus();

		// add additional test code here
		assertNotNull(result);
		assertEquals("OK", result.name());
		assertEquals("OK", result.toString());
		assertEquals(0, result.ordinal());
	}

	/**
	 * Run the Status getStatus() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testGetStatus_fixture3_1()
		throws Exception {
		OperationState fixture = getFixture3();

		Status result = fixture.getStatus();

		// add additional test code here
		assertNotNull(result);
		assertEquals("OK", result.name());
		assertEquals("OK", result.toString());
		assertEquals(0, result.ordinal());
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
		new org.junit.runner.JUnitCore().run(OperationStateCodeProTest.class);
	}
}