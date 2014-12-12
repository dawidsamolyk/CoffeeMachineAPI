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

	private static void checkInputArguments(String[] args)
			throws InvalidAttributesException {
		if (args == null || args.length != 1) {
			throw new InvalidAttributesException(
					"Nieprawidłowe wywołanie! Jako argument podaj cieżkę do katalogu z plikami konfiguracyjnymi.");
		}
	}

	/**
	 * Spodziewany jest tylko jeden argument wejciowy - pełna cieżka do pliku
	 * konfiguracyjnego, zapisanego w formacie (i z rozszrzeniem) JSON.
	 * 
	 * @param arg
	 *            Argumenty uruchomieniowe.
	 * @throws IOException
	 *             Wystšpi w przypadku błędów odczytu/zapisu przy operacjach na
	 *             plikach.
	 * @throws InvalidAttributesException
	 *             Wystšpi w przypadku błędnego pliku konfiguracyjnego.
	 */
	public static void main(String[] args) throws InvalidAttributesException,
			IOException {
		checkInputArguments(args);

		final ConfigurationFile configurationFile = new ConfigurationFile(
				new File(args[0]));
		final MachineConfigurationReader reader = new MachineConfigurationReader(
				configurationFile);

		final MachineController controller = new MachineController(new Api());
		controller.setUpUsing(reader);
		controller.start();

		while (controller.isAlive()) {
		}

		controller.stopWorking();
	}

}
