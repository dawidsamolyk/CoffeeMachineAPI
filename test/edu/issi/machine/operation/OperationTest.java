package edu.issi.machine.operation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Method;

import javax.naming.directory.InvalidAttributeValueException;

import org.junit.Before;
import org.junit.Test;

import edu.issi.machine.Identity;
import edu.issi.machine.api.API;
import edu.issi.machine.product.Ingredient;
import edu.issi.machine.subassembly.Subassembly;

@SuppressWarnings("javadoc")
public class OperationTest {
    private Operation operation;

    @Before
    public void setUp() throws Exception {
	Method apiOperation = mockApiMethod();
	this.operation = new Operation(apiOperation);
    }

    @Test
    public void shouldGiveResponseAfterExecution() throws Exception {
	Subassembly subassembly = mockSubassembly(operation);

	OperationState state;
	state = operation.setIngredient(mockIngredient()).setSubassembly(subassembly).execute();

	assertNotNull(state);
    }

    @Test
    public void shouldGiveErrorResponseWhenOnlySubassemblySetted() throws Exception {
	Subassembly subassembly = mockSubassembly(operation);

	OperationState state = operation.setSubassembly(subassembly).execute();

	assertEquals(Status.ERROR, state.getStatus());
    }

    @Test
    public void shouldGiveErrorResponseWhenOnlyIngredientSetted() throws Exception {
	OperationState state = operation.setIngredient(mockIngredient()).execute();

	assertEquals(Status.ERROR, state.getStatus());
    }

    @Test
    public void shouldExecuteValidlyWhenIngredientAndSubassemblySetted() throws Exception {
	Subassembly subassembly = mockSubassembly(operation);

	OperationState state;
	state = operation.setIngredient(mockIngredient()).setSubassembly(subassembly).execute();

	assertEquals(Status.OK, state.getStatus());
    }

    @Test
    public void shouldSetSubassemblyOnlyWhenItCanDoSpecifiedOperation() throws Exception {
	Subassembly subassembly = mockSubassembly(operation);

	OperationState state;
	state = operation.setSubassembly(subassembly).setIngredient(mockIngredient()).execute();

	assertEquals(Status.OK, state.getStatus());
    }

    @Test
    public void shouldGiveErrorResponseWhenSettedSubassemblyCanNotDoSpecifiedOperation() {
	Subassembly subassembly = mockSubassembly(new Operation(null));

	OperationState state = operation.setSubassembly(subassembly).execute();

	assertEquals(Status.ERROR, state.getStatus());
    }

    public static Subassembly mockSubassembly(Operation... operations) {
	try {
	    return new Subassembly(Identity.SAMPLE, null, operations);
	} catch (InvalidAttributeValueException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public static Method mockApiMethod() throws NoSuchMethodException {
	return API.class.getMethod("giveTheCup", Integer.class);
    }

    public static Ingredient mockIngredient() {
	return new Ingredient(Identity.SAMPLE);
    }

}
