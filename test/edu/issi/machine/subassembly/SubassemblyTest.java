package edu.issi.machine.subassembly;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.naming.directory.InvalidAttributeValueException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.id.Identity;
import edu.issi.machine.operation.Operation;

@SuppressWarnings("javadoc")
public class SubassemblyTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldCreatesWithNotEmptyOperations() {
	Subassembly subassembly = new Subassembly(Identity.SAMPLE, new Operation(null));

	assertNotNull(subassembly);
    }

    @Test
    public void shouldNotCreatesWhenOperationsAreNotSetted() {
	Operation[] operations = null;

	exception.expect(IllegalArgumentException.class);
	new Subassembly(Identity.SAMPLE, operations);
    }

    @Test
    public void shouldNotCreatesWhenOperationsListIsEmpty() {
	exception.expect(IllegalArgumentException.class);
	new Subassembly(Identity.SAMPLE, new Operation[] {});
    }

    @Test
    public void shouldCorrectRecognizeSupportedOperations() {
	Operation testOperation = new Operation(null);
	Subassembly subassembly = new Subassembly(Identity.SAMPLE, testOperation, new Operation(null));

	assertTrue(subassembly.supports(testOperation));
    }

    @Test
    public void shouldCorrectRecognizeNotSupportedOperations() {
	Operation testOperation = new Operation(new Identity(0));
	Subassembly subassembly = new Subassembly(new Identity(1), new Operation(new Identity(1)));

	assertFalse(subassembly.supports(testOperation));
    }

}
