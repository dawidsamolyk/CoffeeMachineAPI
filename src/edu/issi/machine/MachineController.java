package edu.issi.machine;

import edu.issi.machine.api.MachineApi;
import edu.issi.machine.configuration.MachineConfiguration;
import edu.issi.machine.configuration.MachineConfigurationReader;

/**
 * @author Dawid
 *
 */
public class MachineController extends Thread {
    private boolean working = false;
    private MachineConfiguration configuration;
    private MachineApi api = MachineApi.API;

    /**
     * @param configurationReader
     *            Wczytuje konfiguracjê z pliku.
     * 
     */
    public void setUpUsing(MachineConfigurationReader configurationReader) {
	UnsupportedOperationException throwWhenError = new UnsupportedOperationException(
		"Nie mo¿na zmieniæ konfiguracji w trakcie dzia³ania maszyny!");

	if (working == true && api != null) {
	    api.log(throwWhenError);

	} else if (working == true && api == null) {
	    throw throwWhenError;

	} else {
	    readConfiguration(configurationReader);
	}
    }

    private void readConfiguration(MachineConfigurationReader configurationReader) {
	configuration = configurationReader.getMachineConfiguration();
    }

    @Override
    public void run() {
	if (configuration == null || api == null) {
	    throw new UnsupportedOperationException(
		    "Nie mo¿na uruchomiæ maszyny bez ustawionej konfiguracji!");
	}
	this.working = true;

	api.log("START");
    }

    /**
     * 
     */
    public void stopWorking() {
	api.log("STOP");
	this.working = false;
    }

    /**
     * 
     */
    public void restart() {
	stopWorking();
	run();
    }
}
