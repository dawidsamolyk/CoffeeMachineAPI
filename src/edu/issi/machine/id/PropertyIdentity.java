package edu.issi.machine.id;

import edu.issi.machine.Validator;
import edu.issi.machine.product.ingredient.Unit;

/**
 * @author Dawid
 *
 */
public class PropertyIdentity extends Identity {
    private Unit unit;

    /**
     * @param id
     *            Numer identyfikacyjny.
     * @param name
     *            Nazwa właściwości.
     * @param unit
     *            Jednostka miary właściwości.
     * @throws IllegalArgumentException
     */
    protected PropertyIdentity(int id, String name, Unit unit) throws IllegalArgumentException {
	super(id, name);

	Validator.throwExceptionWhenObjectIsNotCreated(unit, "Nie podano jednostki właściwości!");
	this.unit = unit;
    }

    /**
     * @return Jednostka miary właściwości.
     */
    public Unit getUnit() {
	return unit;
    }

    /**
     * 
     *
     */
    public static class Factory extends Identity.Factory {

	/**
	 * @param name
	 * @param unit
	 * @return Identyfikator właściwości.
	 * @throws IllegalArgumentException
	 */
	public static synchronized PropertyIdentity newProperty(String name, Unit unit) throws IllegalArgumentException {
	    return new PropertyIdentity(counter++, name, unit);
	}

    }
}
