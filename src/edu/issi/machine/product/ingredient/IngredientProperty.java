package edu.issi.machine.product.ingredient;

import java.io.Serializable;

/**
 * @author Dawid
 *
 */
@SuppressWarnings("javadoc")
public enum IngredientProperty implements Serializable {
    PRESSURE_IN_BAR("Ci�nienie [bar]"), TEMPERATURE_IN_C("Temperatura [*C]"), QUANTITY_IN_ML("Ilo�� [ml]"), QUANTITY_IN_G(
	    "Ilo�� [g]");

    private String description;

    private IngredientProperty(String description) {
	this.description = description;
    }

    @Override
    public String toString() {
	return description;
    }

}
