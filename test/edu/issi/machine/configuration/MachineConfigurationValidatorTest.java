package edu.issi.machine.configuration;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class MachineConfigurationValidatorTest {
    private File testFile;

    @Before
    public void setUp() throws Exception {
	testFile = new File("machineConfiguration.json");
	testFile.createNewFile();
    }

    @After
    public void tearDown() throws Exception {
	testFile.delete();
    }

    @Test
    public void test() {
	fail("Not yet implemented");
    }

}
