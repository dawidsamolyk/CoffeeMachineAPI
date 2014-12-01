package edu.issi.machine.product.ingredient;

import java.util.HashMap;
import java.util.Map;

import edu.issi.machine.id.Identity;

@SuppressWarnings("javadoc")
public class IngredientTest {

    public static Ingredient mockIngredient() {
	Map<IngredientProperty, Double> properties = new HashMap<IngredientProperty, Double>(1);
	properties.put(IngredientProperty.QUANTITY_IN_G, 10.5);

	return new Ingredient(new Identity(1), properties);
    }

}
