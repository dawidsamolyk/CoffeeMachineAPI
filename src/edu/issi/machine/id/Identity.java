package edu.issi.machine.id;

import javax.naming.directory.InvalidAttributeIdentifierException;

import edu.issi.machine.Validator;

/**
 * @author Dawid
 * 
 */
public class Identity {
    private final int id;
    private String name;

    /**
     * @param id
     *            Numer identyfikacyjny.
     * @param name
     *            Nazwa.
     */
    protected Identity(int id, String name) {
	Validator.throwExceptionWhenTextIsEmpty(name, "Nazwa obiektu nie mo¿e byæ pusta!");

	this.id = id;
	this.name = name;
    }

    /**
     * @param newName
     *            Nowa nazwa.
     * @return Poprzednia nazwa.
     */
    public String changeName(String newName) {
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
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!getClass().equals(obj.getClass()))
	    return false;
	final Identity other = (Identity) obj;
	if (id != other.id)
	    return false;
	return true;
    }

    /**
     * 
     *
     */
    public static class Factory {
	protected static int counter = 0;

	/**
	 * @param name
	 *            Nazwa.
	 * @return Identyfikator.
	 * @throws InvalidAttributeIdentifierException
	 *             Wyst¹pi, jeœli identyfikator nie jest unikalny (ju¿
	 *             istnieje).
	 */
	public static synchronized Identity newIdentity(String name) throws InvalidAttributeIdentifierException {
	    return new Identity(counter++, name);
	}

    }

    /**
     * @param productID
     * @return Czy obiekt jest identyfikowany podanym numerem.
     */
    public boolean identifiesBy(int productID) {
	return id == productID;
    }

}
