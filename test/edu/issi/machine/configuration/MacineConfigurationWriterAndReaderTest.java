package edu.issi.machine.configuration;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class MacineConfigurationWriterAndReaderTest {
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
    public void shouldWriteConfiguration() throws Exception {
	MachineConfiguration conf = MachineConfigurationTest.mockMachineConfiguration();

	MachineConfigurationWriter writer = new MachineConfigurationWriter(testFile);
	writer.write(conf);

	MachineConfigurationReader reader = new MachineConfigurationReader(testFile);
	
	assertTrue(conf.equals(reader.getMachineConfiguration()));
    }

}
