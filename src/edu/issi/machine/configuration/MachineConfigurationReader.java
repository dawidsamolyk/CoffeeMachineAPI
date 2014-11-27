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
     *            Katalog, z kt�rego zostanie odczytana konfiguracja i API.
     * @throws IOException
     *             Wyst�pi w przypadku b��d�w odczytu z pliku.
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
     * @return Obiekt reprezentuj�cy konfiguracj� maszyny.
     */
    public MachineConfiguration getMachineConfiguration() {
	return confifuration;
    }
}
