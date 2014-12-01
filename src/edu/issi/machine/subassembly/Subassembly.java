package edu.issi.machine.subassembly;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.issi.machine.Validator;
import edu.issi.machine.id.Identity;
import edu.issi.machine.id.ObjectWithIdentity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.subassembly.handler.DefaultHandler;
import edu.issi.machine.subassembly.handler.Handler;

/**
 * @author Dawid
 * 
 */
public class Subassembly extends ObjectWithIdentity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1208676282732135179L;

    private final List<Handler> handlers;
    private final List<Operation> operations;

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
    public Subassembly(Identity id, Operation... operations) throws IllegalArgumentException {
	super(id);

	Validator.throwExceptionWhenArrayContainsNullOrEmpty(operations,
		"Lista operacji nie mo�e by� pusta oraz nie mo�e zawiera� pustych operacji!");

	this.operations = getAsList(operations);
	handlers = getNewListWithDefaultHandler();
    }

    private List<Handler> getNewListWithDefaultHandler() {
	final List<Handler> results = new ArrayList<Handler>();

	results.add(new DefaultHandler());

	return results;
    }

    private List<Operation> getAsList(Operation... operations) {
	return Arrays.asList(operations);
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
    public void addLastHandler(Handler handler) {
	handlers.add(handler);
    }

}
