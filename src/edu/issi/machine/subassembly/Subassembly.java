package edu.issi.machine.subassembly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import javax.naming.directory.InvalidAttributeValueException;

import edu.issi.exceptions.Validator;
import edu.issi.machine.id.Identity;
import edu.issi.machine.id.ObjectWithIdentity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.properties.Properties;

/**
 * @author Dawid
 * 
 */
public class Subassembly extends ObjectWithIdentity {
    private List<Handler> handlers;
    private List<Operation> operations;
    private Properties properties;

    /**
     * @param id
     *            Numer ID.
     * @param operations
     *            Operacje, które mo¿e wykonaæ wybrany podzespó³.
     * @param properties
     *            Dodatkowe w³aœciwoœci podzespo³u.
     * @throws InvalidAttributeValueException
     *             Wyst¹pi, jeœli lista operacji bêdzie pusta.
     */
    public Subassembly(Identity id, Properties properties, Operation... operations)
	    throws InvalidAttributeValueException {

	super(id);

	Validator.throwExceptionWhenEmpty(operations, "Lista operacji nie mo¿e byæ pusta!");

	this.properties = properties;

	this.operations = getAsList(operations);
	this.handlers = getNewListWithDefaultHandler();
    }

    private List<Handler> getNewListWithDefaultHandler() {
	List<Handler> result = new ArrayList<Handler>();
	handlers.add(new DefaultHandler());
	return result;
    }

    private List<Operation> getAsList(Operation... operations) {
	return Arrays.asList(operations);
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
     *             Wyst¹pi, jeœli nie istnieje dodatkowa w³aœciwoœæ podzespo³u o
     *             podanym ID.
     */
    public Object getProperty(Identity id) throws NoSuchElementException {
	Validator.generateExceptionWhenObjectIsNotCreated(properties,
		"Ten podzespol nie ma ustawionych zadnych wlasciwosci.");

	Object result = properties.get(id);

	Validator.generateExceptionWhenObjectIsNotCreated(result,
		"Ten podzespol nie posiada wlasciwosci o podanym identyfikatorze.");

	return result;
    }

    /**
     * @param handler
     *            Wykonawca operacji.
     */
    public void addLastHandler(Handler handler) {
	handlers.add(handler);
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((handlers == null) ? 0 : handlers.hashCode());
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
	if (handlers == null) {
	    if (other.handlers != null)
		return false;
	} else if (!handlers.equals(other.handlers))
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

}
