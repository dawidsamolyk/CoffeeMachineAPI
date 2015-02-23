package edu.issi.machine.subassembly;

import java.util.Collection;

import edu.issi.machine.Validator;
import edu.issi.machine.id.Identity;
import edu.issi.machine.id.ObjectWithIdentity;
import edu.issi.machine.operation.Operation;

/**
 * @author Dawid Samo�yk
 * 
 *         Podzesp�.
 */
public abstract class Subassembly extends ObjectWithIdentity {
    protected final Collection<Operation> operations;

    /**
     * Konstruktor. Obiekt klasy Identity oraz kolekcja obiekt�w Operation musz�
     * by� utworzone.
     * 
     * @param id
     *            Identyfikator.
     * @param operations
     *            Operacje, kt�re mo�e wykona� wybrany podzesp�.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li lista operacji b�dzie pusta lub niepoprawna.
     */
    public Subassembly(Identity id, Collection<Operation> operations) throws IllegalArgumentException {
	super(id);

	Validator.throwExceptionWhenEmptyOrContainsEmptyObject(operations,
		"Lista operacji nie mo�e by� pusta oraz nie mo�e zawiera� pustych operacji!");

	this.operations = operations;
    }

    /**
     * Informuje czy podzesp� jest w stanie wykona� podan� operacj�.
     * 
     * @param operation
     *            Operacja.
     * @return Czy podzespol wspiera podana operacje.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li operacja nie zosta�a utworzona.
     */
    public boolean supports(Operation operation) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(operation, "Nie jest mo�liwe sprawdzanie zgodno�ci z pust� operacj�!");
	return operations.contains(operation);
    }

    /**
     * Uruchomia podzesp�.
     */
    public abstract void run();

    /**
     * Zatrzymuje podzesp�.
     */
    public abstract void stop();

}
