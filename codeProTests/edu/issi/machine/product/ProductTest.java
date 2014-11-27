package edu.issi.machine.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.id.Identity;
import edu.issi.machine.product.ingredient.Ingredient;

/**
 * The class <code>ProductTest</code> contains tests for the class
 * <code>{@link Product}</code>.
 *
 * @generatedBy CodePro at 27.11.14 17:52
 * @author Dawid
 * @version $Revision: 1.0 $
 */
public class ProductTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    /**
     * An instance of the class being tested.
     *
     * @see Product
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    private Product fixture;

    /**
     * Return an instance of the class being tested.
     *
     * @return an instance of the class being tested
     *
     * @see Product
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    public Product getFixture() throws Exception {
	if (fixture == null) {
	    fixture = new Product(Identity.SAMPLE);
	}
	return fixture;
    }

    /**
     * Run the Product(Identity) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testProduct_1() throws Exception {
	Identity id = Identity.SAMPLE;

	Product result = new Product(id);

	// add additional test code here
	assertNotNull(result);
	assertEquals(0, result.numberOfElements());
    }

    /**
     * Run the Product(Identity) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testProduct_2() throws Exception {
	Identity id = new Identity(0);

	Product result = new Product(id);

	// add additional test code here
	assertNotNull(result);
	assertEquals(0, result.numberOfElements());
    }

    /**
     * Run the void addAt(int,Ingredient) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testAddAt_fixture_1() throws Exception {
	Product fixture2 = getFixture();
	int index = 0;
	Ingredient ingredient = new Ingredient(Identity.SAMPLE);

	exception.expect(UnsupportedOperationException.class);
	fixture2.addAt(index, ingredient);

	// add additional test code here
	// An unexpected exception was thrown in user code while executing this
	// test:
	// java.lang.UnsupportedOperationException: Nie mozna dodac elementu pod
	// indeksem 0!
	// at
	// edu.issi.machine.product.OrderedElementsList.addAt(OrderedElementsList.java:43)
	// at edu.issi.machine.product.Product.addAt(Product.java:62)
    }

    /**
     * Run the void addAt(int,Ingredient) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testAddAt_fixture_2() throws Exception {
	Product fixture2 = getFixture();
	int index = 1;
	Ingredient ingredient = new Ingredient(Identity.SAMPLE);

	exception.expect(UnsupportedOperationException.class);
	fixture2.addAt(index, ingredient);

	// add additional test code here
	// An unexpected exception was thrown in user code while executing this
	// test:
	// java.lang.UnsupportedOperationException: Nie mozna dodac elementu pod
	// indeksem 1!
	// at
	// edu.issi.machine.product.OrderedElementsList.addAt(OrderedElementsList.java:43)
	// at edu.issi.machine.product.Product.addAt(Product.java:62)
    }

    /**
     * Run the void addAt(int,Ingredient) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testAddAt_fixture_3() throws Exception {
	Product fixture2 = getFixture();
	int index = 7;
	Ingredient ingredient = new Ingredient(Identity.SAMPLE);

	exception.expect(UnsupportedOperationException.class);
	fixture2.addAt(index, ingredient);

	// add additional test code here
	// An unexpected exception was thrown in user code while executing this
	// test:
	// java.lang.UnsupportedOperationException: Nie mozna dodac elementu pod
	// indeksem 7!
	// at
	// edu.issi.machine.product.OrderedElementsList.addAt(OrderedElementsList.java:43)
	// at edu.issi.machine.product.Product.addAt(Product.java:62)
    }

    /**
     * Run the void addAtTheEnd(Ingredient) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testAddAtTheEnd_fixture_1() throws Exception {
	Product fixture2 = getFixture();
	Ingredient ingredient = new Ingredient(Identity.SAMPLE);

	fixture2.add(ingredient);

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
	Product fixture2 = getFixture();
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
	Product fixture2 = getFixture();
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
	Product fixture2 = getFixture();
	Object obj = new Product(Identity.SAMPLE);

	boolean result = fixture2.equals(obj);

	// add additional test code here
	assertEquals(true, result);
    }

    /**
     * Run the Ingredient getIngredientAt(int) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test(expected = java.util.NoSuchElementException.class)
    public void testGetIngredientAt_fixture_1() throws Exception {
	Product fixture2 = getFixture();
	int index = 0;

	Ingredient result = fixture2.getIngredientAt(index);

	// add additional test code here
	assertNotNull(result);
    }

    /**
     * Run the Ingredient getIngredientAt(int) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test(expected = java.util.NoSuchElementException.class)
    public void testGetIngredientAt_fixture_2() throws Exception {
	Product fixture2 = getFixture();
	int index = 1;

	Ingredient result = fixture2.getIngredientAt(index);

	// add additional test code here
	assertNotNull(result);
    }

    /**
     * Run the Ingredient getIngredientAt(int) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test(expected = java.util.NoSuchElementException.class)
    public void testGetIngredientAt_fixture_3() throws Exception {
	Product fixture2 = getFixture();
	int index = 7;

	Ingredient result = fixture2.getIngredientAt(index);

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
	Product fixture2 = getFixture();

	int result = fixture2.hashCode();

	// add additional test code here
	assertEquals(63, result);
    }

    /**
     * Run the Iterator<Ingredient> iterator() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testIterator_fixture_1() throws Exception {
	Product fixture2 = getFixture();

	Iterator<Ingredient> result = fixture2.iterator();

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
    public void testNumberOfElements_fixture_1() throws Exception {
	Product fixture2 = getFixture();

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
    @Test
    public void testRemoveAt_fixture_1() throws Exception {
	Product fixture2 = getFixture();
	int index = 0;

	exception.expect(NoSuchElementException.class);
	fixture2.removeAt(index);

	// add additional test code here
	// An unexpected exception was thrown in user code while executing this
	// test:
	// java.util.NoSuchElementException: Produkt nie zawiera elementu pod
	// podanym indeksem!
	// at
	// edu.issi.machine.product.OrderedElementsList.checkIsThereSuchElementAt(OrderedElementsList.java:87)
	// at
	// edu.issi.machine.product.OrderedElementsList.removeAt(OrderedElementsList.java:67)
	// at edu.issi.machine.product.Product.removeAt(Product.java:71)
    }

    /**
     * Run the void removeAt(int) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testRemoveAt_fixture_2() throws Exception {
	Product fixture2 = getFixture();
	int index = 1;

	exception.expect(NoSuchElementException.class);
	fixture2.removeAt(index);

	// add additional test code here
	// An unexpected exception was thrown in user code while executing this
	// test:
	// java.util.NoSuchElementException: Produkt nie zawiera elementu pod
	// podanym indeksem!
	// at
	// edu.issi.machine.product.OrderedElementsList.checkIsThereSuchElementAt(OrderedElementsList.java:87)
	// at
	// edu.issi.machine.product.OrderedElementsList.removeAt(OrderedElementsList.java:67)
	// at edu.issi.machine.product.Product.removeAt(Product.java:71)
    }

    /**
     * Run the void removeAt(int) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testRemoveAt_fixture_3() throws Exception {
	Product fixture2 = getFixture();
	int index = 7;

	exception.expect(NoSuchElementException.class);
	fixture2.removeAt(index);

	// add additional test code here
	// An unexpected exception was thrown in user code while executing this
	// test:
	// java.util.NoSuchElementException: Produkt nie zawiera elementu pod
	// podanym indeksem!
	// at
	// edu.issi.machine.product.OrderedElementsList.checkIsThereSuchElementAt(OrderedElementsList.java:87)
	// at
	// edu.issi.machine.product.OrderedElementsList.removeAt(OrderedElementsList.java:67)
	// at edu.issi.machine.product.Product.removeAt(Product.java:71)
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
	new org.junit.runner.JUnitCore().run(ProductTest.class);
    }
}