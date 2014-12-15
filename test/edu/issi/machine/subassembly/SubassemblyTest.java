package edu.issi.machine.subassembly;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
    public void shouldCreatesWithNotEmptyOperations() {
	Subassembly subassembly = getFixture();

	assertNotNull(subassembly);
    }

    @Test
    public void shouldNotCreatesWhenOperationsAreNotSetted() {
	exception.expect(IllegalArgumentException.class);
	new TestingSubassembly(new Identity(0), null);
    }

    @Test
    public void shouldNotCreatesWhenOperationsListIsEmpty() {
	exception.expect(IllegalArgumentException.class);
	List<Operation> operations = new ArrayList<Operation>();
	new TestingSubassembly(new Identity(0), operations);
    }

    @Test
    public void shouldCreates() {
	Identity id = new Identity(0, "");
	Operation operation = new EmptyOperation(new Identity(0));
	
	List<Operation> operations = new ArrayList<Operation>();
	operations.add(operation);

	assertNotNull(new TestingSubassembly(id, operations));
    }

    @Test
    public void shouldBeEnabledToAddOneHandler() {
	TestingSubassembly fixture = getFixture();
	Handler handler = new DefaultHandler();

	fixture.addHandler(handler);

	assertTrue(fixture.getHandlersQuantity() == 1);
    }

    @Test
    public void shouldBeEnabledToAddManyHandlers() {
	TestingSubassembly fixture = getFixture();
	fixture.addHandler(new DefaultHandler());
	fixture.addHandler(new DefaultHandler());

	Handler handler = new DefaultHandler();
	fixture.addHandler(handler);

	assertTrue(fixture.getHandlersQuantity() == 3);
    }

    @Test
    public void shouldBeEnabledToAddManyHandlersExcludingEmptyHandlers() {
	TestingSubassembly fixture = getFixture();

	fixture.addHandler(new DefaultHandler());
	fixture.addHandler((Handler) null);
	fixture.addHandler(new DefaultHandler());
	fixture.addHandler((Handler) null);

	assertTrue(fixture.getHandlersQuantity() == 2);
    }

    @Test
    public void shouldCorrectRecognizeSupportedOperation() {
	Operation operation = new EmptyOperation(new Identity(111));
	
	List<Operation> operations = new ArrayList<Operation>();
	operations.add(operation);

	TestingSubassembly fixture = new TestingSubassembly(new Identity(0, ""), operations);

	boolean result = fixture.supports(operation);

	assertEquals(true, result);
    }

    @Test
    public void shouldCorrectRecognizeNotSupportedOperation() {
	Operation unsupportedOperation = new EmptyOperation(new Identity(333));
	Operation supportedOperation = new EmptyOperation(new Identity(111));

	List<Operation> operations = new ArrayList<Operation>();
	operations.add(supportedOperation);
	
	TestingSubassembly fixture = new TestingSubassembly(new Identity(0, ""), operations);

	boolean result = fixture.supports(unsupportedOperation);

	assertEquals(false, result);
    }

    public static TestingSubassembly getFixture() {
	List<Operation> operations = new ArrayList<Operation>();
	operations.add(new EmptyOperation(new Identity(1)));

	return new TestingSubassembly(new Identity(0), operations);
    }

    public static void main(String[] args) {
	new org.junit.runner.JUnitCore().run(SubassemblyTest.class);
    }

}
