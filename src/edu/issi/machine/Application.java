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
     *            Argumenty wej�ciowe aplikacji.
     * @throws IOException
     *             Wyst�pi w przypadku b��d�w odczytu/zapisu przy operacjach na
     *             plikach.
     * @throws InvalidAttributesException
     *             Wyst�pi w przypadku b��dnego pliku konfiguracyjnego.
     * @throws ParseException
     *             Wyst�pi w przypadku b��d�w parsowania komend CLI.
     */
    public static void main(String[] args) throws IOException, InvalidAttributesException {
	if (args.length != 1) {
	    System.err
		    .println("Nieprawid�owe wywo�anie! Jako argument podaj �cie�k� do katalogu z plikami konfiguracyjnymi.");
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
