package edu.issi.exceptions;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * The class <code>ValidatorTest</code> contains tests for the class
 * <code>{@link Validator}</code>.
 *
 * @generatedBy CodePro at 27.11.14 17:52
 * @author Dawid
 * @version $Revision: 1.0 $
 */
public class ValidatorTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    /**
     * Run the void generateExceptionWhenObjectIsNotCreated(Object,String)
     * method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testGenerateExceptionWhenObjectIsNotCreated_1() throws Exception {
	Object object = "1";
	String exceptionMessage = "";

	Validator.generateExceptionWhenObjectIsNotCreated(object, exceptionMessage);

	// add additional test code here
    }

    /**
     * Run the void generateExceptionWhenObjectIsNotCreated(Object,String)
     * method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testGenerateExceptionWhenObjectIsNotCreated_2() throws Exception {
	Object object = "1";
	String exceptionMessage = "0123456789";

	Validator.generateExceptionWhenObjectIsNotCreated(object, exceptionMessage);

	// add additional test code here
    }

    /**
     * Run the void generateExceptionWhenObjectIsNotCreated(Object,String)
     * method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testGenerateExceptionWhenObjectIsNotCreated_3() throws Exception {
	Object object = null;
	String exceptionMessage = "0123456789";

	exception.expect(NoSuchElementException.class);
	Validator.generateExceptionWhenObjectIsNotCreated(object, exceptionMessage);

	// add additional test code here
    }

    /**
     * Run the void generateExceptionWhenObjectIsNotCreated(Object,String)
     * method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testGenerateExceptionWhenObjectIsNotCreated_4() throws Exception {
	Object object = null;
	String exceptionMessage = "";

	exception.expect(NoSuchElementException.class);
	Validator.generateExceptionWhenObjectIsNotCreated(object, exceptionMessage);

	// add additional test code here
    }

    /**
     * Run the void throwExceptionWhenEmpty(List<?>,String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testThrowExceptionWhenEmpty_1() throws Exception {
	List<Object> list = null;
	String exceptionMessage = "";

	exception.expect(IllegalArgumentException.class);
	Validator.throwExceptionWhenEmpty(list, exceptionMessage);

	// add additional test code here
    }

    /**
     * Run the void throwExceptionWhenEmpty(List<?>,String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testThrowExceptionWhenEmpty_2() throws Exception {
	List<Object> list = null;
	String exceptionMessage = "0123456789";

	exception.expect(IllegalArgumentException.class);
	Validator.throwExceptionWhenEmpty(list, exceptionMessage);

	// add additional test code here
    }

    /**
     * Run the void throwExceptionWhenEmpty(Object[],String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testThrowExceptionWhenEmpty_3() throws Exception {
	Object[] table = new Object[] { null };
	String exceptionMessage = "";

	exception.expect(IllegalArgumentException.class);
	Validator.throwExceptionWhenEmpty(table, exceptionMessage);

	// add additional test code here
    }

    /**
     * Run the void throwExceptionWhenEmpty(Object[],String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testThrowExceptionWhenEmpty_4() throws Exception {
	Object[] table = new Object[] {};
	String exceptionMessage = "0123456789";

	exception.expect(IllegalArgumentException.class);
	Validator.throwExceptionWhenEmpty(table, exceptionMessage);

	// add additional test code here
	// An unexpected exception was thrown in user code while executing this
	// test:
	// java.lang.IllegalStateException: 0123456789
	// at
	// edu.issi.exceptions.Validator.throwExceptionWhenEmpty(Validator.java:54)
    }

    /**
     * Run the void throwExceptionWhenEmpty(Object[],String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testThrowExceptionWhenEmpty_5() throws Exception {
	Object[] table = null;
	String exceptionMessage = "0123456789";

	exception.expect(IllegalArgumentException.class);
	Validator.throwExceptionWhenEmpty(table, exceptionMessage);

	// add additional test code here
	// An unexpected exception was thrown in user code while executing this
	// test:
	// java.lang.IllegalStateException: 0123456789
	// at
	// edu.issi.exceptions.Validator.throwExceptionWhenEmpty(Validator.java:54)
    }

    /**
     * Run the void throwExceptionWhenEmpty(Object[],String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testThrowExceptionWhenEmpty_6() throws Exception {
	Object[] table = new Object[] {};
	String exceptionMessage = "";

	exception.expect(IllegalArgumentException.class);
	Validator.throwExceptionWhenEmpty(table, exceptionMessage);

	// add additional test code here
	// An unexpected exception was thrown in user code while executing this
	// test:
	// java.lang.IllegalStateException:
	// at
	// edu.issi.exceptions.Validator.throwExceptionWhenEmpty(Validator.java:54)
    }

    /**
     * Run the void throwExceptionWhenEmpty(Object[],String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testThrowExceptionWhenEmpty_7() throws Exception {
	Object[] table = null;
	String exceptionMessage = "";

	exception.expect(IllegalArgumentException.class);
	Validator.throwExceptionWhenEmpty(table, exceptionMessage);

	// add additional test code here
	// An unexpected exception was thrown in user code while executing this
	// test:
	// java.lang.IllegalStateException:
	// at
	// edu.issi.exceptions.Validator.throwExceptionWhenEmpty(Validator.java:54)
    }

    /**
     * Run the void throwExceptionWhenEmpty(Object[],String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testThrowExceptionWhenEmpty_8() throws Exception {
	Object[] table = new Object[] { null };
	String exceptionMessage = "0123456789";

	exception.expect(IllegalArgumentException.class);
	Validator.throwExceptionWhenEmpty(table, exceptionMessage);

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
	new org.junit.runner.JUnitCore().run(ValidatorTest.class);
    }
}