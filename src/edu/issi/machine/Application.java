package edu.issi.machine;

import java.io.File;
import java.io.IOException;

import javax.naming.directory.InvalidAttributesException;

import edu.issi.machine.api.Api;
import edu.issi.machine.configuration.ConfigurationFile;
import edu.issi.machine.configuration.MachineConfigurationReader;
import edu.issi.machine.controller.MachineController;

/**
 * @author Dawid
 *
 */
public class Application {

    private static void checkInputArguments(String[] args) throws InvalidAttributesException {
	if (args == null || args.length != 1) {
	    throw new InvalidAttributesException(
		    "Nieprawid�owe wywo�anie! Jako argument podaj �cie�k� do katalogu z plikami konfiguracyjnymi.");
	}
    }

    /**
     * Spodziewany jest tylko jeden argument wej�ciowy - pe�na �cie�ka do pliku
     * konfiguracyjnego, zapisanego w formacie (i z rozszrzeniem) JSON.
     * 
     * @param args
     *            Argumenty uruchomieniowe.
     * @throws IOException
     *             Wyst�pi w przypadku b��d�w odczytu/zapisu przy operacjach na
     *             plikach.
     * @throws InvalidAttributesException
     *             Wyst�pi w przypadku b��dnego pliku konfiguracyjnego.
     */
    public static void main(String[] args) throws InvalidAttributesException, IOException {
	checkInputArguments(args);

	final ConfigurationFile configurationFile = new ConfigurationFile(new File(args[0]));
	final MachineConfigurationReader reader = new MachineConfigurationReader(configurationFile);

	final MachineController controller = new MachineController(new Api());
	controller.setUpUsing(reader);
	controller.start();

	while (controller.isAlive()) {
	}

	controller.stopWorking();
    }

}
