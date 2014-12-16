package edu.issi.machine.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.id.Identity;
import edu.issi.machine.id.PropertyIdentity;
import edu.issi.machine.operation.EmptyOperation;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.product.ingredient.Unit;

@SuppressWarnings("javadoc")
public class ProductTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldCreateEmptyProduct() {
	Product result = new Product(new Identity(0));

	assertNotNull(result);
	assertEquals(0, result.numberOfElements());
    }

    @Test
    public void shouldAddNewIngredientsCorrectly() {
	Product fixture = new Product(new Identity(0));

	HashMap<PropertyIdentity, Double> ingredientProperties = new HashMap<PropertyIdentity, Double>();
	ingredientProperties.put(new PropertyIdentity(0, "", Unit.BAR), new Double(-1.0));
	ingredientProperties.put(new PropertyIdentity(1, "0123456789", Unit.C), new Double(0.0));
	ingredientProperties.put(new PropertyIdentity(7, "An??t-1.0.txt", Unit.G), new Double(1.0));

	OrderedElementsList<Operation> operations = new OrderedElementsList<Operation>();
	operations.add(new EmptyOperation(new Identity(10)));

	Ingredient ingredient = new Ingredient(new Identity(0, ""));

	fixture.add(ingredient);
	fixture.add(ingredient);
	fixture.add(ingredient);

	assertTrue(fixture.numberOfElements() == 3);
    }

    @Test
    public void shouldNotAddNewElementAtZeroIndexWhenTheresNoElementsOnIngredienstList() {
	Product fixture = new Product(new Identity(0));

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.addAt(0, ingredientFixture());
    }

    @Test
    public void shouldNotAddNewElementAtFirstPlaceWhenTheresNoElementsOnIngredienstList() {
	Product fixture = new Product(new Identity(0));

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.addAt(1, ingredientFixture());
    }

    @Test
    public void shouldNotAddNewElementAtUnreachableIngredientsListIndex() {
	Product fixture = new Product(new Identity(0));

	exception.expect(java.lang.UnsupportedOperationException.class);
	fixture.addAt(7, ingredientFixture());
    }

    protected Ingredient ingredientFixture() {
	OrderedElementsList<Operation> operations = new OrderedElementsList<Operation>();
	operations.add(new EmptyOperation(new Identity(0)));

	Ingredient ingredient = new Ingredient(new Identity(1));
	ingredient.addOperations(operations);
	ingredient.add(new PropertyIdentity(0, "", Unit.BAR), new Double(-1.0));

	return ingredient;
    }

    public static void main(String[] args) {
	new org.junit.runner.JUnitCore().run(ProductTest.class);
    }
}