package edu.issi.machine.operation;

/**
 * @author Dawid Samołyk
 *
 * Status.
 */
public enum Status {
    /**
     * 
     */
    OK,
    /**
     * 
     */
    WARNING,
    /**
     * 
     */
    ERROR;

    /**
     * @return Czy dany status wymaga uwagi.
     */
    public boolean requiresAttention() {
	return this == ERROR || this == WARNING;
    }

}
