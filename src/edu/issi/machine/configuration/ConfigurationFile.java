package edu.issi.machine.configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.naming.directory.InvalidAttributesException;

/**
 * @author Dawid
 *
 */
public class ConfigurationFile extends File {
    /**
     * Wygenerowany kod UID.
     */
    private static final long serialVersionUID = 2324343097316631855L;

    /**
     * @param file
     *            Plik konfiguracyjny.
     * @throws IOException
     *             Wyst�pi w przypadku b��du odczytu danych z dyskuF.
     * @throws InvalidAttributesException
     *             Wyst�pi w przypadku, gdy u�ytkownik poda nieprawid�owe
     *             rozszerzenie pliku.
     */
    public ConfigurationFile(File file) throws IOException, InvalidAttributesException {
	super(file.getPath());

	ensureValidity();
    }

    private void ensureValidity() throws InvalidAttributesException, FileNotFoundException {
	if (!this.exists()) {
	    throw new FileNotFoundException("Podany plik konfiguracyjny nie istnieje!");
	}
	if (!this.isFile() || !this.canRead()) {
	    throw new InvalidAttributesException("Podany plik jest niepoprawny lub niemo�liwy do odczytu!");
	}
	if (!this.getName().endsWith(".json")) {
	    throw new InvalidAttributesException("Niepoprawny format pliku konfiguracyjnego!");
	}
    }

}
