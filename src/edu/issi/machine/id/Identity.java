package edu.issi.machine.id;

import edu.issi.machine.Validator;

/**
 * @author Dawid Samo³yk
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
     *             Wyst¹pi, jeœli nazwa obiektu bêdzie pusta.
     */
    protected Identity(int id, String name) throws IllegalArgumentException {
	Validator.throwExceptionWhenTextIsEmpty(name, "Nazwa obiektu nie mo¿e byæ pusta!");

	this.id = id;
	this.name = name;
    }

    /**
     * @param newName
     *            Nowa nazwa.
     * @return Poprzednia nazwa.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli nazwa obiektu bêdzie pusta
     */
    public String changeName(String newName) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(newName, "Nazwa obiektu nie mo¿e byæ pusta!");

	final String actualName = name;
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
     * @return Unikalny numer identyfikuj¹cy obiekt.
     */
    public int getIdNumber() {
	return id;
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
	if (this == obj) {
	    return true;
	}
	return false;
    }

    /**
     * Fabryka dostarczaj¹ca unikalne identyfikatory.
     */
    public static class Factory {
	private static int Counter = 0;

	/**
	 * @param name
	 *            Nazwa.
	 * @return Identyfikator.
	 * @throws IllegalArgumentException
	 *             Wyst¹pi, jeœli nazwa obiektu bêdzie pusta.
	 */
	public static synchronized Identity newIdentity(String name) throws IllegalArgumentException {
	    return new Identity(Counter++, name);
	}
    }
}
