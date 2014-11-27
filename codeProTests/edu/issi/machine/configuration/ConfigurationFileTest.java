package edu.issi.machine.configuration;

import static org.junit.Assert.assertNotNull;

import java.io.File;

import javax.naming.directory.InvalidAttributesException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * The class <code>ConfigurationFileTest</code> contains tests for the class
 * <code>{@link ConfigurationFile}</code>.
 *
 * @generatedBy CodePro at 27.11.14 17:52
 * @author Dawid
 * @version $Revision: 1.0 $
 */
public class ConfigurationFileTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    /**
     * Run the ConfigurationFile(File) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test(expected = javax.naming.directory.InvalidAttributesException.class)
    public void testConfigurationFile_4() throws Exception {
	File file = File.createTempFile("0123456789", "0123456789");

	ConfigurationFile result = new ConfigurationFile(file);

	// add additional test code here
	assertNotNull(result);
    }

    /**
     * Run the ConfigurationFile(File) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test(expected = javax.naming.directory.InvalidAttributesException.class)
    public void testConfigurationFile_5() throws Exception {
	File file = File.createTempFile("0123456789", "0123456789", (File) null);

	ConfigurationFile result = new ConfigurationFile(file);

	// add additional test code here
	assertNotNull(result);
    }

    /**
     * Run the ConfigurationFile(File) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testConfigurationFile_6() throws Exception {
	File file = File.createTempFile("Ant-1.0.txt", "Ant-1.0.txt", (File) null);

	exception.expect(InvalidAttributesException.class);
	ConfigurationFile result = new ConfigurationFile(file);

	// add additional test code here
	assertNotNull(result);
    }

    /**
     * Run the ConfigurationFile(File) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test(expected = javax.naming.directory.InvalidAttributesException.class)
    public void testConfigurationFile_7() throws Exception {
	File file = new File("", "");

	ConfigurationFile result = new ConfigurationFile(file);

	// add additional test code here
	assertNotNull(result);
    }

    /**
     * Run the ConfigurationFile(File) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test(expected = java.io.FileNotFoundException.class)
    public void testConfigurationFile_8() throws Exception {
	File file = new File("");

	ConfigurationFile result = new ConfigurationFile(file);

	// add additional test code here
	assertNotNull(result);
    }

    /**
     * Run the ConfigurationFile(File) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test(expected = java.io.FileNotFoundException.class)
    public void testConfigurationFile_9() throws Exception {
	File file = new File("0123456789", "0123456789");

	ConfigurationFile result = new ConfigurationFile(file);

	// add additional test code here
	assertNotNull(result);
    }

    /**
     * Run the ConfigurationFile(File) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test(expected = java.io.FileNotFoundException.class)
    public void testConfigurationFile_10() throws Exception {
	File file = new File((File) null, "");

	ConfigurationFile result = new ConfigurationFile(file);

	// add additional test code here
	assertNotNull(result);
    }

    /**
     * Run the ConfigurationFile(File) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test(expected = java.io.FileNotFoundException.class)
    public void testConfigurationFile_11() throws Exception {
	File file = new File((File) null, "0123456789");

	ConfigurationFile result = new ConfigurationFile(file);

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
	new org.junit.runner.JUnitCore().run(ConfigurationFileTest.class);
    }
}