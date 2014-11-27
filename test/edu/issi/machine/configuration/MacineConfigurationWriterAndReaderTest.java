package edu.issi.machine.configuration;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import edu.issi.machine.api.MachineApi;

@SuppressWarnings("javadoc")
public class MacineConfigurationWriterAndReaderTest {

    @Test
    public void shouldWriteConfiguration() throws Exception {
	FileSystemDirectory testDirectory = new FileSystemDirectory(new File("./bin"));
	
	MachineConfiguration conf = MachineConfigurationTest.mockMachineConfiguration();
	MachineApi api = MachineApi.API;

	MachineConfigurationWriter writer = new MachineConfigurationWriter(testDirectory);
	writer.write(conf);
	writer.write(api);

	MachineConfigurationReader reader = new MachineConfigurationReader(testDirectory);

	assertTrue(conf.equals(reader.getMachineConfiguration()) );
	assertTrue(api.equals(reader.getMachineApi()));
    }

}
