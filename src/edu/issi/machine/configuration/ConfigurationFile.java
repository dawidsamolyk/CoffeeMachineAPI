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
     * 
     */
    private static final long serialVersionUID = -1837539726725202425L;

    /**
     * @param file
     *            Katalog.
     * @throws IOException
     *             Wyst¹pi w przypadku b³êdu odczytu/zapisu.
     * @throws InvalidAttributesException
     *             Wyst¹pi w przypadku, gdy u¿ytkownik poda nieprawid³owe
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
	    throw new InvalidAttributesException("Podany plik jest niepoprawny lub niemo¿liwy do odczytu!");
	}
	if (!this.getName().endsWith(".json")) {
	    throw new InvalidAttributesException("Niepoprawny format pliku konfiguracyjnego!");
	}
    }

}
