package edu.issi.machine.product.ingredient;

import java.io.Serializable;

import edu.issi.machine.id.Identity;
import edu.issi.machine.id.ObjectWithIdentity;

/**
 * @author Dawid
 * 
 */
public class Ingredient extends ObjectWithIdentity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -2437259497186892897L;

    /**
     * @param id
     *            Identyfikator.
     */
    public Ingredient(Identity id) {
	super(id);
    }

}
