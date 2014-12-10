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
	private final MachineConfiguration confifuration;

	/**
	 * @param file
	 *            Katalog, z którego zostanie odczytana konfiguracja i API.
	 * @throws IOException
	 *             Wystąpi w przypadku błędów odczytu z pliku.
	 */
	public MachineConfigurationReader(ConfigurationFile file)
			throws IOException {
		confifuration = readMachineConfigurationFromFile(file);
	}

	private MachineConfiguration readMachineConfigurationFromFile(
			ConfigurationFile file) throws IOException {
		final BufferedReader configurationReader = new BufferedReader(
				new FileReader(file));

		final MachineConfiguration result = readMachineConfiguration(configurationReader);

		configurationReader.close();

		return result;
	}

	private MachineConfiguration readMachineConfiguration(
			BufferedReader configurationReader) {
		final MachineConfiguration result = new Gson().fromJson(
				configurationReader, MachineConfiguration.class);

		result.ensureValidity();

		return result;
	}

	/**
	 * @return Obiekt reprezentujący konfigurację maszyny.
	 */
	public MachineConfiguration getMachineConfiguration() {
		return confifuration;
	}
}
