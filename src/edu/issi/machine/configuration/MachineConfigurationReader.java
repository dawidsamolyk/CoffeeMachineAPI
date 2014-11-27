package edu.issi.machine.configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

import edu.issi.machine.api.MachineApi;

/**
 * @author Dawid
 *
 */
public class MachineConfigurationReader {
    private final BufferedReader configurationReader;
    private final BufferedReader apiReader;
    private MachineConfiguration confifuration;
    private MachineApi api;

    /**
     * @param directory
     *            Katalog, z którego zostanie odczytana konfiguracja i API.
     * @throws FileNotFoundException
     *             Wyst¹pi, gdy plik z konfiguracj¹ nie zostanie odnaleziony.
     */
    public MachineConfigurationReader(FileSystemDirectory directory) throws FileNotFoundException {
	if (!containsRequiredFiles(directory)) {
	    throw new FileNotFoundException(
		    "W podanym katalogu nie znaleziono wymaganych plików konfiguracyjnych!");
	}

	this.apiReader = getReader(directory, ConfigurationFileName.API);
	this.configurationReader = getReader(directory, ConfigurationFileName.MACHINE_CONFIGURATION);
    }

    /**
     * @return Obiekt reprezentuj¹cy konfiguracjê maszyny.
     */
    public MachineConfiguration getMachineConfiguration() {
	if (confifuration == null) {
	    confifuration = new Gson().fromJson(configurationReader, MachineConfiguration.class);
	}
	return confifuration;
    }

    /**
     * @return Obiekt reprezentuj¹cy API maszyny.
     */
    public MachineApi getMachineApi() {
	if (api == null) {
	    api = new Gson().fromJson(apiReader, MachineApi.class);
	}
	return api;
    }

    private BufferedReader getReader(FileSystemDirectory directory, ConfigurationFileName fileName)
	    throws FileNotFoundException {
	File configurationFile = new File(directory + File.separator + fileName.toString());

	return new BufferedReader(new FileReader(configurationFile));
    }

    private boolean containsRequiredFiles(FileSystemDirectory directory) {
	return directory.contains(ConfigurationFileName.API)
		&& directory.contains(ConfigurationFileName.MACHINE_CONFIGURATION);
    }
}
