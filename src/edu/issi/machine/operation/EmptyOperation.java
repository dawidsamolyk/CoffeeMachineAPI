package edu.issi.machine.operation;

import edu.issi.machine.id.Identity;

/**
 * @author Dawid Samo�yk
 *
 *         Pusta operacja.
 */
public class EmptyOperation extends Operation {
    /**
     * @param id
     *            Identyfikator.
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
	if (!areRequiredElementsProvided()) {
	    setNotDone();

	    return OperationStatus.Factory.createError("Nie ustawiono wymaganych parametr�w!");
	}
	else if (!canDoThisOperation(subassembly)) {
	    setNotDone();

	    return OperationStatus.Factory
		    .createError("Wybrany podzesp� nie jest w stanie wykona� tej operacji!");
	}

	setDone();

	return OperationStatus.Factory.createValid();
    }

}
