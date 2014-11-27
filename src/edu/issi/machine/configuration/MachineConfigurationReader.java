package edu.issi.machine.configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

/**
 * @author Dawid
 *
 */
public class MachineConfigurationReader {
    private MachineConfiguration confifuration;

    /**
     * @param file
     *            Katalog, z którego zostanie odczytana konfiguracja i API.
     * @throws IOException
     *             Wyst¹pi w przypadku b³êdów odczytu z pliku.
     */
    public MachineConfigurationReader(ConfigurationFile file) throws IOException {
	confifuration = readMachineConfiguration(file);
    }

    private MachineConfiguration readMachineConfiguration(ConfigurationFile file) throws IOException {
	BufferedReader configurationReader = new BufferedReader(new FileReader(file));

	MachineConfiguration result = new Gson().fromJson(configurationReader, MachineConfiguration.class);

	configurationReader.close();

	return result;
    }

    /**
     * @return Obiekt reprezentuj¹cy konfiguracjê maszyny.
     */
    public MachineConfiguration getMachineConfiguration() {
	return confifuration;
    }
}
