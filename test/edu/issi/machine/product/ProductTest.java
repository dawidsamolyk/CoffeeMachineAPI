package edu.issi.machine.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.directory.InvalidAttributeIdentifierException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.id.IdentityTest;
import edu.issi.machine.id.PropertyIdentity;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.product.ingredient.IngredientTest;
import edu.issi.machine.product.ingredient.Unit;

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

	HashMap<PropertyIdentity, Double> ingredientProperties = new HashMap<PropertyIdentity, Double>();
	ingredientProperties.put(PropertyIdentity.Factory.newProperty("Pressure", Unit.BAR), new Double(1.0));
	ingredientProperties.put(PropertyIdentity.Factory.newProperty("Temperature", Unit.C), new Double(100.0));
	ingredientProperties.put(PropertyIdentity.Factory.newProperty("Quantity", Unit.G), new Double(500.0));

	Ingredient ingredient = IngredientTest.getSimpleFixture();

	fixture.add(ingredient);
	fixture.add(ingredient);
	fixture.add(ingredient);

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
    public void shouldNotAddNewElementAtFirstPlaceWhenTheresNoElementsOnIngredienstList()
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

    public static Product getFixture() throws InvalidAttributeIdentifierException {
	return new Product(IdentityTest.getIdentityFixture());
    }
    
    public static List<Product> getManyFixtures() throws InvalidAttributeIdentifierException {
	List<Product> products = new ArrayList<Product>();
	
	products.add(ProductTest.getFixture());
	products.add(ProductTest.getFixture());
	
	return products;
    }

    public static void main(String[] args) {
	new org.junit.runner.JUnitCore().run(ProductTest.class);
    }
}