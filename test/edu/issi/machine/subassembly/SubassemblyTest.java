package edu.issi.machine.subassembly;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.id.IdentityTest;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationTest;

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
    public void shouldCreates() {
	assertNotNull(TestingSubassembly.getFixtureWith(OperationTest.getFixture()));
    }

    @Test
    public void shouldCorrectRecognizeSupportedOperation() {
	Operation operation = OperationTest.getFixture();
	TestingSubassembly fixture = TestingSubassembly.getFixtureWith(operation);

	boolean result = fixture.supports(operation);

	assertEquals(true, result);
    }

    @Test
    public void shouldCorrectRecognizeNotSupportedOperation() {
	Operation unsupportedOperation = OperationTest.getFixture();
	Operation supportedOperation = OperationTest.getFixture();

	TestingSubassembly fixture = TestingSubassembly.getFixtureWith(supportedOperation);

	boolean result = fixture.supports(unsupportedOperation);

	assertEquals(false, result);
    }

}
