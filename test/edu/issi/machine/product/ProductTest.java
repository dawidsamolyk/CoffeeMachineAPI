package edu.issi.machine.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.id.Identity;
import edu.issi.machine.id.IdentityTest;
import edu.issi.machine.product.ingredient.Ingredient;

@SuppressWarnings("javadoc")
public class ProductTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldCreateEmptyProduct() {
	Product result = Fixtures.getFixtureWithoutIngredients();

	assertNotNull(result);
	assertEquals(0, result.numberOfElements());
    }

    @Test
    public void shouldAddNewIngredientsCorrectly() {
	Product fixture = Fixtures.getFixtureWithoutIngredients();

	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture());
	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture());
	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture());

	assertTrue(fixture.numberOfElements() == 3);
    }

    @Test
    public void shouldNotAddNewElementAtZeroIndexWhenTheresNoElementsOnIngredienstList() {
	Product fixture = Fixtures.getFixtureWithoutIngredients();

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.addAt(0, edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getComplexFixture());
    }

    @Test
    public void shouldNotAddNewElementAtSecondPlaceWhenTheresNoElementsOnIngredienstList() {
	Product fixture = Fixtures.getFixtureWithoutIngredients();

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.addAt(1, edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getComplexFixture());
    }

    @Test
    public void shouldNotAddNewElementAtUnreachableIngredientsListIndex() {
	Product fixture = Fixtures.getFixtureWithoutIngredients();

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.addAt(7, edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getComplexFixture());
    }

    @Test
    public void shouldProvidesIngredientFromSpecifiedIndex() {
	Product fixture = Fixtures.getFixtureWithoutIngredients();

	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture());
	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture());
	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture());

	assertNotNull(fixture.getIngredientAt(2));
    }

    @Test
    public void shouldProvidesIngredientFromInvalidIndex() {
	Product fixture = Fixtures.getFixtureWithoutIngredients();

	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture());

	exception.expect(NoSuchElementException.class);
	fixture.getIngredientAt(10);
    }

    @Test
    public void shouldPutNewIngredientAtSpecifiedIndex() {
	Product fixture = Fixtures.getFixtureWithoutIngredients();

	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getComplexFixture());

	Ingredient newIngredient = edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture();
	fixture.addAt(0, newIngredient);

	assertEquals(newIngredient, fixture.getIngredientAt(0));
    }

    @Test
    public void shouldRemovesIngredientFromSpecifiedIndex() {
	Product fixture = Fixtures.getFixtureWithoutIngredients();

	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture());
	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture());
	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture());

	fixture.remove(1);

	assertTrue(fixture.numberOfElements() == 2);
    }

    @Test
    public void shouldNotRemovesIngredientFromInvalidIndex() {
	Product fixture = Fixtures.getFixtureWithoutIngredients();

	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture());

	exception.expect(NoSuchElementException.class);
	fixture.remove(10);
    }

    @Test
    public void shouldProvidesIteratorForIngredients() {
	Product fixture = Fixtures.getFixtureWithoutIngredients();

	assertNotNull(fixture.iterator());
    }

    @Test
    public void productsWithTheSameIngredientsShouldNotBeEquals() {
	Product fixture = Fixtures.getFixtureWithoutIngredients();
	Product fixture2 = Fixtures.getFixtureWithoutIngredients();

	Ingredient ingredient = edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getComplexFixture();
	fixture.add(ingredient);
	fixture2.add(ingredient);

	assertFalse(fixture.equals(fixture2));
    }

    public static class Fixtures {

	public static Product getFixtureWithoutIngredients() {
	    return new Product(IdentityTest.getIdentityFixture());
	}

	public static List<Product> getManyFixtures() {
	    List<Product> products = new ArrayList<Product>();

	    products.add(ProductTest.Fixtures.getFixtureWithoutIngredients());
	    products.add(ProductTest.Fixtures.getFixtureWithoutIngredients());

	    return products;
	}

	public static Product getFixtureWith(List<Ingredient> ingredients, String name) throws IllegalArgumentException {
	    Product product = new Product(Identity.Factory.newIdentity(name));

	    for (Ingredient eachIngredient : ingredients) {
		product.add(eachIngredient);
	    }

	    return product;
	}

	public static List<Product> getManyNamedFixturesWithIngredients(List<Ingredient> ingredients, String... names) {
	    List<Product> products = new ArrayList<Product>();

	    for (int p = 0; p < names.length; p++) {
		products.add(getFixtureWith(ingredients, names[p]));
	    }

	    return products;
	}

    }
}