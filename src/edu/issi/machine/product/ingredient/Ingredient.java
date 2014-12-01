package edu.issi.machine.product.ingredient;

import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;

import edu.issi.machine.Validator;
import edu.issi.machine.id.Identity;
import edu.issi.machine.id.ObjectWithIdentity;

/**
 * @author Dawid
 * 
 */
public class Ingredient extends ObjectWithIdentity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -2437259497186892897L;

    private Map<IngredientProperty, Double> properties;

    /**
     * @param id
     *            Identyfikator.
     * @param properties
     *            W�a�ciwo�ci sk�adnika.
     */
    public Ingredient(Identity id, Map<IngredientProperty, Double> properties) {
	super(id);

	Validator.throwExceptionWhenContainsNullOrEmpty(properties,
		"Lista w�a�ciwo�ci sk�adnika nie mo�e by� pusta lub niepe�na!");

	this.properties = properties;
    }

    /**
     * @param property
     *            W�asno�� sk�adnika, kt�r� chcemy pobra�.
     * @return Zwraca warto�� przypisan� do wybranej w�a�ciwo�ci sk�adnika.
     */
    public Double get(IngredientProperty property) {
	Double result = properties.get(property);

	if (result == null) {
	    throw new NoSuchElementException("Wybrany sk�adnik nie posiada podanej w�a�ciwo�ci!");
	}

	return result;
    }

    /**
     * @param property
     *            W�asno�� sk�adnika.
     * @param value
     *            Warto�� przypisana do w�asno�ci.
     */
    public void add(IngredientProperty property, Double value) {
	properties.put(property, value);
    }
    
    /**
     * @param property W�asno�� sk�adnika.
     */
    public void remove(IngredientProperty property) {
	properties.remove(property);
    }
}
