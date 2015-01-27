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
     * @return Numer ID.
     */
    public int getIdNumber() {
	return id.getIdNumber();
    }

    /**
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
	return false;
    }

    /**
     * @param productID
     *            Numer identyfikacyjny.
     * @return Czy ten obiekt jest identyfikowany podanym ID.
     */
    public boolean identifiesBy(int productID) {
	return id.identifiesBy(productID);
    }

}
