package edu.issi.machine.product.ingredient;

import javax.naming.directory.InvalidAttributeIdentifierException;

import edu.issi.machine.id.IdentityTest;

public class IngredientTest {
    public static Ingredient getFixture() throws InvalidAttributeIdentifierException {
	return new Ingredient(IdentityTest.getIdentityFixture());
    }
}
