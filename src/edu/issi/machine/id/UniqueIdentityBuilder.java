package edu.issi.machine.id;

import java.util.HashSet;
import java.util.Set;

import javax.naming.directory.InvalidAttributeIdentifierException;

import edu.issi.machine.product.ingredient.Unit;

/**
 * @author Dawid
 *
 */
public class UniqueIdentityBuilder {
    protected final Set<Identity> identities;

    /**
     * 
     */
    public UniqueIdentityBuilder() {
	identities = new HashSet<Identity>(32, 0.75f);
    }

    /**
     * @return Identyfikator.
     * @throws InvalidAttributeIdentifierException
     *             Wyst¹pi, jeœli identyfikator nie jest unikalny (ju¿
     *             istnieje).
     */
    public Identity newIdentity() throws InvalidAttributeIdentifierException {
	return new Identity(getNextIdNumber());
    }

    /**
     * @param name
     *            Nazwa.
     * @return Identyfikator.
     * @throws InvalidAttributeIdentifierException
     *             Wyst¹pi, jeœli identyfikator nie jest unikalny (ju¿
     *             istnieje).
     */
    public Identity newIdentityWithName(String name) throws InvalidAttributeIdentifierException {
	return new Identity(getNextIdNumber(), name);
    }

    public PropertyIdentity newProperty(String name, Unit unit) {
	return new PropertyIdentity(getNextIdNumber(), name, unit);
    }

    protected int getNextIdNumber() {
	return identities.size() + 1;
    }

}
