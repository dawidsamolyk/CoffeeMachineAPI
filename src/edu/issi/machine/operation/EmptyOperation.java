package edu.issi.machine.operation;

import edu.issi.machine.id.Identity;

/**
 * @author Dawid Samo³yk
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
     *             Wyst¹pi, jeœli identyfikator bêdzie pusty.
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
	    return OperationStatus.Factory.createError("Nie ustawiono wymaganych parametrów!");
	}
	else if (!canDoThisOperation(subassembly)) {
	    return OperationStatus.Factory.createError("Wybrany podzespó³ nie jest w stanie wykonaæ tej operacji!");
	}

	setDone();
	return OperationStatus.Factory.createValid();
    }

}
