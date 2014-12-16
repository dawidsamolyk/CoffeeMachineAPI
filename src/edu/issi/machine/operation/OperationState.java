package edu.issi.machine.operation;

/**
 * @author Dawid
 * 
 */
public class OperationState {
    private final Status status;
    private String description;

    /**
     * @param status
     *            Status operacji (@see {@link Status}).
     * @throws IllegalStateException
     *             Wyst¹pi, gdy status bêdzie wyamga³ uwagi (b³¹d lub
     *             ostrze¿enie), poniewa¿ nie zosta³ ustawiony dla niego opis.
     */
    public OperationState(Status status) throws IllegalStateException {
	ensureIsNotEmpty(status);

	if (status.requiresAttention()) {
	    throw new IllegalStateException("Wybrany status wymaga opisu!");
	}

	this.status = status;
    }

    /**
     * @param status
     *            Status operacji (@see {@link Status}).
     * @param description
     *            Dodatkowy opis stanu operacji.
     * @throws IllegalStateException
     *             Wyst¹pi, gdy status bêdzie wyamga³ uwagi (b³¹d lub
     *             ostrze¿enie) i nie zostanie ustawiony dla niego opis.
     */
    public OperationState(Status status, String description) throws IllegalStateException {
	ensureIsNotEmpty(status);

	if (status.requiresAttention() && isEmpty(description)) {
	    throw new IllegalStateException("Nie podano prawidlowego opisu statusu!");
	}

	this.status = status;
	this.description = description;
    }

    /**
     * @param status
     *            Status operacji (@see {@link Status}).
     * @param stateCodeNumber
     *            Kod operacji.
     * @throws IllegalStateException
     *             Wyst¹pi, gdy status bêdzie wyamga³ uwagi (b³¹d lub
     *             ostrze¿enie) i nie zostanie ustawiony dla niego opis lub kod
     *             operacji.
     */
    public OperationState(Status status, int stateCodeNumber) throws IllegalStateException {
	ensureIsNotEmpty(status);

	if (status.requiresAttention()) {
	    description = "Blad numer: " + stateCodeNumber;
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
	final String statusInBrackets = "[" + status.name() + "] ";

	if (description != null) {
	    return statusInBrackets + description;
	}
	return statusInBrackets;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((description == null) ? 0 : description.hashCode());
	result = prime * result + ((status == null) ? 0 : status.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	OperationState other = (OperationState) obj;
	if (description == null) {
	    if (other.description != null)
		return false;
	} else if (!description.equals(other.description))
	    return false;
	if (status != other.status)
	    return false;
	return true;
    }

    /**
     * Fabryka statusów operacji.
     *
     */
    public static class Factory {
	/**
	 * @param description
	 * @return Status operacji dla b³êdu.
	 */
	public OperationState createErrorWithDescription(String description) {
	    return new OperationState(Status.ERROR, description);
	}

	/**
	 * @param description
	 * @return Status operacji dla ostrze¿enia.
	 */
	public OperationState createWarningWithDescription(String description) {
	    return new OperationState(Status.WARNING, description);
	}

	/**
	 * @param description
	 * @return Poprawny status operacji, z opisem.
	 */
	public OperationState createValidWithDescription(String description) {
	    return new OperationState(Status.OK, description);
	}

	/**
	 * @return Poprawny status operacji.
	 */
	public OperationState createValidState() {
	    return new OperationState(Status.OK);
	}
    }

}
