package edu.issi.machine.controller;

import java.util.Iterator;

import edu.issi.machine.configuration.MachineConfiguration;
import edu.issi.machine.subassembly.Subassembly;

/**
 * @author Dawid
 *
 */
public class MachineController {
    protected MachineConfiguration configuration;
    protected boolean working = false;

    /**
     * @param configuration
     *            Konfiguracja maszyny.
     * 
     */
    public void setUpUsing(MachineConfiguration configuration) throws IllegalStateException {
	if (working) {
	    throw new UnsupportedOperationException(
		    "Nie mo¿na zmieniæ konfiguracji maszyny, gdy jest ona w³¹czona!");
	}
	else if (configuration != null) {
	    configuration.ensureValidity();
	    this.configuration = configuration;
	}
	else {
	    throw new UnsupportedOperationException("Brak konfiguracji do ustawienia!");
	}
    }

    /**
     * @param configuration
     *            Konfiguracja maszyny.
     * 
     */
    public void tearDown() {
	if (working) {
	    throw new UnsupportedOperationException(
		    "Nie mo¿na deinicjalizowaæ maszyny, gdy jest ona w³¹czona!");
	}
	else if (configuration == null) {
	    throw new UnsupportedOperationException(
		    "Nie mo¿na deinicjalizowaæ maszyny, poniewa¿ nie zosta³a ona w³¹czona!");
	}
	else {
	    configuration = null;
	}
    }

    public void start() {
	if (configuration == null) {
	    throw new UnsupportedOperationException(
		    "Nie mo¿na uruchomiæ maszyny bez ustawionej konfiguracji!");
	}
	else {
	    startAllSubassemblies();

	    working = true;
	}
    }

    protected void startAllSubassemblies() {
	Iterator<Subassembly> subassemblies = configuration.subassemblies();

	while (subassemblies.hasNext()) {
	    Subassembly subassembly = subassemblies.next();
	    subassembly.run();
	}
    }

    /**
     * 
     */
    public void stop() {
	working = false;
    }

    /**
     * 
     */
    public void restart() {
	stop();
	start();
    }
}
