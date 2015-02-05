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
import edu.issi.machine.product.ingredient.IngredientTest;

@SuppressWarnings("javadoc")
public class ProductTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldCreateEmptyProduct() throws InvalidAttributeIdentifierException {
	Product result = ProductTest.getFixture();

	assertNotNull(result);
	assertEquals(0, result.numberOfElements());
    }

    @Test
    public void shouldAddNewIngredientsCorrectly() throws InvalidAttributeIdentifierException {
	Product fixture = ProductTest.getFixture();

	fixture.add(IngredientTest.getSimpleFixture());
	fixture.add(IngredientTest.getSimpleFixture());
	fixture.add(IngredientTest.getSimpleFixture());

	assertTrue(fixture.numberOfElements() == 3);
    }

    @Test
    public void shouldNotAddNewElementAtZeroIndexWhenTheresNoElementsOnIngredienstList()
	    throws InvalidAttributeIdentifierException {
	Product fixture = ProductTest.getFixture();

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.addAt(0, IngredientTest.getComplexFixture());
    }

    @Test
    public void shouldNotAddNewElementAtSecondPlaceWhenTheresNoElementsOnIngredienstList()
	    throws InvalidAttributeIdentifierException {
	Product fixture = ProductTest.getFixture();

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.addAt(1, IngredientTest.getComplexFixture());
    }

    @Test
    public void shouldNotAddNewElementAtUnreachableIngredientsListIndex() throws InvalidAttributeIdentifierException {
	Product fixture = ProductTest.getFixture();

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.addAt(7, IngredientTest.getComplexFixture());
    }

    @Test
    public void shouldProvidesIngredientFromSpecifiedIndex() throws InvalidAttributeIdentifierException {
	Product fixture = ProductTest.getFixture();

	fixture.add(IngredientTest.getSimpleFixture());
	fixture.add(IngredientTest.getSimpleFixture());
	fixture.add(IngredientTest.getSimpleFixture());

	assertNotNull(fixture.getIngredientAt(2));
    }

    @Test
    public void shouldProvidesIngredientFromInvalidIndex() throws InvalidAttributeIdentifierException {
	Product fixture = ProductTest.getFixture();

	fixture.add(IngredientTest.getSimpleFixture());

	exception.expect(NoSuchElementException.class);
	fixture.getIngredientAt(10);
    }

    @Test
    public void shouldPutNewIngredientAtSpecifiedIndex() throws InvalidAttributeIdentifierException {
	Product fixture = ProductTest.getFixture();

	fixture.add(IngredientTest.getComplexFixture());

	Ingredient newIngredient = IngredientTest.getSimpleFixture();
	fixture.addAt(0, newIngredient);

	assertEquals(newIngredient, fixture.getIngredientAt(0));
    }

    @Test
    public void shouldRemovesIngredientFromSpecifiedIndex() throws InvalidAttributeIdentifierException {
	Product fixture = ProductTest.getFixture();

	fixture.add(IngredientTest.getSimpleFixture());
	fixture.add(IngredientTest.getSimpleFixture());
	fixture.add(IngredientTest.getSimpleFixture());

	fixture.remove(1);

	assertTrue(fixture.numberOfElements() == 2);
    }

    @Test
    public void shouldNotRemovesIngredientFromInvalidIndex() throws InvalidAttributeIdentifierException {
	Product fixture = ProductTest.getFixture();

	fixture.add(IngredientTest.getSimpleFixture());

	exception.expect(NoSuchElementException.class);
	fixture.remove(10);
    }

    @Test
    public void shouldProvidesIteratorForIngredients() throws InvalidAttributeIdentifierException {
	Product fixture = ProductTest.getFixture();

	assertNotNull(fixture.iterator());
    }

    @Test
    public void productsWithTheSameIngredientsShouldNotBeEquals() throws InvalidAttributeIdentifierException {
	Product fixture = ProductTest.getFixture();
	Product fixture2 = ProductTest.getFixture();

	Ingredient ingredient = IngredientTest.getComplexFixture();
	fixture.add(ingredient);
	fixture2.add(ingredient);

	assertFalse(fixture.equals(fixture2));
    }

    public static Product getFixture() throws InvalidAttributeIdentifierException {
	return new Product(IdentityTest.getIdentityFixture());
    }

    public static List<Product> getManyFixtures() throws InvalidAttributeIdentifierException {
	List<Product> products = new ArrayList<Product>();

	products.add(ProductTest.getFixture());
	products.add(ProductTest.getFixture());

	return products;
    }

    public static List<Product> getManyNamedFixturesWithIngredients(List<Ingredient> ingredients, String... names)
	    throws InvalidAttributeIdentifierException {
	List<Product> products = new ArrayList<Product>();

	for (int p = 0; p < names.length; p++) {
	    Identity identity = Identity.Factory.newIdentity(names[p]);
	    Product product = new Product(identity);
	    
	    for(Ingredient eachIngredient : ingredients) {
		product.add(eachIngredient);
	    }
	    
	    products.add(product);
	}

	return products;
    }

    public static void main(String[] args) {
	new org.junit.runner.JUnitCore().run(ProductTest.class);
    }
}