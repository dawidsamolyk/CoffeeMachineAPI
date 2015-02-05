package edu.issi.machine.product.ingredient;

import static org.junit.Assert.*;

import java.util.List;
import java.util.NoSuchElementException;

import javax.naming.directory.InvalidAttributeIdentifierException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.id.IdentityTest;
import edu.issi.machine.id.PropertyIdentity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationStatus;
import edu.issi.machine.operation.OperationTest;
import edu.issi.machine.product.OrderedElementsList;

@SuppressWarnings("javadoc")
public class IngredientTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void ingredientShouldHoldsProperties() throws InvalidAttributeIdentifierException {
	Ingredient ingredient = Fixtures.getSimpleFixture();
	PropertyIdentity property = PropertyIdentity.Factory.newProperty("Pressure", Unit.BAR);

	ingredient.add(property, new Double(-1.0));

	assertFalse(ingredient.getProperties().isEmpty());
    }

    @Test
    public void ingredientShouldProvidesSpecifiedProperty() throws InvalidAttributeIdentifierException {
	Ingredient ingredient = Fixtures.getComplexFixture();
	PropertyIdentity property = PropertyIdentity.Factory.newProperty("Pressure", Unit.BAR);
	Double value = 10.0;

	ingredient.add(property, value);

	assertEquals(value, ingredient.get(property));
    }

    @Test
    public void ingredientShouldNotProvidesUnknownProperty() throws InvalidAttributeIdentifierException {
	Ingredient ingredient = Fixtures.getSimpleFixture();

	exception.expect(NoSuchElementException.class);
	ingredient.get(PropertyIdentity.Factory.newProperty("Unknown", Unit.C));
    }

    @Test
    public void ingredientShouldNotProvidesEmptyProperty() throws InvalidAttributeIdentifierException {
	Ingredient ingredient = Fixtures.getSimpleFixture();

	exception.expect(IllegalArgumentException.class);
	ingredient.get(null);
    }

    @Test
    public void ingredientShouldRemovesSpecifiedProperty() throws InvalidAttributeIdentifierException {
	Ingredient ingredient = Fixtures.getSimpleFixture();
	PropertyIdentity property = PropertyIdentity.Factory.newProperty("Pressure", Unit.BAR);
	ingredient.add(property, new Double(-1.0));

	ingredient.remove(property);

	assertTrue(ingredient.getProperties().isEmpty());
    }

    @Test
    public void ingredientShouldNotRemovesUnknownProperty() throws InvalidAttributeIdentifierException {
	Ingredient ingredient = Fixtures.getSimpleFixture();
	PropertyIdentity property = PropertyIdentity.Factory.newProperty("Pressure", Unit.BAR);

	exception.expect(NoSuchElementException.class);
	ingredient.remove(property);
    }

    @Test
    public void ingredientShouldNotRemovesEmptyProperty() throws InvalidAttributeIdentifierException {
	Ingredient ingredient = Fixtures.getSimpleFixture();

	exception.expect(IllegalArgumentException.class);
	ingredient.remove(null);
    }

    @Test
    public void ingredientShouldProvidesOperationStatesAfterAllOperationsExecuting()
	    throws InvalidAttributeIdentifierException {
	Ingredient ingredient = Fixtures.getComplexFixture();

	List<OperationStatus> operationsStates = ingredient.doOperations();

	assertFalse(operationsStates.isEmpty());
    }

    @Test
    public void ingredientShouldNotProvidesOperationStatesWhenThereIsntAnyOperationsToExecute()
	    throws InvalidAttributeIdentifierException {
	Ingredient ingredient = Fixtures.getSimpleFixture();

	exception.expect(IllegalArgumentException.class);
	ingredient.doOperations();
    }

    public static class Fixtures {

	public static Ingredient getSimpleFixture() throws InvalidAttributeIdentifierException {
	    return new Ingredient(IdentityTest.getIdentityFixture());
	}

	public static Ingredient getComplexFixture() throws InvalidAttributeIdentifierException {
	    OrderedElementsList<Operation> operations = new OrderedElementsList<Operation>();
	    operations.add(OperationTest.getFixture());

	    Ingredient result = IngredientTest.Fixtures.getSimpleFixture();
	    result.setOperations(operations);

	    PropertyIdentity property = PropertyIdentity.Factory.newProperty("Pressure", Unit.BAR);
	    result.add(property, new Double(-1.0));

	    return result;
	}

    }
}
