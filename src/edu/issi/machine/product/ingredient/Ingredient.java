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
 * @author Dawid Samo³yk
 * 
 *         Sk³adnik.
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
     * Zwraca wartoœæ w³aœciwoœci sk³adnika.
     * 
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
     * Dodaje now¹ w³aœciwoœæ sk³adnika.
     * 
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
     * Usuwa konkretn¹ w³aœciwoœæ sk³adnika.
     * 
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
	Validator.throwExceptionWhenObjectIsNotCreated(property, "Nie mo¿na usun¹æ w³aœciwoœci z pustym identifikatorem!");

	if (!properties.containsKey(property)) {
	    throw new NoSuchElementException("Wybrany sk³adnik nie posiada podanej w³aœciwoœci, wiêc nie mo¿na jej usun¹æ!");
	}

	properties.remove(property);
    }

    /**
     * Ustawia listê operacji do wykoania. Kolejnoœæ wykonania operacji jest
     * istotna.
     * 
     * @param operations
     *            Operacje.
     */
    public void setOperations(Iterable<Operation> operations) {
	Validator.throwExceptionWhenEmptyOrContainsEmptyObject(operations, "Nie mo¿na dodawaæ pustych operacji do sk³adnika!");

	this.operations = operations;
    }

    /**
     * Zwraca wszystkie w³aœciwoœci sk³adnika.
     * 
     * @return W³aœciwoœci sk³adnika.
     */
    public Map<PropertyIdentity, Double> getProperties() {
	return properties;
    }

    /**
     * Wykonuje wszystkie operacje na sk³adniku i zwraca statusy tych operacji.
     * 
     * @return Statusy wszystkich wykonanych operacji.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli nie ustawiono poprawnych operacji
     *             (niepustych).
     */
    public Collection<OperationStatus> doOperations() throws IllegalArgumentException {
	Validator.throwExceptionWhenEmptyOrContainsEmptyObject(operations,
		"Zbiór operacji na sk³adniku nie mo¿e byæ pusty lub niepe³ny!");

	final Collection<OperationStatus> result = new ArrayList<OperationStatus>();

	for (Iterator<Operation> itearator = operations.iterator(); itearator.hasNext();) {
	    OperationStatus state = itearator.next().execute();
	    result.add(state);
	}

	return result;
    }

    /**
     * Ustawia zupe³nie nowe w³aœciwoœci sk³adnika (poprzednie zostan¹ usniête).
     * 
     * @param ingredientProperties
     *            W³aœciwoœci sk³adnika.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli wejœciowe w³aœciwoœci s¹ puste lub
     *             nieprawid³owe.
     */
    public void set(Map<PropertyIdentity, Double> ingredientProperties) throws IllegalArgumentException {
	Validator.throwExceptionWhenEmptyOrContainsEmptyObject(ingredientProperties.keySet(),
		"Nie mo¿na ustawiæ pustych w³aœciwoœci sk³adnika");

	properties = ingredientProperties;
    }
}
