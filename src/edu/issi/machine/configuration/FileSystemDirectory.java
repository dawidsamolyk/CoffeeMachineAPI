package edu.issi.machine.configuration;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Dawid
 *
 */
public class FileSystemDirectory {
    private File directory;

    /**
     * @param directory
     *            Katalog.
     * @throws FileNotFoundException
     *             Wyst¹pi, gdy katalog nie istnieje.
     */
    public FileSystemDirectory(File directory) throws FileNotFoundException {
	checkIsValid(directory);

	this.directory = directory;
    }

    /**
     * @param fileName
     *            Plik konfiguracyjny.
     * @return Czy w folderze znajduje siê podany plik konfiguracyjny.
     */
    public boolean contains(ConfigurationFileName fileName) {
	File configurationFile = new File(directory + File.separator + fileName.toString());

	return configurationFile.exists();
    }

    @Override
    public String toString() {
	return directory.toString();
    }

    private void checkIsValid(File directory) throws FileNotFoundException {
	if (!directory.exists() || !directory.isDirectory()) {
	    throw new FileNotFoundException("Katalog nie istnieje lub nie jest poprawny!");
	}
    }
}
