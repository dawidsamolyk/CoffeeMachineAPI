package edu.issi.machine.product.ingredient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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
    private Map<PropertyIdentity, Double> properties;
    private Iterable<Operation> operations;

    /**
     * Konstruktor. Obiekt klasy Identity jest wymagany.
     * 
     * @param identity
     *            Identyfikator.
     */
    public Ingredient(Identity identity) {
	super(identity);

	this.properties = new HashMap<PropertyIdentity, Double>();
    }

    /**
     * Zwraca warto�� w�a�ciwo�ci sk�adnika.
     * 
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
     * Dodaje now� w�a�ciwo�� sk�adnika.
     * 
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
     * Usuwa konkretn� w�a�ciwo�� sk�adnika.
     * 
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
	Validator.throwExceptionWhenObjectIsNotCreated(property, "Nie mo�na usun�� w�a�ciwo�ci z pustym identifikatorem!");

	if (!properties.containsKey(property)) {
	    throw new NoSuchElementException("Wybrany sk�adnik nie posiada podanej w�a�ciwo�ci, wi�c nie mo�na jej usun��!");
	}

	properties.remove(property);
    }

    /**
     * Ustawia list� operacji do wykoania. Kolejno�� wykonania operacji jest
     * istotna.
     * 
     * @param operations
     *            Operacje.
     */
    public void setOperations(Iterable<Operation> operations) {
	Validator.throwExceptionWhenEmptyOrContainsEmptyObject(operations, "Nie mo�na dodawa� pustych operacji do sk�adnika!");

	this.operations = operations;
    }

    /**
     * Zwraca wszystkie w�a�ciwo�ci sk�adnika.
     * 
     * @return W�a�ciwo�ci sk�adnika.
     */
    public Map<PropertyIdentity, Double> getProperties() {
	return properties;
    }

    /**
     * Wykonuje wszystkie operacje na sk�adniku i zwraca statusy tych operacji.
     * 
     * @return Statusy wszystkich wykonanych operacji.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li nie ustawiono poprawnych operacji
     *             (niepustych).
     */
    public Collection<OperationStatus> doOperations() throws IllegalArgumentException {
	Validator.throwExceptionWhenEmptyOrContainsEmptyObject(operations,
		"Zbi�r operacji na sk�adniku nie mo�e by� pusty lub niepe�ny!");

	final Collection<OperationStatus> result = new ArrayList<OperationStatus>();

	for (Iterator<Operation> itearator = operations.iterator(); itearator.hasNext();) {
	    OperationStatus state = itearator.next().execute();
	    result.add(state);
	}

	return result;
    }

    /**
     * Ustawia zupe�nie nowe w�a�ciwo�ci sk�adnika (poprzednie zostan� usni�te).
     * 
     * @param ingredientProperties
     *            W�a�ciwo�ci sk�adnika.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li wej�ciowe w�a�ciwo�ci s� puste lub
     *             nieprawid�owe.
     */
    public void set(Map<PropertyIdentity, Double> ingredientProperties) throws IllegalArgumentException {
	Validator.throwExceptionWhenEmptyOrContainsEmptyObject(ingredientProperties.keySet(),
		"Nie mo�na ustawi� pustych w�a�ciwo�ci sk�adnika");

	properties = ingredientProperties;
    }
}
