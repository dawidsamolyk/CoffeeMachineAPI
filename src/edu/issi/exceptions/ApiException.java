package edu.issi.exceptions;

import edu.issi.machine.operation.Status;

/**
 * Sytuacja wyj¹tkowa dla API.
 * 
 * @author Dawid
 *
 */
public class ApiException extends Exception {

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
