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
     *            W³asnoœæ sk³adnika, któr¹ chcemy pobraæ.
     * @return Zwraca wartoœæ przypisan¹ do wybranej w³aœciwoœci sk³adnika.
     * @throws IllegalArgumentException 
     */
    public Double get(PropertyIdentity property) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(property, "Nie mo¿na pobraæ pustej w³aœciwoœci");
	
	final Double result = properties.get(property);

	if (result == null) {
	    throw new NoSuchElementException("Wybrany sk³adnik nie posiada podanej w³aœciwoœci!");
	}

	return result;
    }

    /**
     * @param name
     * @return Wartoœæ.
     * @throws NoSuchElementException
     * @throws IllegalArgumentException 
     */
    public Double getValueForPropertyWithName(String name) throws NoSuchElementException, IllegalArgumentException {
	Validator.throwExceptionWhenTextIsEmpty(name, "Nazwa pobieranej w³aœciwoœci sk³anika nie mo¿e byæ pusta!");
	
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
	Validator.throwExceptionWhenObjectIsNotCreated(property, "Nie mo¿na w³aœciwoœci z pustym identifikatorem!");
	Validator.throwExceptionWhenObjectIsNotCreated(value, "Nie mo¿na dodaæ w³aœciwoœci z pust¹ wartoœci¹!");
	
	properties.put(property, value);
    }

    /**
     * @param property
     *            W³asnoœæ sk³adnika.
     */
    public void remove(PropertyIdentity property) {
	Validator.throwExceptionWhenObjectIsNotCreated(property, "Nie mo¿na usun¹æ w³aœciwoœci z pustym identifikatorem!");
	
	properties.remove(property);
    }

    /**
     * @param operations
     */
    public void setOperations(Iterable<Operation> operations) {
	Validator.throwExceptionWhenContainsNullOrEmpty(operations, "Nie mo¿na dodawaæ pustych operacji do sk³adnika!");
	
	this.operations = operations;
    }

    /**
     * @return W³aœciwoœci sk³adnika.
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
		"Zbiór operacji na sk³adniku nie mo¿e byæ pusty lub niepe³ny!");

	List<OperationStatus> result = new ArrayList<OperationStatus>();

	Iterator<Operation> itearator = operations.iterator();

	while (itearator.hasNext()) {
	    OperationStatus state = itearator.next().execute();
	    result.add(state);
	}

	return result;
    }
}
