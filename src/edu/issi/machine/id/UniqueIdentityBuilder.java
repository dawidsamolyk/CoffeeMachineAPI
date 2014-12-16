package edu.issi.machine.id;

import javax.naming.directory.InvalidAttributeIdentifierException;

import edu.issi.machine.product.ingredient.Unit;

/**
 * @author Dawid
 *
 */
public class UniqueIdentityBuilder {
    protected int counter;

    /**
     * @return Identyfikator.
     * @throws InvalidAttributeIdentifierException
     *             Wyst¹pi, jeœli identyfikator nie jest unikalny (ju¿
     *             istnieje).
     */
    public synchronized Identity newIdentity() throws InvalidAttributeIdentifierException {
	return new Identity(counter++);
    }

    /**
     * @param name
     *            Nazwa.
     * @return Identyfikator.
     * @throws InvalidAttributeIdentifierException
     *             Wyst¹pi, jeœli identyfikator nie jest unikalny (ju¿
     *             istnieje).
     */
    public synchronized Identity newIdentityWithName(String name) throws InvalidAttributeIdentifierException {
	return new Identity(counter++, name);
    }

    /**
     * @param name
     * @param unit
     * @return Identyfikator w³aœciwoœci.
     */
    public synchronized PropertyIdentity newProperty(String name, Unit unit) {
	return new PropertyIdentity(counter++, name, unit);
    }

}
