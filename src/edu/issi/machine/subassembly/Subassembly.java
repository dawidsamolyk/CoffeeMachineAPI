package edu.issi.machine.subassembly;

import java.util.List;

import edu.issi.machine.Validator;
import edu.issi.machine.id.Identity;
import edu.issi.machine.id.ObjectWithIdentity;
import edu.issi.machine.operation.Operation;

/**
 * @author Dawid
 * 
 */
public abstract class Subassembly extends ObjectWithIdentity {
    protected List<Operation> operations;

    /**
     * @param id
     *            Numer ID.
     * @param operations
     *            Operacje, kt�re mo�e wykona� wybrany podzesp�.
     * @param properties
     *            Dodatkowe w�a�ciwo�ci podzespo�u.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li lista operacji b�dzie pusta lub niepoprawna.
     */
    public Subassembly(Identity id, List<Operation> operations) throws IllegalArgumentException {
	super(id);

	Validator.throwExceptionWhenEmptyOrContainsNullObjects(operations,
		"Lista operacji nie mo�e by� pusta oraz nie mo�e zawiera� pustych operacji!");

	this.operations = operations;
    }

    /**
     * @param operation
     *            Operacja.
     * @return Czy podzespol wspiera podana operacje.
     * @throws IllegalArgumentException
     */
    public boolean supports(Operation operation) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(operation,
		"Nie jest mo�liwe sprawdzanie zgodno�ci z pust� operacj�!");

	return operations.contains(operation);
    }

    /**
     * 
     */
    public abstract void run();

    /**
     * 
     */
    public abstract void stop();

}
