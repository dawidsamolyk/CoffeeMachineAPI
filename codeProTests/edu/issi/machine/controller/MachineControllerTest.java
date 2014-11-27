package edu.issi.machine.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * The class <code>MachineControllerTest</code> contains tests for the class
 * <code>{@link MachineController}</code>.
 *
 * @generatedBy CodePro at 27.11.14 17:52
 * @author Dawid
 * @version $Revision: 1.0 $
 */
public class MachineControllerTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    /**
     * An instance of the class being tested.
     *
     * @see MachineController
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    private MachineController fixture;

    /**
     * Return an instance of the class being tested.
     *
     * @return an instance of the class being tested
     *
     * @see MachineController
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    public MachineController getFixture() throws Exception {
	if (fixture == null) {
	    fixture = new MachineController();
	}
	return fixture;
    }

    /**
     * Run the void restart() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testRestart_fixture_1() throws Exception {
	MachineController fixture2 = getFixture();

	exception.expect(UnsupportedOperationException.class);
	fixture2.restart();

	// add additional test code here
	// An unexpected exception was thrown in user code while executing this
	// test:
	// java.lang.UnsupportedOperationException: Nie mo¿na uruchomiæ maszyny
	// bez ustawionej konfiguracji!
	// at
	// edu.issi.machine.controller.MachineController.run(MachineController.java:41)
	// at
	// edu.issi.machine.controller.MachineController.restart(MachineController.java:62)
    }

    /**
     * Run the void run() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testRun_fixture_1() throws Exception {
	MachineController fixture2 = getFixture();

	exception.expect(UnsupportedOperationException.class);
	fixture2.run();

	// add additional test code here
	// An unexpected exception was thrown in user code while executing this
	// test:
	// java.lang.UnsupportedOperationException: Nie mo¿na uruchomiæ maszyny
	// bez ustawionej konfiguracji!
	// at
	// edu.issi.machine.controller.MachineController.run(MachineController.java:41)
    }

    /**
     * Run the void stopWorking() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testStopWorking_fixture_1() throws Exception {
	MachineController fixture2 = getFixture();

	fixture2.stopWorking();

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
	new org.junit.runner.JUnitCore().run(MachineControllerTest.class);
    }
}