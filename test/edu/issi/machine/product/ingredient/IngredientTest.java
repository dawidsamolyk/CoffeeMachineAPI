package edu.issi.machine.product.ingredient;

import java.util.HashMap;
import java.util.Map;

import edu.issi.machine.id.Identity;
import edu.issi.machine.id.PropertyIdentity;

@SuppressWarnings("javadoc")
public class IngredientTest {

    public static Ingredient mockIngredient() {
	Map<PropertyIdentity, Double> properties = new HashMap<PropertyIdentity, Double>(1);
	properties.put(new PropertyIdentity(101, "Iloœæ", Unit.G), 10.5);

	return new Ingredient(new Identity(1), properties);
    }

}
