package edu.issi.machine.controller;

import java.util.Iterator;

import edu.issi.machine.Validator;
import edu.issi.machine.configuration.MachineConfiguration;
import edu.issi.machine.subassembly.Subassembly;

/**
 * @author Dawid Samo³yk
 *
 *         Kontroler maszyny, który pozwala na jej uruchomienie i zatrzymanie, z
 *         predefiniowan¹ konfiguracj¹.
 */
public class MachineController {
    protected MachineConfiguration configuration;
    protected boolean working = false;

    /**
     * @param configuration
     *            Konfiguracja maszyny.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli konfiguracja maszyny bêdzie niepoprawna.
     */
    public MachineController(MachineConfiguration configuration) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(configuration, "Brak konfiguracji do ustawienia!");

	this.configuration = configuration;
    }

    /**
     * Uruchomienie maszyny.
     */
    public void start() {
	startAllSubassemblies();

	working = true;
    }

    protected void startAllSubassemblies() {
	Iterator<Subassembly> subassemblies = configuration.subassemblies();

	while (subassemblies.hasNext()) {
	    Subassembly subassembly = subassemblies.next();
	    subassembly.run();
	}
    }

    /**
     * Zatrzymanie maszyny.
     */
    public void stop() {
	stopAllSubassemblies();

	working = false;
    }

    protected void stopAllSubassemblies() {
	Iterator<Subassembly> subassemblies = configuration.subassemblies();

	while (subassemblies.hasNext()) {
	    Subassembly subassembly = subassemblies.next();
	    subassembly.stop();
	}
    }

    /**
     * Ponowne uruchomienie maszyny.
     */
    public void restart() {
	if (working) {
	    stop();
	    start();
	}
	else {
	    start();
	}

    }
}
