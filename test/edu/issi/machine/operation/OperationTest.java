package edu.issi.machine.operation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.InvalidAttributeIdentifierException;

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
    public void shouldGiveResponseAfterExecution() throws InvalidAttributeIdentifierException {
	Operation operation = mockOperation();
	Subassembly subassembly = SubassemblyTest.getFixture();

	OperationStatus state = operation.setIngredient(new Ingredient(Identity.Factory.newIdentity("Test")))
		.setSubassembly(subassembly).execute();

	assertNotNull(state);
    }

    @Test
    public void shouldGiveErrorResponseWhenOnlySubassemblySetted() throws InvalidAttributeIdentifierException {
	Operation operation = new EmptyOperation(Identity.Factory.newIdentity("Test"));

	List<Operation> operations = new ArrayList<Operation>();
	operations.add(operation);

	Subassembly subassembly = new TestingSubassembly(Identity.Factory.newIdentity("Test"), operations);

	OperationStatus state = operation.setSubassembly(subassembly).execute();

	assertEquals(Status.ERROR, state.getStatus());
    }

    @Test
    public void shouldGiveErrorResponseWhenOnlyIngredientSetted() throws InvalidAttributeIdentifierException {
	Operation operation = mockOperation();
	OperationStatus state = operation.setIngredient(new Ingredient(Identity.Factory.newIdentity("Test"))).execute();

	assertEquals(Status.ERROR, state.getStatus());
    }

    @Test
    public void shouldExecuteValidlyWhenIngredientAndSubassemblySetted() throws IllegalArgumentException,
	    InvalidAttributeIdentifierException {
	Operation operation = new EmptyOperation(Identity.Factory.newIdentity("Test"));

	List<Operation> operations = new ArrayList<Operation>();
	operations.add(operation);

	Subassembly subassembly = new TestingSubassembly(Identity.Factory.newIdentity("Test"), operations);

	OperationStatus state = operation.setIngredient(new Ingredient(Identity.Factory.newIdentity("Test")))
		.setSubassembly(subassembly).execute();

	assertEquals(Status.OK, state.getStatus());
    }

    @Test
    public void shouldSetSubassemblyOnlyWhenItCanDoSpecifiedOperation() throws IllegalArgumentException,
	    InvalidAttributeIdentifierException {
	Operation operation = mockOperation();

	List<Operation> operations = new ArrayList<Operation>();
	operations.add(operation);

	Subassembly subassembly = new TestingSubassembly(Identity.Factory.newIdentity("Test"), operations);

	OperationStatus state = operation.setSubassembly(subassembly)
		.setIngredient(new Ingredient(Identity.Factory.newIdentity("Test"))).execute();

	assertEquals(Status.OK, state.getStatus());
    }

    @Test
    public void shouldGiveErrorResponseWhenSettedSubassemblyCanNotDoSpecifiedOperation()
	    throws InvalidAttributeIdentifierException {
	Operation operation = new EmptyOperation(Identity.Factory.newIdentity("Test"));

	List<Operation> operations = new ArrayList<Operation>();
	operations.add(operation);

	Subassembly subassembly = new TestingSubassembly(Identity.Factory.newIdentity("Test"), operations);

	Operation anotherOperation = new EmptyOperation(Identity.Factory.newIdentity("Test"));

	OperationStatus state = anotherOperation.setSubassembly(subassembly).execute();

	assertEquals(Status.ERROR, state.getStatus());
    }

    public static Iterable<Operation> getFixtureOperations() throws InvalidAttributeIdentifierException {
	OrderedElementsList<Operation> operations = new OrderedElementsList<Operation>();
	operations.add(new EmptyOperation(Identity.Factory.newIdentity("Test")));

	return operations;
    }

    public static Operation mockOperation() throws InvalidAttributeIdentifierException {
	return new EmptyOperation(Identity.Factory.newIdentity("Test"));
    }
}
