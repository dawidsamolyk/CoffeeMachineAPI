package edu.issi.machine.id;

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
     */
    public PropertyIdentity(int id, String name, Unit unit) {
	super(id, name);
	this.unit = unit;
    }

    /**
     * @return Jednostka miary właściwości.
     */
    public Unit getUnit() {
	return unit;
    }

}
