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
     *            W³asnoœæ sk³adnika, któr¹ chcemy pobraæ.
     * @return Zwraca wartoœæ przypisan¹ do wybranej w³aœciwoœci sk³adnika.
     */
    public Double get(PropertyIdentity property) {
	final Double result = properties.get(property);

	if (result == null) {
	    throw new NoSuchElementException("Wybrany sk³adnik nie posiada podanej w³aœciwoœci!");
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

    public void addOperations(Iterable<Operation> operations) {
	this.operations = operations;
    }

    public List<OperationState> doOperations() throws IllegalArgumentException {
	Validator.throwExceptionWhenContainsNullOrEmpty(operations,
		"Zbiór operacji na sk³adniku nie mo¿e byæ pusty lub niepe³ny!");

	List<OperationState> result = new ArrayList<OperationState>();

	Iterator<Operation> itearator = operations.iterator();

	while (itearator.hasNext()) {
	    OperationState state = itearator.next().execute();
	    result.add(state);
	}

	return result;
    }
}
