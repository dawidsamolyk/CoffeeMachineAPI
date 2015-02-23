package edu.issi.machine.operation;

import java.util.ArrayList;
import java.util.Collection;
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

    private OperationStatus(Status status) throws IllegalStateException {
	Validator.throwExceptionWhenObjectIsNotCreated(status, "Nie podano statusu operacji!");

	this.status = status;
	this.description = "";
    }

    private OperationStatus(Status status, String description) throws IllegalStateException {
	Validator.throwExceptionWhenObjectIsNotCreated(status, "Nie podano statusu operacji!");
	Validator.throwExceptionWhenTextIsEmpty(description, "Opis statusu operacji nie mo¿e byæ pusty!");

	this.status = status;
	this.description = description;
    }

    /**
     * Dostarcza opis stanu operacji.
     * 
     * @return Opis stanu operacji.
     */
    public String getDescription() {
	return description;
    }

    /**
     * Dostarcza stan operacji.
     * 
     * @return Status stanu operacji.
     */
    public Status getStatus() {
	return status;
    }

    /**
     * Dostarcza skompensowan¹ informacjê (w formie tekstu) na temat stanu
     * operacji oraz opisu stanu operacji.
     * 
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
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	OperationStatus other = (OperationStatus) obj;
	if (description == null) {
	    if (other.description != null)
		return false;
	}
	else if (!description.equals(other.description))
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
	 * Nag³ówek informacji, gdy wyst¹pi³y b³êdy.
	 */
	public static final String ERROR_OCCURS_HEADER = "Wyst¹pi³y b³êdy! ";
	/**
	 * Nag³ówek informacji, gdy wyst¹pi³y ostrze¿enia.
	 */
	public static final String WARNING_OCCURS_HEADER = "Wyst¹pi³y ostrze¿enia! ";
	/**
	 * Informacja, gdy wszystkie operacje wykonano pomyœlnie.
	 */
	public static final OperationStatus ALL_VALID_INFO = createValid("Wszystkie operacje wykonano pomyœlnie! ");

	/**
	 * Tworzy status operacji dla sytuacji, gdy wyst¹pi³ b³¹d.
	 * 
	 * @param description
	 *            Opis.
	 * @return Status operacji dla b³êdu.
	 */
	public static OperationStatus createError(String description) {
	    return new OperationStatus(Status.ERROR, description);
	}

	/**
	 * Tworzy status operacji dla sytuacji, gdy wyst¹pi³o ostrze¿enie.
	 * 
	 * @param description
	 *            Opis.
	 * @return Status operacji dla ostrze¿enia.
	 */
	public static OperationStatus createWarning(String description) {
	    return new OperationStatus(Status.WARNING, description);
	}

	/**
	 * Tworzy status poprawnie wykonanej operacji (z opisem).
	 * 
	 * @param description
	 *            Opis.
	 * @return Poprawny status operacji, z opisem.
	 */
	public static OperationStatus createValid(String description) {
	    return new OperationStatus(Status.OK, description);
	}

	/**
	 * Tworzy status poprawnie wykonanej operacji (bez opisu).
	 * 
	 * @return Poprawny status operacji.
	 */
	public static OperationStatus createValid() {
	    return new OperationStatus(Status.OK);
	}

	/**
	 * Tworzy jeden status operacji agreguj¹cy informacjê z wielu statusów
	 * operacji.
	 * 
	 * @param operationsStatuses
	 *            Statusy wielu operacji.
	 * @return Jeden status operacji powsta³y w wyniku wielu statusów.
	 */
	public static OperationStatus getFrom(Collection<OperationStatus> operationsStatuses) {
	    Validator.throwExceptionWhenEmptyOrContainsEmptyObject(operationsStatuses,
		    "Nie mo¿na stworzyæ skompensowanego statusu operacji z pust¹ list¹ statusów operacji.");

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
		    return createError(ERROR_OCCURS_HEADER + invalidStatuses);
		case WARNING:
		    return createWarning(WARNING_OCCURS_HEADER + invalidStatuses);
		case OK:
		default:
		    return ALL_VALID_INFO;
	    }
	}

	/**
	 * Tworzy statusy operacji, gdy wyst¹pi³y b³edy. Opisy kolejnych
	 * statusów s¹ dostarczane jako argumenty wejœciowe.
	 * 
	 * @param descriptions
	 *            Opisy.
	 * @return Lista statusów operacji (b³êdnych) z opisami, które podano
	 *         jako argument wejœciowy.
	 */
	public static Collection<OperationStatus> createErrors(String... descriptions) {
	    List<OperationStatus> result = new ArrayList<OperationStatus>(descriptions.length);

	    for (String eachDescription : descriptions) {
		result.add(createError(eachDescription));
	    }

	    return result;
	}
    }

}
