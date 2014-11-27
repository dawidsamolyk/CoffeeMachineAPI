package edu.issi.machine.configuration;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class MacineConfigurationWriterAndReaderTest {

    @Test
    public void shouldWriteConfiguration() throws Exception {
	File file = new File("./bin/configuration.json");
	file.createNewFile();
	ConfigurationFile testDirectory = new ConfigurationFile(file);
	
	MachineConfiguration conf = MachineConfigurationTest.mockMachineConfiguration();

	MachineConfigurationWriter writer = new MachineConfigurationWriter(testDirectory);
	writer.write(conf);

	MachineConfigurationReader reader = new MachineConfigurationReader(testDirectory);

	assertTrue(conf.equals(reader.getMachineConfiguration()) );
    }
}
