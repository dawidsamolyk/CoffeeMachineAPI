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
     * @return Czy dany status wymaga uwagi.
     */
    public static boolean requiresAttention(Status status) {
	return status == ERROR || status == WARNING;
    }
}
