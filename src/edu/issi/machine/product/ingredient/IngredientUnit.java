package edu.issi.machine.product.ingredient;

/**
 * @author Dawid
 *
 */
public enum IngredientUnit {

    /**
     * Gram.
     */
    G("g"),
    /**
     * Kilogram
     */
    KG("kg"),
    /**
     * Mililitr
     */
    ML("ml"),
    /**
     * Litr
     */
    L("l");

    private String label;

    private IngredientUnit(String label) {
	this.label = label;
    }

    @Override
    public String toString() {
	return label;
    }

}
