package edu.issi.machine.configuration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import edu.issi.machine.api.MachineApi;

/**
 * @author Dawid
 *
 */
public class MachineConfigurationWriter {
    private Gson gson = new Gson();
    private File apiFile;
    private File configurationFile;

    /**
     * @param directory
     *            Folder, do kt�rego zostanie zapisana konfiguracja.
     * @throws IOException
     *             Wyst�pi, gdy plik nie istnieje lub ma niepoprawny typ (inny
     *             ni� json).
     */
    public MachineConfigurationWriter(FileSystemDirectory directory) throws IOException {
	this.apiFile = createFileInDirectory(directory, ConfigurationFileName.API);
	this.configurationFile = createFileInDirectory(directory, ConfigurationFileName.MACHINE_CONFIGURATION);
    }

    private File createFileInDirectory(FileSystemDirectory directory, ConfigurationFileName filename) throws IOException {
	File file = new File(directory + File.separator + filename.toString());
	
	if (file.exists() == false) {
	    file.createNewFile();
	}
	
	return file;
    }

    /**
     * @param configuration
     *            Konfiguracja maszyny, kt�ra ma zosta� zapisana.
     * @throws IOException
     *             Wyst�pi w przypadku b��du zapisu pliku.
     */
    public void write(MachineConfiguration configuration) throws IOException {
	String json = getAsJson(configuration);
	write(json, configurationFile);
    }

    /**
     * @param api
     *            API, kt�re ma zosta� zapisane.
     * @throws IOException
     *             Wyst�pi w przypadku b��du zapisu pliku.
     */
    public void write(MachineApi api) throws IOException {
	String json = getAsJson(api);
	write(json, apiFile);
    }

    private String getAsJson(Object object) {
	return gson.toJson(object);
    }

    private void write(String json, File file) throws IOException {
	FileWriter writer = new FileWriter(file);
	writer.write(json);
	writer.close();
    }
}
