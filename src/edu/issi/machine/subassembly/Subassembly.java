package edu.issi.machine.subassembly;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import javax.naming.directory.InvalidAttributeValueException;

import edu.issi.exceptions.MachineValidatorException;
import edu.issi.machine.Identity;
import edu.issi.machine.ObjectWithId;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.properties.Properties;

/**
 * @author Dawid
 * 
 */
public class Subassembly extends ObjectWithId {
    private Properties properties;
    private List<Operation> operations;

    /**
     * @param id
     *            Numer ID.
     * @param operations
     *            Operacje, które mo¿e wykonaæ wybrany podzespó³.
     * @param properties
     *            Dodatkowe w³aœciwoœci podzespo³u.
     * @throws InvalidAttributeValueException
     *             Wyst¹pi, jeœli lista operacji bêdzie pusta.
     */
    public Subassembly(Identity id, Properties properties, Operation... operations)
	    throws InvalidAttributeValueException {

	super(id);

	if (isEmpty(operations)) {
	    throw new InvalidAttributeValueException();
	}

	this.operations = Arrays.asList(operations);
	this.properties = properties;
    }

    /**
     * @param operation
     *            Operacja.
     * @return Czy podzespol wspiera podana operacje.
     */
    public boolean supports(Operation operation) {
	return operations.contains(operation);
    }

    /**
     * @param id
     *            Numer ID.
     * @return Wlasciwosc dla obiektu o podanym identyfikatorze.
     * @throws NoSuchElementException
     *             Wyst¹pi, jeœli nie istnieje dodatkowa w³aœciwoœæ podzespo³u o
     *             podanym ID.
     */
    public Object getProperty(Identity id) throws NoSuchElementException {
	MachineValidatorException.generateExceptionWhenObjectIsNotCreated(this.properties,
		"Ten podzespol nie ma ustawionych zadnych wlasciwosci.");

	Object result = properties.get(id);

	MachineValidatorException.generateExceptionWhenObjectIsNotCreated(result,
		"Ten podzespol nie posiada wlasciwosci o podanym identyfikatorze.");

	return result;
    }

    private boolean isEmpty(Operation[] operations) {
	return operations == null || operations.length == 0;
    }

}
