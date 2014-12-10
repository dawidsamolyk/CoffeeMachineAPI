package edu.issi.machine.id;

import java.util.HashSet;
import java.util.Set;

import javax.naming.directory.InvalidAttributeIdentifierException;

/**
 * @author Dawid
 *
 */
public class UniqueIdentityBuilder {
	private final Set<Identity> identities;

	/**
     * 
     */
	public UniqueIdentityBuilder() {
		identities = new HashSet<Identity>(32, 0.75f);
	}

	/**
	 * @param id
	 *            Numer identyfikacyjny.
	 * @param name
	 *            Nazwa.
	 * @return Identyfikator.
	 * @throws InvalidAttributeIdentifierException
	 *             Wyst¹pi, jeœli identyfikator nie jest unikalny (ju¿
	 *             istnieje).
	 */
	public Identity build(int id, String name)
			throws InvalidAttributeIdentifierException {
		final Identity result = new Identity(id);

		ensureUniqueness(result);

		return result;
	}

	private void ensureUniqueness(Identity result)
			throws InvalidAttributeIdentifierException {
		if (identities.contains(result)) {
			throw new InvalidAttributeIdentifierException(
					"Nie mo¿na stworzyæ dwóch obiektów z tym samym numerem ID.");
		}

		identities.add(result);
	}

}
