package edu.issi.machine.controller;

import java.util.Iterator;

import edu.issi.machine.Validator;
import edu.issi.machine.configuration.MachineConfiguration;
import edu.issi.machine.subassembly.Subassembly;

/**
 * @author Dawid Samo�yk
 *
 *         Kontroler maszyny, kt�ry pozwala na jej uruchomienie i zatrzymanie, z
 *         predefiniowan� konfiguracj�.
 */
public class MachineController {
    private final MachineConfiguration configuration;
    private boolean working = false;

    /**
     * Konstruktor. Obiekt MachineConfiguration jest wymagany.
     * 
     * @param configuration
     *            Konfiguracja maszyny.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li konfiguracja maszyny b�dzie niepoprawna.
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
	for (Iterator<Subassembly> subassemblies = configuration.getSubassembliesIterator(); subassemblies.hasNext();) {
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
	for (Iterator<Subassembly> subassemblies = configuration.getSubassembliesIterator(); subassemblies.hasNext();) {
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

    /**
     * Funkcja wskazuj�ca czy maszyna zosta�a uruchomiona.
     * 
     * @return Wskazuje czy maszyna jest uruchomiona.
     */
    public boolean isWorking() {
	return working;
    }
}
