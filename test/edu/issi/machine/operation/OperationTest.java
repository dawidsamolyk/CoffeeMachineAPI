package edu.issi.machine.operation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import edu.issi.machine.id.Identity;
import edu.issi.machine.product.ingredient.IngredientTest;
import edu.issi.machine.subassembly.Subassembly;

@SuppressWarnings("javadoc")
public class OperationTest {

    @Test
    public void shouldGiveResponseAfterExecution() throws Exception {
	Operation operation = new Operation(new Identity(0));
	Subassembly subassembly = new Subassembly(new Identity(10), operation);

	OperationState state;
	state = operation.setIngredient(IngredientTest.mockIngredient()).setSubassembly(subassembly).execute();

	assertNotNull(state);
    }

    @Test
    public void shouldGiveErrorResponseWhenOnlySubassemblySetted() throws Exception {
	Operation operation = new Operation(new Identity(0));
	Subassembly subassembly = new Subassembly(new Identity(10), operation);

	OperationState state = operation.setSubassembly(subassembly).execute();

	assertEquals(Status.ERROR, state.getStatus());
    }

    @Test
    public void shouldGiveErrorResponseWhenOnlyIngredientSetted() throws Exception {
	Operation operation = new Operation(new Identity(0));
	OperationState state = operation.setIngredient(IngredientTest.mockIngredient()).execute();

	assertEquals(Status.ERROR, state.getStatus());
    }

    @Test
    public void shouldExecuteValidlyWhenIngredientAndSubassemblySetted() throws Exception {
	Operation operation = new Operation(new Identity(0));
	Subassembly subassembly = new Subassembly(new Identity(10), operation);

	OperationState state;
	state = operation.setIngredient(IngredientTest.mockIngredient()).setSubassembly(subassembly).execute();

	assertEquals(Status.OK, state.getStatus());
    }

    @Test
    public void shouldSetSubassemblyOnlyWhenItCanDoSpecifiedOperation() throws Exception {
	Operation operation = new Operation(new Identity(0));
	Subassembly subassembly = new Subassembly(new Identity(10), operation);

	OperationState state;
	state = operation.setSubassembly(subassembly).setIngredient(IngredientTest.mockIngredient()).execute();

	assertEquals(Status.OK, state.getStatus());
    }

    @Test
    public void shouldGiveErrorResponseWhenSettedSubassemblyCanNotDoSpecifiedOperation() {
	Operation operation = new Operation(new Identity(0));
	Subassembly subassembly = new Subassembly(new Identity(10), new Operation(new Identity(1)));

	OperationState state = operation.setSubassembly(subassembly).execute();

	assertEquals(Status.ERROR, state.getStatus());
    }
}
