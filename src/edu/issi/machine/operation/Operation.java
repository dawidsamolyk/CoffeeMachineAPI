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
public abstract class Operation extends ObjectWithIdentity implements
		Serializable {
	/**
     * 
     */
	private static final long serialVersionUID = -8742139834110667380L;

	protected Subassembly subassembly;
	protected Ingredient ingredient;

	/**
	 * @param id
	 *            Identyfikator.
	 * @param methods
	 *            Funkcje do wykonania.
	 */
	public Operation(Identity id) {
		super(id);
	}

	/**
	 * @param subassembly
	 *            Podzesp�, na kt�rym ma zosta� wykonana operacja.
	 * @return Zwraca referencje do siebie - wzorzec Fluent Interface.
	 */
	public Operation setSubassembly(Subassembly subassembly) {
		this.subassembly = subassembly;
		return this;
	}

	/**
	 * @param ingredient
	 *            Sk�adnik, na kt�rym ma zosta� wykonana operacja.
	 * @return Zwraca referencje do siebie - wzorzec Fluent Interface.
	 */
	public Operation setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
		return this;
	}

	/**
	 * @return Stan operacji.
	 */
	public abstract OperationState execute();

	protected boolean canDoThisOperation(Subassembly subassembly) {
		return subassembly.supports(this);
	}

	protected boolean isRequiredElementsProvided() {
		return subassembly != null && ingredient != null;
	}

}
