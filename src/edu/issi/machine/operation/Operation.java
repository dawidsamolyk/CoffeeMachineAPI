package edu.issi.machine.operation;

import edu.issi.machine.Validator;
import edu.issi.machine.id.Identity;
import edu.issi.machine.id.ObjectWithIdentity;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.subassembly.Subassembly;

/**
 * @author Dawid Samo�yk
 * 
 *         Operacja.
 */
public abstract class Operation extends ObjectWithIdentity {
    private boolean isDone = false;

    protected Subassembly subassembly;
    protected Ingredient ingredient;

    /**
     * @param identity
     *            Identyfikator.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li identyfikator b�dzie pusty.
     */
    public Operation(Identity identity) throws IllegalArgumentException {
	super(identity);
    }

    /**
     * @param subassembly
     *            Podzesp�, na kt�rym ma zosta� wykonana operacja.
     * @return Zwraca referencje do siebie - wzorzec Fluent Interface.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li spodany podzesp� nie zosta� utworzony.
     */
    public Operation setSubassembly(Subassembly subassembly) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(subassembly,
		"Nie mo�na ustawi� pustego podzespo�u do wykonania operacji!");

	this.subassembly = subassembly;
	return this;
    }

    /**
     * @param ingredient
     *            Sk�adnik, na kt�rym ma zosta� wykonana operacja.
     * @return Zwraca referencje do siebie - wzorzec Fluent Interface.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li spodany sk�adnik nie zosta� utworzony.
     */
    public Operation setIngredient(Ingredient ingredient) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(ingredient,
		"Nie mo�na ustawi� pustego sk�adnika do wykonania na nim operacji!");

	this.ingredient = ingredient;
	return this;
    }

    /**
     * Wykonanie operacji.
     * @return Stan operacji.
     */
    public abstract OperationStatus execute();

    protected boolean canDoThisOperation(Subassembly subassembly) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(subassembly,
		"Nie mo�na sprawdzi� wykonywalno�ci operacji dla pustego podzespo�u!");

	return subassembly.supports(this);
    }

    protected boolean areRequiredElementsProvided() {
	return subassembly != null && ingredient != null;
    }

    protected synchronized void setDone() {
	isDone = true;
    }

    protected synchronized void setNotDone() {
	isDone = false;
    }

    /**
     * @return Czy operacja zosta�a zako�czona.
     */
    public synchronized boolean isDone() {
	return isDone;
    }

}
