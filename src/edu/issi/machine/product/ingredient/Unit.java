package edu.issi.machine.product.ingredient;

/**
 * @author Dawid Samołyk
 *
 * Jednostki miary.
 */
public enum Unit {

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
    L("l"),
    /**
     * Bar
     */
    BAR("bar"),
    /**
     * Celsjusz
     */
    C("*C");

    private final String label;

    private Unit(String label) {
	this.label = label;
    }

    @Override
    public String toString() {
	return label;
    }

}
