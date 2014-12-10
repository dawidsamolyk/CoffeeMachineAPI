package edu.issi.machine.id;

import edu.issi.machine.product.ingredient.Unit;

/**
 * @author Dawid
 *
 */
public class PropertyIdentity extends Identity {
	private Unit unit;

	/**
     * 
     */
	private static final long serialVersionUID = 1138089275597851541L;

	/**
	 * @param id
	 *            Numer identyfikacyjny.
	 * @param name
	 *            Nazwa w³aœciwoœci.
	 * @param unit
	 *            Jednostka miary w³aœciwoœci.
	 */
	public PropertyIdentity(int id, String name, Unit unit) {
		super(id, name);
		this.unit = unit;
	}

	/**
	 * @return Jednostka miary w³aœciwoœci.
	 */
	public Unit getUnit() {
		return unit;
	}

}
