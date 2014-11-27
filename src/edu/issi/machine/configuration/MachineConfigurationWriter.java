package edu.issi.machine.configuration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

/**
 * @author Dawid
 *
 */
public class MachineConfigurationWriter {
    private File configurationFile;

    /**
     * @param file
     *            Folder, do kt�rego zostanie zapisana konfiguracja.
     * @throws IOException
     *             Wyst�pi, gdy plik nie istnieje lub ma niepoprawny typ (inny
     *             ni� json).
     */
    public MachineConfigurationWriter(ConfigurationFile file) throws IOException {
	this.configurationFile = file;
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

    private String getAsJson(Object object) {
	return new Gson().toJson(object);
    }

    private void write(String json, File file) throws IOException {
	FileWriter writer = new FileWriter(file);
	writer.write(json);
	writer.close();
    }
}
