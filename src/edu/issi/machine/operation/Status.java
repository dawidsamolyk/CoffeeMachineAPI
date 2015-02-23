package edu.issi.machine.operation;

/**
 * @author Dawid Samo³yk
 *
 *         Status.
 */
public enum Status {
    /**
     * Poprawny.
     */
    OK,
    /**
     * Ostrze¿enie.
     */
    WARNING,
    /**
     * B³¹d.
     */
    ERROR;

    /**
     * Informuje czy dany status wymaga uwagi, czyli czy jest to b³¹d
     * lub ostrze¿enie.
     * 
     * @return Czy dany status wymaga uwagi.
     */
    public boolean requiresAttention() {
	return this == ERROR || this == WARNING;
    }

}
