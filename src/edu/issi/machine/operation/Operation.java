package edu.issi.machine.operation;

import java.io.Serializable;

import edu.issi.machine.id.Identity;
import edu.issi.machine.id.ObjectWithIdentity;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.subassembly.Subassembly;

/**
 * @author Dawid
 * 
 */
public class Operation extends ObjectWithIdentity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -8742139834110667380L;

    private Subassembly subassembly = null;
    private Ingredient ingredient = null;

    /**
     * @param id
     *            Identyfikator.
     */
    public Operation(Identity id) {
	super(id);
    }

    /**
     * @param subassembly
     *            Podzespó³, na którym ma zostaæ wykonana operacja.
     * @return Zwraca referencje do siebie - wzorzec Fluent Interface.
     */
    public Operation setSubassembly(Subassembly subassembly) {
	this.subassembly = subassembly;
	return this;
    }

    /**
     * @param ingredient
     *            Sk³adnik, na którym ma zostaæ wykonana operacja.
     * @return Zwraca referencje do siebie - wzorzec Fluent Interface.
     */
    public Operation setIngredient(Ingredient ingredient) {
	this.ingredient = ingredient;
	return this;
    }

    /**
     * @return Stan operacji.
     */
    public OperationState execute() {
	if (!isRequiredElementsProvided()) {
	    return new OperationState(Status.ERROR, "Nie podano podzespolu lub skladnika dla tej operacji!");
	}

	if (!canDoThisOperation(subassembly)) {
	    return new OperationState(Status.ERROR, "Podzespol nie moze wykonac tej operacji!");
	}

	// TODO
	
	return new OperationState(Status.OK);
    }

    private boolean canDoThisOperation(Subassembly subassembly) {
	return subassembly.supports(this);
    }

    private boolean isRequiredElementsProvided() {
	return (subassembly != null && ingredient != null);
    }

}
