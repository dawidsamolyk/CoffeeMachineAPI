package edu.issi.machine.controller;

import java.util.Iterator;

import edu.issi.machine.Validator;
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
     * @throws IllegalArgumentException
     */
    public MachineController(MachineConfiguration configuration) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(configuration, "Brak konfiguracji do ustawienia!");

	this.configuration = configuration;
    }

    /**
     * 
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
     * 
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
     * 
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
