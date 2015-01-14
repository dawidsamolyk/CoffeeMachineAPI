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
import edu.issi.machine.operation.OperationStatus;

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
     * @throws IllegalArgumentException 
     */
    public Double get(PropertyIdentity property) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(property, "Nie mo�na pobra� pustej w�a�ciwo�ci");
	
	final Double result = properties.get(property);

	if (result == null) {
	    throw new NoSuchElementException("Wybrany sk�adnik nie posiada podanej w�a�ciwo�ci!");
	}

	return result;
    }

    /**
     * @param name
     * @return Warto��.
     * @throws NoSuchElementException
     * @throws IllegalArgumentException 
     */
    public Double getValueForPropertyWithName(String name) throws NoSuchElementException, IllegalArgumentException {
	Validator.throwExceptionWhenTextIsEmpty(name, "Nazwa pobieranej w�a�ciwo�ci sk�anika nie mo�e by� pusta!");
	
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
	Validator.throwExceptionWhenObjectIsNotCreated(property, "Nie mo�na w�a�ciwo�ci z pustym identifikatorem!");
	Validator.throwExceptionWhenObjectIsNotCreated(value, "Nie mo�na doda� w�a�ciwo�ci z pust� warto�ci�!");
	
	properties.put(property, value);
    }

    /**
     * @param property
     *            W�asno�� sk�adnika.
     */
    public void remove(PropertyIdentity property) {
	Validator.throwExceptionWhenObjectIsNotCreated(property, "Nie mo�na usun�� w�a�ciwo�ci z pustym identifikatorem!");
	
	properties.remove(property);
    }

    /**
     * @param operations
     */
    public void setOperations(Iterable<Operation> operations) {
	Validator.throwExceptionWhenContainsNullOrEmpty(operations, "Nie mo�na dodawa� pustych operacji do sk�adnika!");
	
	this.operations = operations;
    }

    /**
     * @return W�a�ciwo�ci sk�adnika.
     */
    public Map<PropertyIdentity, Double> getProperties() {
	return properties;
    }

    /**
     * @return Statusy wszystkich wykonanych operacji.
     * @throws IllegalArgumentException
     */
    public List<OperationStatus> doOperations() throws IllegalArgumentException {
	Validator.throwExceptionWhenContainsNullOrEmpty(operations,
		"Zbi�r operacji na sk�adniku nie mo�e by� pusty lub niepe�ny!");

	List<OperationStatus> result = new ArrayList<OperationStatus>();

	Iterator<Operation> itearator = operations.iterator();

	while (itearator.hasNext()) {
	    OperationStatus state = itearator.next().execute();
	    result.add(state);
	}

	return result;
    }
}
