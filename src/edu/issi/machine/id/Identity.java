package edu.issi.machine.id;

import javax.naming.directory.InvalidAttributeIdentifierException;

import edu.issi.machine.Validator;

/**
 * @author Dawid Samo�yk
 * 
 *         Identyfikator.
 */
public class Identity {
    private final int id;
    private String name;

    /**
     * @param id
     *            Numer identyfikacyjny.
     * @param name
     *            Nazwa.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li nazwa obiektu b�dzie pusta.
     */
    protected Identity(int id, String name) throws IllegalArgumentException {
	Validator.throwExceptionWhenTextIsEmpty(name, "Nazwa obiektu nie mo�e by� pusta!");

	this.id = id;
	this.name = name;
    }

    /**
     * @param newName
     *            Nowa nazwa.
     * @return Poprzednia nazwa.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li nazwa obiektu b�dzie pusta
     */
    public String changeName(String newName) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(newName, "Nazwa obiektu nie mo�e by� pusta!");

	String actualName = name;

	name = newName;

	return actualName;
    }

    /**
     * @return Nazwa.
     */
    public String getName() {
	return name;
    }

    /**
     * @param productID
     *            Numer identyfikacyjny.
     * @return Czy obiekt jest identyfikowany podanym numerem.
     */
    public boolean identifiesBy(int productID) {
	return id == productID;
    }

    /**
     * @return Unikalny numer identyfikuj�cy obiekt.
     */
    public int getIdNumber() {
	return hashCode();
    }

    @Override
    public String toString() {
	return "ID: " + id + ", Nazwa: " + name;
    }

    @Override
    public int hashCode() {
	return id;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) return true;
	if (obj == null) return false;
	if (!getClass().equals(obj.getClass())) return false;
	final Identity other = (Identity) obj;
	if (id != other.id) return false;
	return true;
    }

    /**
     * Fabryka dostarczaj�ca unikalne identyfikatory.
     */
    public static class Factory {
	protected static int counter = 0;

	/**
	 * @param name
	 *            Nazwa.
	 * @return Identyfikator.
	 * @throws InvalidAttributeIdentifierException
	 *             Wyst�pi, je�li identyfikator nie jest unikalny (ju�
	 *             istnieje).
	 */
	public static synchronized Identity newIdentity(String name) throws InvalidAttributeIdentifierException {
	    return new Identity(counter++, name);
	}

    }

}
