package edu.issi.machine;

import java.io.File;
import java.io.IOException;

import javax.naming.directory.InvalidAttributesException;

import edu.issi.machine.configuration.ConfigurationFile;
import edu.issi.machine.configuration.MachineConfigurationReader;
import edu.issi.machine.controller.MachineController;

/**
 * @author Dawid
 *
 */
public class Application {

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
    public static void main(String[] args) throws IOException, InvalidAttributesException {
	if (args == null || args.length != 1) {
	    throw new InvalidAttributesException(
		    "Nieprawid�owe wywo�anie! Jako argument podaj �cie�k� do katalogu z plikami konfiguracyjnymi.");
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
