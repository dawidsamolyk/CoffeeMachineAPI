package edu.issi.machine.operation;

import edu.issi.machine.Validator;
import edu.issi.machine.id.Identity;
import edu.issi.machine.id.ObjectWithIdentity;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.subassembly.Subassembly;

/**
 * @author Dawid
 * 
 */
public abstract class Operation extends ObjectWithIdentity {
    private boolean isDone = false;

    protected Subassembly subassembly;
    protected Ingredient ingredient;

    /**
     * @param identity
     *            Identyfikator.
     * @param methods
     *            Funkcje do wykonania.
     */
    public Operation(Identity identity) {
	super(identity);
    }

    /**
     * @param subassembly
     *            Podzespó³, na którym ma zostaæ wykonana operacja.
     * @return Zwraca referencje do siebie - wzorzec Fluent Interface.
     */
    public Operation setSubassembly(Subassembly subassembly) {
	Validator.throwExceptionWhenObjectIsNotCreated(subassembly, "Nie mo¿na ustawiæ pustego podzespo³u do wykonania operacji!");
	
	this.subassembly = subassembly;
	return this;
    }

    /**
     * @param ingredient
     *            Sk³adnik, na którym ma zostaæ wykonana operacja.
     * @return Zwraca referencje do siebie - wzorzec Fluent Interface.
     */
    public Operation setIngredient(Ingredient ingredient) {
	Validator.throwExceptionWhenObjectIsNotCreated(ingredient, "Nie mo¿na ustawiæ pustego sk³adnika do wykonania na nim operacji!");

	this.ingredient = ingredient;
	return this;
    }

    /**
     * @return Stan operacji.
     */
    public abstract OperationStatus execute();

    protected boolean canDoThisOperation(Subassembly subassembly) {
	return subassembly.supports(this);
    }

    protected boolean isRequiredElementsProvided() {
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
