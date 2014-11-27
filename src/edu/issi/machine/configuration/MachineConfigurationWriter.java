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
    private Gson gson = new Gson();
    private File file;

    /**
     * @param file
     *            Plik, do którego zostanie zapisana konfiguracja.
     * @throws IOException
     *             Wyst¹pi, gdy plik nie
     */
    public MachineConfigurationWriter(File file) throws IOException {
	if (file.exists() == false && file.isFile() == false && isJsonFile(file)) {
	    throw new IOException("Niepoprawny plik docelowy!");
	}

	this.file = file;
    }

    /**
     * @param configuration
     *            Konfiguracja maszyny, która ma zostaæ zapisana.
     * @throws IOException
     *             Wyst¹pi w przypadku b³êdu zapisu pliku.
     */
    public void write(MachineConfiguration configuration) throws IOException {
	String json = getAsJson(configuration);
	writeToFile(json);
    }

    private void writeToFile(String json) throws IOException {
	FileWriter writer = new FileWriter(file);
	writer.write(json);
	writer.close();
    }

    private String getAsJson(MachineConfiguration configuration) {
	return gson.toJson(configuration);
    }

    private boolean isJsonFile(File file) {
	return file.getName().toLowerCase().endsWith(".json");
    }
}
