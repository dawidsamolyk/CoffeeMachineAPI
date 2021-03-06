package edu.issi.machine.id;

import edu.issi.machine.Validator;
import edu.issi.machine.product.ingredient.Unit;

/**
 * @author Dawid Samołyk
 *
 *         Identyfikator właściwości.
 */
public class PropertyIdentity extends Identity {
    private final Unit unit;

    protected PropertyIdentity(int id, String name, Unit unit) throws IllegalArgumentException {
	super(id, name);

	Validator.throwExceptionWhenObjectIsNotCreated(unit, "Nie podano jednostki właściwości!");
	this.unit = unit;
    }

    /**
     * Pobranie jednostki miary.
     * 
     * @return Jednostka miary właściwości.
     */
    public Unit getUnit() {
	return unit;
    }

    /**
     * Fabryka dostarczająca unikalne identyfikatory właściwości.
     *
     */
    public static class Factory {
	private static int Counter = 0;

	/**
	 * Dostarcza nowy identyfikator właściwości składnika.
	 * 
	 * @param name
	 *            Nazwa właściwości.
	 * @param unit
	 *            Jednostka miary właściwości.
	 * @return Identyfikator właściwości.
	 * @throws IllegalArgumentException
	 *             Wystąpi, jeśli jednostka miary nie zostanie podana.
	 */
	public static synchronized PropertyIdentity newProperty(String name, Unit unit) throws IllegalArgumentException {
	    return new PropertyIdentity(Counter++, name, unit);
	}

    }
}
