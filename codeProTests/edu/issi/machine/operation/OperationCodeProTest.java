package edu.issi.machine.operation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.subassembly.Subassembly;

/**
 * The class <code>OperationTest</code> contains tests for the class
 * <code>{@link Operation}</code>.
 *
 * @generatedBy CodePro at 27.11.14 17:52
 * @author Dawid
 * @version $Revision: 1.0 $
 */
public class OperationCodeProTest {
    /**
     * An instance of the class being tested.
     *
     * @see Operation
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    private Operation fixture;

    /**
     * Return an instance of the class being tested.
     *
     * @return an instance of the class being tested
     *
     * @see Operation
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    public Operation getFixture() throws Exception {
	if (fixture == null) {
	    fixture = new Operation((Method) null);
	}
	return fixture;
    }

    /**
     * Run the Operation(Method) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testOperation_1() throws Exception {
	Method apiMethod = null;

	Operation result = new Operation(apiMethod);

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
    public void testEquals_fixture_1() throws Exception {
	Operation fixture2 = getFixture();
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
	Operation fixture2 = getFixture();
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
	Operation fixture2 = getFixture();
	Object obj = new Operation((Method) null);

	boolean result = fixture2.equals(obj);

	// add additional test code here
	assertEquals(true, result);
    }

    /**
     * Run the OperationState execute() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testExecute_fixture_1() throws Exception {
	Operation fixture2 = getFixture();

	OperationState result = fixture2.execute();

	// add additional test code here
	assertNotNull(result);
	assertEquals("Nie podano podzespolu lub skladnika dla tej operacji!", result.getDescription());
	assertEquals("[ERROR] Nie podano podzespolu lub skladnika dla tej operacji!",
		result.getCompensatedStatus());
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
	Operation fixture2 = getFixture();

	int result = fixture2.hashCode();

	// add additional test code here
	assertEquals(29791, result);
    }

    /**
     * Run the Operation setIngredient(Ingredient) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testSetIngredient_fixture_1() throws Exception {
	Operation fixture2 = getFixture();
	Ingredient ingredient = null;

	Operation result = fixture2.setIngredient(ingredient);

	// add additional test code here
	assertNotNull(result);
    }

    /**
     * Run the Operation setSubassembly(Subassembly) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testSetSubassembly_fixture_1() throws Exception {
	Operation fixture2 = getFixture();
	Subassembly subassembly = null;

	Operation result = fixture2.setSubassembly(subassembly);

	// add additional test code here
	assertNotNull(result);
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
	new org.junit.runner.JUnitCore().run(OperationCodeProTest.class);
    }
}