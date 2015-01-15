package edu.issi.machine.id;

import edu.issi.machine.Validator;
import edu.issi.machine.product.ingredient.Unit;

/**
 * @author Dawid Samo³yk
 *
 *         Identyfikator w³aœciwoœci.
 */
public class PropertyIdentity extends Identity {
    private Unit unit;

    /**
     * @param id
     *            Numer identyfikacyjny.
     * @param name
     *            Nazwa w³aœciwoœci.
     * @param unit
     *            Jednostka miary w³aœciwoœci.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli jednostka miary nie zostanie podana.
     */
    protected PropertyIdentity(int id, String name, Unit unit) throws IllegalArgumentException {
	super(id, name);

	Validator.throwExceptionWhenObjectIsNotCreated(unit, "Nie podano jednostki w³aœciwoœci!");
	this.unit = unit;
    }

    /**
     * @return Jednostka miary w³aœciwoœci.
     */
    public Unit getUnit() {
	return unit;
    }

    /**
     * Fabryka dostarczaj¹ca unikalne identyfikatory w³aœciwoœci.
     *
     */
    public static class Factory extends Identity.Factory {

	/**
	 * @param name
	 *            Nazwa w³aœciwoœci.
	 * @param unit
	 *            Jednostka miary w³aœciwoœci.
	 * @return Identyfikator w³aœciwoœci.
	 * @throws IllegalArgumentException
	 *             Wyst¹pi, jeœli jednostka miary nie zostanie podana.
	 */
	public static synchronized PropertyIdentity newProperty(String name, Unit unit) throws IllegalArgumentException {
	    return new PropertyIdentity(counter++, name, unit);
	}

    }
}
