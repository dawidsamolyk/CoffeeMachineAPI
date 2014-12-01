package edu.issi.machine.product.ingredient;

import java.io.Serializable;

/**
 * @author Dawid
 *
 */
@SuppressWarnings("javadoc")
public enum IngredientProperty implements Serializable {
    PRESSURE_IN_BAR("Ciœnienie [bar]"), TEMPERATURE_IN_C("Temperatura [*C]"), QUANTITY_IN_ML("Iloœæ [ml]"), QUANTITY_IN_G(
	    "Iloœæ [g]");

    private String description;

    private IngredientProperty(String description) {
	this.description = description;
    }

    @Override
    public String toString() {
	return description;
    }

}
