package edu.issi.machine.controller;

import edu.issi.machine.api.ExampleApi;
import edu.issi.machine.configuration.MachineConfiguration;
import edu.issi.machine.configuration.MachineConfigurationReader;

/**
 * @author Dawid
 *
 */
public class MachineController extends Thread {
    private boolean working = false;
    private MachineConfiguration configuration;
    /**
     * 
     */
    public static ExampleApi API = ExampleApi.API;

    /**
     * @param configurationReader
     *            Wczytuje konfiguracjê z pliku.
     * 
     */
    public void setUpUsing(MachineConfigurationReader configurationReader) {
	if (working) {
	    API.log(new UnsupportedOperationException(
		    "Nie mo¿na zmieniæ konfiguracji w trakcie dzia³ania maszyny!"));
	    
	} else {
	    readConfiguration(configurationReader);
	}
    }

    private void readConfiguration(MachineConfigurationReader configurationReader) {
	configuration = configurationReader.getMachineConfiguration();
    }

    @Override
    public void run() {
	if (configuration == null) {
	    throw new UnsupportedOperationException(
		    "Nie mo¿na uruchomiæ maszyny bez ustawionej konfiguracji!");
	}
	working = true;

	API.log("START");
    }

    /**
     * 
     */
    public void stopWorking() {
	API.log("STOP");
	working = false;
    }

    /**
     * 
     */
    public void restart() {
	stopWorking();
	run();
    }
}
