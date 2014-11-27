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
     * Spodziewany jest tylko jeden argument wejœciowy - pe³na œcie¿ka do pliku
     * konfiguracyjnego, zapisanego w formacie (i z rozszrzeniem) JSON.
     * 
     * @param args
     *            Argumenty uruchomieniowe.
     * @throws IOException
     *             Wyst¹pi w przypadku b³êdów odczytu/zapisu przy operacjach na
     *             plikach.
     * @throws InvalidAttributesException
     *             Wyst¹pi w przypadku b³êdnego pliku konfiguracyjnego.
     */
    public static void main(String[] args) throws IOException, InvalidAttributesException {
	if (args == null || args.length != 1) {
	    throw new InvalidAttributesException(
		    "Nieprawid³owe wywo³anie! Jako argument podaj œcie¿kê do katalogu z plikami konfiguracyjnymi.");
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
