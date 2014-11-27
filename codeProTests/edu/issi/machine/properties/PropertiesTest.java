package edu.issi.machine.properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.issi.machine.id.Identity;

/**
 * The class <code>PropertiesTest</code> contains tests for the class
 * <code>{@link Properties}</code>.
 *
 * @generatedBy CodePro at 27.11.14 17:52
 * @author Dawid
 * @version $Revision: 1.0 $
 */
public class PropertiesTest {
    /**
     * An instance of the class being tested.
     *
     * @see Properties
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    private Properties fixture;

    /**
     * Return an instance of the class being tested.
     *
     * @return an instance of the class being tested
     *
     * @see Properties
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    public Properties getFixture() throws Exception {
	if (fixture == null) {
	    fixture = new Properties();
	}
	return fixture;
    }

    /**
     * Run the Properties() constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testProperties_1() throws Exception {

	Properties result = new Properties();

	// add additional test code here
	assertNotNull(result);
    }

    /**
     * Run the void add(Identity,Object) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testAdd_fixture_1() throws Exception {
	Properties fixture2 = getFixture();
	Identity key = Identity.SAMPLE;
	Object value = new Object();

	fixture2.add(key, value);

	// add additional test code here
    }

    /**
     * Run the void add(Identity,Object) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testAdd_fixture_2() throws Exception {
	Properties fixture2 = getFixture();
	Identity key = new Identity(0);
	Object value = null;

	fixture2.add(key, value);

	// add additional test code here
    }

    /**
     * Run the void add(Identity,Object) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testAdd_fixture_3() throws Exception {
	Properties fixture2 = getFixture();
	Identity key = new Identity(0);
	Object value = new Object();

	fixture2.add(key, value);

	// add additional test code here
    }

    /**
     * Run the void add(Identity,Object) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testAdd_fixture_4() throws Exception {
	Properties fixture2 = getFixture();
	Identity key = Identity.SAMPLE;
	Object value = null;

	fixture2.add(key, value);

	// add additional test code here
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
	Properties fixture2 = getFixture();
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
    public void testEquals_fixture_2() throws Exception {
	Properties fixture2 = getFixture();
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
    public void testEquals_fixture_3() throws Exception {
	Properties fixture2 = getFixture();
	Object obj = new Properties();

	boolean result = fixture2.equals(obj);

	// add additional test code here
	assertEquals(true, result);
    }

    /**
     * Run the Object get(Identity) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test(expected = java.util.NoSuchElementException.class)
    public void testGet_fixture_1() throws Exception {
	Properties fixture2 = getFixture();
	Identity key = Identity.SAMPLE;

	Object result = fixture2.get(key);

	// add additional test code here
	assertNotNull(result);
    }

    /**
     * Run the Object get(Identity) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test(expected = java.util.NoSuchElementException.class)
    public void testGet_fixture_2() throws Exception {
	Properties fixture2 = getFixture();
	Identity key = new Identity(0);

	Object result = fixture2.get(key);

	// add additional test code here
	assertNotNull(result);
    }

    /**
     * Run the int hashCode() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testHashCode_fixture_1() throws Exception {
	Properties fixture2 = getFixture();

	int result = fixture2.hashCode();

	// add additional test code here
	assertEquals(31, result);
    }

    /**
     * Run the Iterator<java.util.Map.Entry<Identity, Object>> iterator() method
     * test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testIterator_fixture_1() throws Exception {
	Properties fixture2 = getFixture();

	Iterator<java.util.Map.Entry<Identity, Object>> result = fixture2.iterator();

	// add additional test code here
	assertNotNull(result);
	assertEquals(false, result.hasNext());
    }

    /**
     * Run the void remove(Identity) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testRemove_fixture_1() throws Exception {
	Properties fixture2 = getFixture();
	Identity key = Identity.SAMPLE;

	fixture2.remove(key);

	// add additional test code here
    }

    /**
     * Run the void remove(Identity) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testRemove_fixture_2() throws Exception {
	Properties fixture2 = getFixture();
	Identity key = new Identity(0);

	fixture2.remove(key);

	// add additional test code here
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
	new org.junit.runner.JUnitCore().run(PropertiesTest.class);
    }
}