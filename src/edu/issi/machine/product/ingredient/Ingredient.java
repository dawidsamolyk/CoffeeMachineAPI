package edu.issi.machine.product.ingredient;

import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;

import edu.issi.machine.Validator;
import edu.issi.machine.id.Identity;
import edu.issi.machine.id.ObjectWithIdentity;
import edu.issi.machine.id.PropertyIdentity;

/**
 * @author Dawid
 * 
 */
public class Ingredient extends ObjectWithIdentity implements Serializable {
	/**
	 * Wygenerowany numer UID.
	 */
	private static final long serialVersionUID = -2437259497186892897L;

	private final Map<PropertyIdentity, Double> properties;

	/**
	 * @param identity
	 *            Identyfikator.
	 * @param properties
	 *            W³aœciwoœci sk³adnika.
	 */
	public Ingredient(Identity identity,
			Map<PropertyIdentity, Double> properties) {
		super(identity);

		Validator.throwExceptionWhenMapContainsNullOrEmpty(properties,
				"Lista w³aœciwoœci sk³adnika nie mo¿e byæ pusta lub niepe³na!");

		this.properties = properties;
	}

	/**
	 * @param property
	 *            W³asnoœæ sk³adnika, któr¹ chcemy pobraæ.
	 * @return Zwraca wartoœæ przypisan¹ do wybranej w³aœciwoœci sk³adnika.
	 */
	public Double get(PropertyIdentity property) {
		final Double result = properties.get(property);

		if (result == null) {
			throw new NoSuchElementException(
					"Wybrany sk³adnik nie posiada podanej w³aœciwoœci!");
		}

		return result;
	}

	/**
	 * @param property
	 *            W³asnoœæ sk³adnika.
	 * @param value
	 *            Wartoœæ przypisana do w³asnoœci.
	 */
	public void add(PropertyIdentity property, Double value) {
		properties.put(property, value);
	}

	/**
	 * @param property
	 *            W³asnoœæ sk³adnika.
	 */
	public void remove(PropertyIdentity property) {
		properties.remove(property);
	}
}
