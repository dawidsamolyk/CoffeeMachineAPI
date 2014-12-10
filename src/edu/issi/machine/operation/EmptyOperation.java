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
	 * 
	 */
	private static final long serialVersionUID = -1356621351041006478L;

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
	public OperationState execute() {
		if (!isRequiredElementsProvided()) {
			return new OperationState(Status.ERROR,
					"Nie ustawiono wymaganych parametrów!");

		} else if (!canDoThisOperation(subassembly)) {
			return new OperationState(Status.ERROR,
					"Wybrany podzespó³ nie jest w stanie wykonaæ tej operacji!");
		}
		return new OperationState(Status.OK);
	}

}
