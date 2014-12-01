package edu.issi.machine.configuration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Dawid
 *
 */
public class MachineConfigurationWriter {
    private final ConfigurationFile configurationFile;

    /**
     * @param file
     *            Plik, do kt�rego zostanie zapisana konfiguracja.
     */
    public MachineConfigurationWriter(ConfigurationFile file) {
	configurationFile = file;
    }

    private String getAsJson(Object object) {
	return jsonCreator().toJson(object);
    }

    private Gson jsonCreator() {
	return new GsonBuilder().setPrettyPrinting().create();
    }

    /**
     * @param configuration
     *            Konfiguracja maszyny, kt�ra ma zosta� zapisana.
     * @throws IOException
     *             Wyst�pi w przypadku b��du zapisu pliku.
     */
    public void write(MachineConfiguration configuration) throws IOException {
	final String json = getAsJson(configuration);
	write(json, configurationFile);
    }

    private void write(String json, File file) throws IOException {
	final BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	writer.write(json);
	writer.close();
    }
}
