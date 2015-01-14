package edu.issi.machine.operation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.naming.directory.InvalidAttributeIdentifierException;

import org.junit.Test;

import edu.issi.machine.id.IdentityTest;
import edu.issi.machine.product.OrderedElementsList;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.product.ingredient.IngredientTest;
import edu.issi.machine.subassembly.Subassembly;
import edu.issi.machine.subassembly.TestingSubassembly;

@SuppressWarnings("javadoc")
public class OperationTest {

    @Test
    public void shouldGiveResponseAfterExecution() throws InvalidAttributeIdentifierException {
	Operation operation = OperationTest.getFixture();
	Subassembly subassembly = TestingSubassembly.getFixtureWith(operation);
	Ingredient ingredient = IngredientTest.getFixture();

	OperationStatus state = operation.setIngredient(ingredient).setSubassembly(subassembly).execute();

	assertNotNull(state);
    }

    @Test
    public void shouldGiveErrorResponseWhenOnlySubassemblySetted() throws InvalidAttributeIdentifierException {
	Operation operation = new EmptyOperation(IdentityTest.getIdentityFixture());
	Subassembly subassembly = TestingSubassembly.getFixtureWith(operation);

	OperationStatus state = operation.setSubassembly(subassembly).execute();

	assertEquals(Status.ERROR, state.getStatus());
    }

    @Test
    public void shouldGiveErrorResponseWhenOnlyIngredientSetted() throws InvalidAttributeIdentifierException {
	Operation operation = OperationTest.getFixture();
	Ingredient ingredient = IngredientTest.getFixture();

	OperationStatus state = operation.setIngredient(ingredient).execute();

	assertEquals(Status.ERROR, state.getStatus());
    }

    @Test
    public void shouldExecuteValidlyWhenIngredientAndSubassemblySetted() throws IllegalArgumentException,
	    InvalidAttributeIdentifierException {
	Operation operation = new EmptyOperation(IdentityTest.getIdentityFixture());

	Subassembly subassembly = TestingSubassembly.getFixtureWith(operation);
	Ingredient ingredient = IngredientTest.getFixture();

	OperationStatus state = operation.setIngredient(ingredient).setSubassembly(subassembly).execute();

	assertEquals(Status.OK, state.getStatus());
    }

    @Test
    public void shouldSetSubassemblyOnlyWhenItCanDoSpecifiedOperation() throws IllegalArgumentException,
	    InvalidAttributeIdentifierException {
	Operation operation = OperationTest.getFixture();
	Subassembly subassembly = TestingSubassembly.getFixtureWith(operation);
	Ingredient ingredient = IngredientTest.getFixture();

	OperationStatus state = operation.setSubassembly(subassembly).setIngredient(ingredient).execute();

	assertEquals(Status.OK, state.getStatus());
    }

    @Test
    public void shouldGiveErrorResponseWhenSettedSubassemblyCanNotDoSpecifiedOperation()
	    throws InvalidAttributeIdentifierException {
	Operation operation = new EmptyOperation(IdentityTest.getIdentityFixture());
	Subassembly subassembly = TestingSubassembly.getFixtureWith(operation);
	Operation anotherOperation = new EmptyOperation(IdentityTest.getIdentityFixture());

	OperationStatus state = anotherOperation.setSubassembly(subassembly).execute();

	assertEquals(Status.ERROR, state.getStatus());
    }

    public static Iterable<Operation> getFixtureOperations() throws InvalidAttributeIdentifierException {
	OrderedElementsList<Operation> operations = new OrderedElementsList<Operation>();

	EmptyOperation operation = new EmptyOperation(IdentityTest.getIdentityFixture());
	operations.add(operation);

	return operations;
    }

    public static Operation getFixture() throws InvalidAttributeIdentifierException {
	return new EmptyOperation(IdentityTest.getIdentityFixture());
    }
}
