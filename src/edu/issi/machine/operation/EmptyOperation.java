package edu.issi.machine.operation;

import edu.issi.machine.id.Identity;

/**
 * @author Dawid Samo�yk
 *
 *         Pusta operacja.
 */
public class EmptyOperation extends Operation {
    /**
     * Konstruktor. Wymagany jest identyfikator (obiekt klasy Identity).
     * 
     * @param id
     *            Identyfikator.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li identyfikator b�dzie pusty.
     * 
     */
    public EmptyOperation(Identity id) throws IllegalArgumentException {
	super(id);
    }

    /*
     * (non-Javadoc)
     * @see edu.issi.machine.operation.Operation#execute()
     */
    @Override
    public synchronized OperationStatus execute() {
	setNotDone();
	
	if (!areRequiredElementsProvided()) {
	    return OperationStatus.Factory.createError("Nie ustawiono wymaganych parametr�w!");
	}
	else if (!canDoThisOperation(subassembly)) {
	    return OperationStatus.Factory.createError("Wybrany podzesp� nie jest w stanie wykona� tej operacji!");
	}

	setDone();
	return OperationStatus.Factory.createValid();
    }

}
