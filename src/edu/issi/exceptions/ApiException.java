package edu.issi.exceptions;

import edu.issi.machine.operation.Status;

/**
 * @author Dawid
 *
 */
public class ApiException extends Exception {

    /**
     * @param stateCodeNumber
     */
    public ApiException(int stateCodeNumber) {
	// TODO
    }
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * @return Status wyjatku.
     */
    public Status getStatus() {
	return Status.ERROR;
    }

}
