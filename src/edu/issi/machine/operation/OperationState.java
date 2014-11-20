package edu.issi.machine.operation;

/**
 * @author Dawid
 * 
 */
public class OperationState {
    private Status status;
    private String description;

    /**
     * @param status
     * @throws IllegalStateException
     */
    public OperationState(Status status) throws IllegalStateException {
	ensureIsNotEmpty(status);

	if (Status.requiresAttention(status)) {
	    throw new IllegalStateException("Wybrany status wymaga opisu!");
	}

	this.status = status;
    }

    /**
     * @param status
     * @param description
     * @throws IllegalStateException
     */
    public OperationState(Status status, String description) throws IllegalStateException {
	ensureIsNotEmpty(status);

	if (Status.requiresAttention(status) && isEmpty(description)) {
	    throw new IllegalStateException("Nie podano prawidlowego opisu statusu!");
	}

	this.status = status;
	this.description = description;
    }
    
    /**
     * @param status
     * @param stateCodeNumber
     * @throws IllegalStateException
     */
    public OperationState(Status status, int stateCodeNumber) throws IllegalStateException {
	ensureIsNotEmpty(status);
	
	if (Status.requiresAttention(status)) {
	    this.description = "Blad numer: " + stateCodeNumber;
	}

	this.status = status;
    }

    private boolean isEmpty(String description) {
	return description == null || description.length() == 0;
    }

    private void ensureIsNotEmpty(Status status) {
	if (status == null) {
	    throw new IllegalStateException("Wybrany status wymaga opisu!");
	}
    }

    /**
     * @return Opis stanu operacji.
     */
    public String getDescription() {
	return description;
    }

    /**
     * @return Status stanu operacji.
     */
    public Status getStatus() {
	return status;
    }

    /**
     * @return Status operacji i opis w jednym tekscie.
     */
    public String getCompensatedStatus() {
	String statusInBrackets = "[" + status.name() + "] ";

	if (description != null) {
	    return statusInBrackets + description;
	}
	return statusInBrackets;
    }
}
