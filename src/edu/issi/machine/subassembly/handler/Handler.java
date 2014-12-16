package edu.issi.machine.subassembly.handler;

import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationStatus;

/**
 * @author Dawid
 *
 */
public abstract class Handler {
    private boolean isOperationDone = false;
    private OperationStatus noSuchHandlersState = OperationStatus.Factory
	    .createErrorWithDescription("Nie ustawiono kolejnej operacji do wykonania!");
    private Handler nextHandler;

    protected Operation operation;

    /**
     * @param handler
     *            Zadanie, kt�re powinno by� wykonane jako nast�pne w
     *            kolejno�ci.
     * @return Kolejny wykonawca zada�, kt�ry zosta� ustawiony za aktualnym.
     */
    public synchronized Handler next(Handler handler) {
	nextHandler = handler;
	return handler;
    }

    /**
     * @param operation
     *            Operacja do wykonania.
     * @return Status wykonanej operacji (b�dzie dost�pny dopiero po jej
     *         zako�czeniu).
     */
    public synchronized OperationStatus doOperation(Operation operation) {
	if (operation == null) {
	    return OperationStatus.Factory.createErrorWithDescription("Nie mo�na wykona� pustej operacji!");
	}

	this.operation = operation;

	OperationStatus operationState = runOperation();

	isOperationDone = true;

	if (!isLastHandler()) {
	    executeAtNextHandler(operation);
	}

	return operationState;
    }

    protected boolean isLastHandler() {
	return nextHandler == null;
    }

    protected OperationStatus executeAtNextHandler(Operation operation) {
	if (isLastHandler()) {
	    return noSuchHandlersState;
	}
	return nextHandler.doOperation(operation);
    }

    /**
     * @return Czy operacja zosta�a wykonana.
     */
    public synchronized boolean isOperationDone() {
	return isOperationDone;
    }

    /**
     * Wykonanie operacji.
     */
    abstract protected OperationStatus runOperation();

}
