package edu.issi.machine.configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

/**
 * @author Dawid
 *
 */
public class MachineConfigurationReader {
    private BufferedReader br;
    private MachineConfiguration confifuration;

    /**
     * @param file
     *            Plik, z kt�rego ma by� odczytana konfiguracja.
     * @throws FileNotFoundException
     *             Wyst�pi, gdy plik z konfiguracj� nie zostanie odnaleziony.
     */
    public MachineConfigurationReader(File file) throws FileNotFoundException {
	this.br = new BufferedReader(new FileReader(file));
    }

    /**
     * @return Obiekt reprezentuj�cy konfiguracj� maszyny.
     */
    public MachineConfiguration getMachineConfiguration() {
	if (confifuration == null) {
	    confifuration = new Gson().fromJson(br, MachineConfiguration.class);
	}

	return confifuration;
    }

}
