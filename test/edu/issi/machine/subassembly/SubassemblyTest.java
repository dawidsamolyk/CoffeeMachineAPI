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

import edu.issi.machine.id.IdentityTest;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationTest;
import edu.issi.machine.subassembly.handler.DefaultHandler;
import edu.issi.machine.subassembly.handler.Handler;

@SuppressWarnings("javadoc")
public class SubassemblyTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldNotCreatesWhenOperationsAreNotSetted() throws Exception {
	exception.expect(IllegalArgumentException.class);
	new TestingSubassembly(IdentityTest.getIdentityFixture(), null);
    }

    @Test
    public void shouldNotCreatesWhenOperationsListIsEmpty() throws Exception {
	List<Operation> operations = new ArrayList<Operation>();

	exception.expect(IllegalArgumentException.class);
	new TestingSubassembly(IdentityTest.getIdentityFixture(), operations);
    }

    @Test
    public void shouldCreates() throws InvalidAttributeIdentifierException {
	assertNotNull(TestingSubassembly.getFixtureWith(OperationTest.getFixture()));
    }

    @Test
    public void shouldBeEnabledToAddOneHandler() throws InvalidAttributeIdentifierException {
	TestingSubassembly fixture = TestingSubassembly.getFixtureWith(OperationTest.getFixture());

	fixture.addHandler(new DefaultHandler());

	assertTrue(fixture.getHandlersQuantity() == 1);
    }

    @Test
    public void shouldBeEnabledToAddManyHandlers() throws InvalidAttributeIdentifierException {
	TestingSubassembly fixture = TestingSubassembly.getFixtureWith(OperationTest.getFixture());
	
	fixture.addHandler(new DefaultHandler());
	fixture.addHandler(new DefaultHandler());
	fixture.addHandler(new DefaultHandler());

	assertTrue(fixture.getHandlersQuantity() == 3);
    }

    @Test
    public void shouldBeEnabledToAddManyHandlersExcludingEmptyHandlers() throws InvalidAttributeIdentifierException {
	TestingSubassembly fixture = TestingSubassembly.getFixtureWith(OperationTest.getFixture());
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
	Operation operation = OperationTest.getFixture();
	TestingSubassembly fixture = TestingSubassembly.getFixtureWith(operation);

	boolean result = fixture.supports(operation);

	assertEquals(true, result);
    }

    @Test
    public void shouldCorrectRecognizeNotSupportedOperation() throws InvalidAttributeIdentifierException {
	Operation unsupportedOperation = OperationTest.getFixture();
	Operation supportedOperation = OperationTest.getFixture();

	TestingSubassembly fixture = TestingSubassembly.getFixtureWith(supportedOperation);

	boolean result = fixture.supports(unsupportedOperation);

	assertEquals(false, result);
    }

    public static void main(String[] args) {
	new org.junit.runner.JUnitCore().run(SubassemblyTest.class);
    }

}
