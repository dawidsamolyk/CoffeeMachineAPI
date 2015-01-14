package edu.issi.machine.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import javax.naming.directory.InvalidAttributeIdentifierException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.id.IdentityTest;
import edu.issi.machine.id.PropertyIdentity;
import edu.issi.machine.operation.EmptyOperation;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.product.ingredient.IngredientTest;
import edu.issi.machine.product.ingredient.Unit;

@SuppressWarnings("javadoc")
public class ProductTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldCreateEmptyProduct() throws InvalidAttributeIdentifierException {
	Product result = new Product(IdentityTest.getIdentityFixture());

	assertNotNull(result);
	assertEquals(0, result.numberOfElements());
    }

    @Test
    public void shouldAddNewIngredientsCorrectly() throws InvalidAttributeIdentifierException {
	Product fixture = new Product(IdentityTest.getIdentityFixture());

	HashMap<PropertyIdentity, Double> ingredientProperties = new HashMap<PropertyIdentity, Double>();
	ingredientProperties.put(PropertyIdentity.Factory.newProperty("..", Unit.BAR), new Double(-1.0));
	ingredientProperties.put(PropertyIdentity.Factory.newProperty("0123456789", Unit.C), new Double(0.0));
	ingredientProperties.put(PropertyIdentity.Factory.newProperty("An??t-1.0.txt", Unit.G), new Double(1.0));

	OrderedElementsList<Operation> operations = new OrderedElementsList<Operation>();
	operations.add(new EmptyOperation(IdentityTest.getIdentityFixture()));

	Ingredient ingredient = IngredientTest.getFixture();

	fixture.add(ingredient);
	fixture.add(ingredient);
	fixture.add(ingredient);

	assertTrue(fixture.numberOfElements() == 3);
    }

    @Test
    public void shouldNotAddNewElementAtZeroIndexWhenTheresNoElementsOnIngredienstList()
	    throws InvalidAttributeIdentifierException {
	Product fixture = new Product(IdentityTest.getIdentityFixture());

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.addAt(0, ingredientFixture());
    }

    @Test
    public void shouldNotAddNewElementAtFirstPlaceWhenTheresNoElementsOnIngredienstList()
	    throws InvalidAttributeIdentifierException {
	Product fixture = new Product(IdentityTest.getIdentityFixture());

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.addAt(1, ingredientFixture());
    }

    @Test
    public void shouldNotAddNewElementAtUnreachableIngredientsListIndex() throws InvalidAttributeIdentifierException {
	Product fixture = new Product(IdentityTest.getIdentityFixture());

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.addAt(7, ingredientFixture());
    }

    protected Ingredient ingredientFixture() throws InvalidAttributeIdentifierException {
	OrderedElementsList<Operation> operations = new OrderedElementsList<Operation>();
	operations.add(new EmptyOperation(IdentityTest.getIdentityFixture()));

	Ingredient ingredient = IngredientTest.getFixture();
	ingredient.addOperations(operations);
	
	PropertyIdentity property = PropertyIdentity.Factory.newProperty("Test", Unit.BAR);
	ingredient.add(property, new Double(-1.0));

	return ingredient;
    }

    public static void main(String[] args) {
	new org.junit.runner.JUnitCore().run(ProductTest.class);
    }
}