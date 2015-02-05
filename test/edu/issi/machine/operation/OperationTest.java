package edu.issi.machine.operation;

import static org.junit.Assert.*;

import javax.naming.directory.InvalidAttributeIdentifierException;

import org.junit.Test;

import edu.issi.machine.id.IdentityTest;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.product.ingredient.IngredientTest.Fixtures;
import edu.issi.machine.subassembly.Subassembly;
import edu.issi.machine.subassembly.TestingSubassembly;

@SuppressWarnings("javadoc")
public class OperationTest {

    @Test
    public void shouldGiveResponseAfterExecution() throws InvalidAttributeIdentifierException {
	Operation operation = OperationTest.getFixture();
	Subassembly subassembly = TestingSubassembly.getFixtureWith(operation);
	Ingredient ingredient = Fixtures.getSimpleFixture();

	OperationStatus status = operation.setIngredient(ingredient).setSubassembly(subassembly).execute();

	assertNotNull(status);
    }

    @Test
    public void shouldGiveErrorResponseWhenOnlySubassemblySetted() throws InvalidAttributeIdentifierException {
	Operation operation = OperationTest.getFixture();
	Subassembly subassembly = TestingSubassembly.getFixtureWith(operation);

	OperationStatus status = operation.setSubassembly(subassembly).execute();

	assertEquals(Status.ERROR, status.getStatus());
    }

    @Test
    public void shouldGiveErrorResponseWhenOnlyIngredientSetted() throws InvalidAttributeIdentifierException {
	Operation operation = OperationTest.getFixture();
	Ingredient ingredient = Fixtures.getSimpleFixture();

	OperationStatus status = operation.setIngredient(ingredient).execute();

	assertEquals(Status.ERROR, status.getStatus());
    }

    @Test
    public void shouldExecuteValidlyWhenIngredientAndSubassemblySetted() throws IllegalArgumentException,
	    InvalidAttributeIdentifierException {
	Operation operation = OperationTest.getFixture();

	Subassembly subassembly = TestingSubassembly.getFixtureWith(operation);
	Ingredient ingredient = Fixtures.getSimpleFixture();

	OperationStatus status = operation.setIngredient(ingredient).setSubassembly(subassembly).execute();

	assertEquals(Status.OK, status.getStatus());
    }

    @Test
    public void shouldSetSubassemblyOnlyWhenItCanDoSpecifiedOperation() throws IllegalArgumentException,
	    InvalidAttributeIdentifierException {
	Operation operation = OperationTest.getFixture();
	Subassembly subassembly = TestingSubassembly.getFixtureWith(operation);
	Ingredient ingredient = Fixtures.getSimpleFixture();

	OperationStatus status = operation.setSubassembly(subassembly).setIngredient(ingredient).execute();

	assertEquals(Status.OK, status.getStatus());
    }

    @Test
    public void shouldGiveErrorResponseWhenSettedSubassemblyCanNotDoSpecifiedOperation()
	    throws InvalidAttributeIdentifierException {
	Operation operation = OperationTest.getFixture();
	Subassembly subassembly = TestingSubassembly.getFixtureWith(operation);
	
	Operation anotherOperation = OperationTest.getFixture();

	OperationStatus status = anotherOperation.setSubassembly(subassembly).execute();

	assertEquals(Status.ERROR, status.getStatus());
    }
    
    @Test
    public void operationShouldGivesInformationAboutHisStatus() throws InvalidAttributeIdentifierException {
	Operation operation = OperationTest.getFixture();
	Subassembly subassembly = TestingSubassembly.getFixtureWith(operation);
	Ingredient ingredient = Fixtures.getSimpleFixture();

	operation.setSubassembly(subassembly).setIngredient(ingredient).execute();
	
	assertTrue(operation.isDone());
    }
    
    @Test
    public void shouldGiveErrorWhenSpecifiedSubassemblyCannotDoThisOperation() throws InvalidAttributeIdentifierException {
	Operation operation = OperationTest.getFixture();
	Operation anotherOperation = OperationTest.getFixture();
	Subassembly subassembly = TestingSubassembly.getFixtureWith(anotherOperation);
	Ingredient ingredient = Fixtures.getSimpleFixture();

	OperationStatus status = operation.setSubassembly(subassembly).setIngredient(ingredient).execute();
	
	assertEquals(Status.ERROR, status.getStatus());
    }

    public static Operation getFixture() throws InvalidAttributeIdentifierException {
	return new EmptyOperation(IdentityTest.getIdentityFixture());
    }
}
