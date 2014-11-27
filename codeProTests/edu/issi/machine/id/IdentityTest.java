package edu.issi.machine.id;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The class <code>IdentityTest</code> contains tests for the class
 * <code>{@link Identity}</code>.
 *
 * @generatedBy CodePro at 27.11.14 17:52
 * @author Dawid
 * @version $Revision: 1.0 $
 */
public class IdentityTest {
    /**
     * An instance of the class being tested.
     *
     * @see Identity
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    private Identity fixtureSAMPLE;

    /**
     * An instance of the class being tested.
     *
     * @see Identity
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    private Identity fixture;

    /**
     * Return an instance of the class being tested.
     *
     * @return an instance of the class being tested
     *
     * @see Identity
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    public Identity getFixtureSAMPLE() throws Exception {
	if (fixtureSAMPLE == null) {
	    fixtureSAMPLE = Identity.SAMPLE;
	}
	return fixtureSAMPLE;
    }

    /**
     * Return an instance of the class being tested.
     *
     * @return an instance of the class being tested
     *
     * @see Identity
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    public Identity getFixture() throws Exception {
	if (fixture == null) {
	    fixture = new Identity(0);
	}
	return fixture;
    }

    /**
     * Run the Identity(int) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testIdentity_1() throws Exception {
	int id = 0;

	Identity result = new Identity(id);

	// add additional test code here
	assertNotNull(result);
    }

    /**
     * Run the Identity(int) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testIdentity_2() throws Exception {
	int id = 1;

	Identity result = new Identity(id);

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
    public void testEquals_fixtureSAMPLE_1() throws Exception {
	Identity fixture2 = getFixtureSAMPLE();
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
    public void testEquals_fixture_1() throws Exception {
	Identity fixture2 = getFixture();
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
    public void testEquals_fixtureSAMPLE_2() throws Exception {
	Identity fixture2 = getFixtureSAMPLE();
	Object obj = Identity.SAMPLE;

	boolean result = fixture2.equals(obj);

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
    public void testEquals_fixture_2() throws Exception {
	Identity fixture2 = getFixture();
	Object obj = new Identity(0);

	boolean result = fixture2.equals(obj);

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
    public void testEquals_fixture_3() throws Exception {
	Identity fixture2 = getFixture();
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
    public void testEquals_fixtureSAMPLE_3() throws Exception {
	Identity fixture2 = getFixtureSAMPLE();
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
    public void testEquals_fixture_4() throws Exception {
	Identity fixture2 = getFixture();
	Object obj = Identity.SAMPLE;

	boolean result = fixture2.equals(obj);

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
    public void testEquals_fixtureSAMPLE_4() throws Exception {
	Identity fixture2 = getFixtureSAMPLE();
	Object obj = new Identity(0);

	boolean result = fixture2.equals(obj);

	// add additional test code here
	assertEquals(true, result);
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
	new org.junit.runner.JUnitCore().run(IdentityTest.class);
    }
}