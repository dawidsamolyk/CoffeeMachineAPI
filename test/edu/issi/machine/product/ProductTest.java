package edu.issi.machine.product;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.naming.directory.InvalidAttributeIdentifierException;

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
    public void shouldCreateEmptyProduct() throws InvalidAttributeIdentifierException {
	Product result = Fixtures.getFixtureWithoutIngredients();

	assertNotNull(result);
	assertEquals(0, result.numberOfElements());
    }

    @Test
    public void shouldAddNewIngredientsCorrectly() throws InvalidAttributeIdentifierException {
	Product fixture = Fixtures.getFixtureWithoutIngredients();

	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture());
	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture());
	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture());

	assertTrue(fixture.numberOfElements() == 3);
    }

    @Test
    public void shouldNotAddNewElementAtZeroIndexWhenTheresNoElementsOnIngredienstList()
	    throws InvalidAttributeIdentifierException {
	Product fixture = Fixtures.getFixtureWithoutIngredients();

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.addAt(0, edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getComplexFixture());
    }

    @Test
    public void shouldNotAddNewElementAtSecondPlaceWhenTheresNoElementsOnIngredienstList()
	    throws InvalidAttributeIdentifierException {
	Product fixture = Fixtures.getFixtureWithoutIngredients();

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.addAt(1, edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getComplexFixture());
    }

    @Test
    public void shouldNotAddNewElementAtUnreachableIngredientsListIndex() throws InvalidAttributeIdentifierException {
	Product fixture = Fixtures.getFixtureWithoutIngredients();

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.addAt(7, edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getComplexFixture());
    }

    @Test
    public void shouldProvidesIngredientFromSpecifiedIndex() throws InvalidAttributeIdentifierException {
	Product fixture = Fixtures.getFixtureWithoutIngredients();

	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture());
	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture());
	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture());

	assertNotNull(fixture.getIngredientAt(2));
    }

    @Test
    public void shouldProvidesIngredientFromInvalidIndex() throws InvalidAttributeIdentifierException {
	Product fixture = Fixtures.getFixtureWithoutIngredients();

	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture());

	exception.expect(NoSuchElementException.class);
	fixture.getIngredientAt(10);
    }

    @Test
    public void shouldPutNewIngredientAtSpecifiedIndex() throws InvalidAttributeIdentifierException {
	Product fixture = Fixtures.getFixtureWithoutIngredients();

	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getComplexFixture());

	Ingredient newIngredient = edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture();
	fixture.addAt(0, newIngredient);

	assertEquals(newIngredient, fixture.getIngredientAt(0));
    }

    @Test
    public void shouldRemovesIngredientFromSpecifiedIndex() throws InvalidAttributeIdentifierException {
	Product fixture = Fixtures.getFixtureWithoutIngredients();

	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture());
	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture());
	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture());

	fixture.remove(1);

	assertTrue(fixture.numberOfElements() == 2);
    }

    @Test
    public void shouldNotRemovesIngredientFromInvalidIndex() throws InvalidAttributeIdentifierException {
	Product fixture = Fixtures.getFixtureWithoutIngredients();

	fixture.add(edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture());

	exception.expect(NoSuchElementException.class);
	fixture.remove(10);
    }

    @Test
    public void shouldProvidesIteratorForIngredients() throws InvalidAttributeIdentifierException {
	Product fixture = Fixtures.getFixtureWithoutIngredients();

	assertNotNull(fixture.iterator());
    }

    @Test
    public void productsWithTheSameIngredientsShouldNotBeEquals() throws InvalidAttributeIdentifierException {
	Product fixture = Fixtures.getFixtureWithoutIngredients();
	Product fixture2 = Fixtures.getFixtureWithoutIngredients();

	Ingredient ingredient = edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getComplexFixture();
	fixture.add(ingredient);
	fixture2.add(ingredient);

	assertFalse(fixture.equals(fixture2));
    }

    public static class Fixtures {

	public static Product getFixtureWithoutIngredients() throws InvalidAttributeIdentifierException {
	    return new Product(IdentityTest.getIdentityFixture());
	}

	public static List<Product> getManyFixtures() throws InvalidAttributeIdentifierException {
	    List<Product> products = new ArrayList<Product>();

	    products.add(ProductTest.Fixtures.getFixtureWithoutIngredients());
	    products.add(ProductTest.Fixtures.getFixtureWithoutIngredients());

	    return products;
	}

	public static Product getFixtureWith(List<Ingredient> ingredients, String name)
		throws IllegalArgumentException, InvalidAttributeIdentifierException {
	    Product product = new Product(Identity.Factory.newIdentity(name));

	    for (Ingredient eachIngredient : ingredients) {
		product.add(eachIngredient);
	    }

	    return product;
	}

	public static List<Product> getManyNamedFixturesWithIngredients(List<Ingredient> ingredients, String... names)
		throws InvalidAttributeIdentifierException {
	    List<Product> products = new ArrayList<Product>();

	    for (int p = 0; p < names.length; p++) {
		products.add(getFixtureWith(ingredients, names[p]));
	    }

	    return products;
	}

    }
}