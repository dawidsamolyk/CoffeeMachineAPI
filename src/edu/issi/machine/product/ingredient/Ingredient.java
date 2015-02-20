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
 * @author Dawid Samo³yk
 * 
 *         Sk³adnik.
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
     *             Wyst¹pi, jeœli identyfikator bêdzie pusty.
     * @throws NoSuchElementException
     *             Wyst¹pi, gdy sk³adnik nie posiada podanej w³aœciwoœci.
     */
    public Double get(PropertyIdentity property) throws IllegalArgumentException, NoSuchElementException {
	Validator.throwExceptionWhenObjectIsNotCreated(property, "Nie mo¿na pobraæ pustej w³aœciwoœci!");

	final Double result = properties.get(property);

	if (result == null) {
	    throw new NoSuchElementException("Wybrany sk³adnik nie posiada podanej w³aœciwoœci!");
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
	Validator.throwExceptionWhenObjectIsNotCreated(property, "Nie mo¿na w³aœciwoœci z pustym identifikatorem!");
	Validator.throwExceptionWhenObjectIsNotCreated(value, "Nie mo¿na dodaæ w³aœciwoœci z pust¹ wartoœci¹!");

	properties.put(property, value);
    }

    /**
     * @param property
     *            W³asnoœæ sk³adnika.
     * @throws IllegalArgumentException
     *             Wyst¹pi, gdy zajdzie próba usuniêcia w³aœciwoœci z pustym
     *             identyfikatorem.
     * @throws NoSuchElementException
     *             Wyst¹pi, gdy zajdzie próba usuniêcia w³aœciwoœci, której ten
     *             sk³adnik nie posiada.
     */
    public void remove(PropertyIdentity property) throws IllegalArgumentException, NoSuchElementException {
	Validator.throwExceptionWhenObjectIsNotCreated(property,
		"Nie mo¿na usun¹æ w³aœciwoœci z pustym identifikatorem!");

	if (!properties.containsKey(property)) {
	    throw new NoSuchElementException(
		    "Wybrany sk³adnik nie posiada podanej w³aœciwoœci, wiêc nie mo¿na jej usun¹æ!");
	}

	properties.remove(property);
    }

    /**
     * @param operations
     *            Operacje.
     */
    public void setOperations(Iterable<Operation> operations) {
	Validator.throwExceptionWhenEmptyOrContainsEmptyObject(operations, "Nie mo¿na dodawaæ pustych operacji do sk³adnika!");

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
     *             Wyst¹pi, jeœli nie ustawiono poprawnych operacji
     *             (niepustych).
     */
    public List<OperationStatus> doOperations() throws IllegalArgumentException {
	Validator.throwExceptionWhenEmptyOrContainsEmptyObject(operations,
		"Zbiór operacji na sk³adniku nie mo¿e byæ pusty lub niepe³ny!");

	final List<OperationStatus> result = new ArrayList<OperationStatus>();

	for (Iterator<Operation> itearator = operations.iterator(); itearator.hasNext();) {
	    OperationStatus state = itearator.next().execute();
	    result.add(state);
	}

	return result;
    }
}
