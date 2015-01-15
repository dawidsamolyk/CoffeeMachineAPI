package edu.issi.machine.id;

import edu.issi.machine.Validator;
import edu.issi.machine.product.ingredient.Unit;

/**
 * @author Dawid Samo�yk
 *
 *         Identyfikator w�a�ciwo�ci.
 */
public class PropertyIdentity extends Identity {
    private Unit unit;

    /**
     * @param id
     *            Numer identyfikacyjny.
     * @param name
     *            Nazwa w�a�ciwo�ci.
     * @param unit
     *            Jednostka miary w�a�ciwo�ci.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li jednostka miary nie zostanie podana.
     */
    protected PropertyIdentity(int id, String name, Unit unit) throws IllegalArgumentException {
	super(id, name);

	Validator.throwExceptionWhenObjectIsNotCreated(unit, "Nie podano jednostki w�a�ciwo�ci!");
	this.unit = unit;
    }

    /**
     * @return Jednostka miary w�a�ciwo�ci.
     */
    public Unit getUnit() {
	return unit;
    }

    /**
     * Fabryka dostarczaj�ca unikalne identyfikatory w�a�ciwo�ci.
     *
     */
    public static class Factory extends Identity.Factory {

	/**
	 * @param name
	 *            Nazwa w�a�ciwo�ci.
	 * @param unit
	 *            Jednostka miary w�a�ciwo�ci.
	 * @return Identyfikator w�a�ciwo�ci.
	 * @throws IllegalArgumentException
	 *             Wyst�pi, je�li jednostka miary nie zostanie podana.
	 */
	public static synchronized PropertyIdentity newProperty(String name, Unit unit) throws IllegalArgumentException {
	    return new PropertyIdentity(counter++, name, unit);
	}

    }
}
