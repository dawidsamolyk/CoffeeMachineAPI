/**
 * 
 */
package edu.issi.machine.operation;

import edu.issi.machine.id.Identity;

/**
 * @author Dawid
 *
 */
public class EmptyOperation extends Operation {
    /**
     * @param id
     */
    public EmptyOperation(Identity id) {
	super(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see edu.issi.machine.operation.Operation#execute()
     */
    @Override
    public synchronized OperationStatus execute() {
	if (!isRequiredElementsProvided()) {
	    return OperationStatus.Factory.createErrorWithDescription("Nie ustawiono wymaganych parametr�w!");
	} else if (!canDoThisOperation(subassembly)) {
	    return OperationStatus.Factory.createErrorWithDescription("Wybrany podzesp� nie jest w stanie wykona� tej operacji!");
	}

	setDone();

	return OperationStatus.Factory.createValidState();
    }

}
