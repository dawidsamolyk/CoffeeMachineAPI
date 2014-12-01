package edu.issi.machine.controller;

import edu.issi.machine.api.Api;
import edu.issi.machine.configuration.MachineConfiguration;
import edu.issi.machine.configuration.MachineConfigurationReader;

/**
 * @author Dawid
 *
 */
public class MachineController extends Thread {
    private final Api api;
    
    private boolean working = false;
    private MachineConfiguration configuration;

    /**
     * @param api
     *            API.
     */
    public MachineController(Api api) {
	this.api = api;
    }

    /**
     * @param configurationReader
     *            Wczytuje konfiguracjê z pliku.
     * 
     */
    public void setUpUsing(MachineConfigurationReader configurationReader) {
	if (working) {
	    api.logError(new UnsupportedOperationException(
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

	api.log("START");
    }

    /**
     * 
     */
    public void stopWorking() {
	api.log("STOP");
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
