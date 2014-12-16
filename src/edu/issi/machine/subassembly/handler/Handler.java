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
     *            Zadanie, które powinno byæ wykonane jako nastêpne w
     *            kolejnoœci.
     * @return Kolejny wykonawca zadañ, który zosta³ ustawiony za aktualnym.
     */
    public synchronized Handler next(Handler handler) {
	nextHandler = handler;
	return handler;
    }

    /**
     * @param operation
     *            Operacja do wykonania.
     * @return Status wykonanej operacji (bêdzie dostêpny dopiero po jej
     *         zakoñczeniu).
     */
    public synchronized OperationStatus doOperation(Operation operation) {
	if (operation == null) {
	    return OperationStatus.Factory.createErrorWithDescription("Nie mo¿na wykonaæ pustej operacji!");
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
     * @return Czy operacja zosta³a wykonana.
     */
    public synchronized boolean isOperationDone() {
	return isOperationDone;
    }

    /**
     * Wykonanie operacji.
     */
    abstract protected OperationStatus runOperation();

}
