package edu.issi.machine;

import javax.naming.directory.InvalidAttributesException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * The class <code>ApplicationTest</code> contains tests for the class
 * <code>{@link Application}</code>.
 *
 * @generatedBy CodePro at 27.11.14 17:52
 * @author Dawid
 * @version $Revision: 1.0 $
 */
public class ApplicationCodeProTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    /**
     * Run the void main(String[]) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testMain_1() throws Exception {
	String[] args = new String[] {};

	exception.expect(InvalidAttributesException.class);
	Application.main(args);

	// add additional test code here
	// An unexpected exception was thrown in user code while executing this
	// test:
	// java.lang.IllegalStateException: Nieprawid³owe wywo³anie! Jako
	// argument podaj œcie¿kê do katalogu z plikami konfiguracyjnymi.
	// at edu.issi.machine.Application.main(Application.java:32)
    }

    /**
     * Run the void main(String[]) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testMain_2() throws Exception {
	String[] args = null;

	exception.expect(InvalidAttributesException.class);
	Application.main(args);

	// add additional test code here
	// An unexpected exception was thrown in user code while executing this
	// test:
	// java.lang.IllegalStateException: Nieprawid³owe wywo³anie! Jako
	// argument podaj œcie¿kê do katalogu z plikami konfiguracyjnymi.
	// at edu.issi.machine.Application.main(Application.java:32)
    }

    /**
     * Run the void main(String[]) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test(expected = java.io.FileNotFoundException.class)
    public void testMain_3() throws Exception {
	String[] args = new String[] { "0123456789" };

	Application.main(args);

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
	new org.junit.runner.JUnitCore().run(ApplicationCodeProTest.class);
    }
}