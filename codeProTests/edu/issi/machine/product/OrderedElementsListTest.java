package edu.issi.machine.product;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>OrderedElementsListTest</code> contains tests for the class <code>{@link OrderedElementsList}</code>.
 *
 * @generatedBy CodePro at 27.11.14 17:52
 * @author Dawid
 * @version $Revision: 1.0 $
 */
public class OrderedElementsListTest {
	/**
	 * An instance of the class being tested.
	 *
	 * @see OrderedElementsList
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	private OrderedElementsList fixture;

	/**
	 * Return an instance of the class being tested.
	 *
	 * @return an instance of the class being tested
	 *
	 * @see OrderedElementsList
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	public OrderedElementsList getFixture()
		throws Exception {
		if (fixture == null) {
			fixture = new OrderedElementsList();
		}
		return fixture;
	}

	/**
	 * Run the OrderedElementsList() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testOrderedElementsList_1()
		throws Exception {

		OrderedElementsList result = new OrderedElementsList();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.numberOfElements());
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
		OrderedElementsList fixture2 = getFixture();
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
		OrderedElementsList fixture2 = getFixture();
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
		OrderedElementsList fixture2 = getFixture();
		Object obj = new OrderedElementsList();

		boolean result = fixture2.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the Object getElementAt(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test(expected = java.util.NoSuchElementException.class)
	public void testGetElementAt_fixture_1()
		throws Exception {
		OrderedElementsList fixture2 = getFixture();
		int index = 0;

		Object result = fixture2.getElementAt(index);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Object getElementAt(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test(expected = java.util.NoSuchElementException.class)
	public void testGetElementAt_fixture_2()
		throws Exception {
		OrderedElementsList fixture2 = getFixture();
		int index = 1;

		Object result = fixture2.getElementAt(index);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Object getElementAt(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test(expected = java.util.NoSuchElementException.class)
	public void testGetElementAt_fixture_3()
		throws Exception {
		OrderedElementsList fixture2 = getFixture();
		int index = 7;

		Object result = fixture2.getElementAt(index);

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
	public void testHashCode_fixture_1()
		throws Exception {
		OrderedElementsList fixture2 = getFixture();

		int result = fixture2.hashCode();

		// add additional test code here
		assertEquals(32, result);
	}

	/**
	 * Run the Iterator<Object> iterator() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testIterator_fixture_1()
		throws Exception {
		OrderedElementsList fixture2 = getFixture();

		Iterator<Object> result = fixture2.iterator();

		// add additional test code here
		assertNotNull(result);
		assertEquals(false, result.hasNext());
	}

	/**
	 * Run the int numberOfElements() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testNumberOfElements_fixture_1()
		throws Exception {
		OrderedElementsList fixture2 = getFixture();

		int result = fixture2.numberOfElements();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the void removeAt(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test(expected = java.util.NoSuchElementException.class)
	public void testRemoveAt_fixture_1()
		throws Exception {
		OrderedElementsList fixture2 = getFixture();
		int index = 0;

		fixture2.removeAt(index);

		// add additional test code here
	}

	/**
	 * Run the void removeAt(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test(expected = java.util.NoSuchElementException.class)
	public void testRemoveAt_fixture_2()
		throws Exception {
		OrderedElementsList fixture2 = getFixture();
		int index = 1;

		fixture2.removeAt(index);

		// add additional test code here
	}

	/**
	 * Run the void removeAt(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test(expected = java.util.NoSuchElementException.class)
	public void testRemoveAt_fixture_3()
		throws Exception {
		OrderedElementsList fixture2 = getFixture();
		int index = 7;

		fixture2.removeAt(index);

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
		new org.junit.runner.JUnitCore().run(OrderedElementsListTest.class);
	}
}