package edu.issi.machine.subassembly.handler;

import java.io.Serializable;

import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationState;
import edu.issi.machine.operation.Status;

/**
 * @author Dawid
 *
 */
public abstract class Handler implements Serializable {
	/**
     * 
     */
	private static final long serialVersionUID = -5027179270529781719L;

	private Handler nextHandler;
	protected Operation operation;

	/**
	 * @param handler
	 *            Zadanie, które powinno byæ wykonane jako nastêpne w
	 *            kolejnoœci.
	 * @return Kolejny wykonawca zadañ, który zosta³ ustawiony za aktualnym.
	 */
	public Handler next(Handler handler) {
		nextHandler = handler;
		return handler;
	}

	/**
	 * @param operation
	 *            Operacja do wykonania.
	 * @return Status wykonanej operacji (bêdzie dostêpny dopiero po jej
	 *         zakoñczeniu).
	 */
	public synchronized OperationState doOperation(Operation operation) {
		if (operation == null) {
			return new OperationState(Status.ERROR,
					"Nie mo¿na wykonaæ pustej operacji!");
		}

		OperationState operationState = run();

		executeNext(operation);

		return operationState;
	}

	protected OperationState executeNext(Operation operation) {
		if (nextHandler != null) {
			return nextHandler.doOperation(operation);
		}
		return new OperationState(Status.WARNING,
				"Nie ustawiono kolejnej operacji do wykonania!");
	}

	/**
	 * Wykonanie operacji.
	 */
	abstract protected OperationState run();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((operation == null) ? 0 : operation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		final Handler other = (Handler) obj;
		if (nextHandler == null) {
			if (other.nextHandler != null)
				return false;
		} else if (!nextHandler.equals(other.nextHandler))
			return false;
		if (operation == null) {
			if (other.operation != null)
				return false;
		} else if (!operation.equals(other.operation))
			return false;
		return true;
	}

}
