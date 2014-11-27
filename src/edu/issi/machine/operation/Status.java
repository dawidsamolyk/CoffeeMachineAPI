package edu.issi.machine.operation;

import java.io.Serializable;

/**
 * @author Dawid
 *
 */
public enum Status implements Serializable {
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
