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
 * @author Dawid Samo�yk
 * 
 *         Sk�adnik.
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
     *             Wyst�pi, je�li identyfikator b�dzie pusty.
     * @throws NoSuchElementException
     *             Wyst�pi, gdy sk�adnik nie posiada podanej w�a�ciwo�ci.
     */
    public Double get(PropertyIdentity property) throws IllegalArgumentException, NoSuchElementException {
	Validator.throwExceptionWhenObjectIsNotCreated(property, "Nie mo�na pobra� pustej w�a�ciwo�ci!");

	final Double result = properties.get(property);

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
    public void add(PropertyIdentity property, Double value) {
	Validator.throwExceptionWhenObjectIsNotCreated(property, "Nie mo�na w�a�ciwo�ci z pustym identifikatorem!");
	Validator.throwExceptionWhenObjectIsNotCreated(value, "Nie mo�na doda� w�a�ciwo�ci z pust� warto�ci�!");

	properties.put(property, value);
    }

    /**
     * @param property
     *            W�asno�� sk�adnika.
     * @throws IllegalArgumentException
     *             Wyst�pi, gdy zajdzie pr�ba usuni�cia w�a�ciwo�ci z pustym
     *             identyfikatorem.
     * @throws NoSuchElementException
     *             Wyst�pi, gdy zajdzie pr�ba usuni�cia w�a�ciwo�ci, kt�rej ten
     *             sk�adnik nie posiada.
     */
    public void remove(PropertyIdentity property) throws IllegalArgumentException, NoSuchElementException {
	Validator.throwExceptionWhenObjectIsNotCreated(property,
		"Nie mo�na usun�� w�a�ciwo�ci z pustym identifikatorem!");

	if (!properties.containsKey(property)) {
	    throw new NoSuchElementException(
		    "Wybrany sk�adnik nie posiada podanej w�a�ciwo�ci, wi�c nie mo�na jej usun��!");
	}

	properties.remove(property);
    }

    /**
     * @param operations
     *            Operacje.
     */
    public void setOperations(Iterable<Operation> operations) {
	Validator.throwExceptionWhenEmptyOrContainsEmptyObject(operations, "Nie mo�na dodawa� pustych operacji do sk�adnika!");

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
     *             Wyst�pi, je�li nie ustawiono poprawnych operacji
     *             (niepustych).
     */
    public List<OperationStatus> doOperations() throws IllegalArgumentException {
	Validator.throwExceptionWhenEmptyOrContainsEmptyObject(operations,
		"Zbi�r operacji na sk�adniku nie mo�e by� pusty lub niepe�ny!");

	final List<OperationStatus> result = new ArrayList<OperationStatus>();

	for (Iterator<Operation> itearator = operations.iterator(); itearator.hasNext();) {
	    OperationStatus state = itearator.next().execute();
	    result.add(state);
	}

	return result;
    }
}
