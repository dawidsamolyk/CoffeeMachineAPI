package edu.issi.machine.subassembly;

import java.util.ArrayList;
import java.util.List;

import edu.issi.machine.Validator;
import edu.issi.machine.id.Identity;
import edu.issi.machine.id.ObjectWithIdentity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.subassembly.handler.Handler;

/**
 * @author Dawid
 * 
 */
public abstract class Subassembly extends ObjectWithIdentity {
    protected List<Handler> handlers;
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
	this.handlers = new ArrayList<Handler>();
    }

    /**
     * @param id
     * @param operations
     * @param handlers
     * @throws IllegalArgumentException
     */
    public Subassembly(Identity id, List<Operation> operations, List<Handler> handlers) throws IllegalArgumentException {
	this(id, operations);
	this.handlers = handlers;
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
     * @param handler
     *            Wykonawca operacji.
     */
    public void addHandler(Handler handler) {
	if (handler != null) {
	    handlers.add(handler);
	}
    }

    /**
     * 
     */
    public abstract void run();

}
