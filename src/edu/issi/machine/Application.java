package edu.issi.machine;

import java.io.File;
import java.io.IOException;

import javax.naming.directory.InvalidAttributesException;

import edu.issi.machine.configuration.ConfigurationFile;
import edu.issi.machine.configuration.MachineConfigurationReader;

/**
 * @author Dawid
 *
 */
public class Application {

    /**
     * @param args
     *            Argumenty wejœciowe aplikacji.
     * @throws IOException
     *             Wyst¹pi w przypadku b³êdów odczytu/zapisu przy operacjach na
     *             plikach.
     * @throws InvalidAttributesException
     *             Wyst¹pi w przypadku b³êdnego pliku konfiguracyjnego.
     * @throws ParseException
     *             Wyst¹pi w przypadku b³êdów parsowania komend CLI.
     */
    public static void main(String[] args) throws IOException, InvalidAttributesException {
	if (args.length != 1) {
	    System.err
		    .println("Nieprawid³owe wywo³anie! Jako argument podaj œcie¿kê do katalogu z plikami konfiguracyjnymi.");
	    System.exit(0);
	}

	ConfigurationFile file = new ConfigurationFile(new File(args[0]));
	MachineConfigurationReader reader = new MachineConfigurationReader(file);

	MachineController controller = new MachineController();
	controller.setUpUsing(reader);
	controller.start();

	while (controller.isAlive()) {
	}

	controller.stopWorking();
    }

}
