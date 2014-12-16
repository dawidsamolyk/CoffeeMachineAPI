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
    public PropertyIdentity(int id, String name, Unit unit) throws IllegalArgumentException {
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

}
