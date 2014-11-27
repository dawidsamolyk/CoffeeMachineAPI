package edu.issi.machine;

import edu.issi.machine.operation.Operation;

/**
 * @author Dawid
 *
 */
public abstract class Handler {
    private Handler nextHandler;
    protected Operation operation;

    /**
     * @param handler
     *            Zadanie, kt�re powinno by� wykonane jako nast�pne w
     *            kolejno�ci.
     * @return Kolejny wykonawca zada�, kt�ry zosta� ustawiony za aktualnym.
     */
    public Handler setNext(Handler handler) {
	this.nextHandler = handler;
	return handler;
    }

    /**
     * @param operation
     *            Operacja do wykonania.
     */
    public void doOperation(Operation operation) {
	//start();
	nextHandler.doOperation(operation);
    }

//    @Override
//    public void run() {
//	if (operation == null) {
//	    throw new UnsupportedOperationException("Nie mo�na wykona� pustej operacji!");
//	}
//    }

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
