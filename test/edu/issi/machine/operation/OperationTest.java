package edu.issi.machine.operation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.issi.machine.id.Identity;
import edu.issi.machine.product.OrderedElementsList;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.subassembly.Subassembly;
import edu.issi.machine.subassembly.SubassemblyTest;
import edu.issi.machine.subassembly.TestingSubassembly;

@SuppressWarnings("javadoc")
public class OperationTest {

    @Test
    public void shouldGiveResponseAfterExecution() {
	Operation operation = mockOperation();
	Subassembly subassembly = SubassemblyTest.getFixture();

	OperationState state = operation.setIngredient(new Ingredient(new Identity(0))).setSubassembly(subassembly).execute();

	assertNotNull(state);
    }

    @Test
    public void shouldGiveErrorResponseWhenOnlySubassemblySetted() {
	Operation operation = new EmptyOperation(new Identity(1));

	List<Operation> operations = new ArrayList<Operation>();
	operations.add(operation);

	Subassembly subassembly = new TestingSubassembly(new Identity(10), operations);

	OperationState state = operation.setSubassembly(subassembly).execute();

	assertEquals(Status.ERROR, state.getStatus());
    }

    @Test
    public void shouldGiveErrorResponseWhenOnlyIngredientSetted() {
	Operation operation = mockOperation();
	OperationState state = operation.setIngredient(new Ingredient(new Identity(0))).execute();

	assertEquals(Status.ERROR, state.getStatus());
    }

    @Test
    public void shouldExecuteValidlyWhenIngredientAndSubassemblySetted() {
	Operation operation = new EmptyOperation(new Identity(0));

	List<Operation> operations = new ArrayList<Operation>();
	operations.add(operation);

	Subassembly subassembly = new TestingSubassembly(new Identity(10), operations);

	OperationState state = operation.setIngredient(new Ingredient(new Identity(0))).setSubassembly(subassembly).execute();

	assertEquals(Status.OK, state.getStatus());
    }

    @Test
    public void shouldSetSubassemblyOnlyWhenItCanDoSpecifiedOperation() {
	Operation operation = mockOperation();

	List<Operation> operations = new ArrayList<Operation>();
	operations.add(operation);

	Subassembly subassembly = new TestingSubassembly(new Identity(10), operations);

	OperationState state = operation.setSubassembly(subassembly).setIngredient(new Ingredient(new Identity(0))).execute();

	assertEquals(Status.OK, state.getStatus());
    }

    @Test
    public void shouldGiveErrorResponseWhenSettedSubassemblyCanNotDoSpecifiedOperation() {
	Operation operation = new EmptyOperation(new Identity(0));

	List<Operation> operations = new ArrayList<Operation>();
	operations.add(operation);

	Subassembly subassembly = new TestingSubassembly(new Identity(10), operations);

	Operation anotherOperation = new EmptyOperation(new Identity(1));

	OperationState state = anotherOperation.setSubassembly(subassembly).execute();

	assertEquals(Status.ERROR, state.getStatus());
    }

    public static Iterable<Operation> getFixtureOperations() {
	OrderedElementsList<Operation> operations = new OrderedElementsList<Operation>();
	operations.add(new EmptyOperation(new Identity(10)));

	return operations;
    }

    public static Operation mockOperation() {
	return new EmptyOperation(new Identity(111));
    }
}
