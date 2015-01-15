package edu.issi.machine.operation;

import edu.issi.machine.Validator;

/**
 * @author Dawid Samo³yk
 * 
 *         Status operacji.
 */
public class OperationStatus {
    private final Status status;
    private String description;

    /**
     * @param status
     *            Status operacji (@see {@link Status}).
     * @throws IllegalStateException
     *             Wyst¹pi, gdy status bêdzie wyamga³ uwagi (b³¹d lub
     *             ostrze¿enie), poniewa¿ nie zosta³ ustawiony dla niego opis.
     */
    private OperationStatus(Status status) throws IllegalStateException {
	Validator.throwExceptionWhenObjectIsNotCreated(status, "Nie podano statusu operacji!");

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
    private OperationStatus(Status status, String description) throws IllegalStateException {
	Validator.throwExceptionWhenObjectIsNotCreated(status, "Nie podano statusu operacji!");
	Validator.throwExceptionWhenTextIsEmpty(description, "Opis statusu operacji nie mo¿e byæ pusty!");

	this.status = status;
	this.description = description;
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
	final String statusInBrackets = "[" + status.name() + "]";

	if (description != null) {
	    return statusInBrackets + " " + description;
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
	if (this == obj) return true;
	if (obj == null) return false;
	if (getClass() != obj.getClass()) return false;
	OperationStatus other = (OperationStatus) obj;
	if (description == null) {
	    if (other.description != null) return false;
	}
	else if (!description.equals(other.description)) return false;
	if (status != other.status) return false;
	return true;
    }

    /**
     * Fabryka statusów operacji.
     *
     */
    public static class Factory {
	/**
	 * @param description Opis.
	 * @return Status operacji dla b³êdu.
	 */
	public static OperationStatus createErrorWithDescription(String description) {
	    return new OperationStatus(Status.ERROR, description);
	}

	/**
	 * @param description Opis.
	 * @return Status operacji dla ostrze¿enia.
	 */
	public static OperationStatus createWarningWithDescription(String description) {
	    return new OperationStatus(Status.WARNING, description);
	}

	/**
	 * @param description Opis.
	 * @return Poprawny status operacji, z opisem.
	 */
	public static OperationStatus createValidWithDescription(String description) {
	    return new OperationStatus(Status.OK, description);
	}

	/**
	 * @return Poprawny status operacji.
	 */
	public static OperationStatus createValid() {
	    return new OperationStatus(Status.OK);
	}
    }

}
