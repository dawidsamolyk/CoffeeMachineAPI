package edu.issi.machine.operation;

/**
 * @author Dawid
 *
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
     * @param status
     *            Status.
     * @return Czy dany status wymaga uwagi.
     */
    public boolean requiresAttention() {
	return this == ERROR || this == WARNING;
    }

}
