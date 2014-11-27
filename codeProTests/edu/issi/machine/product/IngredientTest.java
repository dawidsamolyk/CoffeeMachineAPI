package edu.issi.machine.product;

import org.junit.*;
import static org.junit.Assert.*;
import edu.issi.machine.id.Identity;

/**
 * The class <code>IngredientTest</code> contains tests for the class <code>{@link Ingredient}</code>.
 *
 * @generatedBy CodePro at 27.11.14 17:52
 * @author Dawid
 * @version $Revision: 1.0 $
 */
public class IngredientTest {
	/**
	 * Run the Ingredient(Identity) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testIngredient_1()
		throws Exception {
		Identity id = Identity.SAMPLE;

		Ingredient result = new Ingredient(id);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Ingredient(Identity) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 27.11.14 17:52
	 */
	@Test
	public void testIngredient_2()
		throws Exception {
		Identity id = new Identity(0);

		Ingredient result = new Ingredient(id);

		// add additional test code here
		assertNotNull(result);
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
		new org.junit.runner.JUnitCore().run(IngredientTest.class);
	}
}