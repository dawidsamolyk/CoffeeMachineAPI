package edu.issi.machine.subassembly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import javax.naming.directory.InvalidAttributeValueException;

import edu.issi.exceptions.MachineValidatorException;
import edu.issi.machine.Handler;
import edu.issi.machine.id.Identity;
import edu.issi.machine.id.ObjectWithIdentity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.properties.Properties;

/**
 * @author Dawid
 * 
 */
public class Subassembly extends ObjectWithIdentity {
    private List<Handler> handlersChains;
    private List<Operation> operations;
    private Properties properties;

    /**
     * @param id
     *            Numer ID.
     * @param operations
     *            Operacje, kt�re mo�e wykona� wybrany podzesp�.
     * @param properties
     *            Dodatkowe w�a�ciwo�ci podzespo�u.
     * @throws InvalidAttributeValueException
     *             Wyst�pi, je�li lista operacji b�dzie pusta.
     */
    public Subassembly(Identity id, Properties properties, Operation... operations)
	    throws InvalidAttributeValueException {

	super(id);

	if (isEmpty(operations)) {
	    throw new InvalidAttributeValueException();
	}

	this.operations = Arrays.asList(operations);
	this.properties = properties;
	this.handlersChains = new ArrayList<Handler>();
	//handlersChains.add(new DefaultHandler());
    }

    /**
     * @param operation
     *            Operacja.
     * @return Czy podzespol wspiera podana operacje.
     */
    public boolean supports(Operation operation) {
	return operations.contains(operation);
    }

    /**
     * @param id
     *            Numer ID.
     * @return Wlasciwosc dla obiektu o podanym identyfikatorze.
     * @throws NoSuchElementException
     *             Wyst�pi, je�li nie istnieje dodatkowa w�a�ciwo�� podzespo�u o
     *             podanym ID.
     */
    public Object getProperty(Identity id) throws NoSuchElementException {
	MachineValidatorException.generateExceptionWhenObjectIsNotCreated(this.properties,
		"Ten podzespol nie ma ustawionych zadnych wlasciwosci.");

	Object result = properties.get(id);

	MachineValidatorException.generateExceptionWhenObjectIsNotCreated(result,
		"Ten podzespol nie posiada wlasciwosci o podanym identyfikatorze.");

	return result;
    }

    /**
     * @param handler
     *            Wykonawca operacji.
     */
    public void addLastHandler(Handler handler) {
	this.handlersChains.add(handler);
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((handlersChains == null) ? 0 : handlersChains.hashCode());
	result = prime * result + ((operations == null) ? 0 : operations.hashCode());
	result = prime * result + ((properties == null) ? 0 : properties.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!super.equals(obj))
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Subassembly other = (Subassembly) obj;
	if (handlersChains == null) {
	    if (other.handlersChains != null)
		return false;
	} else if (!handlersChains.equals(other.handlersChains))
	    return false;
	if (operations == null) {
	    if (other.operations != null)
		return false;
	} else if (!operations.equals(other.operations))
	    return false;
	if (properties == null) {
	    if (other.properties != null)
		return false;
	} else if (!properties.equals(other.properties))
	    return false;
	return true;
    }

    private boolean isEmpty(Operation[] operations) {
	return operations == null || operations.length == 0;
    }

}
