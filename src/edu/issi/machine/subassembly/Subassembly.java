package edu.issi.machine.subassembly;

import java.util.List;

import edu.issi.machine.Validator;
import edu.issi.machine.id.Identity;
import edu.issi.machine.id.ObjectWithIdentity;
import edu.issi.machine.operation.Operation;

/**
 * @author Dawid Samo³yk
 * 
 *         Podzespó³.
 */
public abstract class Subassembly extends ObjectWithIdentity {
    protected List<Operation> operations;

    /**
     * @param id
     *            Identyfikator.
     * @param operations
     *            Operacje, które mo¿e wykonaæ wybrany podzespó³.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli lista operacji bêdzie pusta lub niepoprawna.
     */
    public Subassembly(Identity id, List<Operation> operations) throws IllegalArgumentException {
	super(id);

	Validator.throwExceptionWhenContainsNullOrEmpty(operations,
		"Lista operacji nie mo¿e byæ pusta oraz nie mo¿e zawieraæ pustych operacji!");

	this.operations = operations;
    }

    /**
     * @param operation
     *            Operacja.
     * @return Czy podzespol wspiera podana operacje.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli operacja nie zosta³a utworzona.
     */
    public boolean supports(Operation operation) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(operation,
		"Nie jest mo¿liwe sprawdzanie zgodnoœci z pust¹ operacj¹!");

	return operations.contains(operation);
    }

    /**
     * Uruchomia podzespó³.
     */
    public abstract void run();

    /**
     * Zatrzymuje podzespó³.
     */
    public abstract void stop();

}
