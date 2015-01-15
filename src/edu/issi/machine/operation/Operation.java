package edu.issi.machine.operation;

import edu.issi.machine.Validator;
import edu.issi.machine.id.Identity;
import edu.issi.machine.id.ObjectWithIdentity;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.subassembly.Subassembly;

/**
 * @author Dawid Samo³yk
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
     *             Wyst¹pi, jeœli identyfikator bêdzie pusty.
     */
    public Operation(Identity identity) throws IllegalArgumentException {
	super(identity);
    }

    /**
     * @param subassembly
     *            Podzespó³, na którym ma zostaæ wykonana operacja.
     * @return Zwraca referencje do siebie - wzorzec Fluent Interface.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli spodany podzespó³ nie zosta³ utworzony.
     */
    public Operation setSubassembly(Subassembly subassembly) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(subassembly,
		"Nie mo¿na ustawiæ pustego podzespo³u do wykonania operacji!");

	this.subassembly = subassembly;
	return this;
    }

    /**
     * @param ingredient
     *            Sk³adnik, na którym ma zostaæ wykonana operacja.
     * @return Zwraca referencje do siebie - wzorzec Fluent Interface.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli spodany sk³adnik nie zosta³ utworzony.
     */
    public Operation setIngredient(Ingredient ingredient) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(ingredient,
		"Nie mo¿na ustawiæ pustego sk³adnika do wykonania na nim operacji!");

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
		"Nie mo¿na sprawdziæ wykonywalnoœci operacji dla pustego podzespo³u!");

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
     * @return Czy operacja zosta³a zakoñczona.
     */
    public synchronized boolean isDone() {
	return isDone;
    }

}
