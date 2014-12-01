package edu.issi.machine.subassembly;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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
public class Subassembly extends ObjectWithIdentity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1208676282732135179L;

    private List<Handler> handlers;
    private List<Operation> operations;

    /**
     * @param id
     *            Numer ID.
     * @param operations
     *            Operacje, które mo¿e wykonaæ wybrany podzespó³.
     * @param properties
     *            Dodatkowe w³aœciwoœci podzespo³u.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli lista operacji bêdzie pusta lub niepoprawna.
     */
    public Subassembly(Identity id, Operation... operations) throws IllegalArgumentException {

	super(id);

	Validator.throwExceptionWhenContainsNullOrEmpty(operations,
		"Lista operacji nie mo¿e byæ pusta oraz nie mo¿e zawieraæ pustych operacji!");

	this.operations = getAsList(operations);
	this.handlers = getNewListWithDefaultHandler();
    }

    private List<Handler> getNewListWithDefaultHandler() {
	List<Handler> result = new ArrayList<Handler>();
	result.add(new Handler());
	return result;
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
