package edu.issi.machine.operation;

import java.util.ArrayList;
import java.util.List;

import edu.issi.machine.Validator;

/**
 * @author Dawid Samo³yk
 * 
 *         Status operacji.
 */
public class OperationStatus {
    private final Status status;
    private final String description;

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
	this.description = "";
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

	if (!description.isEmpty()) {
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
	 * 
	 */
	public static final String ERROR_OCCURS_INFO = "Wyst¹pi³y b³êdy! ";
	/**
	 * 
	 */
	public static final String WARNING_OCCURS_INFO = "Wyst¹pi³y ostrze¿enia! ";
	/**
	 * 
	 */
	public static final OperationStatus ALL_VALID = createValid("Wszystkie operacje wykonano pomyœlnie! ");

	/**
	 * @param description
	 *            Opis.
	 * @return Status operacji dla b³êdu.
	 */
	public static OperationStatus createError(String description) {
	    return new OperationStatus(Status.ERROR, description);
	}

	/**
	 * @param description
	 *            Opis.
	 * @return Status operacji dla ostrze¿enia.
	 */
	public static OperationStatus createWarning(String description) {
	    return new OperationStatus(Status.WARNING, description);
	}

	/**
	 * @param description
	 *            Opis.
	 * @return Poprawny status operacji, z opisem.
	 */
	public static OperationStatus createValid(String description) {
	    return new OperationStatus(Status.OK, description);
	}

	/**
	 * @return Poprawny status operacji.
	 */
	public static OperationStatus createValid() {
	    return new OperationStatus(Status.OK);
	}

	/**
	 * @param operationsStatuses
	 *            Statusy wielu operacji.
	 * @return Jeden status operacji powsta³y w wyniku wielu statusów.
	 */
	public static OperationStatus getFrom(List<OperationStatus> operationsStatuses) {
	    List<String> invalidStatuses = new ArrayList<String>();
	    Status maxSeverity = Status.OK;

	    for (OperationStatus eachOperationStatus : operationsStatuses) {
		Status eachStatus = eachOperationStatus.getStatus();

		if (eachStatus.requiresAttention()) {
		    invalidStatuses.add(eachOperationStatus.getCompensatedStatus());
		}

		if (!maxSeverity.equals(Status.ERROR) && eachStatus.equals(Status.WARNING)) {
		    maxSeverity = Status.WARNING;
		}
		else if (eachStatus.equals(Status.ERROR)) {
		    maxSeverity = Status.ERROR;
		}
	    }

	    switch (maxSeverity) {
		case ERROR:
		    return createError(ERROR_OCCURS_INFO + invalidStatuses);
		case WARNING:
		    return createWarning(WARNING_OCCURS_INFO + invalidStatuses);
		case OK:
		default:
		    return ALL_VALID;
	    }
	}

	public static List<OperationStatus> createErrors(String ... descriptions) {
	    List<OperationStatus> result = new ArrayList<OperationStatus>(descriptions.length);
	    
	    for(String eachDescription : descriptions) {
		result.add(createError(eachDescription));
	    }
	    
	    return result;
	}
    }

}
