package edu.issi.machine.product.ingredient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import edu.issi.machine.Validator;
import edu.issi.machine.id.Identity;
import edu.issi.machine.id.ObjectWithIdentity;
import edu.issi.machine.id.PropertyIdentity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationState;

/**
 * @author Dawid
 * 
 */
public class Ingredient extends ObjectWithIdentity {
    private final Map<PropertyIdentity, Double> properties;
    private Iterable<Operation> operations;

    /**
     * @param identity
     *            Identyfikator.
     */
    public Ingredient(Identity identity) {
	super(identity);

	this.properties = new HashMap<PropertyIdentity, Double>();
    }

    /**
     * @param property
     *            W�asno�� sk�adnika, kt�r� chcemy pobra�.
     * @return Zwraca warto�� przypisan� do wybranej w�a�ciwo�ci sk�adnika.
     */
    public Double get(PropertyIdentity property) {
	final Double result = properties.get(property);

	if (result == null) {
	    throw new NoSuchElementException("Wybrany sk�adnik nie posiada podanej w�a�ciwo�ci!");
	}

	return result;
    }

    public Double getValueForPropertyWithName(String name) throws NoSuchElementException {
	for (PropertyIdentity each : properties.keySet()) {
	    if (each.getName().equals(name)) {
		return properties.get(each);
	    }
	}
	throw new NoSuchElementException();
    }

    /**
     * @param property
     *            W�asno�� sk�adnika.
     * @param value
     *            Warto�� przypisana do w�asno�ci.
     */
    public void add(PropertyIdentity property, Double value) {
	properties.put(property, value);
    }

    /**
     * @param property
     *            W�asno�� sk�adnika.
     */
    public void remove(PropertyIdentity property) {
	properties.remove(property);
    }

    public void addOperations(Iterable<Operation> operations) {
	this.operations = operations;
    }

    public List<OperationState> doOperations() throws IllegalArgumentException {
	Validator.throwExceptionWhenContainsNullOrEmpty(operations,
		"Zbi�r operacji na sk�adniku nie mo�e by� pusty lub niepe�ny!");

	List<OperationState> result = new ArrayList<OperationState>();

	Iterator<Operation> itearator = operations.iterator();

	while (itearator.hasNext()) {
	    OperationState state = itearator.next().execute();
	    result.add(state);
	}

	return result;
    }
}
