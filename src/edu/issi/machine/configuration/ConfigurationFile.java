package edu.issi.machine.configuration;

import java.io.File;
import java.io.FileNotFoundException;

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
     * @throws InvalidAttributesException
     *             Wyst¹pi w przypadku, gdy u¿ytkownik poda nieprawid³owe
     *             rozszerzenie pliku.
     * @throws FileNotFoundException
     *             Wyst¹pi w przypadku b³êdu odczytu danych z dysku.
     */
    public ConfigurationFile(File file) throws InvalidAttributesException, FileNotFoundException {
	super(file.getPath());

	ensureValidity();
    }

    private void ensureValidity() throws InvalidAttributesException, FileNotFoundException {
	if (!this.exists()) {
	    throw new FileNotFoundException("Podany plik konfiguracyjny nie istnieje!");
	}
	if (!this.isFile() || !this.canRead()) {
	    throw new InvalidAttributesException("Podany plik jest niepoprawny lub niemo¿liwy do odczytu!");
	}
	if (!this.getName().endsWith(".json")) {
	    throw new InvalidAttributesException("Niepoprawny format pliku konfiguracyjnego!");
	}
    }

}
