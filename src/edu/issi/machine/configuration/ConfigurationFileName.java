package edu.issi.machine.configuration;

/**
 * @author Dawid
 *
 */
public enum ConfigurationFileName {
    /**
     * Nazwa pliku, który bêdzie zawiera³ API.
     */
    API("api.json"),
    /**
     * Nazwa pliku, który bêdzie zawiera³ konfiguracjê maszyny.
     */
    MACHINE_CONFIGURATION("configuration.json");

    private final String fileName;

    /**
     * @param fileName
     *            Nazwa pliku.
     */
    private ConfigurationFileName(final String fileName) {
	this.fileName = fileName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
	return fileName;
    }
}
