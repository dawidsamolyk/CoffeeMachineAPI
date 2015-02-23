package edu.issi.machine.id;

import edu.issi.machine.Validator;
import edu.issi.machine.product.ingredient.Unit;

/**
 * @author Dawid Samo�yk
 *
 *         Identyfikator w�a�ciwo�ci.
 */
public class PropertyIdentity extends Identity {
    private final Unit unit;

    protected PropertyIdentity(int id, String name, Unit unit) throws IllegalArgumentException {
	super(id, name);

	Validator.throwExceptionWhenObjectIsNotCreated(unit, "Nie podano jednostki w�a�ciwo�ci!");
	this.unit = unit;
    }

    /**
     * Pobranie jednostki miary.
     * 
     * @return Jednostka miary w�a�ciwo�ci.
     */
    public Unit getUnit() {
	return unit;
    }

    /**
     * Fabryka dostarczaj�ca unikalne identyfikatory w�a�ciwo�ci.
     *
     */
    public static class Factory {
	private static int Counter = 0;

	/**
	 * Dostarcza nowy identyfikator w�a�ciwo�ci sk�adnika.
	 * 
	 * @param name
	 *            Nazwa w�a�ciwo�ci.
	 * @param unit
	 *            Jednostka miary w�a�ciwo�ci.
	 * @return Identyfikator w�a�ciwo�ci.
	 * @throws IllegalArgumentException
	 *             Wyst�pi, je�li jednostka miary nie zostanie podana.
	 */
	public static synchronized PropertyIdentity newProperty(String name, Unit unit) throws IllegalArgumentException {
	    return new PropertyIdentity(Counter++, name, unit);
	}

    }
}
