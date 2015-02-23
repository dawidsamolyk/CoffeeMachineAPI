package edu.issi.machine.id;

import edu.issi.machine.Validator;

/**
 * @author Dawid Samo�yk
 *
 *         Reprezentacja obiektu posiadaj�cego identyfikator.
 */
public class ObjectWithIdentity {
    private final Identity id;

    /**
     * Konstruktor. Obiekt Identity jest wymagany.
     * 
     * @param id
     *            Identyfikator.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li identyfikator b�dzie pusty.
     */
    public ObjectWithIdentity(final Identity id) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(id, "Nie podano ID!");
	this.id = id;
    }

    @Override
    public String toString() {
	return id.toString();
    }

    @Override
    public int hashCode() {
	return id.hashCode();
    }

    /**
     * Pobranie numeru ID.
     * 
     * @return Numer ID.
     */
    public int getIdNumber() {
	return id.getIdNumber();
    }

    /**
     * Pobranie nazwy.
     * 
     * @return Nazwa obiektu.
     */
    public String getName() {
	return id.getName();
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	ObjectWithIdentity other = (ObjectWithIdentity) obj;
	if (id == null) {
	    if (other.id != null) {
		return false;
	    }
	}
	else if (!id.equals(other.id)) {
	    return false;
	}
	return true;
    }

    /**
     * Sprawdzenie czy identyfikator danego obiektu jest uto�samiany z podanym
     * numerem ID.
     * 
     * @param productID
     *            Numer identyfikacyjny.
     * @return Czy ten obiekt jest identyfikowany podanym ID.
     */
    public boolean identifiesBy(int productID) {
	return id.identifiesBy(productID);
    }

}
