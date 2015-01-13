package edu.issi.machine.subassembly;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.InvalidAttributeIdentifierException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.id.Identity;
import edu.issi.machine.operation.EmptyOperation;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.subassembly.handler.DefaultHandler;
import edu.issi.machine.subassembly.handler.Handler;

@SuppressWarnings("javadoc")
public class SubassemblyTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldCreatesWithNotEmptyOperations() throws InvalidAttributeIdentifierException {
	Subassembly subassembly = getFixture();

	assertNotNull(subassembly);
    }

    @Test
    public void shouldNotCreatesWhenOperationsAreNotSetted() throws IllegalArgumentException, InvalidAttributeIdentifierException {
	exception.expect(IllegalArgumentException.class);
	new TestingSubassembly(Identity.Factory.newIdentity("Test"), null);
    }

    @Test
    public void shouldNotCreatesWhenOperationsListIsEmpty() throws IllegalArgumentException, InvalidAttributeIdentifierException {
	exception.expect(IllegalArgumentException.class);
	List<Operation> operations = new ArrayList<Operation>();
	new TestingSubassembly(Identity.Factory.newIdentity("Test"), operations);
    }

    @Test
    public void shouldCreates() throws InvalidAttributeIdentifierException {
	Identity id = Identity.Factory.newIdentity("Test");
	Operation operation = new EmptyOperation(Identity.Factory.newIdentity("Test"));

	List<Operation> operations = new ArrayList<Operation>();
	operations.add(operation);

	assertNotNull(new TestingSubassembly(id, operations));
    }

    @Test
    public void shouldBeEnabledToAddOneHandler() throws InvalidAttributeIdentifierException {
	TestingSubassembly fixture = getFixture();
	Handler handler = new DefaultHandler();

	fixture.addHandler(handler);

	assertTrue(fixture.getHandlersQuantity() == 1);
    }

    @Test
    public void shouldBeEnabledToAddManyHandlers() throws InvalidAttributeIdentifierException {
	TestingSubassembly fixture = getFixture();
	fixture.addHandler(new DefaultHandler());
	fixture.addHandler(new DefaultHandler());

	Handler handler = new DefaultHandler();
	fixture.addHandler(handler);

	assertTrue(fixture.getHandlersQuantity() == 3);
    }

    @Test
    public void shouldBeEnabledToAddManyHandlersExcludingEmptyHandlers() throws InvalidAttributeIdentifierException {
	TestingSubassembly fixture = getFixture();

	fixture.addHandler(new DefaultHandler());
	
	exception.expect(IllegalArgumentException.class);
	fixture.addHandler((Handler) null);
	
	fixture.addHandler(new DefaultHandler());
	
	exception.expect(IllegalArgumentException.class);
	fixture.addHandler((Handler) null);

	assertTrue(fixture.getHandlersQuantity() == 2);
    }

    @Test
    public void shouldCorrectRecognizeSupportedOperation() throws InvalidAttributeIdentifierException {
	Operation operation = new EmptyOperation(Identity.Factory.newIdentity("Test"));

	List<Operation> operations = new ArrayList<Operation>();
	operations.add(operation);

	TestingSubassembly fixture = new TestingSubassembly(Identity.Factory.newIdentity("Test"), operations);

	boolean result = fixture.supports(operation);

	assertEquals(true, result);
    }

    @Test
    public void shouldCorrectRecognizeNotSupportedOperation() throws InvalidAttributeIdentifierException {
	Operation unsupportedOperation = new EmptyOperation(Identity.Factory.newIdentity("Test"));
	Operation supportedOperation = new EmptyOperation(Identity.Factory.newIdentity("Test"));

	List<Operation> operations = new ArrayList<Operation>();
	operations.add(supportedOperation);

	TestingSubassembly fixture = new TestingSubassembly(Identity.Factory.newIdentity("Test"), operations);

	boolean result = fixture.supports(unsupportedOperation);

	assertEquals(false, result);
    }

    public static TestingSubassembly getFixture() throws InvalidAttributeIdentifierException {
	List<Operation> operations = new ArrayList<Operation>();
	operations.add(new EmptyOperation(Identity.Factory.newIdentity("Test")));

	return new TestingSubassembly(Identity.Factory.newIdentity("Test"), operations);
    }

    public static void main(String[] args) {
	new org.junit.runner.JUnitCore().run(SubassemblyTest.class);
    }

}
