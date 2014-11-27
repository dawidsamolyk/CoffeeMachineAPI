package edu.issi.machine.subassembly.handler;

import java.io.Serializable;

import edu.issi.machine.operation.Operation;

/**
 * @author Dawid
 *
 */
public class Handler implements Serializable {
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
     */
    public void doOperation(Operation operation) {
	if (operation == null) {
	    throw new UnsupportedOperationException("Nie mo¿na obs³u¿yæ pustej operacji!");
	}
	run();
	nextHandler.doOperation(operation);
    }

    /**
     * 
     */
    protected void run() {
	operation.execute();
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((nextHandler == null) ? 0 : nextHandler.hashCode());
	result = prime * result + ((operation == null) ? 0 : operation.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Handler other = (Handler) obj;
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
